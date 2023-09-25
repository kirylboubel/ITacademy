package by.itacademy.sorting.impl;

import by.itacademy.sorting.SortingDirection;
import by.itacademy.sorting.SortingReaderException;
import by.itacademy.sorting.SortingType;
import by.itacademy.transport.transport.Transport;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransportSorterTest {

    @Test
    void testReadSorting_happyPath() throws SortingReaderException {
        //given
        List<String> sortingTypeList = new ArrayList<>();
        sortingTypeList.add("model");
        List<String> sortingDirectionList = new ArrayList<>();
        sortingDirectionList.add("dsc");

        //when
        TransportSorter transportSorter = new TransportSorter();
        Comparator<Transport> comparator = transportSorter.readSorting(sortingTypeList, sortingDirectionList);

        //then
        assertNotNull(comparator, "comparator is null");
    }
}