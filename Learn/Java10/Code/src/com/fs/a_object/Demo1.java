package com.fs.a_object;

public class Demo1 {
	public static void main(String[] args) {
		Student student1= new Student(1, "张三", 16, '男');
		Student student2= new Student(1, "张三", 16, '男');
		
		System.out.println(student1);
		System.out.println(student1.hashCode());
		System.out.println(student2);
		System.out.println(student2.hashCode());
		boolean ret = student1.equals(student2);
		System.out.println(ret);
	}
}
