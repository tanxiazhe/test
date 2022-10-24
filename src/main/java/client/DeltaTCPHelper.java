package client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by I311579 on 5/1/2016.
 */
@Component
public class DeltaTCPHelper extends DeltaHelper {
    private static final Logger logger = LoggerFactory.getLogger(DeltaTCPHelper.class);
    private String host;
    private int port;

    public DeltaTCPHelper(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void send(String message) throws IOException {
        logger.debug("Send data to {}:{} with {}", host, port, message);
        Socket socket = new Socket(host, port);
        OutputStream out = socket.getOutputStream();
        out.write(message.getBytes("UTF-8"));
        socket.close();
    }

}
