package src.main.java.day17;

import java.io.*;
import java.net.Socket;

public class Seventeen3_TransClient {
    //ͨ���ͻ��˷��͵������ݣ������תΪ��д����
    public static void main(String[] args) throws IOException {
        //����socket����
        Socket s = new Socket("127.0.0.1", 10006);
        //�ӿͻ��˶�ȡ����¼������ݲ�����
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        //��������͸������
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        //���շ���˷��ص�����
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        //io��д
        String  line;
        while (null != (line = bufr.readLine())) {
            if ("88".equals(line))
                break;
            //�ͻ��˼���¼�����ݷ��ͷ����
            out.println(line);
            String str = bufIn.readLine();
            System.out.println("trans:" + str);
        }
        s.close();
    }
}
