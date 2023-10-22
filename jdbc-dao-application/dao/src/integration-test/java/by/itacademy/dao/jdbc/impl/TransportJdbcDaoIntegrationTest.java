package by.itacademy.dao.jdbc.impl;

import by.itacademy.Dao;
import by.itacademy.client.Client;
import by.itacademy.datasource.JdbcDataSourceProperties;
import by.itacademy.datasource.factory.DataSourcePropertiesFactory;
import by.itacademy.datasource.factory.impl.FileDataSourcePropertiesFactory;
import by.itacademy.jdbc.impl.TransportJdbcDao;
import by.itacademy.jdbc.mapper.impl.TransportResulSetMapper;
import by.itacademy.modelType.ModelType;
import by.itacademy.transport.Transport;
import by.itacademy.transport.TransportType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TransportJdbcDaoIntegrationTest extends BaseJdbcDaoIntegrationTest{

    @Test
    void testCreateTransport_happyPath() throws Exception{
        //given
        final TransportType expectedTransportType = TransportType.AUTOMOBILE;
        final ModelType expectedModelType = new ModelType(1, "BMW M5");
        final Client expectedClient = new Client(1, "Optimus", "Prime");

        final DataSourcePropertiesFactory factory = new FileDataSourcePropertiesFactory();
        final JdbcDataSourceProperties properties = factory.create("application-test.properties");
        TransportResulSetMapper mapper = new TransportResulSetMapper();

        final Dao<Transport> transportDao = new TransportJdbcDao(properties, mapper);
        final Transport transport = new Transport(null, expectedTransportType, expectedModelType, expectedClient);

        //when
        final Integer id = transportDao.create(transport);

        //then
        final ResultSetVerifier verifier = (rs) -> {
            final Integer transportId = rs.getInt("id");
            final Integer transportTypeId = rs.getInt("transport_type_id");
            final Integer modelTypeId = rs.getInt("model_type_id");
            final Integer clientId = rs.getInt("client_id");

            Assertions.assertEquals(id, transportId);
            Assertions.assertEquals(expectedTransportType.getId(), transportTypeId);
            Assertions.assertEquals(expectedModelType.getId(), modelTypeId);
            Assertions.assertEquals(expectedClient.getId(), clientId);
        };

        verifyCreatedRow("transport", id, verifier);
    }
}
