package src.main.java.day18;

import javax.swing.*;
import java.awt.*;

public class Eighteen3_MySnow {
	public static void main(String[] args) {
/*	Frame f = new Frame();
	MyPanel p = new MyPanel();
	f.add(p);
	f.setSize(1024,768);
	f.setBackground(Color.black);
	f.setVisible(true);*/
	JFrame f = new JFrame();
	f.setSize(1024,768);
	f.getContentPane().setBackground(Color.black);
	MyPanel p = new MyPanel();
	f.add(p);
	Thread t = new Thread(p);
	t.start();
	f.setVisible(true);
	}
}

class MyPanel extends Panel implements Runnable {
	int[] x = new int[300];
	int[] y = new int[300];

	public MyPanel() {
		for (int i = 0; i < 300; i++) {
			x[i] = (int) (Math.random() * 1024);
			y[i] = (int) (Math.random() * 768);
		}
	}

	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		for (int i = 0; i < 300; i++) {
			g.drawString("*", x[i], y[i]);
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				for (int i = 0; i < 300; i++) {
					y[i]++;
					if (y[i] > 768) {
						y[i] = 0;
					}
				}
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			repaint();
		}
	}
}