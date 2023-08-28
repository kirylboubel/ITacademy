package by.itacademy.reader.impl;

import by.itacademy.reader.TransportReaderException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileTrasportReaderTest {

    @Test
    void testRead_happyTest() throws TransportReaderException {
        var fileTrasportReader = new FileTrasportReader("transport.json");
        assertEquals(fileTrasportReader.getFileName(), "transport.json");
        //понимаю что должен вызывать метод getAbsolutePath, но не могу его вызвать из-за приватного метода gwtReader
    }
}