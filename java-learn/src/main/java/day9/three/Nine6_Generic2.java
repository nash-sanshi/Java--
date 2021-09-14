package src.main.java.day9.three;

import java.util.Arrays;

public class Nine6_Generic2<T> {
	private T[] fooArray;//·ºÐÍÊý×é

	public T[] getFooArray() {
		return fooArray;
	}

	public void setFooArray(T[] fooArray) {
		this.fooArray = fooArray;
	}
	
	public static void main(String[] args) {
		Nine6_Generic2<String> foo = new Nine6_Generic2<>();
		String[] str1 = {"hello","world","welcome"};
		//String[] str2;
		foo.setFooArray(str1);
		String[] str2 = foo.getFooArray();
		for (String s : str2) {
			System.out.println(s);
		}
		System.out.println(Arrays.toString(foo.getFooArray()));
	}
}
