package src.main.java.day2;

public class Hanshu
{
	/*
	����ֵ����abc���������� ��ʽ����1���������� ��ʽ����2��......��
	{
	//ִ�����
	return ����ֵ
	}

	���󣺶���һ���ӷ�����Ĺ���
	˼·��
		������java�е����־���һ������
		1.����ֵ���������������ĺͣ�int����
		2.�в����������㣬������ʹ�øù��ܵ�ʱ�������ȷ�м���������int����
		
	�����ĺô���
		1.��ϸ�ڽ��з�װ
		2.����˴���ĸ�����
	*/
	

	/*
	���������������
	��һ������û�о���������ʱ���ùؼ���void����ʾ����ֵ����
	void������û�о��巵��ֵ�����
	��void���͵ĺ�������ʱ�������е�return����ֱ�ӷֺŽ���
	ͬʱ����return������ʡ�Բ�д�����Ǳ�������������
	����
		��2�������ĺͣ���ӡ������̨
	˼·��
		1.û�з���ֵ��ֻ����void��ʾ����ֵ����
		2.��2������
		
	Return�����ã�
		1.������Ĺ��ܽ�����ظ�������
		2.��������������һ���������
	*/
	public static int add (int x, int y)
	{
		return x + y;
	}
	
	public static void printsum(int a,int b)
	{
		System.out.println(a + b);
	}
	
	public static void main(String[] args)
	{
		//���ú���.1,2��Ϊ�鼮����
		int sum = add(1,2);
		int sum2 = add(2,3);
		System.out.println("sum=" + sum);
		System.out.println("sum2=" + sum2);
		printsum(1,2);
	}
}