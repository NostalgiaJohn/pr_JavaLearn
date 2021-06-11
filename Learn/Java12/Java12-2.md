# 线程与进程-1



## 基本概念

#### 进程是什么

```
	Windows电脑中，打开任务管理器，可以看到电脑中执行的每一个程序，每一个正在运行的程序就是一个进程。
	Windows系统是一个多任务系统--电脑可以同时执行多个程序。
	但是其实质上依旧是单任务系统--只是系统在不同的程序中切换过快，会认为是同时在执行多个程序。（时间片概念）
```

![CPU时间片概念](https://i.loli.net/2021/06/11/hDRnpGQby5J1VTE.png)

#### 线程是什么

```
电脑管家是一个程序 ==> 进程
	电脑可以同时开启 病毒查杀，垃圾清理，一键加速...
	其中的每一个功能就可以看做是线程！（线程是进程的单元）

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

#### 并发和并行

```
并发:
	两个或者两个以上的事务在同一个时间段发生
	
并行:
	两个或者两个以上的事务在同一个时刻发生

宏观并行，微观串行
	
高并发
	双十一
	12306
	中午下课的餐厅

同时在一个时间段以内，很多事情都发生了，这就是高并发。
```

## 多线程

#### 多线程的优缺点

```
优点
	1. 提升资源利用率
	2. 提高用户体验

缺点:
	1. 降低了其他线程的执行概率
	2. 用户会感受到软件的卡顿问题
	3. 增加的系统，资源压力
	4. 多线程情况下的共享资源问题，线程冲突，线程安全问题
```

#### 创建自定义线程类的两种方式

```
class Thread类
	Java中的一个线程类
	Thread类是Runnable接口的实现类，同时提供了很多线程的操作使用的方法。
	
interface Runnable接口
	这里规定了what will be run?
	里面只有一个方法 run方法

方式一:
	自定义线程类，继承Thread类，重写run方法
	创建自定义线程对象，直接调用start方法，开启线程
	
方式二：
	自定义线程类，遵从Runnable接口
	使用自定义遵从接口Runnable实现类对象，作为Thread构造方法参数
	借助于Thread类对象和start方法，开启线程

【推荐】
	以上两种方式，推荐使用方拾二，遵从Runnable接口来完成自定义线程，不影响正常的继承逻辑，并且可以使用匿名内部类来完成线程代码块的书写

```

代码：

```java
package com.fs.b_thread;

/*
 * 自定义线程类MyThread1继承Thread
 */
class MyThread1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++ )  {
			System.out.println("继承Thread类自定义线程类");
		}
	}
}
class MyThread2 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++ )  {
			System.out.println("遵从Runnable接口实现自定义线程类");
		}
	}
}

public class Demo1 {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++ )  {
					System.out.println("匿名内部类方式创建对象，作为线程执行代码");
				}
			}
		}).start();
		
		// 创建一个继承Thread类自定义线程类对象
		MyThread1 myThread1 = new MyThread1();
		// 此处不用启动线程，而是将run方法作为一个普通方法执行
		//		myThread1.run(); 
		myThread1.start();
		
		// 创建一个Thread类对象，使用遵从Runnable接口的实现类作为构造方法参数
		Thread thread = new Thread(new MyThread2());
		// 借助于Thread类内的start方法开启线程
		thread.start();
		
		for (int i = 0; i < 10; i++ )  {
			System.out.println("main线程");
		}
		

	}
}

```

执行结果：

![线程抢占](https://i.loli.net/2021/06/01/GMBq67FyVovDWRp.png)

#### 自定义线程执行流程简述

![自定义线程执行流程简述](https://i.loli.net/2021/06/01/SanQfyxXvLtiw6T.png)

#### Thread类需要了解的方法

```
构造方法 Constructor
	Thread();
		分配一个新的线程对象，无目标，无指定名字
	Thread(Runnable target);
		创建一个新的线程对象，并且在创建线程对象的过程中，使用Runnable接口的实现类对象作为执行的线程代码块目标
	Thread(String name);
		创建一个新的线程，无指定目标，但是指定当前线程的名字是什么
	Thread(Runnable target, String name);
		创建一个线程的线程对象，使用Runnable接口实现类对象，作为执行目标，并且指定name作为线程名
	
