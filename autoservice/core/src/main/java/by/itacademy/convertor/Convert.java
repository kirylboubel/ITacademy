package by.itacademy.convertor;

import by.itacademy.transport.transport.Transport;
import org.json.JSONObject;

import java.util.Comparator;
import java.util.List;

public interface Convert {
    List<JSONObject> convertToProcessedJsonTransports(List<Transport> transportList, Comparator<Transport> comparator) throws ValidationException;

    List<JSONObject> convertToInvalidJsonTransports(List<Transport> transportList, Comparator<Transport> comparator) throws ValidationException;
}
