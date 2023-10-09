package by.itacademy.dao.jdbc.impl;

import by.itacademy.dao.DaoException;
import by.itacademy.dao.datasource.impl.JdbcDataSourceProperties;
import by.itacademy.dao.jdbc.GenericJdbcDao;
import by.itacademy.dao.jdbc.mapper.ResultSetMapper;
import by.itacademy.dao.jdbc.mapper.ResultSetMapperException;
import by.itacademy.dao.mapper.model.modelType.ModelType;
import by.itacademy.dao.mapper.model.transport.TransportType;

import java.sql.*;

public class ModelTypeJdbcDao extends GenericJdbcDao<ModelType> {
    private final ResultSetMapper<ModelType> mapper;

    public ModelTypeJdbcDao(
            final JdbcDataSourceProperties properties,
            final ResultSetMapper<ModelType> mapper
    ) throws DaoException {
        super(properties, "model_type", mapper);
        this.mapper = mapper;
    }

    @Override
    protected PreparedStatement getPrepareStatementForCreate(final Connection cn, final ModelType modelType) throws SQLException {
        final PreparedStatement ps = cn.prepareStatement("insert into model_type (name) values (?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, modelType.getName());

        return ps;
    }

    @Override
    protected ModelType mapReadResult(final ResultSet resultSet) throws SQLException {
        try {
            return mapper.map(resultSet);
        } catch (ResultSetMapperException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer create(final ModelType model) throws DaoException {
        return super.create(model);
    }

    @Override
    public ModelType read(final Integer id) throws DaoException {
        return super.read(id);
    }
}
