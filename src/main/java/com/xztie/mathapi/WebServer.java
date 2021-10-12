package com.xztie.mathapi;

import com.xztie.mathapi.queryprocessor.*;
import com.xztie.mathapi.web.ApiResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebServer {

    public WebServer() throws Exception {
        Server server = new Server(portNumber());

        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(new ServletHolder(new ComputeMin()), "/min");
        handler.addServletWithMapping(new ServletHolder(new ComputeMax()), "/max");
        handler.addServletWithMapping(new ServletHolder(new ComputeAvg()), "/avg");
        handler.addServletWithMapping(new ServletHolder(new ComputeMedian()), "/median");
        handler.addServletWithMapping(new ServletHolder(new ComputePercentile()), "/percentile");
        server.setHandler(handler);

        server.start();
    }

    static class ComputeMin extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws IOException {
            String quantifier = req.getParameter("quantifier");
            String numbers = req.getParameter("numbers");
            String respContent = MinQueryProcessor.process(quantifier, numbers);
            ApiResponse.writeTo(respContent, resp);
        }
    }

    static class ComputeMax extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws IOException {
            String quantifier = req.getParameter("quantifier");
            String numbers = req.getParameter("numbers");
            String respContent = MaxQueryProcessor.process(quantifier, numbers);
            ApiResponse.writeTo(respContent, resp);
        }
    }

    static class ComputeAvg extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws IOException {
            String numbers = req.getParameter("numbers");
            String respContent = AvgQueryProcessor.process(numbers);
            ApiResponse.writeTo(respContent, resp);
        }
    }

    static class ComputeMedian extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws IOException {
            String numbers = req.getParameter("numbers");
            String respContent = MedianQueryProcessor.process(numbers);
            ApiResponse.writeTo(respContent, resp);
        }
    }

    static class ComputePercentile extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws IOException {
            String percentile = req.getParameter("q");
            String numbers = req.getParameter("numbers");
            String respContent = PercentileQueryProcessor.process(percentile, numbers);
            ApiResponse.writeTo(respContent, resp);

        }
    }


    private int portNumber() {
        return System.getenv("PORT") != null ? Integer.valueOf(System.getenv("PORT")) : 5000;
    }

    public static void main(String[] args) throws Exception {
        new WebServer();
    }
}
