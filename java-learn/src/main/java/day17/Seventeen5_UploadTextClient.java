package src.main.java.day17;

import java.io.*;
import java.net.Socket;

public class Seventeen5_UploadTextClient {
    public static void main(String[] args) throws IOException {
        //创建socket服务
        Socket s = new Socket("127.0.0.1", 10007);
        //从客户端文件读取数据
        BufferedReader bufr = new BufferedReader(new FileReader("D:/java项目/java-learn/src/main/java/day17/client.txt"));
        //BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        //接收服务端返回的
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String  line;
        while (null != (line = bufr.readLine())) {
            out.println(line);
        }
        //out.println("over");//通过over告诉服务端结束，但是万一客户端文件中有over字符串就不行了
        //只能通过shutdownOutput这种方式告诉服务端
        s.shutdownOutput();//告诉服务端，发送的数据已经发送完成
        //读取一次，服务端反馈“上传成功”
        String ok = bufIn.readLine();
        System.out.println(ok);
        s.close();
    }
}
