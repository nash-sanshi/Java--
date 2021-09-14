package src.main.java.day10;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ten19_DateTest {

	public static void main(String[] args) throws ParseException {
		//创建一个日期对象
		Date date = new Date();
		System.out.println("当前时间："+date);
		System.out.println("-----------------------");
		/*
		 * 要想对日期对象的字符串表现形式进行指定格式的显示
		 * 找到dateformat类
		 * 格式化：日期-》文本，日期对象-》字符串
		 * 解析：文本-》日期，日期格式字符串-》日期对象
		 */

		DateFormat df = DateFormat.getDateInstance();
		//System.out.println(df);
		//通过format方法对日期对象进行格式化
		//df = DateFormat.getDateInstance(DateFormat.FULL);//2021年8月19日 星期四
		//df = DateFormat.getDateInstance(DateFormat.LONG);//2021年8月19日
		//df = DateFormat.getDateInstance(DateFormat.MEDIUM);//2021-8-19
		//df = DateFormat.getDateInstance(DateFormat.SHORT);//21-8-19
		df = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);//2021年8月19日 星期四 下午05时51分24秒 CST
		String str_date = df.format(new Date());
		System.out.println(str_date);

		System.out.println("-----------------------");
		//自定义格式化，SimpleDateFormat创建对象
		//通过其构造函数将自定义模式进行封装
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		//String str_date1 = df1.format(new Date());
		System.out.println("日期转字符串：" + df1.format(new Date()));

		System.out.println("-----------------------");
		//字符串转日期
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		System.out.println("字符串转日期：" + df2.parse(df1.format(new Date())));
		Date date2 = df2.parse("2020/12/12 20:20:20");
		//System.out.println(date2);
	}
}
