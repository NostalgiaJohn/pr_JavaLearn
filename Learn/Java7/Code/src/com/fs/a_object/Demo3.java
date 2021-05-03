package com.fs.a_object;

class Cat{
	// 成员变量
	String name;
	int age;
	int height;
	char gender;
	
	// 自定义构造方法
	/*
	 * 无参数构造方法
	 */
	public Cat() {
		System.out.println("自定义无参数构造方法");
	}
	
	/**
	 * 使用一个String类型的参数用于初始化类对象中name属性
	 * 
	 * @param n String类型参数
	 */
	public Cat(String n) {
		// 在类内的方法可以直接使用类内的成员变量【80%正确】
		name = n;
		System.out.println("带有String类型的构造方法");
	}
	
	/**
	 * 使用String类型参数和int类型参数初始化类对象成员变量数据
	 * 
	 * @param name String类型数据 用于初始化name属性
	 * @param age int类型数据 用于初始化age属性
	 */
	public Cat(String name, int age) {
		/*
		 * 使用this关键字明确告知编译器这里使用的是一个成员变量，
		 * 而不是局部变量
		 * 解决就近原则问题
		 */
		this.name = name;
		this.age = age;
		System.out.println("带有两个参数的构造方法");
	}
	
	/**
	 * 带有三个参数的构造方法
	 * 
	 * @param n String类型，初始化name属性
	 * @param a int类型。初始化age属性
	 * @param g char类型， 初始化gender属性
	 */
	public Cat(String n, int a, char g) {
		name = n;
		age = a;
		gender = g;
		System.out.println("带有三个参数的构造方法");
	}
}

public class Demo3 {
	public static void main(String[] args) {
		Cat cat = new Cat();
		Cat cat2 = new Cat("Tom");
		Cat cat3 = new Cat("加菲猫", 5);
		Cat cat4 = new Cat("蛋卷", 9, '雌');

		System.out.println(cat2.name);
		System.out.println("----------------");
		System.out.println(cat3.name);
		System.out.println(cat3.age);
		System.out.println("----------------");
		System.out.println(cat4.name);
		System.out.println(cat4.age);
		System.out.println(cat4.gender);
	}
}










