package by.itacademy.dao.jdbc.provider;

import by.itacademy.dao.Dao;
import by.itacademy.dao.DaoException;
import by.itacademy.dao.datasource.impl.JdbcDataSourceProperties;
import by.itacademy.dao.jdbc.impl.ClientJdbcDao;
import by.itacademy.dao.jdbc.impl.ModelTypeJdbcDao;
import by.itacademy.dao.jdbc.impl.TransportJdbcDao;
import by.itacademy.dao.jdbc.mapper.model.ModelTypeResultSetMapper;
import by.itacademy.dao.mapper.model.BaseModel;
import by.itacademy.dao.jdbc.mapper.model.ClientResultSetMapper;
import by.itacademy.dao.jdbc.mapper.model.TransportResulSetMapper;
import by.itacademy.dao.mapper.model.client.Client;
import by.itacademy.dao.mapper.model.modelType.ModelType;
import by.itacademy.dao.mapper.model.transport.Transport;
import by.itacademy.dao.provider.DaoProvider;

import java.util.HashMap;
import java.util.Map;

public class JdbcDaoProviderJdbc implements DaoProvider {

    private final Map<Class<? extends BaseModel>, Dao<? extends BaseModel>> map;
    private final JdbcDataSourceProperties properties;

    public JdbcDaoProviderJdbc(final JdbcDataSourceProperties properties) throws DaoException {
        this.properties = properties;
        this.map = new HashMap<>();

        map.put(Transport.class, new TransportJdbcDao(properties, new TransportResulSetMapper()));
        map.put(Client.class, new ClientJdbcDao(properties, new ClientResultSetMapper()));
        map.put(ModelType.class, new ModelTypeJdbcDao(properties, new ModelTypeResultSetMapper()));
    }

    @Override
    public <E extends BaseModel, D extends Dao<E>> D provide(Class<E> entityClass) {
        return (D) map.get(entityClass);
    }
}
