package src.main.java.day6;

public class InstanceofTest
{
	public static void main(String[] main)
	{
		People p = new People();
		//instanceof���ж�ĳ�������Ƿ���ĳ�����ʵ��
		//�﷨��ʽ��������instanceof�������ӿ�����������һ��booleanֵ
		System.out.println(p instanceof People);
		System.out.println(p instanceof Man);
	}
}

class People
{
	
}

class Man extends People 
{
	
}