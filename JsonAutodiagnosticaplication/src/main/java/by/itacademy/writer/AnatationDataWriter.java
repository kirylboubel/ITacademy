package by.itacademy.writer;

import by.itacademy.transport.Transport;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TransferQueue;

public interface AnatationDataWriter {
    <T> T dataWrite(List<Transport> rightTransportList, Comparator<Transport> comparator) throws NoSuchMethodException;
}
