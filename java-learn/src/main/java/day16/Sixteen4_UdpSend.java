package src.main.java.day16;

import java.net.*;

public class Sixteen4_UdpSend {
    /**
     * ����һ��upd���Ͷ�
     * 1���ȴ���udp�˵㣬Ҳ����socket
     * 2����װ���ݰ�
     * 3��ͨ��udp���ݷ���
     */
    public static void main(String[] args) throws Exception {
        System.out.println("udp��ʼ����");
        //����socket
        DatagramSocket ds = new DatagramSocket();//�����ʾ���ڷ��ͺͽ������ݱ����ݰ����׽��֡�
        //��װ����
        String str = "����һ��udp����";
        //ʹ��ƽ̨��Ĭ���ַ������� String����Ϊ�ֽ����У�������洢���µ��ֽ������С�
        byte[] buf = str.getBytes();
        //�������ݰ�����
        DatagramPacket dp = new DatagramPacket(buf,buf.length,
                InetAddress.getByName("127.0.0.1"),10000);
        //ͨ��udp��������
        ds.send(dp);
        ds.close();
        System.out.println("udp���ͳɹ�");
    }
}
