package src.main.java.day17;

import java.io.*;
import java.net.Socket;

public class Seventeen7_UploadPicClient {
    public static void main(String[] args) throws IOException {
        //创建socket服务
        Socket s = new Socket("127.0.0.1", 10008);
        FileInputStream fis = new FileInputStream("D:/java项目/java-learn/src/main/java/day17/1.jpg");
        OutputStream out = s.getOutputStream();
        byte[] buf = new byte[1024];
        int len ;
        //不使用循环的话，会造成读得不完整
        while ((len = fis.read(buf))!= -1){
            out.write(buf,0,len);
        }
        //已完成
        s.shutdownOutput();//禁用此套接字的输出流。告诉服务端，发送的数据已经发送完成

        //获取服务端传输的输入流数据
        InputStream in = s.getInputStream();
        byte[] bytes = new byte[1024];
        int lenIn = in.read(bytes);
        System.out.println(new String(bytes, 0, lenIn));
        fis.close();
        s.close();
    }
}
