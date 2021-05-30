# Java常用API

[toc]

## StringBuffer

##### StringBuffer概述

```
	为了解决String字符串操作导致的内存冗余，提高效率，Java中提供了StringBuffer和StringBuilder来操作字符串，并且提供了很多方法，便于程序员开发。
	StringBuffer和StringBuilder中都有char类型可变长数组作为字符串的保存空间。使用到的方法类型和ArrayList类似。
	
	StringBuffer 线程安全，效率较低
	StringBuilder 线程不安全，效率较高
```

#####  StringBuffer构造方法

```
构造方法 Constructor
	StringBuffer();
		创建一个未存储任何字符串信息的空StringBuffer空间，底层初始化一个16个字符char类型数组
	StringBuffer(String str);
		根据提供的String类型字符串创建对应的StringBuffer空间，底层char类型数组的容量会根据str.length + 16决定，并且保存对应的str
```

##### 添加方法

```
append(Everything)
	在StringBuffer和StringBuilder对象中，添加另外的数据，并且当做字符串处理。
insert(int index, Everything)
	在StringBuffer和StringBuilder对象中，在指定的下标位置，添加其他内容，并且当做
	字符串处理
```

##### 查看方法

```
String toString();	
	将底层的char类型数组保存的字符内容转换成对应的String类型字符串返回
int length();
	返回底层char类型数组中有多少有效元素。
String substring(int begin);
	从指定位置开始获取到char类型数组有效元素末尾对应的字符串，截取操作，
String substring(int begin, int end);
	从指定位置begin开始到end结束，获取对应的字符串，要头不要尾
int indexOf(String str);
	指定元素字符串所在下标位置
int lastIndexOf(String str);
	指定元素字符串最后一次所在下标位置
```

##### 修改方法

```
replace(int start, int end, String str);
	从指定位置start开始，到end结束，start <= n < end, 使用str替换
setCharAt(int index, char ch);
	使用ch替换指定下标index对应的字符
```

##### 删除和反序

```
delete(int start, int end);
	删除指定范围以内的字符 start <= n < end
deleteCharAt(int index);
	删除指定下标的字符
reverse();
	逆序
```

###### 代码

```java
package com.fs.a_stringbuffer;

public class Demo1 {
	public static void main(String[] args) {
		// 构造
		StringBuffer stringBuffer1 = new StringBuffer();
		StringBuffer stringBuffer2 = new StringBuffer("吃饭");
		
		System.out.println(stringBuffer1);
		System.out.println(stringBuffer2.toString());
		
		StringBuffer stringBuffer3 = new StringBuffer("萧记烩面，蔡记蒸饺，何记小面");
		
		// 添加
		stringBuffer3.append("油泼面");
		stringBuffer3.append(new Demo1());
		
		System.out.println(stringBuffer3);
		
		StringBuilder stringBuilder = new StringBuilder("ABCD");
		stringBuilder.insert(3, "羊肉汤");
		
		System.out.println(stringBuilder);
		
		// 查找
		System.out.println(stringBuffer3.indexOf("萧记烩面"));
		System.out.println(stringBuffer3.substring(3));
		System.out.println(stringBuffer3.length());
		
		stringBuffer3.replace(0, 1, "武汉小面");
		System.out.println(stringBuffer3);
		
		// 删除和逆序 
		stringBuffer3.delete(1, 4);
		System.out.println(stringBuffer3);
		
		stringBuffer3.reverse();
		System.out.println(stringBuffer3);
	}
}

```



## Math数学类

```
Java中一些数学方法

public static double abs(double a);
	返回值为绝对值
public static double ceil(double a);
	向上取整
public static double floor(double a);
	向下取整
public static double round(double a);
	四舍五入(本质是 4往下取整，5往上取整)
public static double random();
	随机数 0.0 <= n < 1.0
```

##### 方法使用

