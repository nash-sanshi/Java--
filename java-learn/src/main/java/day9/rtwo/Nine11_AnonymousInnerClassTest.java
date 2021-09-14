package src.main.java.day9.rtwo;

import java.util.Date;

public class Nine11_AnonymousInnerClassTest {
	public String get(Date date) {
		return date.toLocaleString();
	}
	
//�����ڲ��ࣺ�����ڲ������ʽ�ؼ̳�һ�������ʵ��һ���ӿ�
	public static void main(String[] args) {
		Nine11_AnonymousInnerClassTest test = new Nine11_AnonymousInnerClassTest();
		String s1 = test.get(new Date() {
			//��д�����ڲ���
			@Override
			public String toLocaleString()
			{
				return "hello";
			}
		});
		String s2 = test.get(new Date(){});
		System.out.println(s1);
		System.out.println(s2);
	}
}
