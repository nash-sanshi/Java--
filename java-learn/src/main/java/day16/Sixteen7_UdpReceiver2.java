package src.main.java.day16;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Sixteen7_UdpReceiver2 {
    /**
     * 接收键盘发送端数据并打印
     */
    public static void main(String[] args) throws Exception {
        System.out.println("udp接收端开启....");
        //建立udp端口
        DatagramSocket ds = new DatagramSocket(10002);
        //接收数据，将数据存贮到数据包对象中
        while (true) {
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            ds.receive(dp);
            //解析数据
            String ip = dp.getAddress().getHostAddress();
            int port = dp.getPort();
            String text = new String(dp.getData(), 0, dp.getLength());
            System.out.println(ip + ":" + port + ":" + text);
        }
        //关闭资源
        //ds.close();
        //System.out.println("udp接收端关闭了....");
    }
}
