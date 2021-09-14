package src.main.java.day16;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���������
 * ���տͻ��˵����ݲ���ӡ
 */
public class Sixteen10_TcpServer {
    public static void main(String[] args) throws IOException {
        System.out.println("���������.....");
        //����tcp�����socket����ָ���˿�
        ServerSocket ss = new ServerSocket(10004);
        //��ȡ���ӹ����Ŀͻ��˶���
        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostAddress() + ".....connected");
        //ͨ���ͻ��˶����ȡ������ȡ�ͻ��˷���������
        InputStream in = s.getInputStream();
        //io
        //���建��������ȡ����
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        /*int len;
        while (-1 != (len = in.read(buf, 0, buf.length))) {
            System.out.println(new String(buf, 0, len));
        }*/
        System.out.println(new String(buf, 0, len));

        s.close();
        System.out.println("�������ر�.....");
    }
}
