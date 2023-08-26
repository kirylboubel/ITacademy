package by.itacademy.delimiter;

import by.itacademy.transport.Transport;
import java.util.List;


import java.awt.*;

public interface Delimiter {
    void divideList(List<Transport> TRANSPORT_LIST) throws ListDelimiterException;

}
