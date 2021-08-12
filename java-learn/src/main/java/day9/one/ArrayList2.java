package src.main.java.day9.one;

import java.util.ArrayList;

public class ArrayList2 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		/*list.add(3);
		Integer i = (Integer) list.get(0);
		int j = i.intValue();*/
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		//Integer[] in = (Integer[])list.toArray();
		Object[] in = list.toArray();
		for(int i =0;i < in.length;i ++)
		{
		System.out.println(((Integer)in[i]).intValue());	
		}
		
	}

}
