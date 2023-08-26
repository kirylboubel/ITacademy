package by.itacademy.delimiter.impl;

import by.itacademy.delimiter.Delimiter;
import by.itacademy.delimiter.ListDelimiterException;
import by.itacademy.transport.Transport;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class ListDelimiter implements Delimiter {
    private static final Predicate<String> PATTERN_RIGHT_VEHICLE = Pattern.compile("^[a-zA-Z]((\s|-)?[a-zA-Z0-9])*$").asPredicate();
    private List<Transport> wrongTransportList;
    private List<Transport> rightTransportList;


    public List<Transport> getWrongTransportList() {
        return wrongTransportList;
    }

    public List<Transport> getRightTransportList() {
        return rightTransportList;
    }

    @Override
    public void divideList(final List<Transport> transportList) throws ListDelimiterException {
    rightTransportList = new ArrayList<>();
    wrongTransportList = new ArrayList<>();
        for (Transport transport : transportList) {
            if (PATTERN_RIGHT_VEHICLE.test(transport.getTransoprtName())) {
                rightTransportList.add(transport);

            } else wrongTransportList.add(transport);
        }
        System.out.println(rightTransportList);
        System.out.println(wrongTransportList);
    }
}
