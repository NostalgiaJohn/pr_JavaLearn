package com.fs.e_extends;

class Animal {
	// public修饰成员变量，并赋予默认值
	public String name = "动物";
	
	public void eat() {
		System.out.println("父类eat方法");
	}
}

class Dog extends Animal {
	public String name = "狗狗";
	
	public void eat() {
		System.out.println("子类eat方法");
	}
	
	public void test() {
		// 就近原则，name对应的是Dog类内的成员变量
		System.out.println(name);
		// 需要使用父类的name属性
		System.out.println(super.name);
		
		// 就近原则，子类eat方法
		eat();
		// 使用super明确告知这里使用的是父类成员方法
		super.eat();
	}
}

public class Demo2 {
	public static void main(String[] args) {
		new Dog().test();
	}
}
