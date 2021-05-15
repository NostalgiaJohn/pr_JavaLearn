package com.fs.b_set;

import java.util.TreeSet;

public class Demo3 {
	public static void main(String[] args) {
		/*
		 * 目前存储的数据类型Integer类型存在自然顺序
		 * 
		 * 字符串顺序是字典顺序
		 * 	1, 10,11, 2, 3, 4, 5, 6, 7, 8, 9, ...
		 * 
		 */
		TreeSet<Integer> treeSet = new TreeSet<Integer>(); 
		
		treeSet.add(3);
		treeSet.add(1);
		treeSet.add(2);
		treeSet.add(4);
		treeSet.add(5);
		treeSet.add(6);
		
		System.out.println(treeSet);
		
	}
}
