package by.itacademy.parser.impl;

import by.itacademy.parser.DocumentParserException;
import by.itacademy.transport.Transport;
import by.itacademy.transport.TransportTypeAndCost;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonDocumentParserTest {

    @Test
    void testParse_happyPath() throws DocumentParserException {
        final String content = "[\n" +
                "  {\n" +
                "    \"type\": \"automobile\",\n" +
                "    \"model\": \"Audi Q7\"\n" +
                "  }\n" +
                "]";
        final JsonDocumentParser parser = new JsonDocumentParser();
        final List<Transport> transportList = parser.parse(content);

        assertNotNull(transportList, "List is null");
        assertEquals(transportList.get(0).getTransportTypeAndCost(), TransportTypeAndCost.AUTOMOBILE);
    }

    @Test
    void testParse_impossibleToReadContent_happyPath() throws DocumentParserException {
        final String content = "{\n" +
                "    \"type\": \"automobile\",\n" +
                "    \"model\": \"Audi Q7\"\n" +
                "  }\n";
        final JsonDocumentParser parser = new JsonDocumentParser();
        final var exception = assertThrows(DocumentParserException.class, () -> parser.parse(content));

        assertNotNull(exception, "Exception is null");
        assertEquals("Failed to parse JSON content", exception.getMessage());
    }
}