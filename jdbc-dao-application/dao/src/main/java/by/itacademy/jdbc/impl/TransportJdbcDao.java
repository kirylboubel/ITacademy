package by.itacademy.jdbc.impl;

import by.itacademy.datasource.JdbcDataSourceProperties;
import by.itacademy.jdbc.GenericJdbcDao;
import by.itacademy.jdbc.JdbcDaoException;
import by.itacademy.jdbc.mapper.ResultSetMapper;
import by.itacademy.jdbc.mapper.ResultSetMapperException;
import by.itacademy.transport.Transport;

import java.sql.*;

public class TransportJdbcDao extends GenericJdbcDao<Transport> {
    private final ResultSetMapper<Transport> mapper;

    public TransportJdbcDao(
            final JdbcDataSourceProperties properties,
            final ResultSetMapper<Transport> mapper
    ) throws JdbcDaoException {
        super(properties, "transport", mapper);
        this.mapper = mapper;
    }

    @Override
    protected PreparedStatement getPreparedStatementForCreate(
            final Connection cn,
            final Transport transport
    ) throws SQLException {
        final PreparedStatement ps = cn.prepareStatement("insert into transport (transport_type_id, model_type_id, client_id) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, transport.getTransportType().getId());
        ps.setInt(2, transport.getModelType().getId());

        if (transport.getClient() != null) {
            ps.setInt(3, transport.getClient().getId());
        } else {
            ps.setNull(3, Types.INTEGER);
        }

        return ps;
    }

    @Override
    protected Transport mapReaResult(final ResultSet resultSet) throws ResultSetMapperException {
        return mapper.map(resultSet);
    }

    @Override
    public Integer create(Transport model) throws JdbcDaoException {
        return super.create(model);
    }

    @Override
    public Transport read(Integer id) throws JdbcDaoException {
        return super.read(id);
    }
}
