package by.itacademy.parser.impl;

import by.itacademy.parser.DocumentParserException;
import by.itacademy.transport.transport.Transport;
import by.itacademy.transport.transport.TransportTypeAndCost;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class JsonDocumentParserTest {

    @Test
    void testParse_happyPath() throws DocumentParserException {
        //given
        final var transport = new Transport(TransportTypeAndCost.AUTOMOBILE, "X-5");
        final var expectedTransoprtList = Collections.singletonList(transport);
        final var content = "[{\"type\":\"automobile\",\"model\":\"X-5\"}]";

        //when
        final var parser = new JsonDocumentParser();
        final var actualTransportlist = parser.parse(content);

        //then
        assertEquals(expectedTransoprtList, actualTransportlist);
    }
}