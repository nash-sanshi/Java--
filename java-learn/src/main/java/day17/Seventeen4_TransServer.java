package src.main.java.day17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Seventeen4_TransServer {
    //�ѿͻ��˴�������Сд��ĸת��Ϊ��д����ȥ
    public static void main(String[] args) throws Exception{
        //���������socket����
        ServerSocket ss = new ServerSocket(10006);
        //��ȡsocket����
        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostAddress() + ".....connected");
        //���տͻ�������
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //��������͸��ͻ���
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        //io
        String line;
        while ((line = bufIn.readLine())!= null) {
            //���տͻ�������ת��Ϊ��д�ٷ��͸��ͻ���
            out.println(line.toUpperCase());
            System.out.println("receive:" + line);
        }
        s.close();
        ss.close();
    }
}
