package src.main.java.day13.awt;

import java.awt.*;

public class Thirteen2_ExGui {
	public void go() {
		//Frame f;
		//Button button1;
		//Button button2;
		Frame f = new Frame("gui");
		f.setLayout(new FlowLayout());//设置流式布局管理器
		Button button1 = new Button("Press me");
		Button button2 = new Button("Don't press me");
		f.add(button1);
		f.add(button2);
		f.pack();
		f.setVisible(true);
	}

	public static void main(String[] args) {
		Thirteen2_ExGui w = new Thirteen2_ExGui();
		w.go();
	}
}
