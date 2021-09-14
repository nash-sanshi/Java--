package src.main.java.day9.rtwo;

import java.util.Date;

public class Nine11_AnonymousInnerClassTest {
	public String get(Date date) {
		return date.toLocaleString();
	}
	
//匿名内部类：匿名内部类会隐式地继承一个父类或实现一个接口
	public static void main(String[] args) {
		Nine11_AnonymousInnerClassTest test = new Nine11_AnonymousInnerClassTest();
		String s1 = test.get(new Date() {
			//重写匿名内部类
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
