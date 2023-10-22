package by.itacademy.dao.jdbc.impl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class BaseJdbcDaoIntegrationTest {
    protected interface ResultSetVerifier {
        void verify(ResultSet resultSet) throws SQLException;
    }

    private static final String DB_URL = "datasource.jdbc.url";
    private static final String DB_USER = "datasource.jdbc.user";
    private static final String DB_PASSWORD = "datasource.jdbc.user";
    private static final String DB_URL_PARAMETERS = "datasource.jdbc.url.parameters";
    private static Properties testProperties;
    private static Connection connection;

    @BeforeAll
    public static void beforeAll() throws IOException, SQLException {
        final Properties properties = getTestProperties("application-test.properties");

        final var url = properties.getProperty(DB_URL) + properties.getProperty(DB_URL_PARAMETERS);

        connection = DriverManager.getConnection(
                url,
                properties.getProperty(DB_USER),
                properties.getProperty(DB_PASSWORD)
        );
    }

    @AfterAll
    public static void afterAll() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    protected static void verifyCreatedRow(final String tableName, final Integer id, final ResultSetVerifier verifier) throws SQLException {
        final String selectSql = "select * from " + tableName + " where id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

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
        }
    }

    private static Properties getTestProperties(final String fileName) throws IOException {
        if (testProperties != null) {
            return testProperties;
        }

        final InputStream in = BaseJdbcDaoIntegrationTest.class.getClassLoader().getResourceAsStream(fileName);
        if (in == null) {
            throw new FileNotFoundException("Resources file is not found " + fileName);
        }
        try (final InputStreamReader reader = new InputStreamReader(in)) {
            final Properties properties = new Properties();
            properties.load(reader);

            testProperties = properties;
        }
        return testProperties;
    }
}
