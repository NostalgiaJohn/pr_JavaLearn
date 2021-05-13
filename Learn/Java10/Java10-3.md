# Java10-3·集合

[toc]

### 使用集合的原因

```
开发中会使用大量相同数据类型的情况
	
如果用数组来解决：
	1. 数组能够使用的方法非常少，功能方法需要程序员自己完成
	2. 数据类型单一化不支持多种情况
	3. 数组容量不可以直接修改
	
使用的集合的好处
	1. 方法多种多样，基本功能完善
	2. 数据类型支持多样化，但同样要求数据类型一致
	3. 容量可变，不用开发者操心
```

#### 集合架构

​	Java中集合的【总接口】`Collection<E>`。Java中所有和集合有关的内容，都是`Collection<E>`接口的子接口或者实现类

```
interface Collection<E>
--| interface List<E> 
	List接口，有序可重复
----| class ArrayList<E>
	【重点】可变长数组结构
	原码实现，了解其中的特征，性能....
----| class LinkedList<E>
	【重点】双向链表结构
----| class Vector<E>
	【远古时代】JDK1.0 线程安全的ArrayList<E>，如果不考虑线程安全问题，建议使用ArrayList<E>
		
--| interface Set<E> Set
	接口，无序不可重复
----| HashSet<E> 
	底层存储数据的方式是采用哈希表方式
----| TreeSet<E> 
	底层存储数据的方式一个平衡二叉树方式
```

##### `Collection<E>`接口下的常用方法【重点】

```
增：
	boolean add(E e); 
		存入元素到当前集合对象中，这里要求数据类型是E类型，也就是泛型的具体数据类型
	boolean addAll(Collection<? extends E> c);
		class Dog extends Animal...
		==> ? extends E 泛型的上限
		要求存入的集合c中，存储的元素要么是E类型，要么是E类型的子类
		
删：
	void clear();
		清空整个集合
	boolean remove(object obj);
		删除集合中的指定元素
	boolean removeall(Collection<?> C);
		删除两个集合的交集
	boolean retianAll(Collection<?> C);
		保留两个集合的交集
		
查：
	int size();
		返回集合中的有效元素个数
	boolean isEmpty();
		判断当前集合是否为空
	boolean contains(Object obj);
		判断指定元素在当前集合中是否存在
	boolean containsAll(Collection<?> C);
		判断集合C是不是当前集合的子集合

```

代码演示

```java
package com.fs.c_collection;

import java.util.ArrayList;
import java.util.Collection;

public class Demo1 {
	public static void main(String[] args) {
		/*
		 * 因为Collection<E>使用一个接口，接口没有自己的类对象
		 * 这里使用Collection接口的实现类来完成演示过程ArrayList<E>
		 */
		Collection<String> c = new ArrayList<String>();
		
		c.add("82年的可乐");
		c.add("82年的北冰洋");
		c.add("82年的凉白开");

		System.out.println(c);
		
		Collection<String> c1 = new ArrayList<String>();
		
		c1.add("伏特加");
		c1.add("生啤");
		
		c.addAll(c1);
		
		System.out.println(c);
		
		c.remove("82年的可乐");
		System.out.println(c);
		
		// c.removeAll(c1);
		// System.out.println(c);
		
		// c.retainAll(c1);
		// System.out.println(c);
		
		System.out.println("size:" + c.size());
		// c.clear();
		System.out.println(c.isEmpty());
		
		System.out.println(c.contains("生啤"));
		System.out.println("哈尔滨");
		
		System.out.println(c.containsAll(c1));
		
		c1.add("桂花酿");
		System.out.println(c.containsAll(c1));
	}
}


```

输出：

```
[82年的可乐, 82年的北冰洋, 82年的凉白开]
[82年的可乐, 82年的北冰洋, 82年的凉白开, 伏特加, 生啤]
[82年的北冰洋, 82年的凉白开, 伏特加, 生啤]
size:4
false
true
哈尔滨
true
false
```

#### 迭代器

