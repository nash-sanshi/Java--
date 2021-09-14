package src.main.java.day13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Thirteen3_FrameTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("Frame");
		JLabel label = new JLabel("hello world");
		f.addWindowListener(new MyHandler());
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(label,BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);
	}
}

class MyHandler extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}