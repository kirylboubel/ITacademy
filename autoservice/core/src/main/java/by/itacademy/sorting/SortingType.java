package by.itacademy.sorting;

import java.util.Comparator;

import by.itacademy.transport.transport.Transport;

import java.util.function.Function;

public enum SortingType {
    TYPE((Transport::getTransportType)),
    MODEL(Transport::getTransportName),
    PRICE(Transport::getTransportTax);

    private final Comparator<Transport> transportComparator;

    <T extends Comparable<T>> SortingType(final Function<Transport, T> function) {
        this.transportComparator = Comparator.comparing(function);
    }

    public Comparator<Transport> getTransportComparator() {
        return transportComparator;
    }
}
