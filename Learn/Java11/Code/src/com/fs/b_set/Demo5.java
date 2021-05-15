package com.fs.b_set;

import java.util.Comparator;
import java.util.TreeSet;

public class Demo5 {
	public static void main(String[] args) {
		/*
		 * 匿名内部类的匿名对象作为方法参数
		 */
		TreeSet<Person> set = new TreeSet<Person>(new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				System.out.println("匿名内部类");
				int ret = (int) ((o1.getSalary() - o2.getSalary()) * 100);
				
				return ret;
			}
		});
		
		Person p1 = new Person(1, "foo", 10.01);
		Person p2 = new Person(2, "faa", 10.03);
		Person p3 = new Person(3, "fbb", 10.05);
		Person p4 = new Person(4, "fcc", 10.07);
		// p5不被输出，Debug发现：(p5-p4)*100=-2 这是精度问题 
		// 使用BigDecimal解解决浮点数精度问题
		Person p5 = new Person(5, "fdd", 10.00);
		Person p6 = new Person(6, "fee", 11.00);
		
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);
		set.add(p5);
		set.add(p6);
		
		System.out.println(set);
	}
}
