package com.fs.b_polym;

/*
所有的动物都可以看做是一个Animal类

熊猫类
	Panda
老虎类
	Tiger

方法:
	喂食动物的方法
	获取动物的方法
 */
/**
 * 动物类
 */
class Animal {
	
}

/**
 * 熊猫类，为Animal动物的子类
 * @author Anonymous
 *
 */
class Panda extends Animal {
	
}

/**
 * 老虎类，为Animal动物的子类
 */
class Tiger extends Animal {
	
}

public class Demo1 {
	public static void main(String[] args) {
		Animal animal = new Animal();
		Tiger tiger = new Tiger();
		Panda panda = new Panda();
		
		// 这里传入一个Animal类对象
		feed(animal);
		
		// 这里传入的对象是Tiger类对象，Tiger类是Animal的子类对象
		feed(tiger);
		// 同上
		feed(panda);
		
		// 数据类型强转，
		Tiger tiger2 = (Tiger) getAnimal();
		System.out.println(tiger2.getClass());
	}
	
	/**
	 * 该方法的是喂食【动物】的方法
	 * 
	 * @param animal 需要的参数是Animal类对象
	 */
	public static void feed(Animal animal) {
		// 获取当前对象的完整包名.类名
		System.out.println(animal.getClass() + "来吃饭了！！！");
	}
	
	/**
	 * 返回【动物】类对象的方法
	 * 
	 * @return Animal类对象
	 */
	public static Animal getAnimal() {
		// return new Animal();
		return new Tiger();
		// return new Panda();
	}
}