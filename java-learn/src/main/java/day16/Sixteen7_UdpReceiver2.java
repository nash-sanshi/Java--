package src.main.java.day16;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Sixteen7_UdpReceiver2 {
    /**
     * ���ռ��̷��Ͷ����ݲ���ӡ
     */
    public static void main(String[] args) throws Exception {
        System.out.println("udp���ն˿���....");
        //����udp�˿�
        DatagramSocket ds = new DatagramSocket(10002);
        //�������ݣ������ݴ��������ݰ�������
        while (true) {
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            ds.receive(dp);
            //��������
            String ip = dp.getAddress().getHostAddress();
            int port = dp.getPort();
            String text = new String(dp.getData(), 0, dp.getLength());
            System.out.println(ip + ":" + port + ":" + text);
        }
        //�ر���Դ
        //ds.close();
        //System.out.println("udp���ն˹ر���....");
    }
}
