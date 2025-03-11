package TCPLearning;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class DelayAckClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.setTcpNoDelay(false);
        socket.connect(new InetSocketAddress("localhost", 8888));
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String head = "hello, ";
        String body = "world\n";

        for (int i = 0; i < 10; i++) {
            long start = System.currentTimeMillis();
            outputStream.write(("#" + i + " " + head).getBytes());
            outputStream.write(body.getBytes());
            String line = reader.readLine();
            System.out.println("RTT: " + (System.currentTimeMillis() - start) + ": " + line);
        }

        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
