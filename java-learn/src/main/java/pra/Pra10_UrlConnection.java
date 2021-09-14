package src.main.java.pra;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Pra10_UrlConnection {
    public static void main(String[] args) throws IOException {
        URL u = new URL("https://www.baidu.com");
        URLConnection urlConnection = u.openConnection();
        InputStream input = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream(
                "D:/java项目/java-practise/src/test/java/baidu.txt");
        //一次读取多个字节
        byte[] bytes = new byte[1024];//存储读取到的多个字节
        int len = 0;//记录每次读取的有效字节个数
        while ((len = input.read(bytes)) != -1) {
            //String(byte[] bytes, int offset, int length):把字节数组的一部分转换为字符串
            // offset:数组的开始索引 length: 转换的字节个数
            //System.out.println(new String(bytes, 0, len));//有效的字节个数
            fos.write(bytes, 0, len);
        }
        //一次读取一个字节
        /*int len = 0;//记录读取到的字节
        while ((len = input.read()) != -1) {
            //System.out.print(len);//979899
            //强转为char字符
            //System.out.print((char) len);
            fos.write((char)len);
        }*/
        input.close();
        fos.close();
    }
}
