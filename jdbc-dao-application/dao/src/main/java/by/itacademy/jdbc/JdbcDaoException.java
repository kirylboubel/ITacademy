package by.itacademy.jdbc;

import by.itacademy.DaoException;

public class JdbcDaoException extends DaoException {
    public JdbcDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public static class ClientJdbcDaoException extends JdbcDaoException {
        public ClientJdbcDaoException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
