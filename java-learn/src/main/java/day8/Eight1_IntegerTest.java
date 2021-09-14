package src.main.java.day8;

public class Eight1_IntegerTest
{
	public static void main(String[] args)
	{
		int a = 10;
		Integer i = new Integer(a);
		System.out.println(i.intValue());

		byte b = 20;
		Byte j = new Byte(b);
		System.out.println(j.byteValue());

		long c = 30;
		Long k = new Long(c);
		System.out.println(k.longValue());

		short d = 40;
		Short l = new Short(d);
		System.out.println(l.shortValue());

		float e = 1.5f;
		Float m = new Float(e);
		System.out.println(m.floatValue());

		double f = 1.1;
		Double n = new Double(f);
		System.out.println(n.doubleValue());

		char g = 'a';
		Character o = new Character(g);
		System.out.println(o.charValue());

		boolean h = true;
		Boolean p = new Boolean(h);
		System.out.println(p.booleanValue());
	}
}
