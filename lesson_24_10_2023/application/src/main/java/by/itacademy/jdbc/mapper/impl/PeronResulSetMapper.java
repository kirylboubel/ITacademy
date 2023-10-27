package by.itacademy.jdbc.mapper.impl;

import by.itacademy.entity.Person;
import by.itacademy.jdbc.mapper.ResultSetMapper;
import by.itacademy.jdbc.mapper.ResultSetMapperException;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PeronResulSetMapper implements ResultSetMapper<Person> {
    @Override
    public Person map(final ResultSet resultSet) throws ResultSetMapperException {
        try {
            if (!resultSet.next()) {
                return null;
            }
            final Integer id = resultSet.getInt("id");
            final String name = resultSet.getString("name");

            return new Person(id, name);

        } catch (final SQLException e) {
            throw new ResultSetMapperException("Failed to map person", e);
        }
    }
}
