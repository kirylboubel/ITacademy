package by.itacademy.writer.impl;

import by.itacademy.transport.Transport;
import by.itacademy.writer.DataWriter;
import by.itacademy.writer.DataWriterException;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JsonFileWriter implements DataWriter {
    private final File rightJsonFileName;
    private final File wrongJsonFileName;

    public JsonFileWriter(final String rightJsonFileName, final String wrongJsonFileName) {
        this.rightJsonFileName = new File(rightJsonFileName);
        this.wrongJsonFileName = new File(wrongJsonFileName);
    }

    @Override
    public void rightWrite(final List<Transport> rightTransportList, Comparator<Transport> comparator) throws DataWriterException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(rightJsonFileName, StandardCharsets.UTF_8))) {
            final List<JSONObject> rightJsonList = new ArrayList<>();
            final List<Transport> sortedTransportList;
            sortedTransportList = rightTransportList.stream().sorted(comparator).collect(Collectors.toList());

            for (Transport transport : sortedTransportList) {
                final JSONObject jsonObject = new JSONObject();

                jsonObject.put("type", transport.getTransportType());
                jsonObject.put("name", transport.getTransoprtName());
                jsonObject.put("cost", transport.getTransportTax());

                rightJsonList.add(jsonObject);
            }
            bufferedWriter.write(rightJsonList.toString());
        } catch (IOException e) {
            throw new DataWriterException(e);
        }
    }

    @Override
    public void wrongWrite(final List<Transport> wrongTransportList) throws DataWriterException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(wrongJsonFileName, StandardCharsets.UTF_8))) {
            JSONObject jsonObject = new JSONObject();
            final List<JSONObject> wrongJsonList = new ArrayList<>();

            for (Transport transport : wrongTransportList) {
                jsonObject.put("type", transport.getTransportType());
                jsonObject.put("name", transport.getTransoprtName());

                wrongJsonList.add(jsonObject);
            }
            bufferedWriter.write(wrongJsonList.toString());
        } catch (IOException e) {
            throw new DataWriterException(e);
        }
    }
}
