package by.itacademy;

import by.itacademy.dao.Dao;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.datasource.factory.DataSourcePropertiesFactoryException;
import by.itacademy.dao.datasource.factory.impl.FileDataSourcePropertiesFactory;
import by.itacademy.dao.jdbc.provider.JdbcDaoProviderJdbc;
import by.itacademy.dao.mapper.model.client.Client;
import by.itacademy.dao.mapper.model.modelType.ModelType;
import by.itacademy.dao.mapper.model.transport.Transport;
import by.itacademy.dao.mapper.model.transport.TransportType;
import by.itacademy.dao.provider.DaoProvider;

import java.util.Arrays;
import java.util.Scanner;

public class DaoApplication {
    public static void main(final String[] args) throws Exception {
        try (final Scanner scanner = new Scanner(System.in)) {

            final var dataSourcePropertiesFactory = new FileDataSourcePropertiesFactory();
            final var properties = dataSourcePropertiesFactory.create("application.properties");

            final DaoProvider provider = new JdbcDaoProviderJdbc(properties);

            final Dao<ModelType> modelTypeDao = provider.provide(ModelType.class);
            final Dao<Client> clientDao = provider.provide(Client.class);
            final Dao<Transport> transportDao = provider.provide(Transport.class);

            System.out.println("Введите значение transportModel для ModelType");
            final String transportModel = scanner.nextLine();
            final ModelType modelType = new ModelType(null, transportModel);

            final var modelTypeId = modelTypeDao.create(modelType);
            System.out.println("ModelTypeId = " + modelTypeId);
            final ModelType modelTypeCrated = modelTypeDao.read(modelTypeId);

            System.out.println("Введите значение firstName для Client");
            final String firstName = scanner.nextLine();
            System.out.println("Введите значение lastName для Client");
            final String lastName = scanner.nextLine();
            final Client client = new Client(null, firstName, lastName);

            final var clientId = clientDao.create(client);
            System.out.println("ClientId = " + clientId);
            final Client clientCreated = clientDao.read(clientId);

            System.out.println("Введите значение для TransportType из пердложенных: " + Arrays.toString(TransportType.values()));
            final String typeOfTransport = scanner.nextLine();
            final TransportType transportType = TransportType.valueOf(typeOfTransport.toUpperCase());

            final Transport transport = new Transport(null, transportType, modelTypeCrated, clientCreated);
            final var transportId = transportDao.create(transport);
            System.out.println("TransportId = " + transportId);
            final Transport transportCreated = transportDao.read(transportId);
            System.out.println(transportCreated.toString());

        } catch (DataSourcePropertiesFactoryException e) {
            e.printStackTrace();
            throw new DataSourcePropertiesFactoryException("Failed to create properties", e);
        } catch (DaoException e) {
            e.printStackTrace();
            throw new DaoException("Dao Exception", e);
        }
    }
}
