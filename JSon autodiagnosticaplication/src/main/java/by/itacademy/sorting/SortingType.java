package by.itacademy.sorting;

import java.util.Comparator;
import by.itacademy.transport.Transport;
import java.util.function.Function;

public enum SortingType {
    TYPE((transport -> transport.getTransportTypeAndCost().name())),
    MODEL(Transport::getTransoprtName),
    PRICE(Transport::getTransportTax);

    private final Comparator<Transport> transportComparator;

    <T extends Comparable<T>> SortingType(final Function<Transport, T> function) {
        this.transportComparator = Comparator.comparing(function);
    }

    public Comparator<Transport> getTransportComparator() {
        return transportComparator;
    }
}
