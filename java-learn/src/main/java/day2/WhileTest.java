package src.main.java.day2;

public class WhileTest
{   /**
	��ʾwhlie��䣬��ӡ1-100�ĺ�
	�������Ҫִ�кܶ�ε�ʱ�򣬾�Ҫ�õ�ѭ�����
	*/
	public static void main(String [] args) {
		//ѭ������
		int a = 1;
		//�����Ӻ�Ľ��
		int sum = 0;
		while (a <= 100) {
			sum += a;
			a++;
		}
		System.out.println(sum);
	}
}