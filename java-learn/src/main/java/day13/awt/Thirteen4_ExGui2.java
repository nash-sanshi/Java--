package src.main.java.day13.awt;

import java.awt.*;

public class Thirteen4_ExGui2 {
	public void go()
	{
		//创建对象
		Frame f = new Frame("Border Layout");
		Button bn = new Button("B1");
		Button bs = new Button("B2");
		Button bw = new Button("B3");
		Button be = new Button("B4");
		Button bc = new Button("B5");
		//button增加到f中，通过BorderLayout指定button位置
		f.add(bn,BorderLayout.NORTH);
		f.add(bs,BorderLayout.SOUTH);
		f.add(bw,BorderLayout.WEST);
		f.add(be,BorderLayout.EAST);
		f.add(bc,BorderLayout.CENTER);
		f.setSize(200,200);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		Thirteen4_ExGui2 gui = new Thirteen4_ExGui2();
		gui.go();
	}
}
