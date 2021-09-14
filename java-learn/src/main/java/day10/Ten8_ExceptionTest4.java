package src.main.java.day10;

public class Ten8_ExceptionTest4 {

	public void method(String str) throws Ten6_MyException, Ten7_MyException2 {
		if(str == null)
		{
			throw new Ten6_MyException("传入的字符串参数不能为null");
		}else if ("hello".equals(str))
		{
			throw new Ten7_MyException2("传入的字符串不能为hello");
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
			System.out.println("异常处理完毕");
		}
		System.out.println("程序执行完毕");
	}
}
