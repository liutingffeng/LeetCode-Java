package sync;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Piped {

    public static void main(String[] args) throws IOException {
        PipedReader in = new PipedReader();
        PipedWriter out = new PipedWriter();
        //连接
        out.connect(in);
        Thread printThread = new Thread(new Print(in), "PrintThread");
        printThread.start();
        int recieve = 0;
        try {
            while ((recieve = System.in.read())!=-1){
                out.write(recieve);
            }
        } finally {
            out.close();
        }
    }

    static class Print implements Runnable{

        private PipedReader pr;

        public Print(PipedReader pr) {
            this.pr = pr;
        }

        @Override
        public void run() {
            int recieve = 0;
            try {
                while ((recieve = pr.read()) != -1){
                    System.out.print((char) recieve);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    pr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
