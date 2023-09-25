package by.itacademy.reader.impl;

import by.itacademy.reader.TransportReaderException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static by.itacademy.util.CommonConstants.DEFAULT_CHARSET;
import static org.junit.jupiter.api.Assertions.*;

class jsonTransportReaderTest {

    @Test
    void testRead_happyPath() throws TransportReaderException {
        //given
        final var expectedString = "[{\"type\":\"automobile\",\"model\":\"X-5\"}]";
        final var content = "[{\"type\":\"automobile\",\"model\":\"X-5\"}]".getBytes(DEFAULT_CHARSET);
        final var in = new ByteArrayInputStream(content);

        //when
        final var reader = new jsonTransportReader();
        final var transportSting = reader.read(in);

        //then
        assertEquals(expectedString,transportSting);
    }
}