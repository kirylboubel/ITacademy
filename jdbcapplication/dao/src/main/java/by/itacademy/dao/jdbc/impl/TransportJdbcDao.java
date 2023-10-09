package by.itacademy.dao.jdbc.impl;

import by.itacademy.dao.DaoException;
import by.itacademy.dao.datasource.impl.JdbcDataSourceProperties;
import by.itacademy.dao.jdbc.GenericJdbcDao;
import by.itacademy.dao.jdbc.mapper.ResultSetMapper;
import by.itacademy.dao.jdbc.mapper.ResultSetMapperException;
import by.itacademy.dao.mapper.model.transport.Transport;

import java.sql.*;

public class TransportJdbcDao extends GenericJdbcDao<Transport> {

    private final ResultSetMapper<Transport> mapper;

    public TransportJdbcDao(
            final JdbcDataSourceProperties properties,
            final ResultSetMapper<Transport> mapper
    ) throws DaoException {
        super(properties, "transport", mapper);
        this.mapper = mapper;
    }

    @Override
    protected PreparedStatement getPrepareStatementForCreate(
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
    protected Transport mapReadResult(final ResultSet resultSet) throws SQLException {
        try {
            return mapper.map(resultSet);
        } catch (ResultSetMapperException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return null;
    }
}
