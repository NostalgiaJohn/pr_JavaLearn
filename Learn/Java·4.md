# Java·4



[toc]

# 方法

## 1.方法的好处

```
循环能够解决一部分代码复用的问题，但指标不治本。代码依然会出现一下问题
1. 代码过于臃肿！
2. 阅读性极差！
3. 维护性极差！

```

## 2.main方法

```java
public static void main(String[] args) {
    // 方法体
}
/*
public static --后续讲解
void：返回值类型，这里void表示没有返回值
main：方法名，须符合小驼峰命名法，动宾结构
(String[] args): 形式参数列表
{
	方法体
}

方法的模板：
	public static returnType MethodName(Arguments) {
		Method
	}
	
方法定义的位置，是在class大括号以内，其他方法之外
*/
```

## 3.无参数无返回值方法

```java
/*
需求
	打印一个“烤羊排”
	
方法分析
	public static 固定格式
	返回值类型：void
	方法名：bbq
	形式参数列表：()
	
方法声明：
	
*/
/**
* 打印烤羊排
*/
public static void bbq() {
	System.out.println("烤羊排");
}
```

## 4.有参数无返回值方法

```java
/*
参数:
	当前方法执行所需的外部数据
	例如：登录时需要的账号和密码
	
需求
	展示一个int类型
方法分析：
	public static
	返回值类型：
		void 没有返回值，Syout不是一个展示数据的方式，是一种反馈。
	方法名：
		printIntNumber 见名知意，小驼峰命名
	形参列表：
		需要打印int类型--int num
		
方法声明：
	public static void printIntNumber(int num);

*/

/**
* 展示一个int类型数据
* 
* @param num 要求用户传入一个人int类型数据
*/
public static void printIntNumber(int num) {
    System.out.println("用户提供的int类型数据为：" + num);
}



/*
需求：
	打印两个int类型数据之和
方法分析：
	public static
	返回值类型;
		功能是展示/打印数据，不需要返回值
	方法名：
		printSumOfTwoNumber
	形式参数列表：
		这里需要两个int类型--int num1, int num2
	
方法声明：
	public static void printSumOfTwoNumber(int num1, int num2)
*/
/**
* 打印两个int类型数据的和
*
* @param num1 需要用户提供的int类型数据
* @param num2 需要用户提供的int类型数据
*/
public static void printSumOfTwoNumber(int num1, int num2) {
    System.out.println("Sum : " + (num1 + num2));
}

/*
调用时注意事项：
	1. 带有参数的方法一定要提供对应的数据类型--实际参数
	2. 调用带参方法，给实际参数时，数据类型要一致
	3. 多参数方法中，需要在调用过程中给予对应参数，个数不想允许缺少
	4. 多参数方法中，形参列表中声明的参数类型和实际参数类型必须完全一致，一一对应。
	method(int num1, float num2, char ch, double num3);
	method(10,3.5F,'a',5.5) √
	
*/
```



## 5.无参数有返回值方法



```java
/*
return关键字
	1. 结束当前方法的运行
		方法运行到return时，方法运行结束，return之后的代码不再执行
	2. 可以返回到方法之外的数据
		在return关键字之后的数据，可以返回到方法之外，利用返回值
		
返回值：
	返回值是当前方法对于方法之外提供的数据和表现。
	需要对应返回的数据，声明对应的返回值类型
	
【注意】
	方法中如果需要返回值，必有一个明确的return
	方法中返回值类型是void，那么可以使用return作为方法的结束，但return之后不能有任何数据。
*/

```

