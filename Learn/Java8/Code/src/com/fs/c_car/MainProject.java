package com.fs.c_car;

/**
 * ���main����
 * @author fStardust
 */
public class MainProject {
	public static void main(String[] args) {
		/*
		 * ��Ҫ��װ������������������������̥�����
		 */
		Engine engine = new Engine("EA888", 2.0F);
		Tyre tyre = new Tyre("������", 19);
		
		/*
		 * ����Car�����
		 */
		Car car = new Car(engine, tyre);
		
		car.show();
		
		System.out.println("---------------");
		
		Engine engine2 = new Engine("EA113", 1.6F);
		// ��������������
		car.setEngine(engine2);
		
		car.show();
		
		System.out.println("---------------");
		
		Tyre tyre2 = new Tyre("����", 18);
		// ������̥����
		car.setTyre(tyre2);
		
		car.show();
	}
}
