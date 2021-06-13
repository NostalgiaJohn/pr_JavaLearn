# 线程与进程-2



## 线程状态

#### 六种线程状态

```
线程：
	如果按照java.lang.Thread.State枚举方式来考虑，一共提供了6种状态
```

| 状态                    | 导致状态的发生条件                                           |
| :---------------------- | :----------------------------------------------------------- |
| NEW(新建)               | 线程刚刚被创建，没有启动，没有调用start方法                  |
| RUNNABLE(可运行)        | 线程已经可以在JVM中运行，但是是否运行不确定，看当前线程是否拥有CPU执行权 |
| BLOCKED(锁阻塞)         | 当前线程进入一个同步代码需要获取对应的锁对象，但是发现当前锁对象被其他线程持有，当前线程会进入一个BLOCKED。如果占用锁对象的线程打开锁对象，当前线程持有对应锁对象，进入Runnable状态 |
| WAITING(无限等待)       | 通过一个wait方法线程进入一个无限等待状态，这里需要另外一个线程进行唤醒操作。进入无限等待状态的线程是无法自己回到Runnable状态，需要其他线程通过notify或者notifyAll方法进行唤醒操作 |
| TIMED_WAITING(计时等待) | 当前线程的确是等待状态，但是会在一定时间之后自动回到Runnable状态，例如 Thread.sleep() 或者是Object类内的wait(int ms); |
| TERMINATED(被终止)      | 因为Run方法运行结束正常退出线程，或者说在运行的过程中因为出现异常导致当前线程Over |

#### TIMED_WAITING(计时等待)

```
Thread.sleep(int ms);
	在对应线程代码块中，当前线程休眠指定的时间。
Object类内  wait(int ms);
	让当前线程进入一个计时等待状态
		1. 规定的时间计时完毕，线程回到可运行状态
		2. 在等待时间内，通过其他线程被notify或者notifyAll唤醒

Sleep方法
	1. 调用之后休眠指定时间
	2. sleep方法必须执行在run方法内，才可以休眠线程
	3. sleep不会打开当前线程占用的锁对象。
```

