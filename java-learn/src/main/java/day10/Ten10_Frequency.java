package src.main.java.day10;

import java.util.HashMap;
import java.util.Map;

public class Ten10_Frequency {

	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		for(String word:args)
		{
			//将字符串和字符串出现的次数放进map里
			//key就是字符串，value就是字符串出现的次数
			//如果没出现过，value为1，后续每出现一次，value+1
			map.put(word,(null == map.get(word))?1:map.get(word)+1);	
		}
		System.out.println(map);
	}
}