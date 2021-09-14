package src.main.java.day17;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Seventeen6_UploadTextServer {
    public static void main(String[] args) throws Exception{
        //创建服务端socket服务
        ServerSocket ss = new ServerSocket(10007);
        //获取socket对象
        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostAddress() + ".....connected");
        //Socket输入流
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //输入流
        PrintWriter out = new PrintWriter(new FileWriter("D:/java项目/java-learn/src/main/java/day17/server.txt"), true);
        //io
        String line;
        while ((line = bufIn.readLine())!= null) {
            /*if ("over".equals(line))
                break;*/
            out.println(line);
        }
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        pw.println("上传成功");
        s.close();
        ss.close();
    }
}
