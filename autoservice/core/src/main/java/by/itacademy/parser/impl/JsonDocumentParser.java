package by.itacademy.parser.impl;

import by.itacademy.parser.DocumentParser;
import by.itacademy.parser.DocumentParserException;
import by.itacademy.transport.Transport;
import by.itacademy.transport.TransportTypeAndCost;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonDocumentParser implements DocumentParser {

    @Override
    public List<Transport> parse(final String content) throws DocumentParserException {
        final List<Transport> transportList = new ArrayList<>();
        try {
            final JSONArray json = new JSONArray(content);

            for (int index = 0; index <= json.length() - 1; index++) {
                final JSONObject typeData = (JSONObject) json.get(index);

                final String stringType = typeData.getString("type");
                final TransportTypeAndCost type = TransportTypeAndCost.valueOf(stringType.toUpperCase());
                final String model = typeData.getString("model");

                final Transport transport = new Transport(type, model);
                transportList.add(transport);
            }
            return transportList;
        } catch (final JSONException e) {
            throw new DocumentParserException("Failed to parse content [%s]".formatted(content), e);
        }
    }
}