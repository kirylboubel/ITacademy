package by.itacademy.dao.impl;

import by.itacademy.dao.DaoException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import java.sql.*;

public class BaseHibernateIntegrationTest {
    protected interface ResultSetVerifier {
        void verify(final ResultSet resultSet) throws SQLException;
    }

    static Connection connection;

    @BeforeAll
    public static void beforeAll() {
        try {
            connection = DriverManager.getConnection("jdbc:h2:mem:school", "postgres", "postgres");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void afterAll() {
        try {

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected static void verifyCreatedRow(final String tableName, final Integer id, final ResultSetVerifier verifier){
        final String selectSql = "select * from " + tableName + " where id = ?";
        try (final PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setInt(1, id);

            final ResultSet resultSet = preparedStatement.executeQuery();

            int rowCounter = 0;
            while (resultSet.next()) {
                rowCounter++;

                if (rowCounter > 1) {
                    continue;
                }
                verifier.verify(resultSet);
            }
            if (rowCounter != 1) {
                Assertions.fail("Unexpected row number, must be 1 but is: " + rowCounter);
            }
        } catch (final SQLException e){
            e.printStackTrace();
        }
    }
}
