# Java8·面向对象三大特征-封装

[toc]

#### 面向对象的三大特征

封装，继承，多态

# 继承

#### 生活中的继承

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

#### final关键字--最终的

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

#### static关键字【重点】

##### static修饰成员变量



