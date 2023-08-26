package by.itacademy.parser;

import by.itacademy.transport.Transport;

import javax.swing.text.Document;
import java.util.List;

public interface DocumentParser {
    List<Transport> parse (String content) throws DocumentParserException;
}
