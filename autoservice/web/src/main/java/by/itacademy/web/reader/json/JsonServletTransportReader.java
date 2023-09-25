package by.itacademy.web.reader.json;

import by.itacademy.reader.TransportReader;
import by.itacademy.reader.TransportReaderException;
import by.itacademy.reader.impl.jsonTransportReader;

import java.io.*;
import java.net.URLDecoder;

import static by.itacademy.util.CommonConstants.DEFAULT_CHARSET;

public class JsonServletTransportReader implements TransportReader {

    private static final TransportReader READER = new jsonTransportReader();


    @Override
    public String read(InputStream inputstream) throws TransportReaderException, IOException {

        try {
            final var in = getDecodedStream(inputstream);
            return READER.read(in);

        } catch (final TransportReaderException e) {
            throw new IOException("Failed to process content", e);
        }
    }

    private static InputStream getDecodedStream(final InputStream in) throws IOException {
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(in, DEFAULT_CHARSET))) {
            final String content = reader.lines().reduce("", String::concat);

            final String decodedJsonContent = URLDecoder.decode(content, DEFAULT_CHARSET);
            return new ByteArrayInputStream(decodedJsonContent.getBytes(DEFAULT_CHARSET));
        }
    }
}