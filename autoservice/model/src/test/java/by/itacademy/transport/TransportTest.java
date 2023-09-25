package by.itacademy.transport;

import by.itacademy.transport.transport.Transport;
import by.itacademy.transport.transport.TransportTypeAndCost;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransportTest {

    @Test
    void testGetTransportType_happyPath() {
        //given
        final var expectedTranportTypeAndCost = TransportTypeAndCost.AUTOMOBILE;
        final var transport = new Transport(expectedTranportTypeAndCost, null);

        //when
        final var actualTransportTypeAndCost = transport.getTransportType();

        //then
        assertEquals(expectedTranportTypeAndCost.getDescription(), actualTransportTypeAndCost);
    }

    @Test
    void getTransportTax() {
        //given
        final var expectedTranportTypeAndCost = TransportTypeAndCost.AUTOMOBILE;
        final var transport = new Transport(expectedTranportTypeAndCost, null);

        //when
        final var actualTransportTax = transport.getTransportTax();

        //then
        assertEquals(expectedTranportTypeAndCost.getTaxValue(), actualTransportTax);
    }

    @Test
    void testGetTransoprtName_happyPath() {
        //given
        final var expectedTransportName = "name";
        final var transport = new Transport(null, expectedTransportName);

        //when
        final var actualTransportName = transport.getTransportName();

        //then
        assertEquals(expectedTransportName, actualTransportName);
    }
}