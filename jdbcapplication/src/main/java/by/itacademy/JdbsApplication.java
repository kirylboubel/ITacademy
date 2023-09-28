package by.itacademy;

import by.itacademy.client.Client;
import by.itacademy.transport.Transport;
import by.itacademy.transport.TransportType;
import by.itacademy.transportName.TransportName;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class JdbsApplication {
    private static final String URL = "jdbc:postgresql://localhost:5432/autoservice";

    public static void main(String[] args) throws SQLException {
        final Properties properties = getProperties("src/main/resources/application.properties");

        try (final Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties)) {
            final String selectTransportQuery = "select tr.id, mt.\"name\" as modelName, tt.\"name\" as transportType, cl.first_name as firstName, cl.last_name as lastName  from transport tr \n" +
                    "\tleft join model_type mt on tr.model_type_id = mt.id\n" +
                    "\tleft join transport_type tt on tr.transport_type_id = tt.id \n" +
                    "\tleft join client cl on tr.client_id = cl.id ;";


            final Statement statement = connection.createStatement();

            final ResultSet transportRS = statement.executeQuery(selectTransportQuery);

            List<Transport> transportList = new ArrayList<>();
            while (transportRS.next()) {
                final Integer id = transportRS.getInt("id");
                final String modelName = transportRS.getString("modelname");
                final TransportName transportName = new TransportName(modelName);

                final String transportTypeString = transportRS.getString("transportType");
                final TransportType transportType = TransportType.valueOf(transportTypeString.toUpperCase());

                final String firstName = transportRS.getString("firstName");
                final String lastName = transportRS.getString("lastName");
                final Client client = new Client(firstName, lastName);

                final Transport transport = new Transport(transportType, transportName, client);
                transportList.add(transport);
                System.out.println(transport);
            }
        }
    }

    private static Properties getProperties(final String fileName) {
        try (final FileReader reader = new FileReader(fileName)) {
            final Properties properties = new Properties();
            properties.load(reader);

            return properties;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
