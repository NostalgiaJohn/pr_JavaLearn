package com.fs.d_test;

import com.fs.d_util.MyArrayList;

public class Text2 {
	public static void main(String[] args) {
		MyArrayList<String> list1 = new MyArrayList<String>();
		
		list1.add("牛肉");
		list1.add("羊肉");
		list1.add("羊肉");
		list1.add("鸡肉");
		list1.add("鸭肉");
		
		MyArrayList<String> list2 = new MyArrayList<String>();
		list2.add("羊肉");
		list2.add("鸡肉");
		
		System.out.println(list1.containsAll(list2));
	}
}
