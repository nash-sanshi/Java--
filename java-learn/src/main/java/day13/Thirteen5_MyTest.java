package src.main.java.day13;

import javax.swing.*;
import java.awt.*;

public class Thirteen5_MyTest {
	public static void main(String[] args) {
/*	Frame f = new Frame();
	MyPanel p = new MyPanel();
	f.add(p);
	f.setSize(1024,768);
	f.setBackground(Color.black);
	f.setVisible(true);*/
	JFrame f = new JFrame();
	f.getContentPane().setBackground(Color.black);
	MyPanel p = new MyPanel();
	f.add(p);
	f.setSize(1024,768);
	f.setVisible(true);
	}
}

class MyPanel extends Panel {
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		for (int i = 0; i < 300; i++) {
			g.drawString("***", (int) (Math.random() * 1024), (int) (Math.random() * 768));
		}
	}
}