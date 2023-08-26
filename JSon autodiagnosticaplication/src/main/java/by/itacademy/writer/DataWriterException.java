package by.itacademy.writer;

import java.io.IOException;

public class DataWriterException extends Exception {
    public DataWriterException(IOException message) {
        super(message);
    }

    public DataWriterException(String message, Throwable cause) {
        super(message, cause);
    }
}
