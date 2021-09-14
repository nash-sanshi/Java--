package src.main.java.day10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ten9_ForTest {

	public static void main(String[] args) {
		int [] arr = {1,2,3,4,5};
		//old
		for(int i = 0;i < arr.length;i ++)
		{
			System.out.println(arr[i]);
		}
		
		System.out.println("----------");
		//new增强for循环
		for(int element:arr)
		{
			System.out.println(element);
		}

		System.out.println("----------");
		String[] names = {"hello","world","wel"};
		for(String name:names)
		{
			System.out.println(name);
		}
		
		int[][] arr2 = {{1,2,3,},{4,5,6,},{7,8,9}};
		for(int[] row:arr2)
		{
			for (int element:row)
			{
				System.out.println(element);
			}
		}
		System.out.println("----------");
		List<String> col = new ArrayList<>();
		col.add("one");
		col.add("two");
		col.add("one");
		for(String str:col)
		{
			System.out.println(str);
		}
		
		System.out.println("----------");
		for(int i = 0;i < col.size();i ++)
		{
			System.out.println(col.get(i));
		}
		
		System.out.println("----------");
		for(Iterator<String> iter = col.iterator();iter.hasNext();)
		{
			System.out.println(iter.next());
		}
	}
}
