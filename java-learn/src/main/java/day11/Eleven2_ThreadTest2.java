package src.main.java.day11;

public class Eleven2_ThreadTest2 {
	public static void main(String[] args) {
		//匿名内部类，重写Runnable的run方法
		Thread t0 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("hello" + i);
				}
			}
		});
		System.out.println(t0.getName());
		t0.start();

		Thread t3 = new Thread(new Thread3());
		Thread t4 = new Thread(new Thread4());
		System.out.println(t3.getName());
		System.out.println(t4.getName());
		t3.start();
		t4.start();
	}
}

class Thread3 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("world" + i);
		}
	}
}

class Thread4 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("welcome" + i);
		}
	}
}