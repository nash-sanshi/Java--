package src.main.java.day17;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Seventeen2_TcpServer {
    public static void main(String[] args) throws IOException {
        //����tcp����˵�socket������һ���˿�
        ServerSocket ss = new ServerSocket(10005);
        //��ȡ�ͻ��˶���
        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostAddress() + ".....connected");
        //ͨ���ͻ��˶����ȡsocket���е�������
        InputStream in = s.getInputStream();
        //io
        //���建��������ȡ����
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        System.out.println(new String(buf, 0, len));
        //ͨ���ͻ��˶����ȡsocket���е������
        OutputStream out = s.getOutputStream();
        out.write("�յ���".getBytes());
        s.close();
        ss.close();
    }
}
