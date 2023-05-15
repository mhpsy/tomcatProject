package top.mhpsy.achieveTomcat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class tomcatMain {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            Socket accept = serverSocket.accept();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
