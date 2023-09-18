package by.itacademy.web.writer;

import org.json.JSONObject;

import java.util.List;

public interface Writer {
    String writeJsonToHtmlTable(List<JSONObject> jsonObjectList, boolean isValid, String tableName);
}
