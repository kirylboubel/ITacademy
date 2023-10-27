package by.itacademy.datasource;

import java.sql.Connection;
import java.util.Properties;

public class JdbcDataSourceProperties {
    private final String DB_USER;
    private final String DB_PASSWORD;
    private final String DB_URL_PARAMETERS;
    private final String DB_URL;
    private final Connection connection;
    private final Properties h2properties;

    public JdbcDataSourceProperties(
            final String DB_USER,
            final String DB_PASSWORD,
            final String DB_URL_PARAMETERS,
            final String DB_URL,
            final Connection connection,
            final Properties h2properties
    ) {
        this.DB_USER = DB_USER;
        this.DB_PASSWORD = DB_PASSWORD;
        this.DB_URL_PARAMETERS = DB_URL_PARAMETERS;
        this.DB_URL = DB_URL;
        this.connection = connection;
        this.h2properties = h2properties;
    }

    public String getDB_USER() {
        return DB_USER;
    }

    public String getDB_PASSWORD() {
        return DB_PASSWORD;
    }

    public String getDB_URL_PARAMETERS() {
        return DB_URL_PARAMETERS;
    }

    public String getDB_URL() {
        return DB_URL;
    }

    public Connection getConnection() {
        return connection;
    }

    public Properties getH2properties() {
        return h2properties;
    }
}
