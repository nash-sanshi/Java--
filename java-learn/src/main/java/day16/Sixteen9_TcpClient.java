package src.main.java.day16;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 创建tcp客户端，并将数据发送给服务器
 */
public class Sixteen9_TcpClient {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端开启.....");
        //建立tcp客户端socket服务
        Socket s = new Socket("127.0.0.1", 10004);
        //通过socket获取socket流中的输出流对象
        OutputStream os = s.getOutputStream();
        os.write("我来了".getBytes());
        s.close();
        System.out.println("客户端关闭.....");
    }
}
