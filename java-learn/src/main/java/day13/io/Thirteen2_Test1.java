package src.main.java.day13.io;

public class Thirteen2_Test1 {
	//循环方式计算阶乘
	public int compute(int number) {
		int result = 1;
		for (int i = number; i > 0; i--) {
			result *= i;
		}
		return result;
	}
	
	//递归方式
	public int compute2(int number) {
		if (number == 1) {
			return 1;
		} else {
			return number * compute2(number - 1);
		}
	}
	
	public static void main(String[] args) {
		Thirteen2_Test1 test = new Thirteen2_Test1();
		System.out.println(test.compute(5));
		System.out.println(test.compute2(5));
	}
}
