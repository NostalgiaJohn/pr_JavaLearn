package com.fs.e_lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Demo2 {
	public static void main(String[] args) {
		Person[] persons = {
				new Person("faa",16),	
				new Person("fbb",43),	
				new Person("fcc",45),	
				new Person("fdd",13),	
				new Person("fee",34),	
		};
		
		// public static <T> void sort(T[] a, Comparator<? super T> c)
		Arrays.sort(persons, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAge() - o2.getAge();
			}
		});
		
		/*
		 * Lambda表达
		 * 1. 有参数
		 * 2. 有返回值
		 * 
		 * 标准的Lambda
		 */
		Arrays.sort(persons, (Person o1, Person o2) -> {
			return o2.getAge() - o1.getAge();
		});
		
		/*
		 * 省略写法：
		 * 	1. 可以省略数据类型
		 * 	2. 可以直接利用返回值，省略{}和return
		 */
		Arrays.sort(persons, (o1, o2) -> o2.getAge() - o1.getAge());
		
		/*
		 * 如果是递增排序，还能进一步省略如下
		 */
		Arrays.sort(persons, Comparator.comparingInt(Person::getAge));
		
		for (Person person : persons) {
			System.out.println(person);
		}
	}
}
