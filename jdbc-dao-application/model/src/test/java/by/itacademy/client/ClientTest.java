package by.itacademy.client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientTest {

    final Client actualClient = new Client(10, "John", "Conor");

    @Test
    void testGetClientFirstName_happyPath() {
        //given
        final String expectedFirstName = "John";

        //when
        final String actualClientFirstName = actualClient.getFirstName();

        //then
        assertEquals(expectedFirstName, actualClientFirstName);
    }

    @Test
    void testGetLastName_happyPath() {
        //given
        final String expectedLastName = "Conor";

        //when
        final String actualClientLastName = actualClient.getLastName();

        //then
        assertEquals(expectedLastName, actualClientLastName);
    }

    @Test
    void testGetId_happyPath() {
        //given
        final int expectedId = 10;

        //when
        final int actualId = actualClient.getId();

        //
        assertEquals(expectedId, actualId);
    }

    @Test
    void testToString_happyPath() {
        //given
        final String expectedToString = "Client id = 10 first name = John last name = Conor";

        //when
        final String actualToString = actualClient.toString();

        //then
        assertEquals(expectedToString, actualToString);
    }
}