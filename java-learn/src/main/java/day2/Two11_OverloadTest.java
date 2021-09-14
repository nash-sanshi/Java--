package src.main.java.day2;

public class Two11_OverloadTest {
	public static int add (int a, int b) {
		return a + b;
	}

	public static int add (int a, int b, int c) {
		return a + b + c;
	}

	public static void main(String[] args) {
	int a = add(1,2);
	int b = add(1,2,3);
	System.out.println(a + ":" + b);
	}
}