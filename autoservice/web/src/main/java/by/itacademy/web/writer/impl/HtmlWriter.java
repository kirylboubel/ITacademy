package by.itacademy.web.writer.impl;

import by.itacademy.web.writer.Writer;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HtmlWriter implements Writer {
    @Override
    public String writeJsonToHtmlTable(List<JSONObject> jsonObjectList, boolean isValid, String tableName) {
        final List<String> table = new ArrayList<>();
        table.add("<table border=\"1\"");
        table.add("<caption>" + tableName + "</caption>");

        table.add("<tr>");
        table.add("<th>Type</th>");
        table.add("<th>Model</th>");
        if (isValid) {
            table.add("<th>Price</th>");
        }

        for (JSONObject jsonObject : jsonObjectList) {
            table.add("<tr>");
            table.add("<th>" + jsonObject.get("type") + "</th>");
            table.add("<th>" + jsonObject.get("name") + "</th>");
            if (isValid) {
                table.add("<th>" + jsonObject.get("cost") + "</th>");
            }

            table.add("</tr>");
        }
        table.add("</tr>");
        table.add("</tale>");
        return table.stream().reduce("", String::concat);
    }
}
