package src.main.java.day10;

import java.util.HashMap;
import java.util.Map;

public class Ten10_Frequency {

	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		for(String word:args)
		{
			//���ַ������ַ������ֵĴ����Ž�map��
			//key�����ַ�����value�����ַ������ֵĴ���
			//���û���ֹ���valueΪ1������ÿ����һ�Σ�value+1
			map.put(word,(null == map.get(word))?1:map.get(word)+1);	
		}
		System.out.println(map);
	}
}