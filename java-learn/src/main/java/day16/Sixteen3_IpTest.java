package src.main.java.day16;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Sixteen3_IpTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println(ip.getHostAddress());//返回文本显示中的IP地址字符串。
        System.out.println(ip.getHostName());//获取此IP地址的主机名。

        InetAddress ip2 = InetAddress.getByName("www.baidu.com");
        System.out.println(ip2.getHostAddress());
        System.out.println(ip2.getHostName());
    }
}
