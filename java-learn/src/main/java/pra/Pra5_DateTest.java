package src.main.java.pra;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pra5_DateTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        //日期转字符串
        System.out.println(simpleDateFormat.format(new Date()));
        //字符串转日期
        System.out.println(simpleDateFormat2.parse("2020/12/12 12:12:12"));

    }
}
