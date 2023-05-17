package top.mhpsy.achieveTomcat.servlet;

import top.mhpsy.achieveTomcat.http.Request;
import top.mhpsy.achieveTomcat.http.Response;

import java.io.IOException;

public interface ServletLu {

    void init() throws Exception;

    void service(Request request, Response response) throws IOException;

    void destroy();

}
