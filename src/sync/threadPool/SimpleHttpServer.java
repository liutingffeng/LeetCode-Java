package sync.threadPool;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

public class SimpleHttpServer {
    //处理HttpRequest的线程池
    static ThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool<>(1);

    //Server根路径
    static String basePath;
    static ServerSocket serverSocket;
    //监听端口
    static int port = 8080;

    public static void setPort(int port){
        if (port>0){
            SimpleHttpServer.port = port;
        }
    }

    public static void setBasePath(String basePath){
        if (basePath!=null && new File(basePath).exists() && new File(basePath).isDirectory()){
            SimpleHttpServer.basePath = basePath;
        }
    }

    //启动
    public static void start() throws IOException {
        serverSocket = new ServerSocket(port);
        Socket socket = null;
        while ((socket = serverSocket.accept())!=null){
            //接收一个客户端，生成一个任务，放入线程池中执行
            threadPool.execute(new HttpRequestHandler(socket));
        }
        serverSocket.close();
    }

    static class HttpRequestHandler implements Runnable{

        private Socket socket;

        public HttpRequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String line = null;
            BufferedReader br = null;
            BufferedReader reader = null;
            PrintWriter out = null;
            InputStream in = null;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String head = reader.readLine();
                System.out.println(head);
                //由相对路径计算出绝对路径
                String filePath = basePath+head.split(" ")[1];
                System.out.println(filePath);
                out = new PrintWriter(socket.getOutputStream());
                OutputStream ops = socket.getOutputStream();
                //如果请求资源的后缀为.jpg或者ico，读取资源并输出
                if (filePath.endsWith("jpg") || filePath.endsWith("ico")){
                    System.out.println("jpg");
                    in = new FileInputStream(filePath);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int i = 0;
                    while ((i = in.read())!=-1){
                        baos.write(i);
                    }
                    byte[] array = baos.toByteArray();
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: ltf");
                    out.println("Content-Type: image/jpeg");
//                    out.println("Content-Type: text/html; charset=UTF-8");
                    out.println("Content-Length: "+array.length);
                    out.println("");
//                    out.println("<html>");
//                    out.println("<body>");
//                    out.println("b");
//                    out.println("a");
//                    out.println("</body>");
//                    out.println("</html>");
                    System.out.println("out");
                    System.out.println(array.length);
                    socket.getOutputStream().write(array, 0, array.length);
                }
                else {
                    br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
                    out.println("HTTP/1.1 200 OK");
                    out.println("Server: ltf");
                    out.println("Content-Type: text/html; charset=UTF-8");
                    out.println("");
                    while ((line = br.readLine())!=null){
                        out.println(line);
                    }
                }
                out.flush();
                ops.flush();
            }
            catch (Exception e){
                out.println("HTTP/1.1 500");
                out.println("");
                out.flush();
            }
            finally {
                close(br,in,reader,out,socket);
            }
        }

        private void close(Closeable... closeables){
            if (closeables!=null){
                for (Closeable closeable:closeables){
                    if (closeable!=null){
                        try {
                            closeable.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
