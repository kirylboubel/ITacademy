package it.academy.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class ServletAplication extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String servletParamValue = getServletConfig().getInitParameter("servlet-param");
        final String parameters = req.getParameterMap().entrySet()
                        .stream()
                                .map(entry -> entry.getKey() + ": " + Arrays.toString(entry.getValue()) + "\n")
                                        .reduce("", String::concat);


        resp.setContentType("text/html");
        try (final PrintWriter writer = resp.getWriter()) {
            writer.println("<h1>BMW</h1>");
            writer.println("<h1>Ford</h1>");
            writer.println("<h1>Peugeot</h1>");
            writer.println("<h2>" + servletParamValue + "</h2>");
            writer.println(parameters);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String firstParamValue = getServletContext().getInitParameter("first-param");
        final String secondParamValue = getServletContext().getInitParameter("second-param");

        resp.setContentType("text/html");
        try (final PrintWriter writer = resp.getWriter()) {
            writer.println("<h2>" + firstParamValue + "</h2>");
            writer.println("<h2>" + secondParamValue + "</h2>");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
