package src.main.java.day10;

public class Ten11_TestVarargs {
	private static int sum(int...nums)
	{
		int sum = 0;
		for(int num : nums)
		{
			sum += num;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(sum(1,2));
		System.out.println(sum(1,2,3,4,5));
	}

}
