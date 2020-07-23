package computernetwork;

import java.io.IOException;
import java.net.Socket;

public class Server {
    Socket socket ;

    public Server() throws IOException {
        String ip = "127.0.0.1";
        int port = 8888;
        socket = new Socket(ip, port);

    }

}
