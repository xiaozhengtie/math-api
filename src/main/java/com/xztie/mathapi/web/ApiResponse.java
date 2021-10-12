package com.xztie.mathapi.web;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ApiResponse {

    public static void writeTo(String respContent, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.format("<h3>%s</h3>", respContent);
        writer.println("</body>");
        writer.println("</html>");
    }
}
