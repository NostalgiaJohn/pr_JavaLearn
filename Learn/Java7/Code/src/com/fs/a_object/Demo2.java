package com.fs.a_object;

class Dog{
	// ��Ա��������������
	String name;
	int age;
	char gender;
}

public class Demo2 {
	public static void main(String[] args) {
		Dog dog1 = new Dog();
		Dog dog2 = new Dog();
		
		dog1.name = "�˹�";
		dog1.age = 5;
		dog1.gender = '��';
		
		System.out.println("Name:" + dog1.name);
		System.out.println("Age:" + dog1.age);
		System.out.println("Gander:" + dog1.gender);
		
		dog2.name = "С��";
		dog2.age = 2;
		dog2.gender = '��';
		
		System.out.println("Name:" + dog2.name);
		System.out.println("Age:" + dog2.age);
		System.out.println("Gander:" + dog2.gender);
		
		System.out.println("---------------------");
		// �ص� 
		dog1 = dog2;
		
		dog1.name = "��׳";
		System.out.println("Name:" + dog1.name);
		System.out.println("Age:" + dog1.age);
		System.out.println("Gander:" + dog1.gender);
		System.out.println("Name:" + dog2.name);
		System.out.println("Age:" + dog2.age);
		System.out.println("Gander:" + dog2.gender);
		
				
	}
}












