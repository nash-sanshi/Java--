package src.main.java.day10;

import java.io.IOException;

public class Ten17_RuntimeTest {
	/**
	 * Runtime类没有构造方法，不可以实例化，但是提供了非静态的方法
	 * 所以应该会提供静态的返回值类型为Runtime的方法获取该对象
	 */
	
	public static void main(String[] args) throws IOException  {
		//获取Runtime对象
		Runtime r = Runtime.getRuntime();
		//调用exec执行一个程序
		r.exec("notepad.exe");
		Runtime.getRuntime().exec("notepad.exe");
	}
}
