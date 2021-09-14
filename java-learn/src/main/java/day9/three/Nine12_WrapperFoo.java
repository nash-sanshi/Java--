package src.main.java.day9.three;

public class Nine12_WrapperFoo<T> {
	Nine12_GenericFoo3<T> foo;

	public Nine12_GenericFoo3<T> getFoo() {
		return foo;
	}

	public void setFoo(Nine12_GenericFoo3<T> foo) {
		this.foo = foo;
	}

	public static void main(String[] args) {
		Nine12_GenericFoo3<Integer> foo = new Nine12_GenericFoo3<>();
		foo.setFoo(10);
		Nine12_WrapperFoo<Integer> wrapper = new Nine12_WrapperFoo<>();
		wrapper.setFoo(foo);
		//泛型里面嵌泛型
		Nine12_GenericFoo3<Integer> g = wrapper.getFoo();
		System.out.println(g.getFoo());
	}
}
