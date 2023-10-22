package by.itacademy.dao.jdbc.impl;

import by.itacademy.Dao;
import by.itacademy.client.Client;
import by.itacademy.datasource.JdbcDataSourceProperties;
import by.itacademy.datasource.factory.DataSourcePropertiesFactory;
import by.itacademy.datasource.factory.impl.FileDataSourcePropertiesFactory;
import by.itacademy.jdbc.impl.ClientJdbcDao;
import by.itacademy.jdbc.mapper.impl.ClientResultSetMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClientJdbcDaoIntegrationTest extends BaseJdbcDaoIntegrationTest {
    @Test
    void testCreateClient_happyPath() throws Exception {
        //given
        final DataSourcePropertiesFactory factory = new FileDataSourcePropertiesFactory();
        final JdbcDataSourceProperties properties = factory.create("application-test.properties");
        final ClientResultSetMapper mapper = new ClientResultSetMapper();

        final Dao<Client> clientDao = new ClientJdbcDao(properties, mapper);
        final Client client = new Client(null, "Isaak", "Newton");

        //when
        final Integer id = clientDao.create(client);

        //then
        final ResultSetVerifier verifier = (rs) -> {
            final Integer clientId = rs.getInt("id");
            final String clientFirstName = rs.getString("first_name");
            final String clientLastName = rs.getString("last_name");

            Assertions.assertEquals(id, clientId);
            Assertions.assertEquals(client.getFirstName(), clientFirstName);
            Assertions.assertEquals(client.getLastName(), clientLastName);
        };

        verifyCreatedRow("client", id, verifier);
    }
}
