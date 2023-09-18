package by.itacademy.web.writer.impl;

import by.itacademy.annotation.Parametr;
import by.itacademy.delimiter.impl.ListDelimiter;
import by.itacademy.web.writer.Writer;
import org.json.JSONObject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.List;

public class HtmlWriter implements Writer {
    @Override
    public String writeJsonToHtmlTable(List<JSONObject> jsonObjectList, boolean isValid) {
        final List<String> table = new ArrayList<>();
        table.add("<table border=\"1\"");
        table.add("<caption>" + jsonObjectList.getClass().getName() + "</caption>");
        table.add("<tr>");
        table.add("<th>Type</th>");
        table.add("<th>Model</th>");
        .

        if (isValid) {
            table.add("<th>Price</th>");
        }
        for (JSONObject jsonObject:jsonObjectList) {
            table.add("<tr>");
            table.add("<th>"+jsonObject.get("type")+"</th>");
            table.add("<th>"+jsonObject.get("name")+"</th>");
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
