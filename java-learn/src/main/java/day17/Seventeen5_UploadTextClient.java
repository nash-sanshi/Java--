package src.main.java.day17;

import java.io.*;
import java.net.Socket;

public class Seventeen5_UploadTextClient {
    public static void main(String[] args) throws IOException {
        //����socket����
        Socket s = new Socket("127.0.0.1", 10007);
        //�ӿͻ����ļ���ȡ����
        BufferedReader bufr = new BufferedReader(new FileReader("D:/java��Ŀ/java-learn/src/main/java/day17/client.txt"));
        //BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        //���շ���˷��ص�
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String  line;
        while (null != (line = bufr.readLine())) {
            out.println(line);
        }
        //out.println("over");//ͨ��over���߷���˽�����������һ�ͻ����ļ�����over�ַ����Ͳ�����
        //ֻ��ͨ��shutdownOutput���ַ�ʽ���߷����
        s.shutdownOutput();//���߷���ˣ����͵������Ѿ��������
        //��ȡһ�Σ�����˷������ϴ��ɹ���
        String ok = bufIn.readLine();
        System.out.println(ok);
        s.close();
    }
}
