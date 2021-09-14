package src.main.java.pra;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Pra10_UrlConnection1 {
    public static void main(String[] args) throws IOException {
        URL u = new URL("https://www.sina.com.cn");
        URLConnection urlConnection = u.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream(
                "D:/javaÏîÄ¿/java-practise/src/test/java/baidu1.txt");
        byte[] bytes = new byte[1024];
        int len;
        while (-1 != (len = inputStream.read(bytes))) {
            fos.write(bytes,0,len);
        }
        inputStream.close();
        fos.close();
    }
}