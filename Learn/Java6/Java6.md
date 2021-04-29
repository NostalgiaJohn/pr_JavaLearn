# Java6



[toc]

## 数组练习题

#### 找出指定元素在指定数组中所有的下标位置【难点】

限制条件、要求

```
/*
要求：
	a. 不允许在方法内打印展示
	b. 考虑多个数据情况
	c. 需要在方法外获取到下标数据信息
	d. 不允许使用数组作为返回值
*/	
```

解决方法

```java
package com.fs.a_array;

/**
 * 【重点】
 * 
 * @author fStardust
 * 
 */
public class Demo1 {
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 6, 1, 6 , 564, 3 , 4, 5, 2, 7};
		int[] indexArr = new int[arr.length];
		
		int count = allIndexOf(arr, indexArr, 3);
		
		// count=0时，可知输入非法，输出提示
		if (count == 0) {
			System.out.println("没有该值");
		}
		// count是查询到的指定元素个数，同时可以利用循环,在indexArr数组中找到保留的元素--下标
		for (int i = 0; i < count; i++) {
			System.out.println(indexArr[i]);
		}
	}
	/*
	要求：
		a. 不允许在方法内打印展示
		b. 考虑多个数据情况
		c. 需要在方法外获取到下标数据信息
		d. 不允许使用数组作为返回值
	【重点】
		1. 尾插法思想，计数器同时也是下一次存放数据的位置
		2. 数组作为方法参数之后，是可以近似数据传导
		
	方法分析：
		public static 
		返回值类型:
			int 返回找到的指定元素个数
			void 少用黑盒方法
		方法名：
			allIndexOf
			找出所有指定元素的下标位置
		形式参数列表：
			1. 查询数据的源数据数组 int[] arr
			2. 指定查询的元素 int find
			3. 源数据数组容量一致的int类型数组，保存对应的下标位置
			(int[] arr, int[] indexArr, int find)
	思考:
		1. 保存查询数据的下标位置一定会使用到数组
		2. 保存下标的数组数据类型是int类型
	解决方案：
		通过方法为参数形式传入一个数组，int类型，保存找到的下标位置
	思考：
		保存下标的数组容量考虑
	解决方案：
		极值思想：最大容量和源数据数组容量一致
		
	问题：
		如何判断0是有效下标还是无效数据	
	思考：
		需要一个数据，告知找到的数据到底有多少个
		返回值为找到的指定元素的个数，若没有找到，返回0
		
	方法声明：
		public static int allIndexOf(int[] arr, int[] indexArr, int find)
		
	*/	
	/**
	 * 找到指定原数组中所有指定元素所在下标位置，保存到indexArr中，并且返回值是找到的元素个数
	 * 
	 * @param arr 源数据数组，int类型
	 * @param indexArr 找到的下标位置存储数组，要求该数组容量不得小于源数据容量
	 * @param find 需要查询的指定数据
	 * @return 返回值大于0，找到的数据个数，没有找到返回0
	 */
	public static int allIndexOf(int[] arr, int[] indexArr, int find)  {
		// 参数合法性判断
		if (arr.length > indexArr.length) {
			System.out.println("Input Paramter is Invalid!");
			// 参数不合法，返回0--没有找到数据
			return 0;
		}
		
		/*
		 * 定义一个变量
		 * 	1. 计数器，记录找到的元素个数
		 * 	2. 尾插法当中下一次存放元素的位置
		 */
		int count = 0;
		
		// 利用for循环遍历整个源数据arr数组
		for (int i = 0; i < arr.length; i++) {
			// 找到了对应的元素，需要保存下标i
			if (find == arr[i]) {
				// 保存到indexArr数组中
				// 需要使用尾插法！保存下一次存放数据的位置
				indexArr[count] = i;
				// 计数器 += 1
				count += 1;
			}
		}
		
		return count;
	}
	
}
```

【重点】

```
1. 尾插法思想，计数器同时也是下一次存放数据的位置
2. 数组作为方法参数之后，是可以近似数据传导
```

数组作为方法参数的解释

![数组作为方法参数的解释](.\img\数组作为方法参数的解释.png)

对照：无限制条件

```java
package com.fs.a_array;

/**
 * 
 * @author fStardust
 * 
 */
public class Demo {
	public static void main(String[] args) {
		int[] arr = {1, 5, 3, 4534, 3, 4, 6};
		
		allIndexOf(arr, 2);
	}
	
	/*
	 * 要求：
	 * 	返回指定元素在数组中的所有下标
	 * 方法分析：
	 * 	public static
	 * 	返回值
	 * 		没有限制条件，直接在方法中打印元素所在下标
	 * 		void
	 * 	方法名
	 * 		allIndexOf
	 * 	形式参数列表
	 * 		源数据数组，指定元素
	 * 		(int[] arr, int find)
	 * 方法声明：
	 * 	public static void allIndexOf(int[] arr, int find)
	 */
	/**
	 * 简单实现返回指定元素在数组中的所有下标
	 * 
	 * @param arr
	 * @param find
	 */
	public static void allIndexOf(int[] arr, int find) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == find) {
				System.out.println(i);
				count += 1;
			}
		}
		if (count == 0) {
			System.out.println("没有该值");
		}
	}
}

```



