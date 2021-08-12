package src.main.java.day2;

public class WhileTest
{   /**
	演示whlie语句，打印1-100的和
	当语句需要执行很多次的时候，就要用到循环语句
	*/
	public static void main(String [] args) {
		//循环变量
		int a = 1;
		//存放相加后的结果
		int sum = 0;
		while (a <= 100) {
			sum += a;
			a++;
		}
		System.out.println(sum);
	}
}