package by.itacademy.writer;

import by.itacademy.transport.Transport;

import java.io.File;
import java.util.List;

public interface DataWriter {
    void rightWrite(List<Transport> rightTransportList) throws DataWriterException;
    void wrongWrite(List<Transport> wrongTransportList) throws DataWriterException;
}
