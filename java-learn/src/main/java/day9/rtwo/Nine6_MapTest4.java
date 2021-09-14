package src.main.java.day9.rtwo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Nine6_MapTest4 {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		//args就是传进来的全部字符串
		for(int i = 0;i < args.length;i ++)
		{
			//args[i]第i个单词
			if(map.get(args[i])==null)
			{
				map.put(args[i], 1);
			}
			else
			{
				Integer in = (Integer)map.get(args[i]);
				in = in + 1;
				map.put(args[i], in);
			}
		}

		//取值
		Set set = map.keySet();
		for(Iterator iter = set.iterator();iter.hasNext();)
		{
			String key = (String)iter.next();
			Integer value = (Integer)map.get(key);
			System.out.println(key + ":" + value);
		}
	}
}
