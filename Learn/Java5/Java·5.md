

# Java·5

[toc]

# 数组

## 认识数组

#### 生活中的数组

```
图书馆存储书籍：
	存放《数电》十本
	1. 在同一书架上
	2. 是连续存储的
	3. 每一本都是由独立编码的，编码由规律可循
```

#### 开发中数据存储问题

```
开发中可能存在什么情况下，相同数据类型需要大量使用的情况，按照目前我们所学的方式，中就会出现很多行的变量定义。会出现以下问题
	1. 代码过于臃肿
	2. 代码阅读性极差
	3. 数据维护性极差
	4. 数据没有复用性可言，操作繁琐
	
参考图书馆存放图书的方式来使用数组完成操作
	1. 同样的数据类型
	2. 数据的存储时连续的
	3. 每个数据都是一个独立编号，但有同意名字
```

#### Java如何定义数组

```java
数据类型[] 数组名 = new 数据类型[]容量;
/*
赋值号左侧
	数据类型：
		告知编译器，当前数组中能够保存的数据类型是什么？
		指定数据类型后，整个数组中保存的数据类型无法更改。
	[]:
		1. 告知编译器这里的是一个数组类型数据
		2. 明确告知编译器，数组名是一个【引用数据类型】
	数组名：
		1. 操作数据非常重要的数据
		2. 数组名是一个【引用数据类型】
		小拓展：int(*) (void *, void *)
赋值号右侧：
	new： 
		申请【XX】内存空间，并且清空整个内存空间中所有的二进制，所有的二进制位都是0
	数据类型：
		前呼后应
	[容量]:
		容量==> Capacity
		告知编译器，当前数组中能够存放对应数据类型的数据，最大能存储多少个！
		【注意】一旦确定容量，针对当前数组，后期容量无法修改。
*/
```

#### 数组下标【重点】

```
数组中的下标从0开始，到数组容量 - 1

例如：
	数据容量位10
	有效下标范围：0~9
	超出有效下标，为无效下标。后期考虑数组处理异常问题；负数使用问题。
	
操作会出现的问题：
	1. 数组下标越界
	ArrayIndexOutOfBoundsException
	
```

###### 数组内存分析图

