package by.itacademy.web.service.impl;

import by.itacademy.delimiter.impl.ListDelimiter;
import by.itacademy.parser.DocumentParserException;
import by.itacademy.parser.impl.JsonDocumentParser;
import by.itacademy.reader.TransportReaderException;
import by.itacademy.transport.Transport;
import by.itacademy.web.reader.json.JsonServletTransportReader;
import by.itacademy.web.service.TransportService;
import by.itacademy.web.writer.Writer;
import by.itacademy.web.writer.impl.HtmlWriter;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class JsonTransportService implements TransportService {
    @Override
    public void processTransport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final JsonServletTransportReader reader = new JsonServletTransportReader();

        try {
            final String transportString = reader.read(request.getInputStream());

            final JsonDocumentParser jsonDocumentParser = new JsonDocumentParser();
            final List<Transport> transportList = jsonDocumentParser.parse(transportString);

            final ListDelimiter listDelimiter = new ListDelimiter();
            final List<JSONObject> righTransportList = listDelimiter.divideListToRightTransportlist(transportList);
            final List<JSONObject> wrongTransoprtList = listDelimiter.divideListToWrongTransportlist(transportList);

            final Writer writer = new HtmlWriter();

            response.getWriter().println(writer.writeJsonToHtmlTable(righTransportList, true, "Processed-transport"));
            response.getWriter().println(writer.writeJsonToHtmlTable(wrongTransoprtList, false, "Invalid-transport"));


        } catch (final TransportReaderException e) {
            throw new IOException("Failed to process content", e);
        } catch (DocumentParserException e) {
            throw new RuntimeException("Failed to parse content", e);
        }
    }
}
