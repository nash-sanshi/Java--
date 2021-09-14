package src.main.java.day13;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Thirteen4_SwingTest {
	public static void main(String[] args) {
		JFrame f = new JFrame("JFrame");
		JButton b = new JButton("click me");
		b.addActionListener(new MyListener());
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("匿名内部类");
			}
		});
		f.setSize(200, 200);
		f.add(b);
		f.setVisible(true);
	}
}

class MyListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("hello world");
	}
}
