package src.main.java.day13.awt;

import java.awt.*;

public class Thirteen6_ExGui3 {
	public void go() {
		Frame f = new Frame("complexLayout");
		Button b1 = new Button("West");
		Button b2 = new Button("center");
		f.add(b1,BorderLayout.WEST);
		f.add(b2,BorderLayout.EAST);
		Panel p = new Panel();
		Button b3 = new Button("world");
		Button b4 = new Button("welcome");
		p.add(b3);
		p.add(b4);
		f.add(p,BorderLayout.NORTH);
		f.pack();
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		Thirteen6_ExGui3 g = new Thirteen6_ExGui3();
		g.go();
	}
}
