package com.fs.a_private;

/*
 * Private �ؼ���ʹ��
 */
class Dog {
	private String name;
	int age;
	char gender;
	
	public void testField() {
		// ���ڿ���ֱ��ʹ��û�в���Ȩ��
		name = "Bobo";
		test();
	}
	
	private void test() {
		System.out.println("���Է���");
	}
}
public class Demo1 {
	public static void main(String[] args) {
		Dog dog = new Dog();
		
		// ����Ա����ʹ��private����֮�󣬵�ǰ��Ա��������û�в���Ȩ��
		// The field Dog.name is not visible
		// dog.name = "С��";
		// û��ʹ��privateԼ��������£��������ʹ�� 
		dog.age = 5;
		dog.gender = '��';
		
		// ʹ��private���εķ������ⲻ��ʹ��
		// The method test() from the type Dog is not visible
		// dog.test();
	}
}
