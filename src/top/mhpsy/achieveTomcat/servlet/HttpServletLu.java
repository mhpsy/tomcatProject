package top.mhpsy.achieveTomcat.servlet;

import top.mhpsy.achieveTomcat.http.Request;
import top.mhpsy.achieveTomcat.http.Response;

import java.io.IOException;

public class HttpServletLu implements ServletLu {


    @Override
    public void init() throws Exception {

    }

    @Override
    public void service(Request request, Response response) throws IOException {
        if ("get".equalsIgnoreCase(request.getMethod())) {
            doGet(request, response);
        } else if ("post".equalsIgnoreCase(request.getMethod())) {
            doPost(request, response);
        }
    }

    @Override
    public void destroy() {

    }

    public void doGet(Request request, Response response) throws IOException {

    }

    public void doPost(Request request, Response response) throws IOException {

    }
}
