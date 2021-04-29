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

#### 在指定位置插入指定元素

要求和限制条件

```java
/*
存在一个数组，数组中的元素为
	int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 0};
	要求
		1. 0是无效元素，仅占位使用
		2. 当前数组中【有效元素】个数为9
	需求
		在该数组中的指定下标位置放入指定元素
【重点】
	1. 空数据，无效数据思想
	2. 数据的移动过程，粗加工，细打磨过程
	3. 时间消耗问题
*/
```

代码解决

```java
package com.fs.a_array;

import java.util.Arrays;

public class Demo2 {
	public static void main(String[] args) {
		int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 0};
		
		add(array, 5, 20);
		
		// 打印数组元素的值
		System.out.println(Arrays.toString(array));
	}
	
	/*
	存在一个数组，数组中的元素为
		int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 0};
		要求
			1. 0是无效元素，仅占位使用
			2. 当前数组中【有效元素】个数为9
		需求
			在该数组中的指定下标位置放入指定元素
	思考：
		在数组下标为n的位置插入元素，从下标n之后的元素整体向右移动
		从最后一个有效元素开始向后覆盖 --> arr[i] = arr[i-1]
		后置赋值，防止有效数据被覆盖
	【重点】
		1. 空数据，无效数据思想
		2. 数据的移动过程，粗加工，细打磨过程
		3. 时间消耗问题
		
	方法分析:
		pubilc static
		返回值类型：
			void 可用，但不推荐
			boolean 可以 表示插入成功与否
			int 可以 但返回值含义的约束较麻烦
		方法名:
			add
		形式参数列表：
			1. 需要插入数据的数组
			2. 指定插入数据的下标位置
			3. 指定插入的数据
			(int[] arr, int index, int insert)
	方法声明：
		public static boolean add(int[] arr, int index, int insert)
	*/
	/**
	 * 在指定的数组中，指定位置插入指定元素
	 * 
	 * @param arr 指定的int类型数组
	 * @param index 指定的下标位置，必须在合理的区间范围内
	 * @param insert 指定插入的元素，int类型
	 * @return 添加成功返回true，否则返回false
	 */
	public static boolean add(int[] arr, int index, int insert) {
		// 参数合法性判断
		if (index < 0 || index > arr.length - 1) {
			System.out.println("Input Parameter is Invaliad");
			// 方法运行失败
			return false;
		}
		
		for (int i = arr.length - 1; i > index; i--) {
			arr[i] = arr[i - 1];
		}
		
		arr[index] = insert;
		
		return true;
	}
}

```

#### 对照上题：删除数组中的指定下标的元素

要求以及限制条件

```java
/*
存在一个数组，数组中的元素为
	int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
	要求:
		1. 0是无效元素，仅占位使用
	需求:
		在当前数组中删除指定下标的元素
	例如:
		指定下标5
		结果 {1, 3, 5, 7, 9, 13, 15, 17, 19, 0} 
		0占位！！！
*/
```

代码解决

```java
package com.fs.a_array;

import java.util.Arrays;

public class Demo3 {
	public static void main(String[] args) {
		int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
		
		remove(array, 3);
		
		System.out.println(Arrays.toString(array));
	}
	
	/*
	存在一个数组，数组中的元素为
		int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
		要求:
			1. 0是无效元素，仅占位使用
		需求:
			在当前数组中删除指定下标的元素
		例如:
			指定下标5
			结果 {1, 3, 5, 7, 9, 13, 15, 17, 19, 0} 
			0占位！！！
	思考：
		将下标为n的元素从数组中移除，下标n之后的元素整体向左移动
		从n后一个有效元素开始向前覆盖 --> arr[i] = arr[i+1]
		前置赋值，并在最后补上占位元素--0
	方法分析：
		public static
		返回值类型:
			boolean
		方法名：
			remove
		形式参数列表:
			1. 删除数组的数组
			2. 指定删除数据的下标位置
	方法声明：
		public static boolean remove(int[] arr, int index)
	*/
	/**
	 * 删除数组中指定下标元素的内容
	 * @param arr 源数据数组，int类型
	 * @param index 指定删除的下标位置
	 * @return 删除操作成功返回true 失败返回false
	 */
	public static boolean remove(int[] arr, int index)  {
		// 参数合法性判断
		if (index < 0 || index > arr.length - 1) {
			System.out.println("Input Parameter is Invalid");
			return false;
		}
		
		for (int i = index; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}
		//
		arr[arr.length - 1] = 0;
		return true;
	}
}

```

#### 相接三题-数组排序准备

 找出数组中最大值元素，放到指定位置

```java

```

 接上一题，找出数组中剩余元素的最大值，放到下标为1的位置

```java

```

再接上一题，找出数组中剩余元素的最大值，放到下标为2的位置

```java

```

