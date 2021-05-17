# Set集合

[toc]

## Set集合概述

```
特征：
	无序，不可重复
	
	无序：添加顺序和存储顺序不一致,【不代表有排序效果】
	不可重复: 在一个Set集合中不能出现相同元素

interface Set<E> 
--| class HashSet<E> 底层是哈希表存储数据
--| class TreeSet<E> 底层存储数据是一个二叉树
```

#### HashSet结构

![哈希表存储原理](https://i.loli.net/2021/05/15/atkidoNjne97CXv.png)

###### 代码

```java
package com.fs.b_set;

import java.util.HashSet;

public class Demo2 {
	public static void main(String[] args) {
		HashSet<Person> hashSet = new HashSet<Person>();
		
		Person P1 = new Person(1, "foo", 10);
		Person P2 = new Person(2, "faa", 20);
		Person P3 = new Person(3, "fbb", 30);
		Person P4 = new Person(4, "fcc", 40);
		/*
		 * 当前这里两个元素，ID一样==> hashCode值是一致的，会通过底层哈希表运算保存在同一个单元格位置
		 * 这里会通过equals方法，比较两个对象是否一致，来决定是否能够保存
		 * 如果两个对象一致，则无法保存
		 * 
		 * 期望每一个哈希表单元格内保存的数据是唯一的
		 */
		Person P5 = new Person(5, "fdd", 40);
		Person P6 = new Person(5, "fee", 44);
		
		
		hashSet.add(P4);
		hashSet.add(P1);
		hashSet.add(P2);
		hashSet.add(P3);
		hashSet.add(P5);
		hashSet.add(P6);
		
		System.out.println(hashSet);
	}
}

```

#### TreeSet树形结构

![Tree树形结构图例](https://i.loli.net/2021/05/15/fVt2reR75kuCBFS.png)

#### TreeSet存储方式

【注意】没有比较方式无法存储

```java
package com.fs.b_set;

import java.util.TreeSet;

public class Demo4 {
	public static void main(String[] args) {
		// 存储自定义数据类型
		/*
		 * Exception in thread "main" java.lang.ClassCastException: 
		 * 	com.fs.b_set.Person cannot be cast to java.lang.Comparable
		 * 提示当前Person类不能强转成Comparable类型，也就是说当前Person类没有
		 * 比较方式
		 * 
		 * 有两种方式可以提供比较方式:
		 * 		1. Comparable<T>接口
		 * 		2. Comparator<T>接口
		 */
		TreeSet<Person> set = new TreeSet<Person>();
		
		Person p1 = new Person(1, "foo", 10);
		Person p2 = new Person(2, "faa", 5);
		Person p3 = new Person(3, "fbb", 30);
		Person p4 = new Person(4, "fcc", 30);
		
		set.add(p1);
		set.add(p2);
		set.add(p3);
		set.add(p4);
	
		System.out.println(set);
	}
}

```

#### Comparable接口使用

```
interface Comparable<T> {
	int compareTo(T t);
}

方法参数为T类型，由实现类遵从接口时约束，
	compareTo方法，返回值类型int类型，0, 负数，正数
	0 表示两个元素一致，如果在TreeSet中比较结果为0，表示同一个元素，无法存储第二个。

Comparable接口由存储元素对应的类遵从，完成该方法
```

#### Comparator接口使用

```
可以用于匿名内部类和Lambda表达式
interface Comparator<T> {
	int compare(T o1, T o2);
}
需要完成一个自定义比较器类对象，
	int 返回值 0，负数，正数
	0 表示两个元素一致，如果在TreeSet中比较结果为0，表示同一个元素，无法存储第二个。
```

**Comparator使用要高于Comparable使用**

