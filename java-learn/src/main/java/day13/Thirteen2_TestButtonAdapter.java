package src.main.java.day13;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Thirteen2_TestButtonAdapter {
	public static void main(String[] args) {
		Frame f = new Frame("TestButton");
		Button b = new Button("Press me");
		f.addWindowListener(new MyAdapter());
		f.add(b,BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);
	}
}

class MyAdapter extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("关闭窗口");
		System.exit(0);
	}
}