package by.itacademy;

import by.itacademy.delimiter.impl.ListDelimiter;
import by.itacademy.parser.impl.JsonDocumentParser;
import by.itacademy.reader.impl.FileTrasportReader;
import by.itacademy.sorting.SortingReader;
import by.itacademy.sorting.impl.ConsoleSortingReader;
import by.itacademy.transport.Transport;
import by.itacademy.writer.impl.JsonFileWriter;

import java.util.Comparator;
import java.util.List;

public class Autodiagnostic {
    public static void main(String[] args) {
        try {
            final FileTrasportReader reader = new FileTrasportReader("transport.json");
            final String content = reader.read();

            final var parser = new JsonDocumentParser();
            final List<Transport> transportList = parser.parse(content);

            final ListDelimiter listDelimiter = new ListDelimiter();
            final List<Transport> righViechleList = listDelimiter.divideListToRightTransportlis(transportList);
            final List<Transport> wrongViechleList = listDelimiter.divideListToWrongTransportlis(transportList);

            final SortingReader sortingReader = new ConsoleSortingReader();
            final Comparator<Transport> comparator = sortingReader.readSorting();

            final JsonFileWriter jsonFileWriter = new JsonFileWriter("src/main/resources/procesed-transport.json",
                    "src/main/resources/invalid-transport.json");
            jsonFileWriter.rightWrite(righViechleList, comparator);
            jsonFileWriter.wrongWrite(wrongViechleList);
        } catch (final Exception e) {
            System.err.println("Ошибка работы программы. " + e.getMessage());
            e.printStackTrace();
        }
    }
}