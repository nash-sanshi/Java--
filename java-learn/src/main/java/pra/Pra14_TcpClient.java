package src.main.java.pra;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Pra14_TcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10005);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("Œ“¿¥¡À".getBytes());

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len ;
        while (-1 != (len = inputStream.read(bytes))){
            System.out.println(new String(bytes,0,len));
        }

        socket.close();
    }
}