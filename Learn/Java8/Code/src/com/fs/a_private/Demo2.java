package com.fs.a_private;


class Cat {
	// 所有的成员变量全部私有化
	private String name;
	private int age;
	private char gender;
	private boolean married;

	
	// 根据实际需要完成对应Constructor， Setter， Getter
	// 快捷键 shift + alt +s
	
	// 对应的构造方法
	public Cat() {
		super();
	}

	public Cat(String name, int age, char gender, boolean married) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.married = married;
	}


	// Setter和Getter方法
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


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public boolean isMarried() {
		return married;
	}


	public void setMarried(boolean married) {
		this.married = married;
	}
}

public class Demo2 {
	public static void main(String[] args) {
		Cat cat = new Cat();
		
		cat.setName("蛋卷");
		cat.setAge(1);
		cat.setGender('雌');
		cat.setMarried(false);
		
		System.out.println("Name:" + cat.getName());
		System.out.println("Age:" + cat.getAge());
		System.out.println("Gender:" + cat.getGender());
		System.out.println("Married:" + cat.isMarried());
		
	}
}
