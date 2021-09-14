package src.main.java.day3;

public class Three6_Swap2
{
	public static void swap2(char[] ch,char c)
	{
		ch[0] = 'B';
		c = 'D';
	}
	
	public static void main(String [] args)
	{
		char[] ch = {'A','C'};
		swap2 (ch,ch[1]);  //ch[1]没有发生变化
		for (int i = 0;i < ch.length; i++)
		{
			System.out.println(ch[i]);
		}
	}
}