```
通过集合对象获取对应的Iterator<E>迭代器
	Iterator<E> iterator();
常用方法：
	boolean hasNext();
		判断当前Iterator是否可以继续运行。
	E next();
		获取Iterator当前指向元素，并且指向下一个元素。
	void remove();
		删除
	【注意】
		1. remove方法有且只能删除通过next方法获取的元素
		2. remove方法如果想要使用，必须紧挨着next方法
```

代码

```java
package com.fs.c_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo3 {
	public static void main(String[] args) {
		ArrayList<String> c = new ArrayList<String>();

		c.add("烤羊排");
		c.add("油焖大虾");
		c.add("土豆牛肉");
		c.add("黄焖鸡米饭");
		c.add("麻辣香锅");
		c.add("孜然肉片");
		c.add("酸汤肥牛");
		
		Iterator<String> iterator = c.iterator();
		
		iterator.next();
		
		
		/*
		 * 错误信息:ConcurrentModificationException
		 * Iterator在创建的过程中，会对整个集合所有元素打招呼，记录每一个元素位置。
		 * Iterator在执行next方法过程中，会按照初始条件一个一个遍历
		 * 当前集合通过remove方法，删除已经被Iterator记录的元素时，会导致Iterator出错！
		 * 这里就会发生冲突！
		 * 
		 * 这里因为集合中元素，对于集合本身和当前Iterator而言是一个共享资源
		 * 不管是哪一方操作元素，都存在影响对方操作的情况。【共享资源冲突问题】
		 * 
		 * ArrayList存储元素不是连续的吗，土豆牛肉删除了，他的位置不是会被后面的元素顶上来吗
		 */
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			
			// 这里通过集合删除土豆牛肉元素
			// 后期代码中会出现很多相同名字方法，这里一定要注意！！！
			// 调用当前方法的是哪一个
			c.remove("酸汤肥牛");
		}
		
	}
}
```

