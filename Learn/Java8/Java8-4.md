# Java8·补充知识与面试题

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

![代码块运行流程辨析](https://i.loli.net/2021/05/08/3agov9KmXcnQb2f.png)



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