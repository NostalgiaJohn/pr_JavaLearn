package com.fs.a_genericity;

/*
 * 定义一个带有自定义泛型的类
 */
class TypeA<T> {
	/**
	 * 使用和类名一致的自定义泛型，需要通过【类对象】约束
	 * 
	 * @param t 对应泛型具体数据类型的参数
	 * @return 对应泛型具体数据类型的返回值
	 */
	public T test1(T t) {
		return t;
	}
	
	/**
	 * 使用和类名一致的自定义泛型，需要通过【类对象】约束
	 * 
	 * @param t 对应泛型具体数据类型的参数
	 * @return 对应泛型具体数据类型的返回值
	 */
	public void test2(T t1, T t2) {
		System.out.println(t1);
		System.out.println(t2);
	}
	
	/*
	 * public static T staaticMethod(T t) {return t;}
	 * 为什么类名自定义的泛型不能用于当前类内的静态成员方法
	 * 		静态成员方法是在类文件的加载阶段准备完毕，已经可以明确的保证改方法可以执行
	 * 	如果使用类声明的自定义泛型，对应泛型的具体数据类型需要在创建类对象之后才能明确
	 * 	当前静态方法在类文件加载阶段无法明确泛型数据类型，也就无法保证执行
	 * 	【没有对象】
	 * 
	 * 
	 * 如果方法想要使用自定义泛型-->自已定义自己使用
	 * 但要求自定义的泛型占位符和类声明泛型占位符不一致，避免没有必要的歧义，提高阅读性、效率。
	 */
	public static<E> E staaticMethod(E e) {
		return e;
	}
}
public class Demo2 {
	public static void main(String[] args) {
		/*
		 * 创建带有自定义泛型类的对象
		 * Eclipse两种都行
		 * TypeA<String> TypeA = new TypeA<String>(); 
		 * TypeA<String> TypeA = new TypeA<>(); IDEA写法
		 */
		// 明确告知编译器，该泛型对应的具体数据
		// 类内所有使用到泛型占位符的位置都是T类型
		TypeA<String> TypeA = new TypeA<String>();
		
		String test1 = TypeA.test1("北京烤鸭");
		TypeA.test2("卤煮", "豆腐");
		
		// 明确告知编译器这里泛型对应的具体数据类型是Demo2类型
		TypeA<Demo2> typeA2 = new TypeA<Demo2>();
		
		Demo2 test12 = typeA2.test1(new Demo2());
		typeA2.test2(new Demo2(),new Demo2());
		
		/*
		 * 没有告知编译器泛型对应的具体数据类型，那么在类内的所有非静态
		 * 成员方法方法中使用到的泛型， 都是Object类型，虽然可以支持任意
		 * 类型传入参数，但是缺少了数据类型一致化的约束。
		 * 
		 * 不推荐！！！
		 */
		TypeA typeA3 = new TypeA();
		
	}
}









