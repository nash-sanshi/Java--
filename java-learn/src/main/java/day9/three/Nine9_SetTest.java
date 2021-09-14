package src.main.java.day9.three;

import java.util.HashSet;
import java.util.Set;

public class Nine9_SetTest {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("aa");
		set.add("bb");
		set.add("cc");
		for (String value : set) {
			System.out.println(value);
		}
		
		System.out.println("------------------");

		Set<People> set2 = new HashSet<>();
		set2.add(new People("wangwu",40,"nantong"));
		for (People p : set2) {
			String name = p.getName();
			int age = p.getAge();
			String address = p.getAddress();
			System.out.println("Ãû×Ö=" + name + ",ÄêÁä=" + age + ",µØÖ·=" + address);
		}
	}
}

class People
{
	private String name;
	private int age;
	private String address;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public People(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}

/*	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		People other = (People) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}*/
}
