# Lambda表达式

## Lambda表达式

#### 核心思想： "说重点"

```java
// 代码举例
//（来自：package com.fs.d_executors/Demo2;）

service.submit(new Runnable() { 
	@Override
	public void run() {System.out.println(Thread.currentThread().getName());
	}      
});

/*
匿名内部类方式来作为线程池执行目标代码
	1. 这个方法需要的参数是Runnable接口的实现类对象
	2. Runnable接口目标是为了提供一个run 方法， What will be run
	3. What will be run??? --> run方法内容
	
这里需要Runnable提供Run方法，提供Run方法方法体

"说重点"
	需要Run方法方法体
*/    
```

#### Lambda表达式格式

```java
service.submit(() -> System.out.println(Thread.currentThread().getName())); 

/*
	上方代码中的Lambda表达式:
	() -> System.out.println(Thread.currentThread().getName())
    
	() 参数列表
	-> 做什么事情，就是对应方法体
	箭头之后的代码就是正常语句
	
	标准格式：(参数列表) -> {代码语句}
*/
```

#### Lambda表达式使用，无参数无返回值

```java
package com.fs.c_lambda;

interface Cook {
	void cooking();
}

public class Demo1 {
	public static void main(String[] args) {
		invokeCook(new Cook() {

			@Override
			public void cooking() {
				System.out.println("炒青菜");				
			}
		});
		
		invokeCook(() -> {
			System.out.println("土豆牛肉");
		});
		invokeCook(() -> System.out.println("孜然牛肉"));
	}
	
	/**
	 * 执行Cook实现类对象方法
	 * 
	 * @param cook
	 */
	public static void invokeCook(Cook cook) {
		cook.cooking();
	}
}

```

#### Lambda表达式使用，有参数有返回值

```java
package com.fs.e_lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Demo2 {
	public static void main(String[] args) {
		Person[] persons = {
				new Person("faa",16),	
				new Person("fbb",43),	
				new Person("fcc",45),	
				new Person("fdd",13),	
				new Person("fee",34),	
		};
		
		// public static <T> void sort(T[] a, Comparator<? super T> c)
		Arrays.sort(persons, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAge() - o2.getAge();
			}
		});
		
		/*
		 * Lambda表达
		 * 1. 有参数
		 * 2. 有返回值
		 * 
		 * 标准的Lambda
		 */
		Arrays.sort(persons, (Person o1, Person o2) -> {
			return o2.getAge() - o1.getAge();
		});
		
		/*
		 * 省略写法：
		 * 	1. 可以省略数据类型
		 * 	2. 可以直接利用返回值，省略{}和return
		 */
		Arrays.sort(persons, (o1, o2) -> o2.getAge() - o1.getAge());
		
		/*
		 * 如果是递增排序，还能进一步省略如下
		 */
		Arrays.sort(persons, Comparator.comparingInt(Person::getAge));
		
		for (Person person : persons) {
			System.out.println(person);
		}
	}
}

```

```java
package com.fs.e_lambda;

interface A {
	float add(int num1, float num2);
}

public class Demo3 {
	public static void main(String[] args) {
		System.out.println(new A() {

			@Override
			public float add(int num1, float num2) {
				return num1 + num2;
			}
		}.add(5, 13.5F));
		
		/*
		 * 1. 不同数据类型也可以省略
		 * 2. 实现代码不止一行，可以在大括号内完成
		 */
		test(5, 16.5F, (num1, num2) -> {
			float sum = num1 + num2;
			return sum;
		});
		
	}

	private static void test(int num1, float num2, A a) {
		System.out.println(a.add(num1, num2));
	}
}

```

#### Lambda表达式使用前提

```
1. 有且只有一个缺省属性为public abstract方法的接口
	例如 Comparator<T>接口，Runnable接口
2. 使用lambda表达式是有一个前后要求约束的
	方法的参数为接口类型，或者说局部变量使用调用方法，也可以使用lambda
3. 有且只有一个抽象方法的接口，称之为【函数式接口】
```

#### 





#### 作业

![](D:/ProgramLearning/B站Java-NZGP/Day21-多线程，同步/img/多线程问题.png)

```
1. 这里有5个线程类，完全不一样，如果完成一个锁对象操作以上五个线程
2. 测试线程优先级和执行概率问题
	一个优先级为10的线程和优先级为1的线程，执行结果保存到文件
3. OA打卡功能
	1. 9~18打卡
	2. 打卡间隔不得超过2小时
	3. 打卡记录保存到文件，异常文件中要有展示
4. LRC歌词解析
	手动播放歌曲，Java程序解析歌词展示
	字符串练习和集合练习
```







