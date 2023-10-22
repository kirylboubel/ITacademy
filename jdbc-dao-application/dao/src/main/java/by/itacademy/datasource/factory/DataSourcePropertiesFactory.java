package by.itacademy.datasource.factory;

import by.itacademy.datasource.JdbcDataSourceProperties;

public interface DataSourcePropertiesFactory {
    JdbcDataSourceProperties create(String source) throws DataSourcePropertiesFactoryException;
}