![TIMED_WAITING状态](https://i.loli.net/2021/06/06/KT4Z3QPt5MDqg9U.png)

#### BLOCKED(锁阻塞)

```
线程中有锁存在，线程需要进入带有锁操作的同步代码，如果锁对象被别人持有，只能在锁外等待

锁阻塞状态的线程是否能够抢到锁对象有很多因素
	1. 优先级问题，非决定因素
	2. CPU执行概率问题。

后期高并发一定会存在多线程操作锁对象问题：抢购...
	队列方式来处理
```

![BLOCKED阻塞状态](https://i.loli.net/2021/06/06/cuKOVm91H5dtLBo.png)

#### 线程状态 WAITING(无限等待)

```
当某一个线程被执行wait()方法，需要等待另外的一个线程进行唤醒操作。

一下三个方法都是Object类内的方法:
	public void wait();
		在哪一个线程中执行，就会让当前线程进入一个无限等待状态。
			1. 所在线程进入无限等待状态
			2. 开启【锁对象】
	
	public void notify();
		唤醒和当前锁对象有关的无限等待线程中的一个，随机选择。
			1. 唤醒一个无限等待状态线程
			2. 开启【锁对象】
	
	public void notifyAll();
		唤醒所有和当前锁对象有关的无限等待线程
			1. 唤醒所有线程
			2. 开启【锁对象】
			3. 线程进入锁对象抢占过程，就有可能进入一个锁阻塞状态。
```

![无限等待图例](https://i.loli.net/2021/06/11/4p5JSDbC3m7LYgr.png)

#### 线程执行的所有状态分析图

![六大线程状态](https://i.loli.net/2021/06/09/OInc96SfBKlrUHy.png)

## 线程通信

#### 生活化例子

```
预约 --> 抢购
消费者 <--> 商品 <--> 生产者

消费者
	1. 购买商品
	2. 等待，不过在等待之前，需要告知生产者快点生产

生产者：
	1. 生产商品
	2. 休息，在休息之前，要告知消费者你快来买啊

商品:
	就是两个独立线程之间的共享资源。
```

#### 2.2 共享资源处理问题

```
现在存在两个完全无关的线程，生产者和消费者，但是商品会作为他们两者之间的共享资源。

生产者和消费者中都有一个成员变量
	商品类型

【解决方案】
创建生产者或者消费者线程对象时，使用同一个商品类对象，作为构造方法参数进行初始化操作
```

#### 设计程序

![生产者消费者图例](https://i.loli.net/2021/06/11/xyEAbg6j9Sl4Le7.png)

```
遇到的一些注意事项
# 具体见代码package com.fs.c_thread;

	两个线程会同时运行，一个线程进入线程代码块，运行后同时加锁，运行结束
	然后两个线程回到同一起跑线，但是此时若无法保障之前运行过的线程进入休眠状态，会造成之前已经运行过的线程再次运行，并循环下去，直到另一个线程抢到

	所以我们需要加锁并使用wait--如果已经执行完成的，调用wait方法，进入休眠状态
```

## 线程池

##### 线程池

```
当前线程使用问题：	
	不管是继承Thread还是遵从Runnable接口，都需要重写Run方法，而且每一个线程对象有且只能执行一次，之后就会被销毁。
	利用Runnable接口来提供执行目标，而借助于Thread执行线程。

现实举例：一个餐厅
	服务人员
	餐厅会按照餐桌比例安排服务员人数。
	每一个服务员我们都可以看做是一个线程对象
	需要告知服务器做什么事情就可以了，相对于告知线程对象执行目标是什么
	==>线程不随执行目标销毁--线程池

线程池 ==> 可以容纳多个线程的容器
	程序可以从线程池获取线程来完成目标代码
	同时也可以将线程归还给线程池。
	省去了创建线程和销毁线程这样非常繁琐的操作。
```

##### 线程池使用

```
 public static ExecutorService newFixedThreadPool(int nThreads);
 	得到一个线程对象，初始化参数是要求的当前线程池中的线程数
 
 public Future submit(Runnable target);
 	从线程池中获取一个线程对象，并且执行给定的Runnable接口实现类对象作为执行目标
```

```java
package com.fs.d_executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread1 implements Runnable {
	@Override
	public void run() {
		System.out.println("Runnable接口实现类，线程目标代码");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName() + "明天吃土豆牛肉");
	}
}

public class Demo1 {
	public static void main(String[] args) {
		// 1. 创建线程对象
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		// 2. 创建一个MyThread1 Runnable接口实现类对象
		MyThread1 target = new MyThread1();
		
		// 3. 使用线程池对象中的一个线程，制定目标代码
		// 初始化线程数为5，这里使用的是线程池中已经存在的5个线程来执行代码
		service.submit(target);
		service.submit(target);
		service.submit(target);
		service.submit(target);
		service.submit(target);
		
		// 因为5个线程都在使用中，这里等待执行完毕，出现空闲线程来执行对应代码
		service.submit(target);
		service.submit(target);
		
		// 4. 关闭线程池
		// 一般不用关闭线程池，会随着程序的退出而关闭
		// services.shutdown();
	}
}
// 注意:可能会出现一定程度的线程抢占
```

##### 3.4 从匿名内部类引入Lambda表达式

```java
package com.qfedu.b_executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo2 {
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(5);

		
		service.submit(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		}); 
			
		// lambda表达式
		service.submit(() -> System.out.println(Thread.currentThread().getName())); 
		service.submit(() -> System.out.println(Thread.currentThread().getName())); 
		service.submit(() -> System.out.println(Thread.currentThread().getName())); 
		service.submit(() -> System.out.println(Thread.currentThread().getName())); 	
	}
}
```

#### 
