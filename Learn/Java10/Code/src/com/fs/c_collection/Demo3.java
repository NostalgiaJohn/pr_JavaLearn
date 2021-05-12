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