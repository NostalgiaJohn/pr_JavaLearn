package com.fs.c_car;

/**
 * 存放main方法
 * @author fStardust
 */
public class MainProject {
	public static void main(String[] args) {
		/*
		 * 需要组装汽车，这里有引擎类对象和轮胎类对象
		 */
		Engine engine = new Engine("EA888", 2.0F);
		Tyre tyre = new Tyre("米其林", 19);
		
		/*
		 * 创建Car类对象
		 */
		Car car = new Car(engine, tyre);
		
		car.show();
		
		System.out.println("---------------");
		
		Engine engine2 = new Engine("EA113", 1.6F);
		// 更换发动机过程
		car.setEngine(engine2);
		
		car.show();
		
		System.out.println("---------------");
		
		Tyre tyre2 = new Tyre("马牌", 18);
		// 更换轮胎过程
		car.setTyre(tyre2);
		
		car.show();
	}
}
