package by.itacademy.delimiter;

import by.itacademy.transport.Transport;

import java.util.List;

public interface Delimiter {
    List<Transport> divideListToRightTransportlis(List<Transport> transportList);
    List<Transport> divideListToWrongTransportlis(List<Transport> transportList);
}
