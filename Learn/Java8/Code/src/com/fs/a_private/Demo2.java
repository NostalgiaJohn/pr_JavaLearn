package com.fs.a_private;


class Cat {
	// ���еĳ�Ա����ȫ��˽�л�
	private String name;
	private int age;
	private char gender;
	private boolean married;

	
	// ����ʵ����Ҫ��ɶ�ӦConstructor�� Setter�� Getter
	// ��ݼ� shift + alt +s
	
	// ��Ӧ�Ĺ��췽��
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


	// Setter��Getter����
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
		
		cat.setName("����");
		cat.setAge(1);
		cat.setGender('��');
		cat.setMarried(false);
		
		System.out.println("Name:" + cat.getName());
		System.out.println("Age:" + cat.getAge());
		System.out.println("Gender:" + cat.getGender());
		System.out.println("Married:" + cat.isMarried());
		
	}
}
