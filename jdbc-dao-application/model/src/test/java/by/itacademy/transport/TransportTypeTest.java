package by.itacademy.transport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransportTypeTest {
    final TransportType actualTransportType = TransportType.AUTOMOBILE;

    @Test
    void testGetId_happyPath() {
        //given
        final int expectedId = 2;

        //when
        final int actualId = actualTransportType.getId();

        //then
        assertEquals(expectedId, actualId);
    }

    @Test
    void testGetName_happyPath() {
        //given
        final String expectedName = "automobile";

        //when
        final String actualName = actualTransportType.getName();

        //then
        assertEquals(expectedName, actualName);
    }

    @Test
    void testToString_happyPath() {
        //given
        final String expectedToString = "Transport type id = 2 Transport name = automobile";

        //when
        final String actualToString = actualTransportType.toString();

        //then
        assertEquals(expectedToString, actualToString);
    }
}