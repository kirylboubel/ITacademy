package by.itacademy.reader;

import java.io.IOException;
import java.io.InputStream;

public interface TransportReader {
    String read(InputStream in) throws TransportReaderException, IOException;
}
