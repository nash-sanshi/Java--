package src.main.java.day9.one;

import java.util.ArrayList;

public class Nine4_ArrayList3 {
	public static void main(String[] args) {
		ArrayList list =new ArrayList();
		list.add(new Point(2,3));
		list.add(new Point(2,4));
		list.add(new Point(4,4));
		list.add(new Point(1,1));
		for(int i = 0;i < list.size(); i ++) {
			System.out.println(list.get(i));
		}
		System.out.println(list);
	}

	public static class Point {
		int x;
		int y;

		//Alt+Insert生成构造函数
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		//重写toString
		public String toString()
		{
			return "x=" + this.x + ",y=" + this.y;
		}
	}
}
