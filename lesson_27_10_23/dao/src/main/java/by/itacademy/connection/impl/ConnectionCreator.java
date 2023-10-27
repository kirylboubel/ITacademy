package by.itacademy.connection.impl;

import by.itacademy.connection.Connection;
import by.itacademy.connection.ConnectionException;
import by.itacademy.connection.ConnectionProperties;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ConnectionCreator implements Connection {

    @Override
    public ConnectionProperties create(String source) throws ConnectionException {
        try (final Reader reader = getResource(source)) {
            final Properties properties = new Properties();
            properties.load(reader);

            final String user = properties.getProperty("datasource.jdbc.user");
            final String password = properties.getProperty("datasource.jdbc.password");
            final String url = properties.getProperty("datasource.jdbc.url");
            final String driver = properties.getProperty("datasource.jdbc.driver");

            return new ConnectionProperties(user, password, url, driver);
        } catch (final IOException e) {
            throw new ConnectionException("Failed to read properties file: " + source, e);
        }
    }

    private static Reader getResource(final String source) throws ConnectionException {
        final InputStream in = ConnectionCreator.class.getClassLoader().getResourceAsStream(source);
        if (in != null) {
            return new InputStreamReader(in, StandardCharsets.UTF_8);
        }

        throw new ConnectionException("Properties file not found: " + source);
    }
}
