package src.main.java.day16;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Sixteen2_UrlConnection1 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.sina.com.cn/");
        //�����
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        InputStream inputStream = url.openConnection().getInputStream();
        //io��
        FileOutputStream os = new FileOutputStream("D:/java��Ŀ/java-learn/src/main/java/day16/sina.html");
        FileOutputStream fileOutputStream = new FileOutputStream("D:/java��Ŀ/java-learn/src/main/java/day16/sina1.html");
        //��ǣ���Ҫ��ʽ
        byte[] buffer = new byte[1024];
        int length;
        while (-1 != (length = is.read(buffer,0,buffer.length))){
            os.write(buffer,0,length);
        }
        while (-1 != (length = inputStream.read(buffer))) {
            fileOutputStream.write(buffer,0,length);
        }
        /*����������������
        int len = inputStream.read(buffer,0, buffer.length);
        fileOutputStream.write(buffer,0,len);*/
        is.close();
        os.close();
    }
}
