package by.itacademy.dao.jdbc;

import by.itacademy.dao.DaoException;

public class JdbcDaoException extends DaoException {
    public JdbcDaoException(String message) {
        super(message);
    }

    public JdbcDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public static class ClientJdbcDaoException extends JdbcDaoException {
        public ClientJdbcDaoException(String message) {
            super(message);
        }

        public ClientJdbcDaoException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class TransportJdbcDaoException extends JdbcDaoException {
        public TransportJdbcDaoException(String message) {
            super(message);
        }

        public TransportJdbcDaoException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
