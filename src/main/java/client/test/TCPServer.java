package client.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        String host = "10.97.191.73";
        int port = 8094;
        ServerSocket listen = new ServerSocket(port, 1, InetAddress.getByName(host));

        Socket server = listen.accept();
        InputStream in = server.getInputStream();
        OutputStream out = server.getOutputStream();
        char c = (char) in.read();
        System.out.println("收到:" + c);
        out.write('s');

        out.close();
        in.close();
        server.close();
        listen.close();
    }
}
