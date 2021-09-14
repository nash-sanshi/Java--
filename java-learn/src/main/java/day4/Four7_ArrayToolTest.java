package src.main.java.day4;

import java.util.Arrays;

public class Four7_ArrayToolTest
{
	public static void main(String [] args)
	{
		int[] arr = {23,1,4,5,70,8};
		//ArrayTool tool = new ArrayTool();
		//ArrayTool为静态类
		int max = Four8_ArrayTool.getMax(arr);
		System.out.println("max =" + max);

		System.out.println("max="+ Four8_ArrayTool.getMax(arr));

		Four8_ArrayTool.bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}