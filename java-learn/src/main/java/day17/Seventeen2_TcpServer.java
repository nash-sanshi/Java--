package src.main.java.day17;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Seventeen2_TcpServer {
    public static void main(String[] args) throws IOException {
        //创建tcp服务端的socket，监听一个端口
        ServerSocket ss = new ServerSocket(10005);
        //获取客户端对象
        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostAddress() + ".....connected");
        //通过客户端对象获取socket流中的输入流
        InputStream in = s.getInputStream();
        //io
        //定义缓冲区，读取数据
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        System.out.println(new String(buf, 0, len));
        //通过客户端对象获取socket流中的输出流
        OutputStream out = s.getOutputStream();
        out.write("收到了".getBytes());
        s.close();
        ss.close();
    }
}
