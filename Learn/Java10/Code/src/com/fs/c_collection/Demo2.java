package com.fs.c_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo2 {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		
		c.add("烤羊排");
		c.add("烧烤");
		c.add("甜点");
		c.add("牛排");
		
		System.out.println(c);
		
		/*
		 * 获取当前集合对应的Iterator迭代器对象
		 */
		Iterator<String> iterator = c.iterator();
		/*
		System.out.println("当前Iterator是否可继续运行：" + iterator.hasNext());
		System.out.println("获取当Iterator指向元：" + iterator.next());
		System.out.println("获取当Iterator指向元：" + iterator.next());
		
		iterator.remove();
		System.out.println(c);
		*/
		/*
		while (iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
		*/
		System.out.println(c);
	}

}
