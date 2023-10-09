package by.itacademy.dao.datasource.impl;

import by.itacademy.dao.datasource.DataSourceProperties;

public class JdbcDataSourceProperties implements DataSourceProperties {
    private final String user;
    private final String password;
    private final String url;
    private final String driver;

    public JdbcDataSourceProperties(
            final String user,
            final String password,
            final String url,
            final String driver
    ) {
        this.user = user;
        this.password = password;
        this.url = url;
        this.driver = driver;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }
}
