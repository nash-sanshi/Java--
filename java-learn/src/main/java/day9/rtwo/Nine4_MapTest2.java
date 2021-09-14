package src.main.java.day9.rtwo;

import java.util.HashMap;

public class Nine4_MapTest2 {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		String str = new String("zhangsan");
		map.put("a", str);
		map.put("b", str);
		map.put("b", str);
		System.out.println(map);
//Map的keySet()方法会返回key的集合，因为map的键是不能重复的，因此keyset方法的返回类型是set，
//而map的值是可以重复的，因此value的方法的返回类型是collection，可以容纳重复的元素
	}
}
