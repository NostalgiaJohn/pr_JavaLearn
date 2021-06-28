package com.fs.n_reflect;

/*
Class Class.forName(String packageNameAndClassName);    
	Class类的静态成员方法，通过完整的包名.类名获取对应.class文件的Class对象   
	同时也可以作为.class文件加载的方式。
​Class 类名.class;    
	通过类名.class方法，获取对应的Class类对象，通常用于方法的参数类型。
​Class 类对象.getClass();    
	通过类对象获取对应.class的Class类对象，方法参数，或者说数据类型判断。
 */
public class GetClassObject {
	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println(123456);
		
		Class<?> forName = Class.forName("com.qfedu.a_reflect.Person");
		
		Class<com.fs.n_reflect.Person> cls = Person.class;
		
		Class<? extends Person> class1 = new Person().getClass();
		
		/*
		 * 请问这个三个Class对象是不是同一个Class对象???
		 * 		Class对象对应的是在内存代码区的.class文件占用的内存空间
		 * 		Class引用数据类型变量保存的就是当前空间首地址，
		 * 		Java程序中，.class字节码文件有且只加载一次
		 * 		.class文件占用的空间独一份，不管通过哪一种方式获取对应的Class类对象都是同一个对象
		 */
		System.out.println(forName == cls);
		System.out.println(class1 == cls);
		System.out.println(class1 == forName);
		
		System.out.println("-------------------------");
		
		System.out.println(forName);
		System.out.println(cls);
		System.out.println(class1);
		System.out.println(int.class);
	}
}
