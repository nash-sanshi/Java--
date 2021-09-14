package src.main.java.day10;

public class Ten18_MathTest {

	/*
	 * Math是用于数学运算的类，提供了数学运算的静态方法
	 */
	public static void main(String[] args) {
		double d1 = Math.ceil(12.55); //返回大于参数的最小整数
		double d2 = Math.floor(12.55);//返回小于参数的最大整数
		System.out.println("d1=" + d1);
		System.out.println("d2=" + d2);

		double d3 = Math.round(12.55); //四舍五入
		System.out.println("d3=" + d3);
		System.out.println(Math.random()*100);
		System.out.println(Math.random()*100);
		System.out.println(Math.random()*100);
		System.out.println(Math.random()*100);
		System.out.println(Math.random()*100);
	}

}
