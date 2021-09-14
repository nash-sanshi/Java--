package src.main.java.day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Ⱥ�ĳ���һ�߷�һ����
 * 1��ʹ�ù㲥192.168.0.255
 * 2��ʹ�ö��߳�
 */
public class Sixteen8_ChatTest {
    public static void main(String[] args) throws SocketException {
        //���͵����ݰ�
        DatagramSocket send = new DatagramSocket();
        //���յ����ݰ�
        DatagramSocket rece = new DatagramSocket(10003);
        //�����̷߳�������
        new Thread(new Send(send)).start();
        //�����߳̽�������
        new Thread(new Rece(rece)).start();
    }
}

//�������͵��߳�
class Send implements Runnable{
    private DatagramSocket ds;
    public Send(DatagramSocket ds){
        this.ds = ds;
    }
    @Override
    public void run() {
        try {
            BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while (null != (line = bufr.readLine())) {
                if ("gameover".equals(line))
                    break;
                byte[] buf = line.getBytes();
                //�������ݰ�����
                DatagramPacket dp = new DatagramPacket(buf, buf.length,
                        InetAddress.getByName("192.168.3.255"), 10003);
                //ͨ��udp��������
                ds.send(dp);
            }
            ds.close();
            //exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//�������յ��߳�
class Rece implements Runnable{
    private DatagramSocket ds;
    public Rece(DatagramSocket ds){
        this.ds = ds;
    }
    @Override
    public void run() {
        //�������ݣ������ݴ��������ݰ�������
        while (true) {
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            try {
                ds.receive(dp);
                //��������
                String ip = dp.getAddress().getHostAddress();
                int port = dp.getPort();
                String text = new String(dp.getData(), 0, dp.getLength());
                System.out.println(ip + ":" + port + "˵" + text);
                if ("gameover".equals(text)) {
                    System.out.println(ip + "....�뿪������");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

