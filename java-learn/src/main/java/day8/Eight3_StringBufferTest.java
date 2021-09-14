package src.main.java.day8;

public class Eight3_StringBufferTest
{
	public static void main(String[] args)
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("hello").append("world").append("welcome");
		/*
		buffer.append("hello");
		buffer.append("world");
		buffer.append("welcome");
		*/
		//toString·½·¨£¬·µ»Ø×Ö·û´®
		String result = buffer.toString();
		System.out.println(result);
		System.out.println(buffer.toString());
		System.out.println((String) buffer.toString());
	}
	
}
