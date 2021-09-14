package src.main.java.day10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ten21_ConvertDemo {

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
        System.out.println("����ת�ַ�����" + Ten21_ConvertDemo.DateToStr(date));
        System.out.println("�ַ���ת���ڣ�" + Ten21_ConvertDemo.StrToDate(Ten21_ConvertDemo.DateToStr(date)));
        System.out.println("�ַ���ת���ڣ�" + Ten21_ConvertDemo.StrToDate("2020-2-2 20:20:20"));

    }

}
