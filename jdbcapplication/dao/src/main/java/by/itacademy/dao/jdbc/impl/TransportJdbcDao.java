package by.itacademy.dao.jdbc;

import by.itacademy.dao.DaoException;
import by.itacademy.dao.datasource.JdbcDataSourceProperties;
import by.itacademy.dao.mapper.ResultSetMapper;
import by.itacademy.dao.mapper.ResultSetMapperException;
import by.itacademy.dao.mapper.model.IdField;
import by.itacademy.dao.mapper.model.client.Client;
import by.itacademy.dao.mapper.model.modelType.ModelType;
import by.itacademy.dao.mapper.model.transport.Transport;
import by.itacademy.dao.mapper.model.transport.TransportType;

import java.sql.*;

public class TransportJdbcDao extends GenericJdbcDao <Transport> {


    public TransportJdbcDao(JdbcDataSourceProperties properties, ResultSetMapper<Transport> mapper) throws DaoException {
        super(properties, "transport", mapper);
    }

    @Override
    protected PreparedStatement getPrepareStatementForCreate(Connection cn, Transport transport) throws SQLException {
        final PreparedStatement ps = cn.prepareStatement("insert into transport ('model_type_id', 'transport_type_id', 'client_id' values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, transport.getTransportType().getId());
        ps.setInt(2, transport.getModelType().getId());

        if(transport.getClient() != null) {
            ps.setInt(3, transport.getClient().getId());
        }

        return ps;
    }

    @Override
    protected Transport mapReadResult(ResultSet resultSet) throws SQLException, ResultSetMapperException {
        return null;
    }

    @Override
    public Integer create(Transport transport) throws DaoException {
        return null;
    }

    @Override
    public Transport read(Integer id) throws DaoException {
        return null;
    }

//    private static <T extends Enum<T> & IdField> T mapToEnum (final Class<T> enumClass, final Integer id){
//        for (final T value : enumClass.getEnumConstants()){
//            if (value.getId() == id){
//                return value;
//            }
//        }
//        return null;
//    }

//    private static <T extends Class<T> & IdField> String mapToString (final Class<T> clazz, final Integer id){
//        String name = null;
//        for (final Field value : clazz.getFields()){
//            if(!value.canAccess(clazz) && !value.trySetAccessible()){
//                continue;
//            }
//            try {
//                final Object fieldType = value.get(clazz);
//                if (!(fieldType instanceof String)){
//                    continue;
//                }
//                name = (String) fieldType;
//            } catch (IllegalAccessException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return name;
//    }
}
