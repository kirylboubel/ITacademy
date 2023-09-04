package by.itacademy.reader.impl;

import by.itacademy.reader.TransportFileReader;
import by.itacademy.reader.TransportReaderException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileTrasportReader implements TransportFileReader {
    private final String fileName;

    public String getFileName() {
        return fileName;
    }

    public FileTrasportReader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String read() throws TransportReaderException {
        try (final var reader = getReader()) {
            final String content = reader.lines()
                    .reduce(String::concat)
                    .orElse(null);
            System.out.println(content);

            return content;
        } catch (final IOException ex) {
            final var errorMessage = "Failed to process document from file [%s]".formatted(fileName);
            throw new TransportReaderException(errorMessage, ex);
        }
    }

    private BufferedReader getReader() throws TransportReaderException {
        final var in = getClass().getClassLoader().getResourceAsStream(fileName);
        if (in != null) {
            return new BufferedReader(new InputStreamReader(in));
        }
        throw new TransportReaderException("Resource from file [%s] is null".formatted(fileName));
    }
}
