package src.main.java.day17;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * �ͻ��˷��͵�����ˣ�����˽�Ӧ�����ݷ������ͻ���
 */
public class Seventeen1_TcpClient {
    public static void main(String[] args) throws IOException {
        //����socket����
        Socket s = new Socket("127.0.0.1", 10005);
        //��ȡsocket�������������
        OutputStream out = s.getOutputStream();
        //����д�뵽socket����
        out.write("��������".getBytes());

        //��ȡ����˷��ص����ݣ���Ҫ�õ�socket����������
        InputStream in = s.getInputStream();
        //io
        //��������������ȡ����
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        System.out.println(new String(buf,0,len));
        s.close();
    }
}
