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

