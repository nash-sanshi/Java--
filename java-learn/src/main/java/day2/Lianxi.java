package src.main.java.day2;

public class Lianxi
{
	/*
	��ϰ1���ж����������Ƿ����
	��ϰ2����ӡ�˷���
	��ϰ3����ӡ�������ַ�����Ϣ
	��ϰ4�����幦�ܻ�ȡ���������н��������
	*/
	
	
	/*
	��ϰ1���ж����������Ƿ����
		1.��������boolean
		2.2��������int����
	*/
	public static boolean compare(int a,int b)
	{
		if(a == b)
			return true;
		else
			return false;
		//return (a == b) ? true : false;
		//return a == b;
	}
	
	/*
	��ϰ2����ӡ�˷���
		1.û�н��coid
		2.û�в���
	*/
	public static void printmult()
	{
		for(int x = 1;x <= 9;x++)
		{
			for(int y = 1;y <= x;y++)
			{
				System.out.print(y + "*" + x + "=" + y*x + "\t");
			}
			System.out.println();
		}
	}
	
	/*
	��ϰ3����ӡ�������ַ�����Ϣ
	*/
	public static void printString(String str)
	{
		System.out.println(str);
	}
	
	/*
	��ϰ4�����幦�ܻ�ȡ���������нϴ������
	*/
	public static int max(int a, int b)
	{
		if (a>b)
			return a;
		else
			return b;

		//retun (a > b)? a :b ;
	}
	
	public static void main(String[] args)
	{
		boolean c = compare(1, 2);
		printString("c=" +  c);
		printString("-------------");
		printmult();
		printString("-------------");
		int max = max(4,8);
		printString("max=" + max);
	}
}