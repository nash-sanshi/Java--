package src.main.java.day7;

public class EqualsTest
{
	public static void main(String[] args) {
		Student2 s1 = new Student2("zhangsan");
		Student2 s2 = new Student2("zhangsan");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
	}
}

class Student2
{
	String name;
	public Student2 (String name)
	{
		this.name = name;
	}

    //public Student2() { }

    //重写object类的equals方法
    public boolean equals(Object obj)
	{
        if (this == obj) 
		{
            return true;
		}
		if (obj instanceof Student2)
		{
            Student2 student = (Student2) obj;
            if (student.name.equals(this.name)) 
			{
                return true;
            }
        }
        return false;
	}
}