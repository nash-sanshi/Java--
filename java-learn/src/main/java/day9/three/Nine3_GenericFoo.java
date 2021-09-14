package src.main.java.day9.three;

public class Nine3_GenericFoo<T> {

	//T代表一种类型的信息，泛型，不具体
	private T foo;

	public T getFoo() {
		return foo;
	}

	public void setFoo(T foo) {
		this.foo = foo;
	}
	
	public static void main(String[] args) {
		Nine3_GenericFoo<Boolean> foo1 = new Nine3_GenericFoo<>();
		Nine3_GenericFoo<Integer> foo2 = new Nine3_GenericFoo<>();
		foo1.setFoo(false);
		foo2.setFoo(2);
		System.out.println(foo1.getFoo());
		System.out.println(foo2.getFoo());
	}
}
