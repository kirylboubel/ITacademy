package by.itacademy.transport;

import by.itacademy.client.Client;
import by.itacademy.modelType.ModelType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransportTest {
    final Client actualClient = new Client(10, "John", "Conor");
    final ModelType actualModelType = new ModelType(10, "BMW X-7");
    final TransportType actualTransportType = TransportType.AUTOMOBILE;
    final Transport actualTransport = new Transport(10, actualTransportType, actualModelType, actualClient);

    @Test
    void testGetTransportType_happyPath() {
        //given
        final TransportType expectedTransportType = TransportType.AUTOMOBILE;

        //when
        final TransportType actualTransportType = actualTransport.getTransportType();

        //then
        assertEquals(expectedTransportType, actualTransportType);
    }

    @Test
    void testGetModelType_happyPath() {
        //given
        final ModelType expectedModelType = new ModelType(10, "BMW X-7");

        //when
        final ModelType actualModelType = actualTransport.getModelType();

        //then
        assertEquals(expectedModelType, actualModelType);
    }

    @Test
    void testGetClient_happyPath() {
        //given
        final Client expectedClient = new Client(10, "John", "Conor");

        //when
        final Client actualClient = actualTransport.getClient();

        //then
        assertEquals(expectedClient, actualClient);
    }

    @Test
    void testToString_happyPath() {
        //given
        final String expectedToString = "| Id = 10 | | Transport Type Id = 2 | | Model type Id  = 10| Client Id  = 10";

        //when
        final String actualToString = actualTransport.toString();

        //then
        assertEquals(expectedToString, actualToString);
    }
}