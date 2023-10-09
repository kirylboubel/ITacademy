package by.itacademy.dao.datasource.factory;

import by.itacademy.dao.datasource.impl.JdbcDataSourceProperties;

public interface DataSourcePropertiesFactory {
    JdbcDataSourceProperties create(String source) throws DataSourcePropertiesFactoryException;
}
