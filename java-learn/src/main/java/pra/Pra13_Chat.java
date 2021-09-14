package src.main.java.pra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Pra13_Chat {
    public static void main(String[] args) throws SocketException {

        new Thread(new Send(new DatagramSocket())).start();
        new Thread(new Rece(new DatagramSocket(10000))).start();
    }

    static class Send implements Runnable{
        private DatagramSocket ds;

        public Send(DatagramSocket ds) {
            this.ds = ds;
        }

        @Override
        public void run() {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String str;
                while (null != (str = bufferedReader.readLine())) {
                    byte[] bytes = str.getBytes();
                    DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.3.255"), 10000);
                    ds.send(dp);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class Rece implements Runnable{
        private DatagramSocket ds;

        public Rece(DatagramSocket ds) {
            this.ds = ds;
        }
        @Override
        public void run() {
            while (true) {
                byte[] bytes = new byte[1024];
                DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
                try {
                    ds.receive(dp);
                    String ip = dp.getAddress().getHostAddress();
                    int port = dp.getPort();
                    String text = new String(dp.getData(), 0, dp.getLength());
                    System.out.println(ip + ":" + port + "Ëµ" + text);
                    if ("gameover".equals(text)) {
                        System.out.println(ip + "....Àë¿ªÁÄÌìÊÒ");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
