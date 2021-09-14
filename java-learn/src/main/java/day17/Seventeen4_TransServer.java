package src.main.java.day17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Seventeen4_TransServer {
    //把客户端传过来的小写字母转化为大写传回去
    public static void main(String[] args) throws Exception{
        //创建服务端socket服务
        ServerSocket ss = new ServerSocket(10006);
        //获取socket对象
        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostAddress() + ".....connected");
        //接收客户端数据
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //输出流发送给客户端
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        //io
        String line;
        while ((line = bufIn.readLine())!= null) {
            //接收客户端数据转换为大写再发送给客户端
            out.println(line.toUpperCase());
            System.out.println("receive:" + line);
        }
        s.close();
        ss.close();
    }
}
