package src.main.java.day10;

public class Ten3_ExceptionTest {

	public static void main(String[] args) {
		int c = 0;
		try
		{
			int a = 3;
			int b = 0;
			c = a / b;
		}
		catch(ArithmeticException e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("welcome");
		}
		System.out.println("hello");
		System.out.println(c);
	}
}
