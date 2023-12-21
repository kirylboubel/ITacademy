package by.itacademy.dao.impl;

import by.itacademy.Address;
import by.itacademy.dao.DaoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Statement;

import static by.itacademy.dao.impl.SessionFactoryTest.SESSION_FACTORY;

public class AddressDaoIntegrationTest extends BaseHibernateIntegrationTest {
    private static final AddressDao ADDRESS_DAO = new AddressDao(SESSION_FACTORY);
    private static final Address ADDRESS = new Address();

    @BeforeAll
    public static void createObject() {
        ADDRESS.setCity("Brest");
        ADDRESS.setStreet("Naganova");
        ADDRESS.setBuildingNumber("50");
    }

    @Test
    void testCreateAddress_happyPath() throws DaoException {
        ADDRESS_DAO.create(ADDRESS);

        final ResultSetVerifier verifier = resultSet -> {
            final Integer addressId = resultSet.getInt("id");
            final String city = resultSet.getString("city");
            final String street = resultSet.getString("street");
            final String buildingNumber = resultSet.getString("building_number");

            Assertions.assertEquals(ADDRESS.getId(), addressId);
            Assertions.assertEquals(ADDRESS.getCity(), city);
            Assertions.assertEquals(ADDRESS.getStreet(), street);
            Assertions.assertEquals(ADDRESS.getBuildingNumber(), buildingNumber);
        };
        verifyCreatedRow("address", ADDRESS.getId(), verifier);
    }

    @Test
    void testReadAddress_happyPath() throws DaoException, SQLException {
        final Statement statement = connection.createStatement();
        statement.executeUpdate("insert into address (city, street, building_number) values ('Brest', 'Dzerjinskogo', '50')");

        final Address readAddress = ADDRESS_DAO.read(1);

        final ResultSetVerifier verifier = resultSet -> {
            Assertions.assertEquals(ADDRESS.getId(), readAddress.getId());
            Assertions.assertEquals(ADDRESS.getCity(), readAddress.getCity());
            Assertions.assertEquals(ADDRESS.getStreet(), readAddress.getStreet());
            Assertions.assertEquals(ADDRESS.getBuildingNumber(), readAddress.getBuildingNumber());
        };
    }

    @Test
    void testUpdateAddress_happyPath() throws DaoException, SQLException {
        final Statement statement = connection.createStatement();
        statement.executeUpdate("insert into address (city, street, building_number) values ('Brest', 'Dzerjinskogo', '50')");

        final Address updateAddress = ADDRESS;
        updateAddress.setBuildingNumber("150");

        ADDRESS_DAO.update(ADDRESS);
        final ResultSetVerifier verifier = resultSet -> {
            final Integer updateAddressId = resultSet.getInt("id");
            final String updateCity = resultSet.getString("city");
            final String updateStreet = resultSet.getString("street");
            final String updateBuildingNumber = resultSet.getString("building_number");

            Assertions.assertEquals(ADDRESS.getId(), updateAddressId);
            Assertions.assertEquals(ADDRESS.getCity(), updateCity);
            Assertions.assertEquals(ADDRESS.getStreet(), updateStreet);
            Assertions.assertNotEquals(ADDRESS.getBuildingNumber(), updateBuildingNumber);
        };
    }

    @Test
    void testDeleteAddress_happyPath() throws DaoException, SQLException {
        final Statement statement = connection.createStatement();
        statement.executeUpdate("insert into address (city, street, building_number) values ('Brest', 'Dzerjinskogo', '50')");

        final ResultSetVerifier verifier = resultSet -> {
            final Integer addressId = resultSet.getInt("id");
            final String city = resultSet.getString("city");
            final String street = resultSet.getString("street");
            final String buildingNumber = resultSet.getString("building_number");

            Assertions.assertEquals(ADDRESS.getId(), addressId);
            Assertions.assertEquals(ADDRESS.getCity(), city);
            Assertions.assertEquals(ADDRESS.getStreet(), street);
            Assertions.assertEquals(ADDRESS.getBuildingNumber(), buildingNumber);
        };

        ADDRESS_DAO.delete(1);

        final ResultSetVerifier verifierAfterDelete = resultSet -> {
            final Integer addressId = resultSet.getInt("id");
            final String city = resultSet.getString("city");
            final String street = resultSet.getString("street");
            final String buildingNumber = resultSet.getString("building_number");

            Assertions.assertNull(addressId);
            Assertions.assertNull(city);
            Assertions.assertNull(street);
            Assertions.assertNull(buildingNumber);
        };
    }
}
