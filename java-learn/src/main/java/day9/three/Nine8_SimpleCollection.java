package src.main.java.day9.three;

//创建一个简单的集合
public class Nine8_SimpleCollection<T> {
	private final T[] objArr;
	private int index = 0;

	public Nine8_SimpleCollection()
	{
		objArr = (T[])new Object[10];
	}
//如果增加的元素个数超过了10个，那么ArrayList底层会新生成一个数组，长度比原数组的长，
//然后将原数组的内容赋值到新数组当中，并且后续增加的内容都会放到新数组当中
	public Nine8_SimpleCollection(int capacity) {
		objArr = (T[])new Object[capacity];	
	}
	
	public void add(T t)
	{
		objArr[index++] = t;
	}

	public int getLength()
	{
		return this.index;
	}

	public T get(int i)
	{
		return objArr[i];
	}

	public static void main(String[] args) {
		Nine8_SimpleCollection<Integer> c = new Nine8_SimpleCollection<>();
		for (int i = 0; i < 10; i++) {
			c.add(i);
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(c.get(i));
		}
	}
}
