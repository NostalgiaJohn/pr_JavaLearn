package com.fs.a_private;

/*
 * Private 关键字使用
 */
class Dog {
	private String name;
	int age;
	char gender;
	
	public void testField() {
		// 类内可以直接使用没有操作权限
		name = "Bobo";
		test();
	}
	
	private void test() {
		System.out.println("测试方法");
	}
}
public class Demo1 {
	public static void main(String[] args) {
		Dog dog = new Dog();
		
		// 当成员变量使用private修饰之后，当前成员变量类外没有操作权限
		// The field Dog.name is not visible
		// dog.name = "小七";
		// 没有使用private约束的情况下，类外可以使用 
		dog.age = 5;
		dog.gender = '雌';
		
		// 使用private修饰的方法类外不能使用
		// The method test() from the type Dog is not visible
		// dog.test();
	}
}
