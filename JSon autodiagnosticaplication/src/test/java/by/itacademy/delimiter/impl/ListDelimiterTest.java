package by.itacademy.delimiter.impl;

import by.itacademy.transport.Transport;
import by.itacademy.transport.TransportTypeAndCost;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListDelimiterTest {

    @Test
    void testDivideList_happyTest() {
        final List<Transport> transportList = new ArrayList<>();
        transportList.add(new Transport(TransportTypeAndCost.AUTOMOBILE, "galaxy"));
        transportList.add(new Transport(TransportTypeAndCost.AUTOMOBILE, "MX-5!"));

        final ListDelimiter listDelimiter = new ListDelimiter();
        listDelimiter.divideList(transportList);

        assertNotNull(listDelimiter.getWrongTransportList(), "wrongTransportList is null");
        assertNotNull(listDelimiter.getRightTransportList(), "rightTransportList is null");
        assertEquals(listDelimiter.getRightTransportList().get(0).getTransportTypeAndCost(), TransportTypeAndCost.AUTOMOBILE);
    }
}