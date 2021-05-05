package com.fs.f_extends;

 /*
 * abstract使用
 * 
 * 第一个错误
 * 	Abstract methods do not specify a body
 * 	abstract不能修饰一个方法体
 * 快速修复提示：快捷键ctrl+1
 * 	Remove method body
 * 
 * 第二个错误：
 * 	The abstract method Q in type LOLHero can only be defined by an abstract class
 * 	在LOLHero中使用abstract修饰的方法Q，只能定义在abstract修饰的类内
 * 快速修复提示：
 * 	Make Type 'LOLHero' abstract
 * 
 * 第三个错误：
 * 	The type Yasuo must implement the inherited abstract method LOLHero.Q()
 * 	子类（亚索类）必须实现继承而来的abstract LOLHero.Q()方法
 * 快速修复提示：
 * 	Add unimplemented method
 * 	添加没有实现的父类中abstract方法
 */
abstract class LOLHero {
	abstract public void Q();
	
	abstract public void W();
	
	abstract public void E();
	
	abstract public void R();
}

/*
 * 子类继承父类可以直接使用父类的方法，
 * 但是在实际情况中
 * 	(例如LOL中英雄父类--跟具体英雄子类的情况下)：
 * 		我们可以发现父类的方法是一定不能在子类中使用的
 * 		但是又没有一个强制要求(交流沟通不便)
 * 
 * 需求;
 * 	从语法约束，强制要求子类重写父类的方法
 */
class Yasuo extends LOLHero {

	@Override
	public void Q() {
		System.out.println("斩钢闪");
	}

	@Override
	public void W() {
		System.out.println("风之障壁");
	}

	@Override
	public void E() {
		System.out.println("踏前斩");
	}

	@Override
	public void R() {
		System.out.println("狂风绝息斩");
	}
	
}

class Garen extends LOLHero {

	@Override
	public void Q() {
		System.out.println("致命打击");
	}

	@Override
	public void W() {
		System.out.println("勇气");
	}

	@Override
	public void E() {
		System.out.println("审判");
	}

	@Override
	public void R() {
		System.out.println("德玛西亚正义");
	}
	
}

public class Demo2 {
	public static void main(String[] args) {
		Yasuo yasuo = new Yasuo();
		
		yasuo.Q();
		yasuo.W();
		yasuo.E();
		yasuo.R();
		
		Garen garen = new Garen();
		
		garen.Q();
		garen.W();
		garen.E();
		garen.R();
	}
}
