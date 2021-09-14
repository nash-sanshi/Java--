package src.main.java.day17;

import java.io.*;
import java.net.Socket;

public class Seventeen3_TransClient {
    //通过客户端发送单词数据，服务端转为大写返回
    public static void main(String[] args) throws IOException {
        //创建socket服务
        Socket s = new Socket("127.0.0.1", 10006);
        //从客户端读取键盘录入的数据并发送
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        //输出流发送给服务端
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        //接收服务端返回的数据
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //io读写
        String  line;
        while (null != (line = bufr.readLine())) {
            if ("88".equals(line))
                break;
            //客户端键盘录入数据发送服务端
            out.println(line);
            String str = bufIn.readLine();
            System.out.println("trans:" + str);
        }
        s.close();
    }
}
