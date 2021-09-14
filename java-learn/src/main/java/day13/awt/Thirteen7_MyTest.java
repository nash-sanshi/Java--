package src.main.java.day13.awt;

import java.awt.*;

public class Thirteen7_MyTest {
	public static void main(String[] args) {
		Frame f = new Frame();
		f.setSize(500, 500);
		MyPanel p = new MyPanel();
		f.add(p);
		f.setVisible(true);
	}

	public static class MyPanel extends Panel {
		public void paint(Graphics g) {
			g.setColor(Color.GREEN);
			g.drawLine(30, 30, 100, 100);
			g.drawOval(250, 250, 100, 200);
		}
	}
}

