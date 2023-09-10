package by.itacademy.delimiter.impl;

import by.itacademy.delimiter.Delimiter;
import by.itacademy.transport.Transport;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class ListDelimiter implements Delimiter {
    private static final Predicate<String> PATTERN_RIGHT_VEHICLE = Pattern.compile("^[a-zA-Z]((\s|-)?[a-zA-Z0-9])*$").asPredicate();

    @Override
    public final List<Transport> divideListToRightTransportlis(final List<Transport> transportList) {
        return transportList.stream()
                .filter(ListDelimiter::isValid)
                .toList();
    }

    @Override
    public final List<Transport> divideListToWrongTransportlis(final List<Transport> transportList) {
        return transportList.stream()
                .filter(ListDelimiter::inValid)
                .toList();
    }

    private static boolean isValid(final Transport transport) {
        return PATTERN_RIGHT_VEHICLE.test(transport.getTransoprtName());
    }

    private static boolean inValid(final Transport transport) {
        return PATTERN_RIGHT_VEHICLE.negate().test(transport.getTransoprtName());
    }
}

