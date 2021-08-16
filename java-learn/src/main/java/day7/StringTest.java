package src.main.java.day7;

public class StringTest
{
	public static void main(String[] args)
	{
		String str = new String("aa");
		String str2 = new String("aa");
		System.out.println(str.equals(str2));
		String str3 = "a";
		String str4 = "a";
		System.out.println(str3.equals(str4));
		System.out.println("--------------------------");
		Object o = new Object();
		Object o2 = new Object();
		System.out.println(o.equals(o2));
		System.out.println(o.equals(o2));
	}
}

