package by.itacademy.web.servlet;

import by.itacademy.web.service.impl.JsonTransportService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class TransportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        try (final PrintWriter writer = resp.getWriter()) {
            writer.println("<h1>Ford</h1>");
            writer.println("<h1>Peugeot</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final JsonTransportService service = new JsonTransportService();
        service.processTransport(req,resp);
    }
}
