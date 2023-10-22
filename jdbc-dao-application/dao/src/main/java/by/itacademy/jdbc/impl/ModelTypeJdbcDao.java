package by.itacademy.jdbc.impl;

import by.itacademy.datasource.JdbcDataSourceProperties;
import by.itacademy.jdbc.GenericJdbcDao;
import by.itacademy.jdbc.JdbcDaoException;
import by.itacademy.jdbc.mapper.ResultSetMapper;
import by.itacademy.jdbc.mapper.ResultSetMapperException;
import by.itacademy.modelType.ModelType;

import java.sql.*;

public class ModelTypeJdbcDao extends GenericJdbcDao<ModelType> {
    private final ResultSetMapper<ModelType> mapper;

    public ModelTypeJdbcDao(
            final JdbcDataSourceProperties properties,
            final ResultSetMapper<ModelType> mapper
    ) throws JdbcDaoException {
        super(properties, "model_type", mapper);
        this.mapper = mapper;
    }

    @Override
    protected PreparedStatement getPreparedStatementForCreate(final Connection cn, final ModelType modelType) throws SQLException {
        final PreparedStatement ps = cn.prepareStatement("insert into model_type (name) values (?)", Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, modelType.getName());

        return ps;
    }

    @Override
    protected ModelType mapReaResult(final ResultSet resultSet) throws ResultSetMapperException {
        return mapper.map(resultSet);
    }

    @Override
    public Integer create(ModelType model) throws JdbcDaoException {
        return super.create(model);
    }

    @Override
    public ModelType read(Integer id) throws JdbcDaoException {
        return super.read(id);
    }
}
