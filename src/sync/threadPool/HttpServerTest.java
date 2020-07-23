package sync.threadPool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServerTest {
    public static void main(String[] args) throws IOException {
        String filePath = "F:/java/LCpractice/src/sync/threadPool";
//        File file = new File(pathName);
//        System.out.println(file.isDirectory());
        SimpleHttpServer.setBasePath("F:/java/LCpractice/src/sync/threadPool");


        try {
            SimpleHttpServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
