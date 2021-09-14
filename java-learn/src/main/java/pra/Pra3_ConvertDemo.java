package src.main.java.pra;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pra3_ConvertDemo {

    /**
     * 日期转换成字符串
     * @param date
     * @return str
     */
    public static String DateToStr(Date date) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    /**
     * 字符串转换成日期
     * @param str
     * @return date
     */
    public static Date StrToDate(String str) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.parse(str);
    }

    public static void main(String[] args) throws ParseException {

        Date date = new Date();
        System.out.println("日期转字符串：" + Pra3_ConvertDemo.DateToStr(date));
        System.out.println("字符串转日期：" + Pra3_ConvertDemo.StrToDate(Pra3_ConvertDemo.DateToStr(date)));
        System.out.println("字符串转日期：" + Pra3_ConvertDemo.StrToDate("2020-2-2 20:20:20"));

    }

}
