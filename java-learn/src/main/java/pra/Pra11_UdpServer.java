package src.main.java.pra;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Pra11_UdpServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10000);
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        ds.receive(dp);
        System.out.println(dp.getAddress().getHostAddress());
        System.out.println(dp.getPort());
        System.out.println(new String(dp.getData(),0,dp.getLength()));
    }
}