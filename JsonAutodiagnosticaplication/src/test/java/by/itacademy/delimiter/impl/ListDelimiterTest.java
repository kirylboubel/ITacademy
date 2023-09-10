package by.itacademy.delimiter.impl;

import by.itacademy.transport.Transport;
import by.itacademy.transport.TransportTypeAndCost;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListDelimiterTest {

    @Test
    void divideListToRightTransportlis_happyTest() {
        final List<Transport> transportList = new ArrayList<>();
        transportList.add(new Transport(TransportTypeAndCost.AUTOMOBILE, "galaxy"));
        transportList.add(new Transport(TransportTypeAndCost.AUTOMOBILE, "malibu"));

        final ListDelimiter listDelimiter = new ListDelimiter();
        final List<Transport> rightTransportList = listDelimiter.divideListToRightTransportlis(transportList);

        assertNotNull(rightTransportList, "rightTransportList is null");
        for (Transport transport : rightTransportList){
            assertEquals(transport.getTransportTypeAndCost(), TransportTypeAndCost.AUTOMOBILE);
        }
    }

    @Test
    void divideListToWrongTransportlist_happyTest() {
        final List<Transport> transportList = new ArrayList<>();
        transportList.add(new Transport(TransportTypeAndCost.AUTOMOBILE, "MX-5!"));
        transportList.add(new Transport(TransportTypeAndCost.AUTOMOBILE, "Land Cruze&"));

        final ListDelimiter listDelimiter = new ListDelimiter();
        final List<Transport> wrongTransportList = listDelimiter.divideListToWrongTransportlis(transportList);

        assertNotNull(wrongTransportList, "wrongTransportList is null");
        for (Transport transport: wrongTransportList){
            assertEquals(transport.getTransportTypeAndCost(), TransportTypeAndCost.AUTOMOBILE);
        }
    }
}