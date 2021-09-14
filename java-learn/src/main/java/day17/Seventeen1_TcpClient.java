package src.main.java.day17;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 客户端发送到服务端，服务端将应答数据反馈给客户端
 */
public class Seventeen1_TcpClient {
    public static void main(String[] args) throws IOException {
        //创建socket服务
        Socket s = new Socket("127.0.0.1", 10005);
        //获取socket流的输出流对象
        OutputStream out = s.getOutputStream();
        //数据写入到socket流中
        out.write("我又来了".getBytes());

        //获取服务端发回的数据，需要用到socket流的输入流
        InputStream in = s.getInputStream();
        //io
        //创建缓冲区，读取数据
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        System.out.println(new String(buf,0,len));
        s.close();
    }
}