```java
package com.fs.b_math;

/*
 * Math工具类方法
 */
public class Demo1 {
	public static void main(String[] args) {
		// 绝对值
		System.out.println(Math.abs(1.5));
		System.out.println(Math.abs(-1.5));
		System.out.println(Math.abs(5));
		System.out.println(Math.abs(-5));
	
		System.out.println("--------------------------------");
		
		// 向上取整
		System.out.println(Math.ceil(1.5));
		System.out.println(Math.ceil(1.1));
		System.out.println(Math.ceil(-1.9));
		System.out.println(Math.ceil(-2.9));
		
		System.out.println("--------------------------------");
		
		// 向下取整
		System.out.println(Math.floor(10.5));
		System.out.println(Math.floor(10.1));
		System.out.println(Math.floor(-10.5));
		System.out.println(Math.floor(-10.1));
		
		System.out.println("--------------------------------");
		
		// 四舍五入
		System.out.println(Math.round(3.5)); // 4
		System.out.println(Math.round(3.4)); // 3
		System.out.println(Math.round(-2.5)); // -2
		System.out.println(Math.round(-2.4)); // -2
		System.out.println(Math.round(-2.6)); // -3
	}
}
```

##### 抽奖小演示

```java
package com.fs.b_math;

public class Demo2 {
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			double num = Math.random() * 100;
			
			if (0.0 <= num && num < 50) {
				System.out.println("普通卡");
			} else if (50 <= num && num < 80) {
				System.out.println("高端卡");
			} else if (80 <= num && num < 98) {
				System.out.println("传说卡");
			} else {
				System.err.println("史诗卡");
			}	
		}
	}
}

```

## 日历时间格式

#### Date 时期类[逐渐淘汰]

````
获取当前系统时间
	大部分构造方法已经过时

构造方法
	Date();
		创建一个Date，对应当前时间，精度在毫秒值
	Date(long date);
		根据时间戳毫秒数，创建对应的Date对象，时间戳是从1970-01-01 00:00:00 GMT
	tips：
		中国采用的东八区时间
			1970-01-01 08:00:00 
常用方法：
	long getTime();	
		通过Date类对象获取对应当前时间的毫秒数
		System.currentTimeMillis(); 可以获取当前系统时间戳毫秒数
````

#### DateFormat 日期格式类

```
DateFormat 是一个abstract修饰的类，用于转换时间格式。
DateFormat不能直接使用，一般使用DateFormat子类SimpleDataFormat来使用

SimpleDataForma构造方法中需要的参数是一个String，String类型的参数有特定的要求
```

| 常用标识字母(区分大小写) |      对应含义       |
| :----------------------: | :-----------------: |
|            y             |         年          |
|            M             |         月          |
|            d             |         日          |
|            H             | 时(24小时)h(12小时) |
|            m             |         分          |
|            s             |         秒          |

```
String format(Date date);
	根据指定匹配要求，转换Date格式成为字符串

Date parse(String format);
	按照指定的匹配规则，解析对应的字符串，返回一个Date数据
```

#### Calender日历类

```
	Calender日历类，替换了很多Date类中的方法。把很多数据都作为静态的属性，通过一些特定的方法来获取。比Date处理日期数据更加方便。
	
	Calender是一个abstract修饰的类，没有自己的类对象。这里通过特定的方法getInstance获取Calender日历类对象。
	public static Calender getInstance();
		默认当前系统时区的Calender对象

常用方法：
	public int get(int field);
		返回特定数据的数值
	public void set(int field, int value);
		设置特定字段对应的数据
	public Date getTime();
		返回得到一个Date对象，从计算机元年到现在的毫秒数，保存在date对象中
```

|    字段名    |            含义             |
| :----------: | :-------------------------: |
|     YEAR     |             年              |
|    MONTH     | 月(从0开始，使用时习需要+1) |
| DAY_OF_MONTH |       当前月的第几天        |
|     HOUR     |       小时(12小时制)        |
| HOUR_OF_DAY  |       小时(24小时制)        |
|    MINUTE    |            分钟             |
|    SECOND    |             秒              |
| DAY_OF_WEEK  |        周几(周日为1)        |

## System类

