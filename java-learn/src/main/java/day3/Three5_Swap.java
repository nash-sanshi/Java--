package src.main.java.day3;

public class Three5_Swap {
	public static void swap(int a , int b) {
		//交换值
		int temp = a;
		a = b;
		b = temp;
	}
	
	public static void main(String [] args) {
		int a = 3;
		int b = 4;
		swap(a,b);//方法中值的变幻不影响主方法中变量值
		System.out.println(a);
		System.out.println(b);
	}
}