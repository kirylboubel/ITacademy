package by.itacademy.sorting;

import by.itacademy.transport.Transport;

import java.util.Comparator;

public interface SortingReader {
    Comparator<Transport> readSorting() throws SortingReaderException;
}
