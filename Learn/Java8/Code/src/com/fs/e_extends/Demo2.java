package com.fs.e_extends;

class Animal {
	// public���γ�Ա������������Ĭ��ֵ
	public String name = "����";
	
	public void eat() {
		System.out.println("����eat����");
	}
}

class Dog extends Animal {
	public String name = "����";
	
	public void eat() {
		System.out.println("����eat����");
	}
	
	public void test() {
		// �ͽ�ԭ��name��Ӧ����Dog���ڵĳ�Ա����
		System.out.println(name);
		// ��Ҫʹ�ø����name����
		System.out.println(super.name);
		
		// �ͽ�ԭ������eat����
		eat();
		// ʹ��super��ȷ��֪����ʹ�õ��Ǹ����Ա����
		super.eat();
	}
}

public class Demo2 {
	public static void main(String[] args) {
		new Dog().test();
	}
}
