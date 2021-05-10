package com.fs.a_genericity;

interface A<T> {
	void test(T t);
}

/*
 * 接口带有泛型，遵从接口的实现类有两种方案可以implements当前接口
 * 		1. 自由
 * 		2. 规矩
 */

/**
 * 自由方式，类名之后和接口同名自定义泛型，
 * 泛型对应的具体数据类型是需要在创建当前类对象时进行约束使用的
 * 
 * @author fStardust
 *
 * @param <T> 遵从接口和接口一致的泛型
 */
class TypeB<T> implements A<T> {
	@Override
	public void test(T t) {
		System.out.println("自由模式");
		
	}
}

/**
 * 规矩模式，遵从接口时，接口使用泛型对应的具体数据类型已经明确
 * 在类内使用接口中缺省属性为public abstract方法时，泛型已确认
 * 
 * @author Anonymous
 */
class TypeC<T> implements A<String> {
	@Override
	public void test(String t) {
		System.out.println("规矩模式");
	}
}

public class Demo3 {
	public static void main(String[] args) {
		/*
		 * 自由模式
		 */
		TypeB<Integer> typeB = new TypeB<Integer>();
		typeB.test(10);
		
		TypeB<Character> typeC = new TypeB<Character>();
		typeC.test('A');
		
		/*
		 * 规矩模式
		 */
		TypeC type1 = new TypeC();
		
		type1.test("规矩");

	}
}