package by.itacademy;

import by.itacademy.delimiter.Delimiter;
import by.itacademy.delimiter.impl.ListDelimiter;
import by.itacademy.parser.impl.JsonDocumentParser;
import by.itacademy.reader.TransportFileReader;
import by.itacademy.reader.impl.FileTrasportReader;
import by.itacademy.sorting.SortingReader;
import by.itacademy.sorting.impl.ConsoleSortingReader;
import by.itacademy.transport.Transport;
import by.itacademy.writer.AnatationDataWriter;
import by.itacademy.writer.DataWriter;
import by.itacademy.writer.impl.JsonFileWriter;
import by.itacademy.writer.impl.JsonFileWriterWithAnatation;

import java.util.Comparator;
import java.util.List;

public class Autodiagnostic {
    public static void main(String[] args) {
        try {
            final TransportFileReader reader = new FileTrasportReader("transport.json");
            final String content = reader.read();

            final var parser = new JsonDocumentParser();
            final List<Transport> transportList = parser.parse(content);

            final Delimiter listDelimiter = new ListDelimiter();
            final List<Transport> righViechleList = listDelimiter.divideListToRightTransportlis(transportList);
            final List<Transport> wrongViechleList = listDelimiter.divideListToWrongTransportlis(transportList);

            final SortingReader sortingReader = new ConsoleSortingReader();
            final Comparator<Transport> comparator = sortingReader.readSorting();
            final AnatationDataWriter jsonFileWriter = new JsonFileWriterWithAnatation("src/main/resources/procesed-transport.json",
                    "src/main/resources/invalid-transport.json");
            jsonFileWriter.dataWrite(righViechleList, comparator, Transport.class);

//            final DataWriter jsonFileWriter = new JsonFileWriter("src/main/resources/procesed-transport.json",
//                    "src/main/resources/invalid-transport.json");
//            jsonFileWriter.rightWrite(righViechleList, comparator);
//            jsonFileWriter.wrongWrite(wrongViechleList);
        } catch (final Exception e) {
            System.err.println("Ошибка работы программы. " + e.getMessage());
            e.printStackTrace();
        }
    }
}