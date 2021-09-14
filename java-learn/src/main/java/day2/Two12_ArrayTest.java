package src.main.java.day2;

public class Two12_ArrayTest
{
	public static void main(String[] args)
	{

		int[] a = new int [4];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		a[3] = 4;
		System.out.println(a[3]);
	
		//int [] a = {1,2,3,4};
		
		//int [] b = new int [] {1,2,3,4};
		System.out.println("-----------------------");
		int [] b = new int [100];
		for (int i = 0;i < b.length; i++)
		{
			b[i] = i + 1;
		}			
		//取值
		for (int i = 0;i < b.length; i++)
		{
			System.out.println(b[i]);
		}	
	}
}