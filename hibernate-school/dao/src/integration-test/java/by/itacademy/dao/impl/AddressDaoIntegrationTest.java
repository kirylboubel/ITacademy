package by.itacademy.dao.impl;

import by.itacademy.Address;
import by.itacademy.dao.DaoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static by.itacademy.dao.impl.SessionFactoryTest.SESSION_FACTORY;

public class AddressDaoIntegrationTest extends BaseHibernateIntegrationTest {
    protected static final AddressDao ADDRESS_DAO = new AddressDao(SESSION_FACTORY);
    private static final Address ADDRESS = new Address();

    @BeforeAll
    public static void createObject() {
        ADDRESS.setCity("Brest");
        ADDRESS.setStreet("Naganova");
        ADDRESS.setBuildingNumber("50");
    }

    @Test
    void testCreateAddress_happyPath() throws DaoException, SQLException {

        ADDRESS_DAO.create(ADDRESS);

        final ResultSetVerifier verifier = resultSet -> {
            Integer addressId = resultSet.getInt("id");
            String city = resultSet.getString("city");
            String street = resultSet.getString("street");
            String buildingNumber = resultSet.getString("building_number");

            Assertions.assertEquals(ADDRESS.getId(), addressId);
            Assertions.assertEquals(ADDRESS.getCity(), city);
            Assertions.assertEquals(ADDRESS.getStreet(), street);
            Assertions.assertEquals(ADDRESS.getBuildingNumber(), buildingNumber);
        };
        verifyCreatedRow("address", ADDRESS.getId(), verifier);
    }

    @Test
    void testReadAddress_happyPath() throws DaoException {
        ADDRESS_DAO.create(ADDRESS);

        final Address readAddress = ADDRESS_DAO.read(ADDRESS.getId());

        final ResultSetVerifier verifier = resultSet -> {
            Assertions.assertEquals(ADDRESS.getId(), readAddress.getId());
            Assertions.assertEquals(ADDRESS.getCity(), readAddress.getCity());
            Assertions.assertEquals(ADDRESS.getStreet(), readAddress.getStreet());
            Assertions.assertEquals(ADDRESS.getBuildingNumber(), readAddress.getBuildingNumber());
        };
        verifyCreatedRow("address", ADDRESS.getId(), verifier);
    }

    @Test
    void testUpdateAddress_happyPath() throws DaoException {
        ADDRESS_DAO.create(ADDRESS);

        Address updateAddress = ADDRESS;
        updateAddress.setBuildingNumber("150");

        ADDRESS_DAO.update(ADDRESS);
        final ResultSetVerifier verifier = resultSet -> {
            Integer updateAddressId = resultSet.getInt("id");
            String updateCity = resultSet.getString("city");
            String updateStreet = resultSet.getString("street");
            String updateBuildingNumber = resultSet.getString("building_number");

            Assertions.assertEquals(ADDRESS.getId(), updateAddressId);
            Assertions.assertEquals(ADDRESS.getCity(), updateCity);
            Assertions.assertEquals(ADDRESS.getStreet(), updateStreet);
            Assertions.assertNotEquals(ADDRESS.getBuildingNumber(), updateBuildingNumber);
        };
    }

    @Test
    void testDeleteAddress_happyPath() throws DaoException {
        ADDRESS_DAO.create(ADDRESS);

        final ResultSetVerifier verifier = resultSet -> {
            Integer addressId = resultSet.getInt("id");
            String city = resultSet.getString("city");
            String street = resultSet.getString("street");
            String buildingNumber = resultSet.getString("building_number");

            Assertions.assertEquals(ADDRESS.getId(), addressId);
            Assertions.assertEquals(ADDRESS.getCity(), city);
            Assertions.assertEquals(ADDRESS.getStreet(), street);
            Assertions.assertEquals(ADDRESS.getBuildingNumber(), buildingNumber);
        };
        verifyCreatedRow("address", ADDRESS.getId(), verifier);

        ADDRESS_DAO.delete(ADDRESS.getId());
        Assertions.assertNull(ADDRESS_DAO.read(ADDRESS.getId()));
    }
}
