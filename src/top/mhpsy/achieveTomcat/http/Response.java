package top.mhpsy.achieveTomcat.http;

import java.io.OutputStream;

public class Response {
    private final OutputStream outputStream;

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public final String responseHeader = "HTTP/1.1 200 OK\n" +
            "Content-Type: text/html;charset=utf-8\n" +
            "\n";

    public void write(String content) {
        try {
            outputStream.write(responseHeader.getBytes());
            outputStream.write(content.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
