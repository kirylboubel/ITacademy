package by.itacademy.delimiter.impl;

import by.itacademy.delimiter.Delimiter;
import by.itacademy.transport.Transport;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class ListDelimiter implements Delimiter {
    private static final Predicate<String> PATTERN_RIGHT_VEHICLE = Pattern.compile("^[a-zA-Z]((\s|-)?[a-zA-Z0-9])*$").asPredicate();

    @Override
    public final List<JSONObject> divideListToRightTransportlist(final List<Transport> transportList) {
        final List<Transport> rightTransportList = transportList.stream()
                .filter(ListDelimiter::isValid)
                .toList();

        return divideList(rightTransportList, true);
    }

    @Override
    public final List<JSONObject> divideListToWrongTransportlist(final List<Transport> transportList) {
        final List<Transport> wrongTransportList = transportList.stream()
                .filter(transport -> !isValid(transport))
                .toList();

        return divideList(wrongTransportList, false);
    }

    private static boolean isValid(final Transport transport) {
        return PATTERN_RIGHT_VEHICLE.test(transport.getTransportName());
    }

    private List<JSONObject> divideList(final List<Transport> transportList, final boolean isValid) {
        final List<JSONObject> jsonObjectList = new ArrayList<>(transportList.size());

        for (final Transport transport : transportList) {
            final JSONObject jsonObject = new JSONObject();
            jsonObject.put("type", transport.getTransportType());
            jsonObject.put("name", transport.getTransportName());

            if (isValid) {
                jsonObject.put("cost", transport.getTransportTax());
            }
            jsonObjectList.add(jsonObject);
        }
        return jsonObjectList;
    }
}

