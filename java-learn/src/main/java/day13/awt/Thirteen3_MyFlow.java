package src.main.java.day13.awt;

import java.awt.*;

public class Thirteen3_MyFlow {
	public void go() {
		Frame f = new Frame("FlowLayout");
		//使用FlowLayout替换掉默认的BorderLayout布局管理器
		f.setLayout(new FlowLayout());
		Button b1 = new Button("hello");
		Button b2 = new Button("world");
		Button b3 = new Button("welcome");
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.setSize(100,100);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		Thirteen3_MyFlow f = new Thirteen3_MyFlow();
		f.go();
	}
}
