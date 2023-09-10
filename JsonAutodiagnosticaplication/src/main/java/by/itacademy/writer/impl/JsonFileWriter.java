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

    public File getRightJsonFileName() {
        return rightJsonFileName;
    }

    public File getWrongJsonFileName() {
        return wrongJsonFileName;
    }

    @Override
    public void rightWrite(final List<Transport> rightTransportList, final Comparator<Transport> comparator) throws DataWriterException {
        final List<Transport> sortedTransportList = rightTransportList.stream()
                .sorted(comparator)
                .toList();

        write(sortedTransportList, true);
    }

    @Override
    public void wrongWrite(final List<Transport> wrongTransportList) throws DataWriterException {
        write(wrongTransportList, false);
    }

    private void write(final List<Transport> transports, final boolean isValid) throws DataWriterException {
        final File outFile = isValid ? rightJsonFileName : wrongJsonFileName;

        try (final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outFile, StandardCharsets.UTF_8))) {
            final List<JSONObject> jSonList = new ArrayList<>(transports.size());

            for (final Transport transport : transports) {
                final JSONObject jsonObject = new JSONObject();
                jsonObject.put("type", transport.getTransportType());
                jsonObject.put("name", transport.getTransoprtName());

                if (isValid) {
                    jsonObject.put("cost", transport.getTransportTax());
                }

                jSonList.add(jsonObject);
            }
            bufferedWriter.write(jSonList.toString());
        } catch (final IOException e) {
            final String exception = "Failed to write file " + outFile.getAbsolutePath();
            throw new DataWriterException(exception, e);
        }
    }
}
