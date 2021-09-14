package src.main.java.day2;

public class Two3_DoWhileTest
{
	public static void main(String [] args) 
	{
		int a = 1;
		int sum = 0;
		do 
		{
			sum += a;
			a++;
		}
		while (a <= 100);
			System.out.println(sum);
	}
}