package by.itacademy.delimiter.impl;

import by.itacademy.delimiter.Delimiter;
import by.itacademy.transport.Transport;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ListDelimiter implements Delimiter {
    private static final Predicate<String> PATTERN_RIGHT_VEHICLE = Pattern.compile("^[a-zA-Z]((\s|-)?[a-zA-Z0-9])*$").asPredicate();

    @Override
    public final List<Transport> divideListToRightTransportlis(final List<Transport> transportList) {
        return transportList.stream()
                .filter(transport -> isValid(transport))
                .collect(Collectors.toList());
    }

    @Override
    public final List<Transport> divideListToWrongTransportlis(List<Transport> transportList) {
        return transportList.stream()
                .filter(transport -> isInvalid(transport))
                .collect(Collectors.toList());
    }

    private static boolean isValid(final Transport transport) {
        return PATTERN_RIGHT_VEHICLE.test(transport.getTransoprtName());
    }

    private static boolean isInvalid(final Transport transport) {
        if (PATTERN_RIGHT_VEHICLE.test(transport.getTransoprtName())) {
            return false;
        } else return true;
    }
}

