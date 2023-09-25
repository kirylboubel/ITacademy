package by.itacademy.web.writer.impl;

import by.itacademy.web.writer.Writer;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HtmlWriter implements Writer {
    @Override
    public String writeJsonToHtmlTable(final List<JSONObject> jsonObjectList, final boolean isValid, final String tableName) {
        final StringBuilder htmlTable = new StringBuilder("<table border=\"1\"");
        htmlTable.append("<caption>" + tableName + "</caption>");

        htmlTable.append("<tr>");
        htmlTable.append("<th>Type</th>");
        htmlTable.append("<th>Model</th>");
        if (isValid) {
            htmlTable.append("<th>Price</th>");
        }

        for (final JSONObject jsonObject : jsonObjectList) {
            htmlTable.append("<tr>");
            htmlTable.append("<th>" + jsonObject.get("type") + "</th>");
            htmlTable.append("<th>" + jsonObject.get("name") + "</th>");
            if (isValid) {
                htmlTable.append("<th>" + jsonObject.get("cost") + "</th>");
            }

            htmlTable.append("</tr>");
        }
        htmlTable.append("</tr>");
        htmlTable.append("</table>");
        return htmlTable.toString();
    }
}
