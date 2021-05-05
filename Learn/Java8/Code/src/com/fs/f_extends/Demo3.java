package com.fs.f_extends;

final class A {
	
	// The blank final field name may not have been initialized
	// 当前的final修饰的成员变量name没有被初始化。
	// -->final修饰的成员变量在定义时必须初始化
	public final String name = "张三";
	
	// final修饰的方法不能被子类重写，为最终模式
	public final void testA() {
		System.out.println("A类的成员方法");
	}
}

// The type B cannot subclass the final class A
// B类不能继承final修饰的A类
//class B extends A {
	// 重写A类中的testA方法
	// The method testA() of type B must override or implement a supertype method
	// 不能重写A类中的方法
//	@Override
//	private void testA() {
//		System.out.println("B类重写A方法");
//	}
//}

public class Demo3 {
	public static void main(String[] args) {
		final int num = 10;
		/*
		 * The final local variable num cannot be assigned. It must be blank and not using a compound assignment
		 * final修饰的局部变量一旦被赋值，之后无法更改
		 */
//		num = 20;
	}
}
