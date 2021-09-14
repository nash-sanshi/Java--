package src.main.java.day12;

public class Twelve5_MainTest {
	public static void main(String[] args) {
		Twelve2_Sample s = new Twelve2_Sample();
		Thread t1 = new Twelve3_IncreaseThread(s);
		Thread t2 = new Twelve4_DecreaseThread(s);
		Thread t3 = new Twelve3_IncreaseThread(s);
		Thread t4 = new Twelve4_DecreaseThread(s);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
