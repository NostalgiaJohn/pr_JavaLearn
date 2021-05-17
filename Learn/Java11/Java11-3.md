# Map和File类

[toc]

## Map双边队列

#### Map是什么

```
键(Key)值(Value)对--1对1的关系
	吴京=战狼

	表格：
        姓名：张三
        年龄：16
        性别：男
	
程序开发大部分数据都是键值对形式的
	MySQL JSON XML 类对象成员变量和存储的数据
	从前端发送的数据也可以转成Map格式 ==> 一键生成生成的类对象 ==> 一键存储入数据库
	
interface Map<K, V>
--| class HashMap<K, V> 哈希表结构
--| class TreeMap<K, V> 底层是树形结构，存储要求K有对应的排序方式
	Map双边队列中键(Key)是唯一的，但是值(Value)可以重复
```

#### Map双边队列方法

```
增
	put(K k, V v);
		存入一个键值对类型， K和V都要符合泛型约束
	putAll(Map<? extends K, ? extends V> map);
		存入另一个Map双边队列，并且要求添加的Map双边队列对接中的K和V都要和当前Map中存储的K和V一致
删
	remove(Object k);
		删除对应的键值对	
改
	put(K k, V v);
		对应的K存在，修改V
查
	int size();
		当前Map双边队列中，有效键值对个数
	boolean containsKey(Object key);
		判断指定Key值是否存在
	boolean containsValue(Object value);
		判断指定value值是否存在
	Set<K> keySet();
		返回整个Map双边队列中所有Key对应的Set集合
		【注意】一个方法使用set结尾，表示改方法返回的是一个集合类型，大多数情况是set
	Collection<V> values();
		返回整个Map双边队列中所有Value对应的Collection集合
		【注意】方法名如果是一个复数，返回值类型集合或者是数组的情况居多
		
```

#### EntrySet

```
Entry 可以认为是键值对对象
定义在Map类内
	class Entry<K, V> {
		K k;
		V v;
	}
	K,V是完全依赖于Map约束的，这里可以Entry里面保存的是每一个键值对类对象

Map中提供了一个方法
	Set<Map.Entry<K, V>> entrySet
	返回值是键值对类对象Set集合
	Set集合中存储的是Entry类型
	Entry类型是带有泛型的
```

###### 代码

```java
package com.fs.d_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo2 {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("吴京", "战狼");
		map.put("黄磊", "暗恋桃花源");
		map.put("刘慈欣", "三体");
		map.put("鲁迅", "狂人日记");
		
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		
		System.out.println(entrySet);
		
	}
}

```

#### `TreeMap<K, V>` 以及`Comparable`和`Comparator`

```
K是需要有对应的比较方式，如果没有比较方式，无法存入。

推荐使用Comparator接口
```

代码

```java
package com.fs.d_map;

import java.util.Comparator;
import java.util.TreeMap;

public class Demo3 {
	public static void main(String[] args) {
		TreeMap<String, String> map = new TreeMap<String, String>();
		
		map.put("faa", "1");
		map.put("fbb", "1");
		map.put("fcc", "1");
		map.put("fdd", "1");
		
		System.out.println(map);
		
		TreeMap<Dog, String> map2 = new TreeMap<Dog, String>(new Comparator<Dog>() {

			@Override
			public int compare(Dog o1, Dog o2) {
				return o1.getAge() - o2.getAge();
			}
			
		});
		
		map2.put(new Dog("八公", 2),"111");
		map2.put(new Dog("旺财", 5),"111");
		
		System.out.println(map2);
	}
}

```

