# Java10-3·集合

[toc]

#### 使用集合的原因

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

