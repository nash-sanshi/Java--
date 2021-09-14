package src.main.java.day2;

public class Two9_Juxing {
	/*
	需求：定义一个画矩形的功能
		1.没有结果，类型是void
		2.有2个参数，int，代表行和列
	*/
	public static void draw(int a,int b) {
		for(int x = 0;x < a; x++) {
			for(int y = 0;y < b; y++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		draw(2,2);
		System.out.println();
		draw(5,5);
	}
}