package src.main.java.day12;

public class Twelve1_ThreadTest {
	public static void main(String[] args) {
		Example e = new Example();
		Thread t1 = new TheThread1(e);
		Thread t2 = new TheThread2(e);
		t1.start();
		t2.start();
	}
}

class TheThread1 extends Thread {
	private final Example example;

	public TheThread1(Example example) {
		this.example = example;
	}

	public void run() {
		this.example.execute1();
	}
}

class TheThread2 extends Thread {
	private final Example example;

	public TheThread2(Example example) {
		this.example = example;
	}

	public void run() {
		this.example.execute2();
	}
}

class Example {
	public synchronized void execute1() {
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("hello:" + i);
		}
	}

	public synchronized void execute2() {
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("world:" + i);
		}
	}
}