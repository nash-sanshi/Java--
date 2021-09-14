package src.main.java.day11;

public class Eleven1_ThreadTest {
	public static void main(String[] args) {
		Thread1 t1 = new Thread1("first thread");
		Thread2 t2 = new Thread2("second thread");
		System.out.println(t1.getName());
		System.out.println(t2.getName());
		t1.start();
		t2.start();
	}
}

class Thread1 extends Thread {
	public Thread1(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("helloworld" + i);
		}
	}
}

class Thread2 extends Thread {
	public Thread2(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("welcome" + i);
		}
	}
}
