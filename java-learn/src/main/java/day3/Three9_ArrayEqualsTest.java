package src.main.java.day3;

public class Three9_ArrayEqualsTest
{
	public static boolean isEquals(int[] a, int[] b)
	{
		if (a == null || b == null)
		{
			return false;
		}			
		
		if (a.length != b.length)
		{
			return false;
		}
		
		for (int i = 0;i < a.length; i++)
		{
			if (a[i] != b[i])
			{
				return false;
			}
		}
		return true;
	}
	
	public static void main(String [] args)
	{
	int[] a = {1,2,3};	
	int[] b = {1,2,3};	
	System.out.println(isEquals(a,b));
	}
	
}