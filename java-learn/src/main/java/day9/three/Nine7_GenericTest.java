package src.main.java.day9.three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Nine7_GenericTest<T> {
	private T foo;

	public T getFoo() {
		return foo;
	}

	public void setFoo(T foo) {
		this.foo = foo;
	}
	
	public static void main(String[] args) {
		//ge类型要在List之下
		Nine7_GenericTest<? extends List> ge = null;
		ge = new Nine7_GenericTest<ArrayList>();
		ge = new Nine7_GenericTest<LinkedList>();
		//ge = new GenericTest<HashMap>();

		//ge2类型要在List之上
		Nine7_GenericTest<? super List> ge2 = null;
		ge2 = new Nine7_GenericTest<Object>();
		
		Nine7_GenericTest<String> ge3 = new Nine7_GenericTest<>();
		ge3.setFoo("hello world");
		Nine7_GenericTest<?> ge4 = ge3;
		System.out.println(ge4.getFoo());
		ge4.setFoo(null);
		System.out.println(ge4.getFoo());
	}
}
