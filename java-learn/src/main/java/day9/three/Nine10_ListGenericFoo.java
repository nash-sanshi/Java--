package src.main.java.day9.three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Nine10_ListGenericFoo<T extends List> {

	private T[] fooArray;
	
	public T[] getFooArray() {
		return fooArray;
	}

	public void setFooArray(T[] fooArray) {
		this.fooArray = fooArray;
	}

	public static void main(String[] args) {
		Nine10_ListGenericFoo<LinkedList> foo1 = new Nine10_ListGenericFoo<>();
		Nine10_ListGenericFoo<ArrayList> foo2 = new Nine10_ListGenericFoo<>();
		LinkedList[] ll = new LinkedList[10];
		foo1.setFooArray(ll);
		ArrayList[] al = new ArrayList[10];
		foo2.setFooArray(al);
		//List接口不能使用hashmap，hashmap是数组，不是链表
		//ListGeneraicFoo<HashMap> foo3 = new ListGenericFoo<>();
	}
}
