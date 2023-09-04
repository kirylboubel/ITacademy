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
        try (final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(rightJsonFileName, StandardCharsets.UTF_8))) {
            final List<JSONObject> rightJsonList = new ArrayList<>();
            final List<Transport> sortedTransportList = rightTransportList.stream()
                    .sorted(comparator)
                    .collect(Collectors.toList());

            for (final Transport transport : sortedTransportList) {
                final JSONObject jsonObject = new JSONObject();

                jsonObject.put("type", transport.getTransportType());
                jsonObject.put("name", transport.getTransoprtName());
                jsonObject.put("cost", transport.getTransportTax());

                rightJsonList.add(jsonObject);
            }
            bufferedWriter.write(rightJsonList.toString());
        } catch (final IOException e) {
            final String exception = "Directory not found ";
            throw new DataWriterException(exception + rightJsonFileName.getAbsolutePath(), e);
        }
    }

    @Override
    public void wrongWrite(final List<Transport> wrongTransportList) throws DataWriterException {
        try (final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(wrongJsonFileName, StandardCharsets.UTF_8))) {
            final List<JSONObject> wrongJsonList = new ArrayList<>();

            for (final Transport transport : wrongTransportList) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("type", transport.getTransportType());
                jsonObject.put("name", transport.getTransoprtName());

                wrongJsonList.add(jsonObject);
            }
            bufferedWriter.write(wrongJsonList.toString());
        } catch (final IOException e) {
            final String exception = "Directory not found ";
            throw new DataWriterException(exception + wrongJsonFileName.getAbsolutePath(), e);
        }
    }
}
