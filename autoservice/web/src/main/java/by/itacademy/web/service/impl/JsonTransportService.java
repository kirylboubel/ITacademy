package by.itacademy.web.service.impl;

import by.itacademy.convertor.impl.ListConvertor;
import by.itacademy.parser.DocumentParserException;
import by.itacademy.parser.impl.JsonDocumentParser;
import by.itacademy.reader.TransportReaderException;
import by.itacademy.sorting.SortingReaderException;
import by.itacademy.sorting.impl.TransportSorter;
import by.itacademy.transport.transport.Transport;
import by.itacademy.web.reader.json.JsonServletTransportReader;
import by.itacademy.web.service.TransportService;
import by.itacademy.web.writer.Writer;
import by.itacademy.web.writer.impl.HtmlWriter;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class JsonTransportService implements TransportService {
    @Override
    public void processTransport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final JsonServletTransportReader reader = new JsonServletTransportReader();

        try {
            final String transportString = reader.read(request.getInputStream());

            final JsonDocumentParser jsonDocumentParser = new JsonDocumentParser();
            final List<Transport> transportList = jsonDocumentParser.parse(transportString);

            final List<String> sortingType = Arrays.asList(request.getParameterValues("sortingType"));
            final List<String> sortingDirection = Arrays.asList(request.getParameterValues("sortingDirection"));

            final TransportSorter transportSorter = new TransportSorter();
            final Comparator<Transport> comparator = transportSorter.readSorting(sortingType, sortingDirection);

            final ListConvertor listDelimiter = new ListConvertor();
            final List<JSONObject> ProcessedTransportList = listDelimiter.convertToProcessedJsonTransports(transportList, comparator);
            final List<JSONObject> incalidTransoprtList = listDelimiter.convertToInvalidJsonTransports(transportList, comparator);

            final Writer writer = new HtmlWriter();

            response.getWriter().println(getWriter(ProcessedTransportList, true, "Processed-transport", writer));
            response.getWriter().println(getWriter(incalidTransoprtList, false, "Invalid-transport", writer));

        } catch (final TransportReaderException e) {
            throw new IOException("Failed to process content", e);
        } catch (DocumentParserException e) {
            throw new IOException("Failed to parse content", e);
        } catch (SortingReaderException e) {
            throw new IOException("Incorrect sort data passed", e);
        }
    }

    private static String getWriter(List<JSONObject> TransportList, boolean isValid, String tableName, Writer writer) {
        return writer.writeJsonToHtmlTable(TransportList, isValid, tableName);
    }
}
