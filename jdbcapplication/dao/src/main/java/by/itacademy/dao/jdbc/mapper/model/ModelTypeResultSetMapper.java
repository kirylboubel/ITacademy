package by.itacademy.dao.jdbc.mapper.model;

import by.itacademy.dao.jdbc.mapper.ResultSetMapper;
import by.itacademy.dao.jdbc.mapper.ResultSetMapperException;
import by.itacademy.dao.mapper.model.modelType.ModelType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelTypeResultSetMapper implements ResultSetMapper<ModelType> {
    @Override
    public ModelType map(final ResultSet resultSet) throws ResultSetMapperException {
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
