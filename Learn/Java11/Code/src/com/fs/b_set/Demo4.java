package com.fs.b_set;

import java.util.TreeSet;

public class Demo4 {
	public static void main(String[] args) {
		// 存储自定义数据类型
		/*
		 * Exception in thread "main" java.lang.ClassCastException: 
		 * 	com.fs.b_set.Person cannot be cast to java.lang.Comparable
		 * 提示当前Person类不能强转成Comparable类型，也就是说当前Person类没有
		 * 比较方式
		 * 
		 * 有两种方式可以提供比较方式:
		 * 		1. Comparable<T>接口
		 * 		2. Comparator<T>接口 --权重更高
		 */
		TreeSet<Person> set = new TreeSet<Person>(new PersonComparator());
		
		Person p1 = new Person(1, "foo", 10);
		Person p2 = new Person(2, "faa", 5);
		Person p3 = new Person(3, "fbb", 30);
		Person p4 = new Person(4, "fcc", 30);
		
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);
	
		System.out.println(set);
	}
}
