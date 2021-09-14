package src.main.java.day9.one;

public class Point1 {
	int x;
	int y;
//	public Point(int x, int y)
//	{
//		this.x = x;
//		this.y = y;
//	}
	//Alt+Insert生成构造函数
	public Point1(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString()
	{
		return "x=" + this.x + ",y=" + this.y;
	}
}
