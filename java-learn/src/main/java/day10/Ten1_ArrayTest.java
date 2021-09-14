package src.main.java.day10;

import java.util.Arrays;

public class Ten1_ArrayTest {
	/*
	Arrays:用于操作数据的工具类提供了常见的方法
	该类中的方法都是静态的
	*/
	public static void main(String[] args) {
		int[] arr = {31,99,2,10,22,55};
		System.out.println(Arrays.toString(arr));//打印数组中的元素字符串形式

		 //数组转集合asList([])
		String[] strs = {"abc","heh","ccc","dsds"};
		System.out.println(Arrays.asList(strs));
	}
}
