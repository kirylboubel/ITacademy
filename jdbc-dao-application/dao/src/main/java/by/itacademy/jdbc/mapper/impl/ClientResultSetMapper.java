package by.itacademy.jdbc.mapper.impl;

import by.itacademy.client.Client;
import by.itacademy.jdbc.mapper.ResultSetMapper;
import by.itacademy.jdbc.mapper.ResultSetMapperException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientResultSetMapper implements ResultSetMapper<Client> {

    @Override
    public Client map(final ResultSet resultSet) throws ResultSetMapperException {
        try {
            if (!resultSet.next()) {
                return null;
            }
            final Integer id = resultSet.getInt("id");
            final String firstName = resultSet.getString("first_name");
            final String lastName = resultSet.getString("last_name");

            return new Client(id, firstName, lastName);

        } catch (final SQLException e) {
            throw new ResultSetMapperException("Failed to map client", e);
        }
    }
}
