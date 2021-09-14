package src.main.java.day9.three;

//����һ���򵥵ļ���
public class Nine8_SimpleCollection<T> {
	private final T[] objArr;
	private int index = 0;

	public Nine8_SimpleCollection()
	{
		objArr = (T[])new Object[10];
	}
//������ӵ�Ԫ�ظ���������10������ôArrayList�ײ��������һ�����飬���ȱ�ԭ����ĳ���
//Ȼ��ԭ��������ݸ�ֵ�������鵱�У����Һ������ӵ����ݶ���ŵ������鵱��
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
