package com.fs.a_object;

class Cat{
	// ��Ա����
	String name;
	int age;
	int height;
	char gender;
	
	// �Զ��幹�췽��
	/*
	 * �޲������췽��
	 */
	public Cat() {
		System.out.println("�Զ����޲������췽��");
	}
	
	/**
	 * ʹ��һ��String���͵Ĳ������ڳ�ʼ���������name����
	 * 
	 * @param n String���Ͳ���
	 */
	public Cat(String n) {
		// �����ڵķ�������ֱ��ʹ�����ڵĳ�Ա������80%��ȷ��
		name = n;
		System.out.println("����String���͵Ĺ��췽��");
	}
	
	/**
	 * ʹ��String���Ͳ�����int���Ͳ�����ʼ��������Ա��������
	 * 
	 * @param name String�������� ���ڳ�ʼ��name����
	 * @param age int�������� ���ڳ�ʼ��age����
	 */
	public Cat(String name, int age) {
		/*
		 * ʹ��this�ؼ�����ȷ��֪����������ʹ�õ���һ����Ա������
		 * �����Ǿֲ�����
		 * ����ͽ�ԭ������
		 */
		this.name = name;
		this.age = age;
		System.out.println("�������������Ĺ��췽��");
	}
	
	/**
	 * �������������Ĺ��췽��
	 * 
	 * @param n String���ͣ���ʼ��name����
	 * @param a int���͡���ʼ��age����
	 * @param g char���ͣ� ��ʼ��gender����
	 */
	public Cat(String n, int a, char g) {
		name = n;
		age = a;
		gender = g;
		System.out.println("�������������Ĺ��췽��");
	}
}

public class Demo3 {
	public static void main(String[] args) {
		Cat cat = new Cat();
		Cat cat2 = new Cat("Tom");
		Cat cat3 = new Cat("�ӷ�è", 5);
		Cat cat4 = new Cat("����", 9, '��');

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










