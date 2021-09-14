package src.main.java.day16;

import java.net.MalformedURLException;
import java.net.URL;

public class Sixteen1_Url1 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://java.sun.com:80/docs/books/index.html");
        String protocol = url.getProtocol();
        String host = url.getHost();
        String file = url.getFile();
        int port = url.getPort();
        String ref = url.getRef();//������ URL��ê��Ҳ��Ϊ���ο�������
        System.out.println(protocol+","+host+","+port+","+ref+","+file);
    }
}
