package src.main.java.day17;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Seventeen6_UploadTextServer {
    public static void main(String[] args) throws Exception{
        //���������socket����
        ServerSocket ss = new ServerSocket(10007);
        //��ȡsocket����
        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostAddress() + ".....connected");
        //Socket������
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //������
        PrintWriter out = new PrintWriter(new FileWriter("D:/java��Ŀ/java-learn/src/main/java/day17/server.txt"), true);
        //io
        String line;
        while ((line = bufIn.readLine())!= null) {
            /*if ("over".equals(line))
                break;*/
            out.println(line);
        }
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        pw.println("�ϴ��ɹ�");
        s.close();
        ss.close();
    }
}