成员方法:
	void setName(String name);
	String getName();
		以上两个是name属性setter和getter方法
	void setPriority(int Priority);
		设置线程的优先级，非一定执行要求，只是增加执行的概率
		优先级数值范围 [1 - 10] 10最高 1最低 5默认
	int getPriority();
		获取线程优先级
	void start();
		启动线程对象
	
	public static void sleep(int ms);
		当前方法是静态方法，通过Thread类调用，要求是当前所在线程代码块对应的线程，进行休眠操作，休眠指定的毫秒数
	public static Thread currentThread();
		当前方法是静态方法，通过Thread类调用，获取当前所处代码块对应的线程对象。
```

## 线程安全问题和解决方案

#### 线程安全问题--共享资源能使用问题

```
一个观影厅中的<<第十一回>>100张电影票票
线上线下几个销售渠道中这100张票是一个共享资源！！！
如果有三个销售渠道，那么可以认为是三个销售线程！！！


问题一：
	100张票共享资源问题，选什么来保存？
	局部变量：
		在方法内，如果run方法执行，存在，run方法当前执行完毕，销毁。
		每一个线程对象中都有run方法，无法满足共享问题
	成员变量：
		每一个线程对象中，都有一个对应的成员变量，非共享资源。
	静态成员变量：
		属于类变量，所有的当前类对象，使用的静态成员变量都是一个，而且一处修改，处处受影响。【共享资源】

问题二:
	资源冲突问题
```

![资源冲突问题](https://i.loli.net/2021/06/01/ZKCaWNIAsgG4fzL.png)

#### 同步代码块

```java
synchronized (/* 锁对象 */) {
    
}
// eg：
while (true) {
    synchronized ("锁") {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "售出了" + ticket + "张票");
            ticket -= 1;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } else {
            System.out.println(Thread.currentThread().getName() + "售罄！");
            break;
        }
    }
}

/*
特征:
 	1. synchronized 小括号里面的对象是锁对象，并且要求如果是多线程的情况下，锁对象必须是同一个对象。
 	2. synchronized 大括号中的代码块就是需要进行同步的代码，或者说是加锁的代码，大括号里面的内容，有且只允许一个线程进入。
 	3. 同步代码块越短越好，在保证安全的情况下，提高性能
 
问题:
	1. 目前锁对象感觉很随意，存在一定的隐患
	2. 代码层级关系很复杂，看着有点麻烦
*/

```

#### 同步方法

```
synchronized 作为关键字来修饰方法，修饰的方法就是对应的同步方法
有且只允许一个线程进入，到底是谁来完成的加锁操作?

1. 静态成员方法 --package com.fs.b_thread/Demo5
	锁对象，是当前类对应的字节码文件.class 类名.class
2. 非静态成员方法 --package com.fs.b_thread/Demo6
	锁对象就是当前类对象 this

选择同步方法是否使用static修饰问题
	1. 如果非static修饰，要保证执行的线程对象有且只有一个，因为锁对象就是当前线程对象
	
	2. 如果是static修饰，锁对象具有唯一性，多个线程使用的锁是同一个锁。
	
```

####  Lock锁

```
Java提供了一个对于线程安全问题，加锁操作相对于同步代码块和同步方法更加广泛的一种操作方式。
1. 对象化操作
	创建Lock构造方法
		Lock lock = new ReentrantLock();
2. 方法化操作
	unlock();	//开锁
	lock();		//加锁
```

#### 三种加锁方式的总结

```
1. 一锁一线程，一锁多线程问题。
	使用对应的锁操作对应的线程，考虑静态和非静态问题。
	同步方法和Lock锁使用。
	静态是一锁多目标，非静态是一锁一目标

2. 涉及到同步问题时，要考虑好锁对象的选择问题
	同步代码块，同步方法，Lock对象。
```

#### 守护线程

```
守护线程，也称之为后台线程，如果当前主线程Over，守护线程也就Over。

守护线程一般用于:
	1. 自动下载
	2. 操作日志
	3. 操作监控

方法是通过线程对象
	setDeamon(boolean flag);
		true为守护线程
		false缺省属性，正常线程
```

