package src.main.java.pra;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Pra12_UdpServerIn {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10000);
        while (true) {
            byte[] bytes = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
            ds.receive(dp);
            String ip = dp.getAddress().getHostAddress();
            int port = dp.getPort();
            String text = new String(dp.getData(), 0, dp.getLength());
            System.out.println(ip +":" +port +":" +text);
        }
    }
}
