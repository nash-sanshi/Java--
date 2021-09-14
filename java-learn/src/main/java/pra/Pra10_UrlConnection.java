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
                "D:/java��Ŀ/java-practise/src/test/java/baidu.txt");
        //һ�ζ�ȡ����ֽ�
        byte[] bytes = new byte[1024];//�洢��ȡ���Ķ���ֽ�
        int len = 0;//��¼ÿ�ζ�ȡ����Ч�ֽڸ���
        while ((len = input.read(bytes)) != -1) {
            //String(byte[] bytes, int offset, int length):���ֽ������һ����ת��Ϊ�ַ���
            // offset:����Ŀ�ʼ���� length: ת�����ֽڸ���
            //System.out.println(new String(bytes, 0, len));//��Ч���ֽڸ���
            fos.write(bytes, 0, len);
        }
        //һ�ζ�ȡһ���ֽ�
        /*int len = 0;//��¼��ȡ�����ֽ�
        while ((len = input.read()) != -1) {
            //System.out.print(len);//979899
            //ǿתΪchar�ַ�
            //System.out.print((char) len);
            fos.write((char)len);
        }*/
        input.close();
        fos.close();
    }
}