![Iterator出现并发错误原因](https://i.loli.net/2021/05/12/QIbSe3jMwhyt5DP.png)

### list

#### `list<E>`集合接口特征和方法

```
特征:
	有序，可重复
	有序: 添加顺序和存储顺序一致
	可重复：相同元素可以同时添加
	List<E>接口下的实现类，存在一定的下标操作机制
		ArrayList<E> 底层数组形式操作，可以通过下标直接访问
		LinkedList<E> 底层是一个双向链表结构，下标 ==> 计数器
特定的方法：
	增:
		add(E e);
			List接口下，当前方法是添加元素到集合的末尾，尾插法
		addAll(Collection<? extends E> c);
			List接口下，当前方法是添加另一个集合到当前集合末尾，要求添加的集合中保存的元素和当前集合保存元素一致，或者说是当前集合保存元素的子类
		add(int index, E e);
			在指定的下标位置，添加指定元素
		addAll(int index, Collection<? extends E> c);
			在指定的下标位置，添加指定的集合，集合要求同上一个addAll方法
	删:
		void clear();
			清空整个集合
		remove(Object obj);
			删除集合中的指定元素
		removeAll(Colletion<?> c);
			删除两个集合的交集
		retainAll(Colletion<?> c);
			保留两个集合的交集
		
		E remove(int index);
			删除集合中指定下标的元素。返回值是被删除的元素
	改:
		E set(int index, E e);
			使用指定元素替换指定下标index的元素，返回值是被替换掉的元素。
	查:
		int size();
			有效元素个数
		boolean isEmpty();
			判断当前集合是否为空
		boolean contains(Object obj);
		boolean containsAll(Collection<?> c);
		
		int indexOf(Object obj);
			找出指定元素在集合中的第一次出现位置
		int lastIndexOf(Object obj);
			找出指定元素在集合中最后一次出现位置
		E get(int index);
			获取指定下标的元素
		List<E> subList(int fromIndex, int endIndex);
			获取当前集合的子集合
			【特征】
				获取数据的范围是 fromIndex <= n < endIndex  要头不要尾
```

#### ArrayList可变长数组

```
特征：
	数组形式的操作方式，查询效率高，但是删除，增加效率低。
	数组:
		Object类型数组
方法:
	ArrayList使用的方法基本上都是从List接口中遵从实现的方法。
	特征:
		ensureCapacity(int minCapacity);
			判断当前容量是否足够
		trimToSize();
			截断整个数组容量 ==> size有效元素个数
			时间换空间，空间换时间

自定义实现的ArrayList	
	Constructor构造方法
	
	add(E e);
	add(int index, E e);
	addAll(自定义ArrayList<E> e)
	addAll(int index,自定义ArrayList<E> e)	
	remove(Object obj);
	remove(int index);
	set(int index, E);
	E get(int index);
	int indexOf();
	int lastIndexOf();
	boolean contains(Object obj);
	boolean containsAll(自定义ArrayList类型 list)
	boolean isEmpty();
	int size();
	自定义ArrayList subList(int fromIndex, int endIndex);
	Object[] toArray();
```

详细代码请见：[MyArrayList.java](.\Code\src\com\fs\d_util\MyArrayList.java) 

测试代码请见：[Test.java](.\Code\src\com\fs\d_test\test.java)

#### ArrayList性能问题

##### 增删慢

```
增加：
	1. 增加元素时有可能出现调用grow方法，grow需要进行数组的扩容操作，扩容过程中需要大量的移动和拷贝操作，浪费时间
	2. 在某一个位置添加元素，会导致从指定位置开始，之后的元素整体向后移动，涉及到移动赋值操作，浪费时间

删除：
	1. 按照ArrayList可变长数组要求，删除元素之后，之后的内容都需要整体向前移动
	
```

##### 补充知识点-内存

```
内存中的地址
      1. 内存中的最小单元 字节
      2. 计算机为了记录标记每一个字节的内存，给内存进行了编号
      3. 精确查询，唯一性
      4. 计算机内存按照字节，一个字节对应一个地址，从0开始编号 到 34359738367 (32G
      内存)
      5. 计算机通过内存编号访问对应的内存，效率是非常高的！！！
      6. 按照十进制表示地址编号，效果很差。 这里引入16进制 0x0 ~ 0x7 FFFF FFFF
      
null到底是谁?
     null ==> 0x0 内存中编号为0的地址
     该地址受到系统保护，任何程序读取，写入0x0地址，系统直接杀死程序
     一般用于在开发中初始化引用数据类型的变量，利用null报错。NullPointerException
```

##### 查询快

![数组地址内存分析图](https://i.loli.net/2021/05/13/BSXWQTzoCEPxIdR.png)

### LinkedList

#### LinkedList

```
底层是一个双向链表
	链子 自行车链子 船锚
	
	自行车链子 
		维修很方便，取出损坏位子，前后链接搞定！！！ 
		需要一个一个来找到损坏的位置

链表结构
	1. 增删快
	2. 查询很慢很慢很慢
```

![双向链表结构图例](https://i.loli.net/2021/05/13/4ulzQnmWAr1i32q.png)

#### LinkedList需要了解的方法

```
LinkedList使用的方法，大部分都是从List接口中遵从实现的方法
但是有一些特征方法
	addFirst(E e);
	addLast(E e); ==> add(E e);
	
	E getFirst();
	E getLast();
	
	removeFirst();
	removeLast();

以上方法组合可以完堆栈队列操作
	堆
		先进后出（堆栈操作）
		addLast(E e); E getLast(); removeLast();
	队列
		先进先出
		addLast(E e); E getFrist(); removeFirst(); 
```

#### 自定义完成MyLinkedList

##### 节点

```
a. 向前的引用
b. 存储元素的引用
c. 向后的引用

class Node {
	private Node prev;
	private Node next;
	private Object value;
	
	// 构造方法存储元素，加入链接
}
```

##### 管理节点的MyLinkedList

```
a. 链表头！！！
b. 当前链表中有多少个元素。

class MyLinkedList<E> {
	private Node first;
	
	private int size;
}

要求实现的方法:
	add(E e);
	addFirst(E e);
	addLast(E e);
	E getFirst();
	E getLast():
	E get(int index);
	removeFirst();
	removeLast();	
	remove(int index);
	remove(Object obj);
    E set(int index, E);
    size();

```

