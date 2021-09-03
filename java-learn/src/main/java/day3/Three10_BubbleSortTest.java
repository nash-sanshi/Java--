package src.main.java.day3;

import java.util.Arrays;

public class Three10_BubbleSortTest {
	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
			System.out.println("第" + (i + 1) + "次排序");
			for (int k = 0; k < array.length; k++) {
				System.out.print(array[k] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String [] args) {
	int[] array = {4,8,7,9,3,2};
	bubbleSort(array);
	System.out.println(Arrays.toString(array));

	//开发时常用的导入包，java.util.Arrays
	Arrays.sort(array);
	System.out.println(Arrays.toString(array));
	}
}