package by.itacademy.dao.impl;

import by.itacademy.Address;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.impl.AddressDao;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static by.itacademy.dao.impl.BaseHibernateIntegrationTest.SESSION_FACTORY;

public class AddressDaoIntegrationTest {

    @Test
    void testCreateAddress_happyPath() throws DaoException, SQLException {
        Address expectedAddress = new Address();
        expectedAddress.setCity("Brest");
        expectedAddress.setCity("Naganova");
        expectedAddress.setStreet("50");

        AddressDao addressDao = new AddressDao(SESSION_FACTORY);
        addressDao.create(expectedAddress);

        final Connection connection = DriverManager.getConnection("jdbc:h2:mem:school", "postgres", "postgres");
        final PreparedStatement preparedStatement = connection.prepareStatement("select * from address");
        final ResultSet resultSet = preparedStatement.executeQuery();
        final Integer id = resultSet.getInt("id");
        final String city = resultSet.getString("city");
        final String street = resultSet.getString("street");

        System.out.println("street = " + street);
    }
}
