# Java8·面向对象三大特征

[toc]

#### 面向对象的三大特征

封装，继承，多态

#### 封装

##### 不局限于面向对象的封装

```
方法；工具类；框架 都可以封装

要有封装的思想，可以用于整合的知识点

建议：
一段代码，你写了三遍 ==> 封装成方法
一堆方法，你用了三遍 ==> 封装成工具类
一个工具类，你使用了三遍 ==> 写好对应的注释，完成对应的API
一个类注释自己修改了三遍==> 写成博客
```

##### 符合JavaBean规范的类封装

```
规范非常重要：
	后期可以有效的提供的开发效率！
	
要求：
	1. 所有的成员变量全部私有化==>private
	2. 必须提供一个无参数构造方法
	3. 要求使用private修饰的成员变量提供对应的操作方法==>Setter;Getter
```

##### private关键字

```
private关键字是一个权限修饰符
	private修饰的成员变量/成员方法/构造方法 都是私有化内容，有且只能在类内使用，类外没有任何操作权限。
```

```java
package com.fs.a_private;

/*
 * Private 关键字使用
 */
class Dog {
	private String name;
	int age;
	char gender;
	
	public void testField() {
		// 类内可以直接使用没有操作权限
		name = "Bobo";
	}
	
	private void test() {
		System.out.println("测试方法");
	}
}
public class Demo1 {
	public static void main(String[] args) {
		Dog dog = new Dog();
		
		// 当成员变量使用private修饰之后，当前成员变量类外没有操作权限
		// The field Dog.name is not visible
		// dog.name = "小七";
		// 没有使用private约束的情况下，类外可以使用 
		dog.age = 5;
		dog.gender = '雌';
		
		// 使用private修饰的方法类外不能使用
		// The method test() from the type Dog is not visible
		// dog.test();
	}
}

```



##### Setter和Getter方法

```
private修饰的成员变量类外没有操作权限，这里需要提供对应的操作方法：
	Setter和Getter方法

Setter方法格式：
	public void set 成员变量名 (对应成员变量的数据类型 成员变量的形式参数) {
		this.成员变量名 = 成员变量的形式参数;
	}
	
	例如:
	public void setName(String name) {
		this.name = name;
	}
	
Getter方法格式：
	public 对应成员变量的数据类型 get成员变量名() {
		return 成员变量;
	}
	
	例如:
	public String getName() {
		return name;
	}

如果成员变量是一个boolean类型，Getter方法有所不同
	boolean married;
	格式:
		public boolean isMarried() {
			return married;
		}

```

```java
package com.fs.a_private;


class Cat {
	// 所有的成员变量全部私有化
	private String name;
	private int age;
	private char gender;
	private boolean married;

	
	// 根据实际需要完成对应Constructor， Setter， Getter
	// 快捷键 shift + alt +s
	
	// 对应的构造方法
	public Cat() {
		super();
	}

	public Cat(String name, int age, char gender, boolean married) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.married = married;
	}


	// Setter和Getter方法
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	public boolean isMarried() {
		return married;
	}


	public void setMarried(boolean married) {
		this.married = married;
	}
	
	
	
}

public class Demo2 {
	public static void main(String[] args) {
		Cat cat = new Cat();
		
		cat.setName("蛋卷");
		cat.setAge(1);
		cat.setGender('雌');
		cat.setMarried(false);
		
		System.out.println("Name:" + cat.getName());
		System.out.println("Age:" + cat.getAge());
		System.out.println("Gender:" + cat.getGender());
		System.out.println("Married:" + cat.isMarried());
		
	}
}

```

#### 多类合作

##### 多类合作的概念

```
在开发中，除了基本数据类型，大多数情况下，都是类对象操作数据，作为：
	1. 方法的参数
	2. 类定义时成员变量数据类型
```

##### 方法参数【电脑及维修店案例】

```
需求:
	电脑类
		属性：
			屏幕是否OK boolean ok;
		方法：
			电脑屏幕如果是OK的，可以看直播，如果不OK，无法观看
			
	维修店类
		属性：
			店址
			电话
			店名
		方法：
			修电脑！！！【重点】
```

代码

```
代码文件位于.\Code\com.fs.b_objectProgram\
Demo1.java	// mian主类 
computer.java	// 电脑类
Repair.java		// 维修类
-->当前代码有问题，见-->匿名函数
```

##### 成员变量的数据类型为自定义类型

```
汽车
	发动机
	轮胎
class Car 
	这里需要的数据类型是自定义复合数据类型，自定义类！！！
	Engine engine
	Tyre tyre

发动机也需要一个类
class Engine 
	型号
	排量

轮胎也需要一个类
class Tyre
	型号
	尺寸
```

#### 匿名函数

解决【电脑及维修店案例】中的代码问题

```java
Factory factory = new Factory();        
                                      
// 通过修理店对象，调用修理电脑的方法                  
// 需要的参数是Computer类对象                  
factory.repair(computer);       

/*
Factory类对象
	1. 有且只使用了一次
	2. 该对象中的设置操作是没有什么作用的

问题：
	1. 代码操作感觉不方便
	2. 浪费时间浪费资源，内存资源，JVM效率问题
*/

匿名对象:
	new 构造方法(必要的参数);
匿名对象的用途:
	1. 使用匿名对象直接调用类内的成员方法
	2. 匿名对象直接作为方法的参数
注意:
	使用匿名对象不要操作成员变量，有可能是有去无回
优势：
	1. 阅后即焚，匿名对象在使用之后 立即被JVM GC收回
	2. 解决内存空间，提高效率，简化代码书写
```

