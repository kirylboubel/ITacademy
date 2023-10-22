package by.itacademy.jdbc.provider;

import by.itacademy.BaseModel;
import by.itacademy.Dao;
import by.itacademy.client.Client;
import by.itacademy.datasource.JdbcDataSourceProperties;
import by.itacademy.jdbc.JdbcDaoException;
import by.itacademy.jdbc.impl.ClientJdbcDao;
import by.itacademy.jdbc.impl.ModelTypeJdbcDao;
import by.itacademy.jdbc.impl.TransportJdbcDao;
import by.itacademy.jdbc.mapper.impl.ClientResultSetMapper;
import by.itacademy.jdbc.mapper.impl.ModelTypeResulSetMapper;
import by.itacademy.jdbc.mapper.impl.TransportResulSetMapper;
import by.itacademy.modelType.ModelType;
import by.itacademy.provider.DaoProvider;
import by.itacademy.transport.Transport;

import java.util.HashMap;
import java.util.Map;

public class JdbcDaoProvider implements DaoProvider {
    private final Map<Class<? extends BaseModel>, Dao<? extends BaseModel>> map;
    private final JdbcDataSourceProperties properties;

    public JdbcDaoProvider(final JdbcDataSourceProperties properties) throws JdbcDaoException {
        this.properties = properties;
        this.map = new HashMap<>();

        map.put(Transport.class, new TransportJdbcDao(properties, new TransportResulSetMapper()));
        map.put(Client.class, new ClientJdbcDao(properties, new ClientResultSetMapper()));
        map.put(ModelType.class, new ModelTypeJdbcDao(properties, new ModelTypeResulSetMapper()));
    }

    @Override
    public <E extends BaseModel, D extends Dao<E>> D provide(Class<E> entityClass) {
        return (D) map.get(entityClass);
    }
}
