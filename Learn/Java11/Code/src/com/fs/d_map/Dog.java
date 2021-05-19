package com.fs.d_map;

// public class Dog implements Comparable<Dog> 不使用Comparable,转而使用Comparator匿名内部类
public class Dog {
	private String name;
	private int age;
	
	public Dog() {}
	
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}

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

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}
	
	/*
	@Override
	public int compareTo(Dog o) {
		return this.age - o.age;
	}
	*/	
}
