package src.main.java.day9.three;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Nine11_MapTest {

	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		map.put("a", "aa");
		map.put("b", "bb");
		map.put("c", "cc");
		map.put("d", "dd");
		Set<String> set = map.keySet();
		for (String key : set) {
			String value = map.get(key);
			System.out.println(key + ":" + value);
		}
		System.out.println("----------------------------------------");
		Set<Map.Entry<String, String>> set2 = map.entrySet();
		for (Map.Entry<String, String> entry : set2) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + ":" + value);
		}
	}
}
