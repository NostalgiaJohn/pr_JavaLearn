# Java9·异常

[toc]

#### 生活中的异常

```
异常在生活中很常见，汽车抛锚……都是异常

医院看病：
医生问你: 你怎么了?
我: 我头疼
我: 昨天晚上喝了2斤二锅头
医生:.....

异常或者说错误，都讲究一个前因后果！！！ 
处理错误，讲究对症下药！！！
```

#### 代码中的异常

```
Throwable类
	Java中所有异常的超类
	在Java中所有的异常，错误的基类就是Throwable类。

Throwable
--| Exception 异常 可以处理，代码还有拯救的可能性
--| Error 错误 重来吧…

Throwable常用方法:
	Constructor:
		Throwable(); 
			Throwable构造方法，Throwable类对象中，存储的异常或者错误信息为null
		Throwable(String message); 
			Throwable构造方法，Throwable类对象中，存储的异常或者错误信息为message	
        
	Method:
		String getMessage(); 
			获取Throwable对象中存储的异常或者错误信息
		String toString(); 
			返回当前异常或者错误的简要描述
		void printStackTrace(); 
			展示错误的前因后果，【红色字体】
```

#### Exception和Error的区别

```
Exception 异常 可以处置
Error 错误，不可以处置，只能避免
```

#### 异常处理

##### 捕获异常

```
try - catch 结构
try - catch - finally 结构 设计到资源问题，再补充

格式:
	try {
		// 有可能出现异常代码
	} catch (/* 对应处理的异常对象 */) {
		// 处理方式
	}
```

代码

```java
package com.fs.a_throwable;

/*
 * 捕获异常问题总结：
 * 	1. 代码中从异常发生位置开始，之后的代码都不再运行
 * 	2. 代码中有多个异常，可以使用多个catch块进行捕获操作，分门别类处理
 *  3. 当前情况下，只能展示异常情况，后期可以将异常情况做成log日志文件
 *  4. 异常被捕获后代码可以正常运行
 */
public class Demo1 {
	public static void main(String[] args) {
		test(10, 0, null);
	}
	
	public static void test(int num1, int num2, int[] arr) {
		int ret = 0;
		
		try {
			ret = num1 / num2;
			System.out.println("测试代码");
			arr[0] = 10;
		} catch (ArithmeticException e) {
			e.printStackTrace();
			// System.out.println("发生了算术异常");
		} catch (NullPointerException e) {
			e.printStackTrace();
			// System.out.println("发生了空指针异常");
		}
		
		System.out.println("ret:" + ret);
	}
}

```

##### 抛出异常

```
throw
	在方法内抛出异常
throws
	在【方法声明】位置，告知调用者当前方法有哪些异常抛出
	声明的异常需要生成对应的文档注释
```

代码

```java
package com.fs.a_throwable;

/*
 * 抛出异常总结:
 * 		1. 一个代码块内，有且只能抛出一个异常
 * 		2. 从throw位置开始，之后的代码不在运行
 * 		3. 代码中存在使用throw抛出异常，在方法的声明位置必须告知调用者这里有什么异常
 */
public class Demo2 {
	// 调用带有异常抛出的方法，
	// 如果选择继续抛出需要在当前方法的声明位置告知其他调用者，这里有什么异常抛出
	public static void main(String[] args) 
			throws ArithmeticException , NullPointerException {
		// 调用一个带有异常抛出的方法
		// 捕获处理
		try {
			test(10, 2, null);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
		// 可以继续抛出异常
		test(10, 0, null);
	}
	
	/**
	 * 测试方法
	 * 
	 * @param num1 int类型
	 * @param num2 int类型
	 * @param arr int类型数组
	 * @throws ArithmeticException 除数不能为0
	 * @throws NullPointerException 操作数组null地址异常
	 */
	public static void test(int num1, int num2, int[] arr) 
			throws ArithmeticException , NullPointerException {
		// 参数合法性判断
		/*
		 * if (0 == num2 || null == arr) {
		 * System.out.println("Input Parameter is Invalid!");
		 * return;}
		 */
		// 抛出异常方式来处理当前参数合法性判断
		if (0 == num2) {
			// 有可能会导致算术异常
			throw new ArithmeticException("算术异常");
		}
		
		if (null == arr) {
			// 有可能会导致算术异常
			throw new NullPointerException("算术异常");
		}
		
		System.out.println(num1 / num2);
		arr[0] = 10;
	}
}

```

##### 抛出和捕获的对比

```
捕获之后，代码可以正常运行，要保证处理之后的异常不会再导致其他问题。
例如：
	用户名密码错误，不能采用捕获异常。
	用户指定路径问题，也不能采用捕获异常。

抛出的确可以解决很多问题，并且可以增强代码健壮性。到用户层面说什么都不能抛出异常。
	所谓不能抛出，是指不能直接返回错误信息给用户。

eg:用户账号输错情况：
	1. 捕获异常
	2. 通过异常处理 catch将错误抛出
	3. 给予用户的友好提示
```

##### 不使用大异常的原因和不知道为什么出错

```
大异常--Exception
	不行！
	对症下药！！！
	不能所有的异常都可以使用Exception捕获或者抛出
	无法得知具体的异常类型，无法做到对症下药

不知道为什么出错
	Eclipse, IDEA都会有当前错误的提示。
	正常情况下，只要不是带有自定义异常的方法，通常情况下需要处理的异常，代码中都有会有声明告知。如果未处理异常，代码报错。
	
```

#### RuntimeException

```
运行时异常:
	JVM在运行的过程中可以非强制检查异常
	例如：
		ArrayIndexOutOfBoundException
		NullPointerException
		StringIndexOutOfBoundException
	
	这些异常在代码中如果出现，不需要代码中强制进行捕获或者抛出处理。
```

##### 自定义异常

```
代码运行的过程中存在一定的生活化
	例如:
		用户名密码错误
		NoGirlFriendException 没有女朋友异常

自定义异常格式：
	class 自定义异常类名 extends Exception {
		// No Fields Constructor
		
		// String Field Constructor
	}
	自定义异常类名:
		必须Exception结尾！！！
```

代码

```java
package com.fs.a_throwable;

/*
 * 自定义异常
 */
class NoGirlFriendException extends Exception {
	/**
	 * 无参数构造方法
	 */
	public NoGirlFriendException() {}
	
	/**
	 * 带有String类型参数的构造方法
	 * 
	 * @param message 描述当前的异常信息
	 */
	public NoGirlFriendException(String message) {
		super(message);
	}
}


public class Demo3 {
	public static void main(String[] args) throws NoGirlFriendException {
		try {
			buyOneFreeOne(false);
		} catch (NoGirlFriendException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		buyOneFreeOne(false);
	}
	
	/**
	 * 买一送一方法，需要判断是不是单身狗
	 * 
	 * @param singleDog boolean类型数据，true是单身，false表示有女朋友
	 * @throws NoGirlFriendException 没有女朋友异常
	 */
	public static void buyOneFreeOne(boolean singleDog) 
			throws NoGirlFriendException {
		if (singleDog) {
			throw new NoGirlFriendException("你还没有女朋友");
		}
		
		System.out.println("买一送一");
	}
}
```

