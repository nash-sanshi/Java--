package src.main.java.day1;

public class IfTest1
{
	/**
	���󣺶��û�����������ָ�����Ӧ������
	˼·��
	1.��ô��ȡ�õ�����
	2.Ҫ�����ݽ����жϣ�������Ӧ������
	���裺
	1.����һ�����������ڼ�¼��ȷ��������
	2.ʹ���жϽṹ�����Ը����ݽ��в���
	3.��ÿһ���ж����ж������Ķ�Ӧ����
	4.ͨ�������佫����ʾ�ڿ���̨��
	*/
	public static void main(String [] args)
	{
		int week = 7;
		if (week ==1)
		{
			System.out.println(week + "������һ");
		} 
		else if (week == 2)
		{
			System.out.println(week + "�����ڶ�");
		}
		else if (week == 3)
		{
			System.out.println(week + "��������");
		}
		else if (week == 4)
		{
			System.out.println(week + "��������");
		}
		else if (week == 5)
		{
			System.out.println(week + "��������");
		}
		else if (week == 6)
		{
			System.out.println(week + "��������");
		}
		else if (week == 7)
		{
			System.out.println(week + "��������");
		}
		else
		System.out.println(week + "�����ڲ�����");
	}
}