![数组内存分析图](https://i.loli.net/2021/04/26/xgulJ3f26hvMTjL.png)

#### 【补充知识点】引用数据类型

```
生活中
	文章中出现了对其他文章的引用操作，会存在对应角标，用于在文章中进行跳转操作
	
开发中引用数据类型
	用于保存其他内存空间的首地址，保存地址后，CPU可以通过对应的引用数据类型，得到对应的地址，从而访问地址对应空间
	
```

#### 数组和循环的关系

```java
/*
获取数组容量的方式
	数组名.length 属性
	当前数组的属性length是要占用一定的数组空间的，属于数组中的内容，这就是数组占用的空间要比存储数据计算空间略大一些。
	
*/
```

#### 数组地址转移问题

```java
class Demo3 {
	public static void main(String[] args) {
		int[] arr1 = new int[10];
		int[] arr2 = new int[10];
		
		arr1[5] = 100;
		arr2[5] = 500;
		
		System.out.println(arr1[5]);
		System.out.println(arr2[5]);
		
		arr1 = arr2;
		arr1[5] = 2000;
		
		System.out.println(arr1[5]); 
		System.out.println(arr2[5]); 
	}
}
```

![数组地址转移问题](https://i.loli.net/2021/04/26/OMXkrUNaHLWqub3.png)



#### 数组和方法之间的关系

```java
/*
Java中数组成为方法的参数以及使用方式
*/
public static viod main(String[] args) {}
/*
格式：
	public static returnType methodName(arrayType[] arrayName)
	arrayName是一个数组类型变量，引用数据类型的变量
*/
```

###### 相关代码

```java
class Demo4{
	public static void main(String[] args) {
		int[] array = new int[10];
		
		// 调用赋值数组中元素的方法
		// 调用参数是一个数组类型的方法，需要传入的内容是数组名
		assignIntArray(array);
		printIntArray(array);
	}
	
	/*
	需求：
		赋值一个int类型数组
	方法分析：
		public static
		返回值类型:
			void 无返回值
		方法名：
			assignIntArray
		形式参数列表;
			需要一个int类型数组
			(int[] arr)
	方法声明：
		public static void assignIntArray(int[] arr)
	*/
	/**
	* 赋值一个指定的int类型数组
	* 
	* @param arr 这里需要的参数是一个int类型数组
	*/
	public static void assignIntArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
	}
	
	/*
	需求：
		展示一个int类型数组中保存的数据
	方法分析：
		public static
		返回值类型:
			void 无返回值
		方法名：
			printIntArray
		形式参数列表;
			展示一个int类型数组中保存的数据
			(int[] arr)
	方法声明：
		public static void printIntArray(int[] arr)
	*/
	/**
	* 展示一个int类型数组中保存的数据
	* 
	* @param arr 这里需要一个int类型数组
	*/
	public static void printIntArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("array[" + i +"]=" + arr[i]);
		}
	}
	
}

```

## 数组算法练习

<center>所有数组都使用int类型</center>

#### 完成一个数组逆序过程

```java
/*
静态数组
	int[] arr = {1,7,3,5,9};
	逆序完成：
		{9,5,3,7,1}
方法的分析：
	public static
	返回值类型:
		void
	方法名：
		逆序 reverse
	形式参数列表：
		int[] arr
方法声明;
	public static void reverse(int[] arr)
*/

/**
* 完成对于int类型数组的逆序过程
* 
* @param arr int 类型数组
*/
public static void reverse(int[] arr) {
    for (int i = 0; i < arr.length / 2; i++) {
        int temp = 0;
        /*
        arr[0] = arr [9]
        交换
        */
        temp = arr[i];
        arr[i] = arr[arr.length - 1 -i];
        arr[arr.length - 1 -i] = temp;
    }
}
```

#### 得到数组最大值下标

```java
class ArrayMethod2 {
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7, 19, 2, 4, 19, 8, 10};
		
 		int index = maxIndexOf(arr);
		System.out.println("index:" + index);
	}
	
	/*
	需求
		从int类型数组中找出对应的最大值下标位置
	方法分析:
		public static 不要问
		返回值类型：
			数组的下标数据类型是int类型
			int
		方法名:
			maxIndexOf
		形式参数列表：
			(int[] arr)
	方法声明：
		public static int maxIndexOf(int[] arr)
	*/

	/**
	* 返回指定int类型数组中最大值的下标位置
	*
	* @param arr int类型数组
	* @return 返回值是最大值所在的下标位置
	*/
	public static int maxIndexOf(int[] arr) {
		// 首先：假定下标为0的元素是数组中最大值
		int maxIndex = 0;
		
		// 因为循环过程中，下标为0的元素没有必要和自己比较
		// 循环变量从1开始
		for (int i = 1; i < arr.length; i++) {
			/*
			如果发现maxIndex保存的下标对应元素，是小于i的
			保存对应的i值
			*/
			if (arr[maxIndex] < arr[i]) {
				maxIndex = i;
			}
		}
		
		return maxIndex;
	}
}


```

#### 得到数组指定元素下标

返回值中应该考虑数据找不到的情况，返回时应该考虑普通用户的使用。

```java
class ArrayMethod3 {
	public static void main(String[] args) {
		int[] arr = {1,3,453};
		
		int index = indexOf(arr,324);
		if (index >= 0) {
			System.out.println("index:" + index);
		} else {
			System.out.println("Not Found");
		}
		
	}
	/**
	* 找出指定数组中，指定元素的下标位置，并通过返回值返回
	* 
	* @param arr 指定的int类型数据数组
	* @param find 指定需要查询的数据
	* @return 返回值大于等于0；-1表示未找到对应数据
	*/
	public static int indexOf(int[] arr, int find) {
		
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (find == arr[i]) {
				index = i;
				break;
			}
		}
		
		return index;
	}
}
```

#### 给出指定下标的元素

现在不能用-1作为范围超标的提示，考虑终止方法，并告知用户错误。

```java
class ArrayMethod4 {
	public static void main(String[] args) {
		int[] arr = {1,23,4,534,87};
		System.out.println(get(arr, 2));
	}
	/**
	* 找出数组指定下标的元素
	* 
	* @param arr 指定的int类型数组
	* @param int 指定查询的下标位置
	* @return 返回对应下标的元素
	*/
	public static int get(int[] arr, int index) {
		if (index < 0 || index > arr.length - 1) {
			System.out.println("Input Parameter is Invalid");
			System.exit(0); // 退出方法
		}
		
		return arr[index];
	}
	
}
```

