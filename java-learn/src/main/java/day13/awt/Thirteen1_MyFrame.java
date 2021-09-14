package src.main.java.day13.awt;

import java.awt.*;

public class Thirteen1_MyFrame extends Frame {
	public Thirteen1_MyFrame(String title)
	{
		super(title);
	}

	public static void main(String[] args) {
		Thirteen1_MyFrame f = new Thirteen1_MyFrame("First GUI");
		f.setSize(500,500);
		f.setBackground(Color.green);
		f.setVisible(true);

		Panel p = new Panel();
		p.setBackground(Color.yellow);
		//panel面板加到frame框架上面
		f.add(p);
	}
}
