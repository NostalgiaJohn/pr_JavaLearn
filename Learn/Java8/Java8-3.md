# Java8·面向对象三大特征-多态

[toc]

## 接口

#### 生活中的接口

```
生活中比较常见的接口:
	USB接口，Type-C, 3.5MM, Lighting接口, HDMI, VGA, SATA, M.2, DisplayPort，雷电口……
	
接口作用举例：
	USB接口 USB-A
	1. 鼠标连接，键盘连接，声卡连接，U盘，移动硬盘……
	2. 规范：都是USB设备
	3. 设备本身决定了，要做什么事情。
```

#### Java中接口使用

```
格式：
	interface 接口名 {
		成员变量
		成员方法
	}

类【遵从】接口
	implements
	class 类名 implements 接口 {
	
	}

接口中成员变量和成员方法缺省属性原因
	从生活角度
	USB接口规定了尺寸和连接方式，但是该接口做什么内容，是由设备决定的！！！
	尺寸是固定 ==> 成员变量 缺省属性是public static final
	
	接口不管设备做什么事情，但是规定连接方式 ==> 成员方法，需要设备自己完成 
	缺省属性 public abstract修饰
	(公开未完成/公开需重写)
```

#### 接口使用总结

```
1. 接口中的
	成员变量缺省属性 public static final
	成员方法缺省属性 public abstract

2. 一个非abstract类遵从interface接口，需要强制完成接口中所有缺省属性为public abstract的成员方法

3. 接口和接口之间，允许使用extends关键字继承，并且允许一个接口，继承多个接口
	interface A extends B, C
	生活中: 协议直接的向下兼容问题

4. 接口中可以使用default关键字修饰方法，default方法拥有方法体，可以认为是非强制实现方法，不要求遵从接口的非abstract强制实现，JDK1.8新特征
```

#### 接口生活化演示

```
从生活映射USB接口
	interface USB
		规定USB设备必须完成的方法
		void connect();
		
鼠标类 implements USB 
	鼠标是一个USB设备，必须完成connect方法
键盘类 implements USB
	键盘是一个USB设备，必须完成connect方法

USB接口在电脑上，我们需要使用USB接口
```

代码：

```java
package com.fs.c;

/*
从生活映射USB接口
	interface USB
		规定USB设备必须完成的方法
		void connect();
		
鼠标类 implements USB 
	鼠标是一个USB设备，必须完成connect方法
键盘类 implements USB
	键盘是一个USB设备，必须完成connect方法

USB接口在电脑上，我们需要使用USB接口
 */
/**
 * USB接口
 * 
 * @author fStardust
 *
 */
interface USB {
	/*
	 * 要求所有USB设备必须完成的方法，
	 * 告知USB接口连接之后完成的功能是什么
	 */
	void connect();
}
/**
 * 鼠标类，遵从USB接口，实现connect方法
 * 
 * @author fStardust
 *
 */
class Mouse implements USB {

	@Override
	public void connect() {
		System.out.println("鼠标连接USB，控制光标");
	}
}

/**
 * Logi类， 继承Mouse鼠标类
 * 	1. 鼠标设备
 * 	2. Logi间接遵从USB接口，是一个USB设备
 * @author fStardust
 *
 */
class Logi extends Mouse {
	
}

/**
 * 键盘类，遵从USB接口，实现connect方法
 * 
 * @author fStardust
 *
 */
class Keyboard implements USB {

	@Override
	public void connect() {
		System.out.println("键盘连接USB，输入设备");
		
	}
}

/**
 * IKBC继承Keyboard类
 * 		1. 键盘设备
 * 		2. 间接遵从USB接口，也是一个USB设备
 * @author fStardust
 *
 */
class IKBC extends Keyboard {
	@Override
	public void connect() {
		System.out.println("IKBC C87 静音红轴");
	}
}

/**
 * PC电脑类，使用USB接口，通过USB接口连接一个USB设备
 * @author fStardust
 *
 */
class PC {
	/**
	 * 电脑类连接USB接口方法，需要一个USB接口
	 * 
	 * @param usb USB接口对应设备
	 */
	public void usbConnect(USB usb) {
		// usb设备执行connect方法
		usb.connect();
	}
}
public class Demo {
	public static void main(String[] args) {
		
		// 电脑中有一个方法是使用USB接口连接USB设备
		PC pc = new PC();
		
		// 鼠标和键盘都是USB设备
		Mouse mouse = new Mouse();
		Keyboard keyboard = new Keyboard();
		
		// 多态的使用-->父类引用指向子类
		// 电脑需要通过USB接口连接USB设备。mouse鼠标就是USB设备
		pc.usbConnect(mouse);
		// keyboarde是USB设备
		pc.usbConnect(keyboard);
		
		// 传入一个Logi类对象
		pc.usbConnect(new Logi());
		// 传入一个IKBC类对象
		pc.usbConnect(new IKBC());
		
	}
}

```

#### 继承生活化演示

```
动物园:
	所有的动物都可以看做是一个Animal类
熊猫类
	Panda
老虎类
	Tiger

方法:
	喂食动物的方法
	获取动物的方法
```

代码：

```java
package com.fs.c;

/*
所有的动物都可以看做是一个Animal类

熊猫类
	Panda
老虎类
	Tiger

方法:
	喂食动物的方法
	获取动物的方法
 */
/**
 * 动物类
 */
class Animal {
	
}

/**
 * 熊猫类，为Animal动物的子类
 * @author Anonymous
 *
 */
class Panda extends Animal {
	
}

/**
 * 老虎类，为Animal动物的子类
 */
class Tiger extends Animal {
	
}

public class Demo1 {
	public static void main(String[] args) {
		Animal animal = new Animal();
		Tiger tiger = new Tiger();
		Panda panda = new Panda();
		
		// 这里传入一个Animal类对象
		feed(animal);
		
		// 这里传入的对象是Tiger类对象，Tiger类是Animal的子类对象
		feed(tiger);
		// 同上
		feed(panda);
		
		// 数据类型强转，
		Tiger tiger2 = (Tiger) getAnimal();
		System.out.println(tiger2.getClass());
	}
	
	/**
	 * 该方法的是喂食【动物】的方法
	 * 
	 * @param animal 需要的参数是Animal类对象
	 */
	public static void feed(Animal animal) {
		// 获取当前对象的完整包名.类名
		System.out.println(animal.getClass() + "来吃饭了！！！");
	}
	
	/**
	 * 返回【动物】类对象的方法
	 * 
	 * @return Animal类对象
	 */
	public static Animal getAnimal() {
		// return new Animal();
		return new Tiger();
		// return new Panda();
	}
}
```

#### 多态总结

```
多态
	多态是同一个行为具有多个不同表现形式或形态的能力。
	多态就是同一个接口，使用不同的实例而执行不同操作。
	
多态存在的三个必要条件：
	1. 继承
	2. 重写
	3. 父类引用指向子类对象
		Parent p = new Child();

作用:
	1. 拓宽方法的参数范围
		例如:
		方法参数为Animal类型
		可以传入Animal类型本身，或者其子类对象都可以
		
		方法参数为USB接口类型
		只要是直接或者间接遵从USB接口的类对象可以作为方法的参数传入
	2. 拓宽方法的返回值范围
	3. 简化代码开发，提高开发效率，整合数据类型
```

