package src.main.java.day7;

public class Seven7_ObjectTest2
{
	public static void main(String[] args)
	{
		Object o = new Object();
		Object o2 = new Object();
		System.out.println(o.equals(o2));//不同对象
		System.out.println(o == o2);//不同对象
		System.out.println("-----------------------------");
		String str = new String("aaaa");
		String str2 = new String("aaaa");
		System.out.println(str == str2);//false
		System.out.println(str.equals(str2));//true
		System.out.println("-----------------------------");
		String str3 = "b";
		String str4 = "b";
		System.out.println(str3 == str4);//true
		System.out.println("-----------------------------");
		String str5 = new String("ccc");
		String str6 = "ccc";
		System.out.println(str5 == str6);//false
		System.out.println(str5.equals(str6));//true
		System.out.println("-----------------------------");
		String s = "hello";
		String s1 = "hel";
		String s2 = "lo";
		//String字符串值要用equals()方法，不能使用==
		System.out.println(s==s1+s2);//false
		System.out.println(s.equals(s1 + s2));//true
		System.out.println(s == "hel" + "lo");//true
		System.out.println("-----------------------------");
		String c1 = "hello";
		String c2 = " world";
		String c3 = c1 + c2;
		System.out.println(c3);
	}
}

