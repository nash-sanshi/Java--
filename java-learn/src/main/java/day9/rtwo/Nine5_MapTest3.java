package src.main.java.day9.rtwo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Nine5_MapTest3 {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("a","aa");
		map.put("b","bb");
		map.put("c","cc");
		map.put("d","dd");
		map.put("e","ee");
		Set set = map.keySet();
		for(Iterator iter = set.iterator(); iter.hasNext();)
		{
			String key = (String)iter.next();
			String value = (String)map.get(key);
			System.out.println(key + "=" + value);
		}
	}
}
