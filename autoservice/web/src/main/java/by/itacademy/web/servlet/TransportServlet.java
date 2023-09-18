package by.itacademy.web.servlet;

import by.itacademy.web.service.impl.JsonTransportService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class TransportServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final JsonTransportService service = new JsonTransportService();
        service.processTransport(req, resp);
    }
}
