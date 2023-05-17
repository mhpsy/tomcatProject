package top.mhpsy.achieveTomcat.handleRunServlet;

import top.mhpsy.achieveTomcat.http.Request;
import top.mhpsy.achieveTomcat.http.Response;
import top.mhpsy.achieveTomcat.servlet.ServletLu;
import top.mhpsy.achieveTomcat.tomcatMain;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class HandleRunServlet implements Runnable {

    private Socket socket;

    @Override
    public void run() {
        try {
            // request 和 response 初始化
            Request request = new Request(socket.getInputStream());
            Response response = new Response(socket.getOutputStream());
            String url = request.getUrl();
            String servletName = tomcatMain.servletUrlMapping.get(url);
            if (servletName == null) {
                servletName = "";
            }

            ServletLu servletLu = tomcatMain.servletMapping.get(servletName);
            if (servletLu == null) {
                response.write("404 - Not Found");
            } else {
                servletLu.service(request, response);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public HandleRunServlet(Socket socket) {
        this.socket = socket;
    }
}
