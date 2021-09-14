package src.main.java.day3;

public class Three11_ArraySearchTest {
	/*
	需求：数组中元素的查找。获取元素的位置
	*/
	public static int search(int[] a, int value) {
		//遍历数组
		for (int i = 0; i < a.length; i++)
			if (value == a[i]) {
				return i;
			}
		return -1;
	}

	//二分查找,针对有序数组
	public static int binarySearch(int[] array, int value) {
		int low = 0;
		int high = array.length - 1;//8
		int middle;//4
		while (low <= high) {
			middle = (low + high) / 2;
//			System.out.println(high);
//			System.out.println(middle);
			for (int i = 0; i < array.length; i++) {
				System.out.print(array[i]);
				if (i == middle) {
					System.out.print("#");
				}
				System.out.print(" ");
			}
			System.out.println();
			System.out.println(middle);
			if (array[middle] == value) {
				return middle;
			}
			if (value < array[middle]) {
				high = middle - 1;
			}
			if (value > array[middle])
				low = middle + 1;
		}
		return -1;
	}
	
	public static void main(String [] args) {
		int[] a = {1, 5, 6, 19, 10, 2, 9};
		//int value = 9;
		int index = search(a, 9);
		System.out.println(index);

		System.out.println("----------------");

		int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int index2 = binarySearch(b, 8);
		System.out.println(index2);

//		int c = 7;
//		int d = 2;
//		int e = c / d;
//		System.out.println(e);
	}
}