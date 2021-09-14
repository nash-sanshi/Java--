package src.main.java.day16;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Sixteen2_UrlConnection1 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.sina.com.cn/");
        //网络层
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        InputStream inputStream = url.openConnection().getInputStream();
        //io层
        FileOutputStream os = new FileOutputStream("D:/java项目/java-learn/src/main/java/day16/sina.html");
        FileOutputStream fileOutputStream = new FileOutputStream("D:/java项目/java-learn/src/main/java/day16/sina1.html");
        //熟记，重要格式
        byte[] buffer = new byte[1024];
        int length;
        while (-1 != (length = is.read(buffer,0,buffer.length))){
            os.write(buffer,0,length);
        }
        while (-1 != (length = inputStream.read(buffer))) {
            fileOutputStream.write(buffer,0,length);
        }
        /*读不到完整的数据
        int len = inputStream.read(buffer,0, buffer.length);
        fileOutputStream.write(buffer,0,len);*/
        is.close();
        os.close();
    }
}
