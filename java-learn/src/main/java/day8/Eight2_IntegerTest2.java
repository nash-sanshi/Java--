package src.main.java.day8;

public class Eight2_IntegerTest2
{
	public static void main(String[] args)
	{
		/**
		从1.5以后，基本数据类型对象包装类有了一个新特性
		自动装箱拆箱
		*/		
		Integer j = new Integer(10);	//-->Integer i = Integer.valueOf(10);
		//简化
		Integer i = 10;	//Integer i = null;
		i = i + 2;	//i+2 ,i先转成一个整数，i.intValue()自动拆箱
		//i = Integer.valueOf(i.intValue()+2);
		show(5);
	}
	public static void show(Object num)
	{
		System.out.println("num=" + num);
	}

}
