package by.itacademy.connection;

import by.itacademy.connection.impl.ConnectionCreator;

public interface Connection {
    ConnectionProperties create (String source) throws ConnectionException;
}
