package com.fs.e_extends;

class Father{
	// public���εĹ�����Ա����
	public String name;
	
	// private���ε�˽�л���Ա����salary
	private double salary;
	
	public Father() {
		System.out.println("Father�๹�췽��");
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
	 * public ���εĹ�������
	 */
	public void game() {
		System.out.println("�ƽ��");
	}
	
	private void testPrivate() {
		System.out.println("����˽�л�����");
	}
	
}

/*
 * Son����Father���һ������
 * Father����һ��Son���Ψһ����
 */
class Son extends Father {
	int age;
	
	public Son() {
		System.out.println("Son�๹�췽��");
	}
	
	public void work() {
		System.out.println("���ǳ���Ա");
	}
}

public class Demo1 {
	public static void main(String[] args) {

		
		Son son = new Son();
		
		// ����ʹ���Զ���ĳ�Ա����
		son.age = 16;
		son.work();
		
		// ͨ���̳к󣬿��Ի�ȡ�������еķ�˽�л���Ա�����ͳ�Ա����
		son.name = "iPhone";
		son.game();
	}
}
