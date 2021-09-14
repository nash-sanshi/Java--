package src.main.java.day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sixteen6_UdpSend2 {
    /**
     * 获取键盘录入的数据，发送给接收端
     */
    public static void main(String[] args) throws Exception {
        System.out.println("udp开始传输");
        //创建socket
        DatagramSocket ds = new DatagramSocket();
        //封装数据
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (null != (line = bufr.readLine())) {
            if ("gameover".equals(line))
                break;
            byte[] buf = line.getBytes();
            //创建数据包对象
            DatagramPacket dp = new DatagramPacket(buf, buf.length,
                    InetAddress.getByName("127.0.0.1"), 10002);
            //通过udp发送数据
            ds.send(dp);
        }
        //关闭资源
        ds.close();
        System.out.println("udp发送成功");
    }
}
