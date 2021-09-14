package src.main.java.day9.one;

import java.util.ArrayList;

public class Nine2_ArrayList1
{
	public static void main(String[] args) 
	{
		ArrayList arrayList = new ArrayList();
		arrayList.add("hello");
		arrayList.add("world");
		arrayList.add("world");
		arrayList.add("welcome");
		String s1 = (String)arrayList.get(0);
		String s2 = (String)arrayList.get(1);
		String s3 = (String)arrayList.get(2);
		String s4 = (String)arrayList.get(3);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println("----------");
		for(int i = 0;i < arrayList.size();i++)
		{
		System.out.println(arrayList.get(i));	
		}
		System.out.println("----------");
		arrayList.clear();
		System.out.println(arrayList.size());
	}
}
