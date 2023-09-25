package by.itacademy.transport;

import by.itacademy.transport.transport.TransportTypeAndCost;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TransportTypeAndCostTest {
    @Test
    void testValues_happyPath() {
        //given
        final var expectedTransportTypesAndCosts  =Arrays.asList("MOTORBIKE", "AUTOMOBILE", "MINIBUS");

        //whrn
        final var actualTransportTypesAndCosts = Stream.of(TransportTypeAndCost.values())
                .map(TransportTypeAndCost::name)
                .toList();

        //then
        assertEquals(expectedTransportTypesAndCosts, actualTransportTypesAndCosts);
    }

    @Test
    void testGetDescription_happyPath() {
        //given
        final var expectedDescription = Arrays.asList("motorbike", "automobile", "minibus");

        //when
        final var actualDescription = Stream.of(TransportTypeAndCost.values())
                .map(TransportTypeAndCost::getDescription)
                .toList();

        //then
        assertEquals(expectedDescription, actualDescription);
    }

    @Test
    void testGetTaxValue_happyPath() {
        //given
        final var expectedTaxValue = Arrays.asList(10, 20, 30);

        //when
        final var actualDescription = Stream.of(TransportTypeAndCost.values())
                .map(TransportTypeAndCost::getTaxValue)
                .toList();

        //then
        assertEquals(expectedTaxValue, actualDescription);
    }
}