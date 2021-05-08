



# Java8·面向对象三大特征-继承

[toc]

#### 面向对象的三大特征

封装，继承，多态

## 生活中的继承

```
子承父业

游戏：
	攻击力，攻速……
	统一属性剥离出来，做成一个【基类】，让其他英雄类继承该基类，从而简化开发压力。
```

#### Java中实现继承的方式

```
继承使用的关键字
	extends
格式：
	class A extends B {
	
	}
-->	
	A类是B类的一个子类
	B类是A类的唯一父类
	Java中的继承是一个单继承模式
	
基本要求：
	1. 子类继承父类后，可以使用父类的非私有化成员变量和成员方法--【非私有化成员】
	2. 子类不能继承得到父类的私有化内容。
	
```

#### 继承的问题

##### 父类的构造方法被调用

![继承父类和子类内存分析图](https://i.loli.net/2021/05/05/uo7RjDvSlqgcWn6.png)

##### 自动执行父类的无参数构造方法的原因

```
super关键字：
	1. 调用父类成员方法和成员变量的关键字
		[解决就近原则问题]
	2. 用于显式调用父类的构造方法
	
super关键字调用父类的构造方法：
	super(实际参数);
	Java编译器会根据实际参数的数据类型，参数顺序，选择对应的父类构造方法执行，初始化父类的成员空间，方法重载机制。
	
特征：
	1. 如果没有显式调用父类的构造方法，默认Java编译器会调用无参父类构造方法使用
	2. 根据数据类型选择对应方法
	3. super调用构造方法，必须在当前构造方法的第一行
```

#### 方法的重写

	需求:
		父类的方法不适用子类的情况，子类需要自定义方法
	
	重写意义：
		在没有增加新方法名的情况下，重写方法题内容，降低开发压力
		
	@Override
		严格格式检查--可以删，但不建议
		要求重写方法的和父类中对应方法声明完成一致，
		包括：返回值类型，方法名和形式参数列表
#### abstract关键字--解决重写和继承的问题

```
解决重写和继承的问题：
    子类继承父类可以直接使用父类的方法，
    但是在实际情况中 
        (例如LOL中英雄父类--跟具体英雄子类的情况下)：
        我们可以发现父类的方法是一定不能在子类中使用的
        但是又没有一个强制要求(交流沟通不便)

    需求：
    	从语法约束，强制要求子类重写父类的方法

abstract修饰的方法：
	要求子类强制重写
	让集成开发环境帮助我们自动生成代码


abstract使用重点
	-->代码位于：.\Code\com.fs.f_extends\Demo2
第一个错误                                                               
	Abstract methods do not specify a body                             
	abstract修饰的方法不能有方法体                                                  
快速修复提示：快捷键ctrl+1                                                    
	Remove method body                                                 
                                                                    
第二个错误：                                                              
	The abstract method Q in type LOLHero can only be defined by an abs
	在LOLHero中使用abstract修饰的方法Q，只能定义在abstract修饰的类内                       
快速修复提示：                                                             
	Make Type 'LOLHero' abstract                                       
                                                                    
第三个错误：                                                              
	The type Yasuo must implement the inherited abstract method LOLHero
	子类（亚索类）必须实现继承而来的abstract LOLHero.Q()方法                             
快速修复提示：                                                             
	Add unimplemented method                                           
	添加没有实现的父类中abstract方法

abstract使用总结:
	1. abstract不能修饰一个方法体
	2. abstract修饰的方法必须定义在abstract修饰的类内或者interface接口内
	3. 一个普通类【非abstract】修饰的类，继承了一个abstract类，那么必须实现在abstract类内的所有abstract，强制要求
	4. 如果一个abstract A类继承另一个abstract B类，A类可以选择实现B类中abstract方法。
	5. abstract修饰的类内允许普通方法
	6. abstract修饰的类不能创建自己的类对象！！！
	【原因】
		abstract修饰的类内有可能存在abstract修饰的方法，
		而abstract修饰的方法是没有方法体的，
		如果说创建了abstract修饰类对应的对象，不能执行没有方法体的abstract方法
	7. 一个类内没有abstract修饰的方法，那么这个类定义成abstract类是无意义的！
```

#### final关键字--常量

```
final修饰的成员变量
	final修饰的成员变量定义时必须初始化，并且赋值之后无法修改，一般用于类内带有名字的常量使用
final修饰的成员方法
	final修饰的成员变量不能被子类重写，为最终方法，可以用于一些安全性方法的定义
final修饰的局部变量
	final修饰的局部变量一旦被赋值，不能修改！
final修饰的类
	final修饰的类没有子类，不能被继承。
	abstract修饰的类不能被final修饰。
```

----

## static关键字【重点】

##### static修饰成员变量

###### 使用原因

![static修饰成员变量的需求](https://i.loli.net/2021/05/06/mVPyntT6LDUGSRi.png)

```
需求：
	大量的对象拥有相同的属性，如果都放在各自的对象空间中，会极大的浪费内存空间。所以需要有一个公共空间存放这些共性属性。
	
生活中的例子：
	共享单车
		1. 存在于公共区域
		2. 每一个人都可以使用
		3. 来到北京前，北京已经有共享单车，离开北京之后，共享单车依旧存在
		4. 如果共享单车损坏了，所要需要使用的人都会受到影响
		
    总结：
        1. 公共区域存放
        2. 共享性使用
        3. 和使用对象无关
        4. 一处修改，皆受影响
```

###### 代码使用

```java
SingleDog singleDog1 = new SingleDog("张三");
SingleDog singleDog2 = new SingleDog("李四");
SingleDog singleDog3 = new SingleDog("王五");

// The static field SingleDog.info should be accessed in a static way
// 使用static修饰的SingleDog类内的info成员变量，应该通过一个静态方式访问
System.out.println(SingleDog.info);
System.out.println(singleDog2.info);

singleDog2.info  = "单身";

System.out.println(SingleDog.info);
System.out.println(singleDog3.info);
```

###### 静态成员变量使用注意事项

```
1. 静态成员变量是使用static修饰的成员变量，定义在内存的【数据区】
2. 静态成员变量不推荐使用类对象调用，会提示警告
	The static field SingleDog.info should be accessed in a static way
	使用static修饰的SingleDog类内的info成员变量，应该通过静态方式访问
3. 静态成员变量使用类名调用是没有任何的问题。【强烈推荐方式】
4. 在代码中没有创建对象时，可以通过类名直接使用静态成员变量，和【对象无关】
5. 代码中对象已经被JVM的GC销毁时，依然可以通过类名调用静态成员变量，和【对象无关】
6. 修改对应的静态成员变量数据，所有使用到当前静态成员变量的位置，都会受到影响。
```

###### 静态成员变量和对象无关的原因

```
1. 从内存角度出发分析
	静态成员变量是保存在内存的数据区
	类对象占用的实际内存空间是在内存的堆区
	这两个区域是完全不同的，所有可以说静态成员变量和对象没有关系 【没有对象】

2. 从静态成员变量以及类对象生命周期来分析
	静态成员变量是随着类文件(.class) 字节码文件的加载过程中，直接定义在内存的数据区。静态成员变量从程序运行开始就已经存在。
	类对象是在代码的运行过程中，有可能被创建的。程序的运行过中，有可能会被JVM的CG垃圾回收机制销毁，程序在退出之前一定会销毁掉当前Java程序使用到的所有内存。
	静态成员变量在程序退出之后，才会销毁
	
	静态成员变量的生命周期是从程序开始，到程序结束
	类对象只是从创建开始，而且随时有可能被JVM的GC销毁
	生命周期不在同一个时间线上，所以静态成员变量和类对象无关，【没有对象】
```

##### static修饰成员方法

###### 静态成员成员方法的格式

```
异常熟悉的格式
	public static 返回值类型 方法名(形式参数列表) {
	
	}
```

###### 静态成员方法注意事项

```
1. 静态成员方法推荐使用静态方式调用，通过类名调用【强烈推荐】
	不推荐使用类对象调用，因为【没有对象】
2. 静态成员方法中不能使用非静态成员 ==> (非静态成员方法和非静态成员变量)	
	因为【没有对象】
3. 静态成员方法中不能使用this关键字
	因为【没有对象】
4. 静态成员方法中可以使用类内的其他静态成员【难兄难弟】
5. 静态成员方法中可以通过new 构造方法创建对象
	单身狗可以找对象
	不能挖墙脚但是能自己找
```

###### 静态成员方法特征解释

```
1. 静态成员方法加载时间问题
	静态成员方法是随着.class字节码文件的加载而直接定义在内存的【方法区】，而且此时的静态成员方法已经可以直接运行。可以通过类名直接调用，而此时没有对象存在。【没有对象】
	
2. 静态成员方法不能使用非静态成员的原因
	非静态成员变量和非静态成员方法时需要类对象调用的，在静态成员方法中，是可以通过类名直接执行的，而此时是【没有对象】的。

3. 为什么静态成员方法不能使用this关键字
	this关键字表示的是调用当前方法的类对象，但是静态成员方法可以通过类名调用，this不能代表类名，同时也是【没有对象】

4. 静态成员方法可以使用其他静态成员
	生命周期一致，调用方式一致
```

##### 类变量和类方法

```
类变量 ==> 静态成员变量
类方法 ==> 静态成员方法
类成员 ==> 静态成员变量和静态成员方法

面试题
	类方法中是否可以使用成员变量?
	答：类方法可以使用当前类内的静态成员变量，但是不允许使用非静态成员变量
```

## 静态代码块

##### 补充知识点·代码块

```
构造代码块
	初始化当前类的所有类对象，只要调用构造方法，一定会执行对应的构造代码块
	{
		// 构造代码块
	}
	
静态代码块
	初始化程序,只要类文件加载,静态代码块中所有内容全部执行
	static {
		// 静态代码块
	}
    只要类文件加载，当前静态代码块中的内容就一定会执行，并且有且只执行一次。
    用于：整个类的初始化过程
	
局部代码块
	提高效率，解决内存，让JVM回收内存的效率提升。
	for() {
		{// 局部代码块} //例: int num
	}
		极致控制数据的生存周期
```

面试题

```java
// 请问以下代码的执行顺序
public class Demo3 {
	Demo3 demo1 = new Demo3();
	Demo3 demo2 = new Demo3();
    
    {
        System.out.println("构造代码块"); // 1
    }
    
    static {
        System.out.println("静态代码块"); // 2
    }
    
    public Demo3() {
        System.out.println("构造方法"); // 3
    }
    
    public static void main(String[] args) {
        Demo3 demo1 = new Demo3();
    }
}
```

答案：

![代码块运行流程辨析](C:\Users\pc\Desktop\代码块运行流程辨析.png)



```java
// 那么以下代码的执行顺序又是什么呢？
package com.fs.m_staticBlock;

public class Demo3 {
	Demo3 demo1 = new Demo3();
	Demo3 demo2 = new Demo3();
	
	{
		System.out.println("构造代码块");	// 1
	}
	
	static {
		System.out.println("静态代码块");	// 2
	}
	
	public Demo3() {
		System.out.println("构造方法");	// 3
	}
	
	public static void main(String[] args) {
		Demo3 demo1 = new Demo3();
	}
}
```

答案：

```
运行完2后，报内存溢出错误。
原因，一直在创建新对象，递归地停留在第4行代码处。
运行顺序：12行-->20行-->4行<-递归->4行
```

![代码运行结果](https://i.loli.net/2021/05/06/lKw8o6QDU5Cm3Wr.png)