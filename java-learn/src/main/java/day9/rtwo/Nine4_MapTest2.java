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
//Map��keySet()�����᷵��key�ļ��ϣ���Ϊmap�ļ��ǲ����ظ��ģ����keyset�����ķ���������set��
//��map��ֵ�ǿ����ظ��ģ����value�ķ����ķ���������collection�����������ظ���Ԫ��
	}
}
