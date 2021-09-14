package src.main.java.day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 群聊程序：一边发一边收
 * 1、使用广播192.168.0.255
 * 2、使用多线程
 */
public class Sixteen8_ChatTest {
    public static void main(String[] args) throws SocketException {
        //发送的数据包
        DatagramSocket send = new DatagramSocket();
        //接收的数据包
        DatagramSocket rece = new DatagramSocket(10003);
        //建立线程发送数据
        new Thread(new Send(send)).start();
        //建立线程接收数据
        new Thread(new Rece(rece)).start();
    }
}

//建立发送的线程
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
                //创建数据包对象
                DatagramPacket dp = new DatagramPacket(buf, buf.length,
                        InetAddress.getByName("192.168.3.255"), 10003);
                //通过udp发送数据
                ds.send(dp);
            }
            ds.close();
            //exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//建立接收的线程
class Rece implements Runnable{
    private DatagramSocket ds;
    public Rece(DatagramSocket ds){
        this.ds = ds;
    }
    @Override
    public void run() {
        //接收数据，将数据存贮到数据包对象中
        while (true) {
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            try {
                ds.receive(dp);
                //解析数据
                String ip = dp.getAddress().getHostAddress();
                int port = dp.getPort();
                String text = new String(dp.getData(), 0, dp.getLength());
                System.out.println(ip + ":" + port + "说" + text);
                if ("gameover".equals(text)) {
                    System.out.println(ip + "....离开聊天室");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

