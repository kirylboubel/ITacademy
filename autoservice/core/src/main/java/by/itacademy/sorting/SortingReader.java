package by.itacademy.sorting;

import by.itacademy.transport.transport.Transport;

import java.util.Comparator;
import java.util.List;

public interface SortingReader {
    Comparator<Transport> readSorting(List<String> sortingTypeList, List<String> sortingDirectionList) throws SortingReaderException;
}
