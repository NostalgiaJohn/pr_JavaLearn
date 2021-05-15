package com.fs.b_set;

import java.util.HashSet;

public class Demo2 {
	public static void main(String[] args) {
		HashSet<Person> hashSet = new HashSet<Person>();
		
		Person P1 = new Person(1, "foo", 10);
		Person P2 = new Person(2, "faa", 20);
		Person P3 = new Person(3, "fbb", 30);
		Person P4 = new Person(4, "fcc", 40);
		/*
		 * 当前这里两个元素，ID一样==> hashCode值是一致的，会通过底层哈希表运算保存在同一个单元格位置
		 * 这里会通过equals方法，比较两个对象是否一致，来决定是否能够保存
		 * 如果两个对象一致，则无法保存
		 * 
		 * 期望每一个哈希表单元格内保存的数据是唯一的
		 */
		Person P5 = new Person(5, "fdd", 40);
		Person P6 = new Person(5, "fee", 44);
		
		
		hashSet.add(P4);
		hashSet.add(P1);
		hashSet.add(P2);
		hashSet.add(P3);
		hashSet.add(P5);
		hashSet.add(P6);
		
		System.out.println(hashSet);
	}
}
