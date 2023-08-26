package by.itacademy.reader;

import by.itacademy.parser.DocumentParser;
import by.itacademy.parser.impl.JsonDocumentParser;
import by.itacademy.transport.Transport;

import java.util.ArrayList;
import java.util.List;

public interface TransportFileReader {
    String read() throws TransportReaderException;
}
