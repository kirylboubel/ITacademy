package by.itacademy;

import by.itacademy.delimiter.impl.ListDelimiter;
import by.itacademy.parser.impl.JsonDocumentParser;
import by.itacademy.reader.impl.FileTrasportReader;
import by.itacademy.transport.Transport;
import by.itacademy.writer.impl.JsonFileWriter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Autodiagnostic {
    public static void main(String[] args) {
        try {
            final FileTrasportReader reader = new FileTrasportReader("transport.json");
            final String content = reader.read();

            final var parser = new JsonDocumentParser();
            final List<Transport> transportList = parser.parse(content);

            final ListDelimiter listDelimiter = new ListDelimiter();
            listDelimiter.divideList(transportList);
            final JsonFileWriter jsonFileWriter = new JsonFileWriter("src/main/resources/procesed-transport.json",
                    "src/main/resources/invalid-transport.json");

            jsonFileWriter.rightWrite(listDelimiter.getRightTransportList());
            jsonFileWriter.wrongWrite(listDelimiter.getWrongTransportList());


        } catch (final Exception e) {
            System.err.println("Ошибка работы программы. " + e.getMessage());
            e.printStackTrace();
        }
    }

}