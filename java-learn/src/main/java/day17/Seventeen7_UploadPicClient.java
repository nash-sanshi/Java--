package src.main.java.day17;

import java.io.*;
import java.net.Socket;

public class Seventeen7_UploadPicClient {
    public static void main(String[] args) throws IOException {
        //����socket����
        Socket s = new Socket("127.0.0.1", 10008);
        FileInputStream fis = new FileInputStream("D:/java��Ŀ/java-learn/src/main/java/day17/1.jpg");
        OutputStream out = s.getOutputStream();
        byte[] buf = new byte[1024];
        int len ;
        //��ʹ��ѭ���Ļ�������ɶ��ò�����
        while ((len = fis.read(buf))!= -1){
            out.write(buf,0,len);
        }
        //�����
        s.shutdownOutput();//���ô��׽��ֵ�����������߷���ˣ����͵������Ѿ��������

        //��ȡ����˴��������������
        InputStream in = s.getInputStream();
        byte[] bytes = new byte[1024];
        int lenIn = in.read(bytes);
        System.out.println(new String(bytes, 0, lenIn));
        fis.close();
        s.close();
    }
}
