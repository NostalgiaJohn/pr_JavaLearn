package com.fs.a_object;

/**
 * 这里定义的是一个Person类
 * 
 * @author fStardust
 *
 */
class Person{
	// 属性描述，这里使用成员变量Field
	// 使用String类型描述Person类的姓名属性
	String name;
	
	// 使用int类型数据描述Person类的年龄属性
	int age;
	
	// 使用char类型数据描述Person类的性别属性
	char gender;
	
	// 使用方法描述Person类的吃饭行为
	public void eat(String food) {
		System.out.println("吃" + food);
	}
	
	// 使用方法描述Person类的睡觉行为
	public void sleep() {
		System.out.println("说出来你可能不信，是床先动的手");
	}
	

}
public class Demo1 {
	public static void main(String[] args) {
		// 这里创建了一个Person类对象，对象名person
		Person person = new Person();
		System.out.println(person);
		/*
		 * com.fs.a_object.Person@4926097b
		 * com.fs.a_object --> 完整的包名
		 * Person 数据类型，这里创建的对象是一个Person类对象
		 * @4926097b 当前类对象在内存空间中的首地址/哈希码！十六进制展示方式 
		 */
		
		Person person1 = new Person();
		System.out.println(person1);
		/*
		 * com.fs.a_object.Person@762efe5d
		 * 发现第二个Person类对象 person1首地址空间@762efe5d 和第一个对象不一致
		 * 两个对象首地址不一致，意味着不是同一个对象！
		 */
		
		// 通过Person类对象 person调用类内成员变量
		// 【赋值】Person；类对象person中对应的成员变量
		person.name = "乔布斯";
		person.age = 26;
		person.gender = '男';
		
		// 【取值】展示Person类对象person中保存的成员变量数据
		System.out.println("Name:" + person.name);
		System.out.println("Age:" + person.age);
		System.out.println("Gender" + person.gender);
		
		// 通过Person类对象person调用类内成员方法
		person.eat("烤羊排");
		person.sleep();
		
	}
}

























