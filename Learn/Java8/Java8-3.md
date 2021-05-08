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

