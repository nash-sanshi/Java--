package src.main.java.day10;

public class Ten4_ExceptionTest2 {

	public void method() throws Exception {
		System.out.println("hello world");
		throw new Exception();
	}

	public static void main(String[] args) {
		Ten4_ExceptionTest2 test = new Ten4_ExceptionTest2();
		try {
			test.method();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("ok");
		}
	}
}
