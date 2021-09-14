package src.main.java.day16;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Sixteen5_UdpReceiver {
    /**
     * ����udp���ն�
     * 1������udp�˿�
     * 2����������
     * 3����������
     * 4����ӡ���ݣ��ر���Դ
     */
    public static void main(String[] args) throws Exception {
        System.out.println("udp���ն˿���....");
        //����udp�˿�
        DatagramSocket ds = new DatagramSocket(10000);
        //�������ݣ������ݴ��������ݰ�������
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        ds.receive(dp);
        //��������
        String ip = dp.getAddress().getHostAddress();
        int port = dp.getPort();
        String text = new String(dp.getData(), 0, dp.getLength());
        System.out.println(ip + "��" + port + "��" + text);
        //�ر���Դ
        ds.close();
        System.out.println("udp���ն˹ر���....");
    }
}