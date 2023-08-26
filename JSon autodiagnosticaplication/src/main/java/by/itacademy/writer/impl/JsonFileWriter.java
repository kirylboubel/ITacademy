package by.itacademy.writer.impl;

import by.itacademy.transport.Transport;
import by.itacademy.writer.DataWriter;
import by.itacademy.writer.DataWriterException;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JsonFileWriter implements DataWriter {
    private final File rightJsonFileName;
    private final File wrongJsonFileName;

    public JsonFileWriter(final String rightJsonFileName, final String wrongJsonFileName) {
        this.rightJsonFileName = new File(rightJsonFileName);
        this.wrongJsonFileName = new File(wrongJsonFileName);
    }

    @Override
    public void rightWrite(final List<Transport> rightTransportList) throws DataWriterException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(rightJsonFileName, StandardCharsets.UTF_8))) {
            JSONObject jsonObject = new JSONObject();
            final List<JSONObject> rightJsonList = new ArrayList<>();
            for (Transport transport : rightTransportList) {
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
