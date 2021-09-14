package src.main.java.day10;

public class Ten8_ExceptionTest4 {

	public void method(String str) throws Ten6_MyException, Ten7_MyException2 {
		if(str == null)
		{
			throw new Ten6_MyException("������ַ�����������Ϊnull");
		}else if ("hello".equals(str))
		{
			throw new Ten7_MyException2("������ַ�������Ϊhello");
		}else
		{
			System.out.println(str);
		}
	}
	public static void main(String[] args) {
		Ten8_ExceptionTest4 test = new Ten8_ExceptionTest4();
		try {
			test.method("null");
		} catch (Ten6_MyException|Ten7_MyException2 e) {
			System.out.println("MyException");
			e.printStackTrace();
		} /*catch (Exception e) {
			System.out.println("MyException");
			e.printStackTrace();
		}*/ finally
		{
			System.out.println("�쳣�������");
		}
		System.out.println("����ִ�����");
	}
}
