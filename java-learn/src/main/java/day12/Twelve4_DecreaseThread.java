package src.main.java.day12;

public class Twelve4_DecreaseThread extends Thread {
	private final Twelve2_Sample s;
	
	public Twelve4_DecreaseThread(Twelve2_Sample s)
	{
		this.s = s;
	}

	public void run() {
		for(int i = 0; i < 20;i ++)
		{
			try{
				Thread.sleep((long)(Math.random()*1000));
			}catch(Exception e){
				e.printStackTrace();
			}
			s.decrease();
		}
	}
}
