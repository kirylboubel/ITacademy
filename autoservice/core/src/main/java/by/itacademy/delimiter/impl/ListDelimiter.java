package by.itacademy.delimiter.impl;

import by.itacademy.annotation.Parametr;
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
    @Parametr(name = "procesed-transport list")
    public final List<JSONObject> divideListToRightTransportlis(final List<Transport> transportList) {
        final List<Transport> rightTransportList = transportList.stream()
                .filter(ListDelimiter::isValid)
                .toList();

        return divideList(rightTransportList, true);
    }

    @Override
    @Parametr(name = "invalid-transport list")
    public final List<JSONObject> divideListToWrongTransportlis(final List<Transport> transportList) {
        final List<Transport> wrongTransportList = transportList.stream()
                .filter(transport -> !isValid(transport))
                .toList();

        return divideList(wrongTransportList, false);
    }

    private static boolean isValid(final Transport transport) {
        return PATTERN_RIGHT_VEHICLE.test(transport.getTransoprtName());
    }

    private List<JSONObject> divideList(final List<Transport> transportList, final boolean isValid) {
        final List<JSONObject> jsonObjectList = new ArrayList<>(transportList.size());

        for (final Transport transport : transportList) {
            final JSONObject jsonObject = new JSONObject();
            jsonObject.put("type", transport.getTransportType());
            jsonObject.put("name", transport.getTransoprtName());

            if (isValid) {
                jsonObject.put("cost", transport.getTransportTax());
            }
            jsonObjectList.add(jsonObject);
        }
        return jsonObjectList;
    }

}

