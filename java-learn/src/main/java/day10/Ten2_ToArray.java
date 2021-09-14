package src.main.java.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Ten2_ToArray {
/*
 集合转数组
 如果传递的数组长度小于集合的长度，在toArray内部自动创建一个长度
 和集合相同的数组，用于存贮集合的元素
 如果传递的数组长度大于等于集合的长度，则使用该数组存贮集合的元素
 一般情况下，数组的长度最好使用集合的size()
 限定对数组元素的更多操作方式比如增删
 Collection接口中的方法toArray()
 */
	public static void main(String[] args) {
		Collection<String> coll = new ArrayList<>();
		coll.add("abc1");
		coll.add("abc2");
		coll.add("abc3");
		//集合转数组
		String[] arr = coll.toArray(new String[coll.size()]);
	  	String[] brr = coll.toArray(new String[0]);
	  	Object[] crr = coll.toArray();
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(brr));
		System.out.println(Arrays.toString(crr));
	}
}
