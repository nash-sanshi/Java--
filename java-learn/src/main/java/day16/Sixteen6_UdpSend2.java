package src.main.java.day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sixteen6_UdpSend2 {
    /**
     * ��ȡ����¼������ݣ����͸����ն�
     */
    public static void main(String[] args) throws Exception {
        System.out.println("udp��ʼ����");
        //����socket
        DatagramSocket ds = new DatagramSocket();
        //��װ����
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (null != (line = bufr.readLine())) {
            if ("gameover".equals(line))
                break;
            byte[] buf = line.getBytes();
            //�������ݰ�����
            DatagramPacket dp = new DatagramPacket(buf, buf.length,
                    InetAddress.getByName("127.0.0.1"), 10002);
            //ͨ��udp��������
            ds.send(dp);
        }
        //�ر���Դ
        ds.close();
        System.out.println("udp���ͳɹ�");
    }
}
