package src.main.java.day10;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ten19_DateTest {

	public static void main(String[] args) throws ParseException {
		//����һ�����ڶ���
		Date date = new Date();
		System.out.println("��ǰʱ�䣺"+date);
		System.out.println("-----------------------");
		/*
		 * Ҫ������ڶ�����ַ���������ʽ����ָ����ʽ����ʾ
		 * �ҵ�dateformat��
		 * ��ʽ��������-���ı������ڶ���-���ַ���
		 * �������ı�-�����ڣ����ڸ�ʽ�ַ���-�����ڶ���
		 */

		DateFormat df = DateFormat.getDateInstance();
		//System.out.println(df);
		//ͨ��format���������ڶ�����и�ʽ��
		//df = DateFormat.getDateInstance(DateFormat.FULL);//2021��8��19�� ������
		//df = DateFormat.getDateInstance(DateFormat.LONG);//2021��8��19��
		//df = DateFormat.getDateInstance(DateFormat.MEDIUM);//2021-8-19
		//df = DateFormat.getDateInstance(DateFormat.SHORT);//21-8-19
		df = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);//2021��8��19�� ������ ����05ʱ51��24�� CST
		String str_date = df.format(new Date());
		System.out.println(str_date);

		System.out.println("-----------------------");
		//�Զ����ʽ����SimpleDateFormat��������
		//ͨ���乹�캯�����Զ���ģʽ���з�װ
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		//String str_date1 = df1.format(new Date());
		System.out.println("����ת�ַ�����" + df1.format(new Date()));

		System.out.println("-----------------------");
		//�ַ���ת����
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		System.out.println("�ַ���ת���ڣ�" + df2.parse(df1.format(new Date())));
		Date date2 = df2.parse("2020/12/12 20:20:20");
		//System.out.println(date2);
	}
}
