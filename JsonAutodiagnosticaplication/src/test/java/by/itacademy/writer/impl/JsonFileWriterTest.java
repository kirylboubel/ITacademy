package by.itacademy.writer.impl;

import by.itacademy.sorting.*;
import by.itacademy.transport.Transport;
import by.itacademy.transport.TransportTypeAndCost;
import by.itacademy.writer.DataWriterException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class JsonFileWriterTest {

    @Test
    void testRightWrite_happyTest() throws DataWriterException, SortingReaderException {
        try (final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/test/resources/test-procesed-transport.json"))) {
            final var sorting = new Sorting(SortingType.TYPE, SortingDirection.ASC);
            final List<Sorting> sortingList = new ArrayList<>();
            sortingList.add(sorting);

            final List<Transport> transportList = new ArrayList<>();
            transportList.add(new Transport(TransportTypeAndCost.AUTOMOBILE, "galaxy"));
            transportList.add(new Transport(TransportTypeAndCost.MOTORBIKE, "ninja"));
            transportList.add(new Transport(TransportTypeAndCost.MINIBUS, "vito"));

            final var comparator = Mockito.mock(SortingReader.class);
            Mockito.when(comparator.readSorting()).thenReturn(sortingList.stream()
                    .map(Sorting::getComparator)
                    .reduce((t1, t2) -> 0, Comparator::thenComparing));

            final List<Transport> sortedTransportList = transportList.stream()
                    .sorted(comparator.readSorting())
                    .toList();

            final List<JSONObject> rightJsonList = new ArrayList<>();
            for (final Transport transport : sortedTransportList) {
                final JSONObject jsonObject = new JSONObject();

                jsonObject.put("type", transport.getTransportType());
                jsonObject.put("name", transport.getTransoprtName());
                jsonObject.put("cost", transport.getTransportTax());

                rightJsonList.add(jsonObject);

            }
            bufferedWriter.write(rightJsonList.toString());

            assertNotNull(rightJsonList, "rightJsonList is null");
            assertEquals(rightJsonList.get(0).getString("type"), TransportTypeAndCost.AUTOMOBILE.getDescription());
            Mockito.verify(comparator).readSorting();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SortingReaderException e) {
            throw new SortingReaderException("Ошибка чтения сортировки для транспорта", e);
        }
    }

    @Test
    void testWrongWrite_happyTest() throws DataWriterException {
        try (final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/test/resources/test-ivalid-transport.json"))) {
            final List<Transport> wrongTransportList = new ArrayList<>();
            wrongTransportList.add(new Transport(TransportTypeAndCost.AUTOMOBILE, "galax#"));
            wrongTransportList.add(new Transport(TransportTypeAndCost.MOTORBIKE, "ninj*"));
            wrongTransportList.add(new Transport(TransportTypeAndCost.MINIBUS, "vit!"));

            final List<JSONObject> wrongJsonList = new ArrayList<>();

            for (final Transport transport : wrongTransportList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("type", transport.getTransportType());
                jsonObject.put("name", transport.getTransoprtName());

                wrongJsonList.add(jsonObject);
            }
            bufferedWriter.write(wrongJsonList.toString());

            assertNotNull(wrongJsonList, "rightJsonList is null");
            assertEquals(wrongJsonList.get(0).getString("type"), TransportTypeAndCost.AUTOMOBILE.getDescription());
        } catch (final IOException e) {
            final String exception = "Directory not found ";
            throw new DataWriterException(exception, e);
        }
    }
}
