package by.itacademy.sorting.impl;

import by.itacademy.sorting.*;
import by.itacademy.transport.transport.Transport;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TransportSorter implements SortingReader {

    @Override
    public Comparator<Transport> readSorting(final List<String> sortingTypeList, final List<String> sortingDirectionList) throws SortingReaderException {
        if (sortingTypeList.size() != sortingDirectionList.size()) {
            throw new SortingReaderException("Incorrect sort data passed");
        }

        final List<Sorting> sortingList = new ArrayList<>(sortingTypeList.size());

        for (int index = 0; index <= sortingTypeList.size() - 1; index++) {
            final SortingType sortingType = SortingType.valueOf(sortingTypeList.get(index).toUpperCase());
            final SortingDirection sortingDirection = SortingDirection.valueOf(sortingDirectionList.get(index).toUpperCase());

            sortingList.add(new Sorting(sortingType, sortingDirection));
        }
        return sortingList.stream()
                .map(Sorting::getComparator)
                .reduce((t1, t2) -> 0, Comparator::thenComparing);
    }
}
