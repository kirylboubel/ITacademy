package by.itacademy.reader.impl;

import by.itacademy.reader.TransportReaderException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileTrasportReaderTest {

    @Test
    void testRead_happyTest() throws TransportReaderException {
        FileTrasportReader fileTrasportReader = new FileTrasportReader("test-transport.json");
        final String content = "[  {    \"type\": \"motorbike\",    \"model\": \"Ninja ZX-14\"  }," +
                "  {    \"type\": \"automobile\",    \"model\": \"Audi Q7\"  }, " +
                " {    \"type\": \"minibus\",    \"model\": \"Sprinter264\"  }, " +
                " {    \"type\": \"minibus\",    \"model\": \"Transporter T5\"  }, " +
                " {    \"type\": \"automobile\",    \"model\": \"BMW M5\"  }, " +
                " {    \"type\": \"automobile\",    \"model\": \"Mazda CX7\"  }, " +
                " {    \"type\": \"motorbike\",    \"model\": \"Ninja **\"  }]";

        assertEquals(content, fileTrasportReader.read());
        assertNotNull(fileTrasportReader.getFileName(), "test-transport.json file not null");
    }

    @Test
    void testRead_impossibleToFindFile() throws TransportReaderException {
        var fileTrasportReader = new FileTrasportReader("transporter.json");
        final var exception = assertThrows(TransportReaderException.class, () -> fileTrasportReader.read());

        assertNotNull(exception, "Exception is null");
        assertNotNull(exception.getMessage(), "Resource from file [%s] is null");
    }
}