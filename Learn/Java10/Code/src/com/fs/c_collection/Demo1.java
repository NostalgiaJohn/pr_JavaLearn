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
