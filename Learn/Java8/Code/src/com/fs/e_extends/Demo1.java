package com.fs.e_extends;

class Father{
	// public修饰的公开成员变量
	public String name;
	
	// private修饰的私有化成员变量salary
	private double salary;
	
	public Father() {
		System.out.println("Father类构造方法");
	}

	public Father() {}

	public Father(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	/*
	 * public 修饰的公开方法
	 */
	public void game() {
		System.out.println("黄金矿工");
	}
	
	private void testPrivate() {
		System.out.println("父类私有化方法");
	}
	
}

/*
 * Son类是Father类的一个子类
 * Father类是一个Son类的唯一父类
 */
class Son extends Father {
	int age;
	
	public Son() {
		System.out.println("Son类构造方法");
	}
	
	public void work() {
		System.out.println("我是程序员");
	}
}

public class Demo1 {
	public static void main(String[] args) {

		
		Son son = new Son();
		
		// 可以使用自定义的成员方法
		son.age = 16;
		son.work();
		
		// 通过继承后，可以获取到父类中的非私有化成员变量和成员方法
		son.name = "iPhone";
		son.game();
	}
}
