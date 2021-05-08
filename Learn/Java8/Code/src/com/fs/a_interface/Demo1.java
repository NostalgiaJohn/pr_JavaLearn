package com.fs.a_interface;
/**
 * 接口A
 * 接口演示
 * 
 * @author fStardust
 *
 */
interface A {
	// 【缺省属性】 public static final
	int num = 10;
	
	// 【缺省属性】public abstract
	void test();
}

interface B {
	void testB();
	
}
/**
 * TypeA类遵从接口A
 * @author fStardust
 *
 */
class TypeA implements A, B {

	@Override
	public void test() {
		System.out.println(num);
		System.out.println("TypeA遵从接口A，实现接口A中缺省属性为abstract的成员方法");	
	}

	@Override
	public void testB() {
		System.out.println("TypeA同时遵从接口B，实现接口B中缺省属性为abstract的成员方法");
		
	}
	
}

public class Demo1 {
	public static void main(String[] args) {
		TypeA typeA = new TypeA();
		typeA.test();
		
	}
}
