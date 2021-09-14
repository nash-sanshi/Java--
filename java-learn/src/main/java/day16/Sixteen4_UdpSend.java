package src.main.java.day16;

import java.net.*;

public class Sixteen4_UdpSend {
    /**
     * 创建一个upd发送端
     * 1、先创建udp端点，也就是socket
     * 2、封装数据包
     * 3、通过udp数据发送
     */
    public static void main(String[] args) throws Exception {
        System.out.println("udp开始传输");
        //创建socket
        DatagramSocket ds = new DatagramSocket();//此类表示用于发送和接收数据报数据包的套接字。
        //封装数据
        String str = "我是一条udp数据";
        //使用平台的默认字符集将此 String编码为字节序列，将结果存储到新的字节数组中。
        byte[] buf = str.getBytes();
        //创建数据包对象
        DatagramPacket dp = new DatagramPacket(buf,buf.length,
                InetAddress.getByName("127.0.0.1"),10000);
        //通过udp发送数据
        ds.send(dp);
        ds.close();
        System.out.println("udp发送成功");
    }
}
