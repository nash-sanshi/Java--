package src.main.java.day9.three;

public class Nine5_Generic<T1,T2> {
	private T1 foo1;
	private T2 foo2;
	
	public T1 getFoo1() {
		return foo1;
	}
	public void setFoo1(T1 foo1) {
		this.foo1 = foo1;
	}
	public T2 getFoo2() {
		return foo2;
	}
	public void setFoo2(T2 foo2) {
		this.foo2 = foo2;
	}

	public static void main(String[] args) {
		Nine5_Generic<Integer,Boolean> foo = new Nine5_Generic<>();
		foo.setFoo1(23);
		foo.setFoo2(false);
		System.out.println(foo.getFoo1());
		System.out.println(foo.getFoo2());
	}
}
