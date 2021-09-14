package src.main.java.day11;

public class Eleven3_FetchMoney {
	public static void main(String[] args) {
		Bank bank = new Bank();
		Thread t1 = new MoneyThread(bank);//柜台
		Thread t2 = new MoneyThread(bank);//ATM
		t1.start();
		t2.start();
	}
}

class Bank {
	private int money = 1000;
	public synchronized int getMoney(int number) {
		if (number < 0)
		{
			return -1;
		} else if (number > money)
		{
			return -2;
		} else
		{
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			money -= number;
			return number;
		}
	}
}

class MoneyThread extends Thread {
	private final Bank bank;
	public MoneyThread(Bank bank)
	{
		this.bank = bank;
	}
	@Override
	public void run() {
		System.out.println(bank.getMoney(800));
	}
}