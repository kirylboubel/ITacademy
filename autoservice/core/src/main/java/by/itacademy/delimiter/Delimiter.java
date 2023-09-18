package by.itacademy.delimiter;

import by.itacademy.transport.Transport;
import org.json.JSONObject;

import java.util.List;

public interface Delimiter {
    List<JSONObject> divideListToRightTransportlis(List<Transport> transportList);
    List<JSONObject> divideListToWrongTransportlis(List<Transport> transportList);
}
