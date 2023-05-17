package top.mhpsy.achieveTomcat.s;

import top.mhpsy.achieveTomcat.http.Request;
import top.mhpsy.achieveTomcat.http.Response;
import top.mhpsy.achieveTomcat.servlet.HttpServletLu;

import java.io.IOException;

public class servletLike extends HttpServletLu {

    @Override
    public void doGet(Request request, Response response) throws IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(Request request, Response response) throws IOException {
        response.write("<h1>hello servlet</h1>");
    }
}
