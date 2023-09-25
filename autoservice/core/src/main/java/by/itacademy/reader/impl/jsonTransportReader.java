package by.itacademy.reader.impl;

import by.itacademy.reader.TransportReader;
import by.itacademy.reader.TransportReaderException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static by.itacademy.util.CommonConstants.DEFAULT_CHARSET;

public class jsonTransportReader implements TransportReader {

    @Override
    public String read(final InputStream in) throws TransportReaderException {
        if (in == null) {
            return "";
        }
        try (final var reader = new BufferedReader(new InputStreamReader(in, DEFAULT_CHARSET))) {
            final String content;
            content = reader.lines()
                    .reduce(String::concat)
                    .orElse(null);

            return content;
        } catch (final IOException ex) {
            final var errorMessage = "Failed to read content";
            throw new TransportReaderException(errorMessage, ex);
        }
    }
}
