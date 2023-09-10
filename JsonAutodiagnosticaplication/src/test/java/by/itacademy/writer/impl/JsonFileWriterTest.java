package by.itacademy.writer.impl;

import by.itacademy.sorting.*;
import by.itacademy.transport.Transport;
import by.itacademy.transport.TransportTypeAndCost;
import by.itacademy.writer.DataWriterException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.xml.crypto.Data;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

import static org.junit.jupiter.api.Assertions.*;

class JsonFileWriterTest {

    private final static String EXPECTED_RIGHT_WRITE = "[{\"cost\":30,\"name\":\"vito\",\"type\":\"микроавтобус\"}," +
            " {\"cost\":10,\"name\":\"ninja\",\"type\":\"мотоцикл\"}," +
            " {\"cost\":20,\"name\":\"galaxy\",\"type\":\"автомобиль\"}]";
    private final static String EXPECTED_WRONG_WRITE = "[{\"name\":\"galax#\",\"type\":\"автомобиль\"}," +
            " {\"name\":\"ninj*\",\"type\":\"мотоцикл\"}," +
            " {\"name\":\"vit!\",\"type\":\"микроавтобус\"}]";

    @Test
    void testRightWrite_happyTest() throws SortingReaderException, DataWriterException {
        Comparator<Transport> comparator = Comparator.comparing(Transport::getTransoprtName);

        final List<Transport> transportList = new ArrayList<>();
        transportList.add(new Transport(TransportTypeAndCost.MOTORBIKE, "ninja"));
        transportList.add(new Transport(TransportTypeAndCost.AUTOMOBILE, "galaxy"));
        transportList.add(new Transport(TransportTypeAndCost.MINIBUS, "vito"));

        JsonFileWriter jsonFileWriter = new JsonFileWriter("src/test/resources/test-procesed-transport.json",
                "src/test/resources/test-invalid-transport.json");
        jsonFileWriter.rightWrite(transportList, comparator.reversed());

        assertNotNull(jsonFileWriter.getRightJsonFileName(), "rightJsonFile is null");

        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/test-procesed-transport.json", StandardCharsets.UTF_8))) {
            final String content = reader.lines()
                    .reduce(String::concat)
                    .orElse(null);

            assertEquals(content, EXPECTED_RIGHT_WRITE);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testWrongWrite_happyTest() throws DataWriterException {

        final List<Transport> wrongTransportList = new ArrayList<>();
        wrongTransportList.add(new Transport(TransportTypeAndCost.AUTOMOBILE, "galax#"));
        wrongTransportList.add(new Transport(TransportTypeAndCost.MOTORBIKE, "ninj*"));
        wrongTransportList.add(new Transport(TransportTypeAndCost.MINIBUS, "vit!"));

        JsonFileWriter jsonFileWriter = new JsonFileWriter("src/test/resources/test-procesed-transport.json",
                "src/test/resources/test-invalid-transport.json");
        jsonFileWriter.wrongWrite(wrongTransportList);

        assertNotNull(jsonFileWriter.getWrongJsonFileName(), "wrongJsonFile is null");
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/test-invalid-transport.json", StandardCharsets.UTF_8))) {
            final String content = reader.lines()
                    .reduce(String::concat)
                    .orElse(null);

            assertEquals(content, EXPECTED_WRONG_WRITE);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testJsonFileWriter_wrongData() {
        final List<Transport> transportList = null;

        JsonFileWriter jsonFileWriter = new JsonFileWriter("D:\\Users\\test-procesed-transport.json",
                "D:\\Users\\test-invalid-transport.json");

        final var exception = assertThrows(DataWriterException.class, () -> jsonFileWriter.wrongWrite(transportList));

        assertNotNull(exception, "Exception is null");
        assertNotNull(exception.getMessage(), "Failed to write file ");

    }
}