package src.main.java.pra;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pra3_ConvertDemo {

    /**
     * ����ת�����ַ���
     * @param date
     * @return str
     */
    public static String DateToStr(Date date) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    /**
     * �ַ���ת��������
     * @param str
     * @return date
     */
    public static Date StrToDate(String str) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.parse(str);
    }

    public static void main(String[] args) throws ParseException {

        Date date = new Date();
        System.out.println("����ת�ַ�����" + Pra3_ConvertDemo.DateToStr(date));
        System.out.println("�ַ���ת���ڣ�" + Pra3_ConvertDemo.StrToDate(Pra3_ConvertDemo.DateToStr(date)));
        System.out.println("�ַ���ת���ڣ�" + Pra3_ConvertDemo.StrToDate("2020-2-2 20:20:20"));

    }

}