```
System类提供了大量的静态方法，操作的内容和系统有关。	
	可以获取当前时间戳	long currentTimeMillis()
	获取系统属性的方法	Properties getProperties();
	退出当前程序		  exit(int status)
	数组拷贝方法 		  arrayCopy(Object src,  -- 原数组
						int srcPos,  -- 从原数组指定下标开始
						Object dest,  -- 目标数组
						int destPos, -- 目标数组从指定位置开始
						int length) -- 读取数据的个数
```

#### Runtime类

```
Runtime当前程序运行环境类对象，主要程序启动就会有对应的Runtime存在。
获取Runtime对象的方法：
	Runtime Runtime.getRuntime();

需要了解的方法:
	gc(); JVM的GC机制，但是就算你调用了GC方法，也不会立即执行。
	long totalMemory(); 目前程序使用的总内存
	long freeMemory(); 目前程序使用的剩余内容
	long maxMemory(); Java程序能过申请的最大内存
	Process exec(String exePath); 开启一个程序
```

#### 包装类

```
Java中提供了两种数据类型
	基本数据类型
		byte short int long double float boolean char
	引用数据类型
		类对象，数组，字符串

Java中万物皆对象，Java中提供了包装类，让基本类型也可以当做类对象来处理。
包装之后的基本数据类型依然可以进行基本的操作和运算，但是多了一些特有的方法，增加了操作性。

ArrayList中如果保存的数据类型是Integer类型
	ArrayList元素：
		[1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
	如果调用 
		remove(1); 删除的是谁???
```

| 基本类型 | 对应的包装类(java.lang) |
| :------: | :---------------------: |
|   byte   |          Byte           |
|  short   |          Short          |
|   int    |         Integer         |
|   long   |          Long           |
|  float   |          Float          |
|  double  |         Double          |
| boolean  |         Boolean         |
|   char   |        Character        |

##### 自动装箱和自动拆箱

```
基本类和包装类型之间进行转换的操作，这个过程就是"装箱"和"拆箱"。
	装箱 从基本类型到包装类
	拆箱 从包装类到基本类型

【不推荐】
	使用强制操作，太麻烦！！！
```

##### 包装类和字符串数据转换过程

```
从文本中读取的数据很多都是字符串类型，例如 JSON XML Database
除了Character字符包装类之外，其他的包装类都有对应的解析方法

以下方法都是static修饰的静态方法
public static byte parseByte(String str);
public static short parseShort(String str);
public static int parseInt(String str);
public static long parseLong(String str);
public static float parseFloat(String str);
public static double parseDouble(String str);
public static boolean parseBoolean(String str);
	以上方法都是对饮的包装类调用，解析成对应的基本数据类型。
```

#### 多线程

##### 进程是什么

```
	windows电脑中，打开任务管理器，可以看到电脑中执行的每一个程序，每一个程序就是一个进程。
	Windows系统是一个多任务系统。
	电脑可以同时执行多个程序。

CPU时间片概念
```

![](D:\ProgramLearning\B站Java-NZGP\Day20-Java常用API和线程初识\img\CPU执行程序时间片概念.png)

##### 线程是什么

```
电脑管家是一个程序 ==> 进程
	电脑可以同时开启 病毒查杀，垃圾清理，一键加速...
	
	每一个功能就可以看做是线程！

一个应用程序 ==> 进程
	应用程序的某一个功能 ==> 线程
	应用程序中可以同时执行多个功能 ==> 多线程

线程使用的是系统资源，该系统资源你是操作系统分配给当前进程使用的。
	多个线程的情况下，同时【抢占执行】会导致资源紧缺。
	这里抢占过程就类似于进程抢占过程。

一个Java程序，最少有几个线程？
	2个线程
		main线程
		JVM的GC机制，守护线程。
```

##### 并发和并行

```
并发:
	两个或者两个以上的事务在同一个时间段发生
	
并行:
	两个或者两个以上的事务在同一个时刻发生
	宏观并行，微观串行
	
高并发
	双十一
	JD 618
	12306
	中午下课的餐厅
	同时在一个时间段以内，很多事情都发生了，这就是高并发。
```

![](D:\ProgramLearning\B站Java-NZGP\Day20-Java常用API和线程初识\img\并发和并行.png)
