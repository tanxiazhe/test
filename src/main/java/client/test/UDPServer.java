package client.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

    public static void main(String[] args) throws IOException {
        String host = "10.97.192.73";
        int port = 8092;
        DatagramSocket server = new DatagramSocket(port, InetAddress.getByName(host));

        byte[] recvBuf = new byte[100000];
        DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);
        server.receive(recvPacket);

        String recvStr = new String(recvPacket.getData(), 0, recvPacket.getLength());
        System.out.println("Hello World!" + recvStr);
        server.close();
    }
}
