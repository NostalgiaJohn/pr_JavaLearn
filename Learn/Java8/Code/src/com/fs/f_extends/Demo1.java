package com.fs.f_extends;

class Father {
	public void game() {
		System.out.println("黄金矿工");
	}
	
	public void work() {
		System.out.println("机械工程师");
	}
}

class Son extends Father{
	/*
	 * @Override 注解
	 * 	开启重写严格格式检查
	 */
	@Override
	public void game() {
		// 按照当前子类的需求完成代码
		System.out.println("LOL");
	}
	
	@Override
	public void work() {
		System.out.println("设计师");
	}
}

public class Demo1 {
	public static void main(String[] args) {
		Son son = new Son();
		
		son.game();
		son.work();
	}
}
