package src.main.java.day16;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * ����tcp�ͻ��ˣ��������ݷ��͸�������
 */
public class Sixteen9_TcpClient {
    public static void main(String[] args) throws IOException {
        System.out.println("�ͻ��˿���.....");
        //����tcp�ͻ���socket����
        Socket s = new Socket("127.0.0.1", 10004);
        //ͨ��socket��ȡsocket���е����������
        OutputStream os = s.getOutputStream();
        os.write("������".getBytes());
        s.close();
        System.out.println("�ͻ��˹ر�.....");
    }
}
