package by.itacademy.convertor.impl;

import by.itacademy.transport.transport.Transport;
import by.itacademy.transport.transport.TransportTypeAndCost;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ListConvertorTest {

    @Test
    void testConvertToProcessedJsonTransports_happyPath() {
        //given
        final List<Transport> expectedTransportList = new ArrayList<>();
        expectedTransportList.add(new Transport(TransportTypeAndCost.AUTOMOBILE, "galaxy"));
        expectedTransportList.add(new Transport(TransportTypeAndCost.AUTOMOBILE, "malibu"));
        Comparator<Transport> comparator = Comparator.comparing(Transport::getTransportName);

        //when
        final ListConvertor listConvertor = new ListConvertor();
        final List<JSONObject> rightTransportList = listConvertor.convertToProcessedJsonTransports(expectedTransportList, comparator);

        //then
        assertNotNull(rightTransportList, "rightTransportList is null");
        assertEquals(2, rightTransportList.size());
        for (JSONObject jsonObject : rightTransportList) {
            assertEquals(TransportTypeAndCost.AUTOMOBILE.getDescription(), jsonObject.getString("type"));
            assertEquals(TransportTypeAndCost.AUTOMOBILE.getTaxValue(), jsonObject.get("cost"));
        }
    }

    @Test
    void testConvertToInvalidJsonTransports_happyPath() {
        //given
        final List<Transport> expectedTransportList = new ArrayList<>();
        expectedTransportList.add(new Transport(TransportTypeAndCost.AUTOMOBILE, "MX-5!"));
        expectedTransportList.add(new Transport(TransportTypeAndCost.AUTOMOBILE, "Land Cruze&"));
        Comparator<Transport> comparator = Comparator.comparing(Transport::getTransportName);

        //when
        final ListConvertor listConvertor = new ListConvertor();
        final List<JSONObject> wrongTransportlist = listConvertor.convertToInvalidJsonTransports(expectedTransportList, comparator);

        //then
        assertNotNull(wrongTransportlist, "wrongTransportlist is null");
        assertEquals(2, wrongTransportlist.size());
        for (JSONObject jsonObject : wrongTransportlist) {
            assertEquals(TransportTypeAndCost.AUTOMOBILE.getDescription(), jsonObject.getString("type"));
        }
    }
}