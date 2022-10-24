package client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.Closeable;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by I311579 on 5/1/2016.
 */
@Component
public class DeltaUDPHelper extends DeltaHelper implements Closeable {
    private static final Logger logger = LoggerFactory.getLogger(DeltaUDPHelper.class);
    private String host;
    private int port;
    private DatagramSocket datagramSocket = new DatagramSocket();

    public DeltaUDPHelper(String host, int port) throws SocketException {
        this.host = host;
        this.port = port;
    }

    public void send(String message) throws IOException {
        logger.debug("Send data to {}:{} with {}", host, port, message);
        byte[] buffer = message.getBytes("UTF-8");

        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(host), port);

        datagramSocket.send(datagramPacket);
    }

    @Override
    public void close() throws IOException {
        datagramSocket.close();
    }
}
