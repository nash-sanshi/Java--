package src.main.java.pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Pra12_UdpClientIn {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while (null != (str=bufferedReader.readLine())) {
            if (str.equals("gameover")) {
                break;
            }
            byte[] bytes = str.getBytes();
            DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("127.0.0.1"), 10000);
            datagramSocket.send(dp);
        }
        datagramSocket.close();
    }
}