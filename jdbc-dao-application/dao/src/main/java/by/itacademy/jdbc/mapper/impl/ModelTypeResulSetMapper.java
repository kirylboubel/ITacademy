package by.itacademy.jdbc.mapper.impl;

import by.itacademy.jdbc.mapper.ResultSetMapper;
import by.itacademy.jdbc.mapper.ResultSetMapperException;
import by.itacademy.modelType.ModelType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelTypeResulSetMapper implements ResultSetMapper<ModelType> {
    @Override
    public ModelType map(ResultSet resultSet) throws ResultSetMapperException {
        try {
            if (!resultSet.next()) {
                return null;
            }
            final Integer id = resultSet.getInt("id");
            final String transportModel = resultSet.getString("name");

            return new ModelType(id, transportModel);
        } catch (final SQLException e) {
            throw new ResultSetMapperException("Failed to map ModelType", e);
        }
    }
}
