package by.itacademy.delimiter.impl;

import by.itacademy.transport.Transport;
import by.itacademy.transport.TransportTypeAndCost;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListDelimiterTest {

    @Test
    void testDivideListToRightTransportlist_happyPath() {
        //given
        final List<Transport> expectedTransportList = new ArrayList<>();
        expectedTransportList.add(new Transport(TransportTypeAndCost.AUTOMOBILE, "galaxy"));
        expectedTransportList.add(new Transport(TransportTypeAndCost.AUTOMOBILE, "malibu"));

        //when
        final ListDelimiter listDelimiter = new ListDelimiter();
        final List<JSONObject> rightTransportList = listDelimiter.divideListToRightTransportlist(expectedTransportList);

        //then
        assertNotNull(rightTransportList, "rightTransportList is null");
        assertEquals(2, rightTransportList.size());
        for (JSONObject jsonObject : rightTransportList) {
            assertEquals(TransportTypeAndCost.AUTOMOBILE.getDescription(), jsonObject.getString("type"));
            assertEquals(TransportTypeAndCost.AUTOMOBILE.getTaxValue(), jsonObject.get("cost"));
        }
    }

    @Test
    void divideListToWrongTransportlist() {
        final List<Transport> expectedTransportList = new ArrayList<>();
        expectedTransportList.add(new Transport(TransportTypeAndCost.AUTOMOBILE, "MX-5!"));
        expectedTransportList.add(new Transport(TransportTypeAndCost.AUTOMOBILE, "Land Cruze&"));

        //when
        final ListDelimiter listDelimiter = new ListDelimiter();
        final List<JSONObject> wrongTransportlist = listDelimiter.divideListToWrongTransportlist(expectedTransportList);

        //then
        assertNotNull(wrongTransportlist, "wrongTransportlist is null");
        assertEquals(2, wrongTransportlist.size());
        for (JSONObject jsonObject : wrongTransportlist) {
            assertEquals(TransportTypeAndCost.AUTOMOBILE.getDescription(), jsonObject.getString("type"));
        }
    }
}