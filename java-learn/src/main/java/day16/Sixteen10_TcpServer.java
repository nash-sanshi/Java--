package src.main.java.day16;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建服务端
 * 接收客户端的数据并打印
 */
public class Sixteen10_TcpServer {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动.....");
        //创建tcp服务端socket服务，指定端口
        ServerSocket ss = new ServerSocket(10004);
        //获取链接过来的客户端对象
        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostAddress() + ".....connected");
        //通过客户端对象读取流，读取客户端发来的数据
        InputStream in = s.getInputStream();
        //io
        //定义缓冲区，读取数据
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        /*int len;
        while (-1 != (len = in.read(buf, 0, buf.length))) {
            System.out.println(new String(buf, 0, len));
        }*/
        System.out.println(new String(buf, 0, len));

        s.close();
        System.out.println("服务器关闭.....");
    }
}
