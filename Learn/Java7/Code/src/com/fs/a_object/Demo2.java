package com.fs.a_object;

class Dog{
	// 成员变量。描述属性
	String name;
	int age;
	char gender;
}

public class Demo2 {
	public static void main(String[] args) {
		Dog dog1 = new Dog();
		Dog dog2 = new Dog();
		
		dog1.name = "八公";
		dog1.age = 5;
		dog1.gender = '雄';
		
		System.out.println("Name:" + dog1.name);
		System.out.println("Age:" + dog1.age);
		System.out.println("Gander:" + dog1.gender);
		
		dog2.name = "小七";
		dog2.age = 2;
		dog2.gender = '雌';
		
		System.out.println("Name:" + dog2.name);
		System.out.println("Age:" + dog2.age);
		System.out.println("Gander:" + dog2.gender);
		
		System.out.println("---------------------");
		// 重点 
		dog1 = dog2;
		
		dog1.name = "大壮";
		System.out.println("Name:" + dog1.name);
		System.out.println("Age:" + dog1.age);
		System.out.println("Gander:" + dog1.gender);
		System.out.println("Name:" + dog2.name);
		System.out.println("Age:" + dog2.age);
		System.out.println("Gander:" + dog2.gender);
		
				
	}
}












