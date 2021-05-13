package com.fs.d_test;

import com.fs.d_util.MyArrayList;

public class Test1 {
	public static void main(String[] args) {
		MyArrayList<String> list1 = new MyArrayList<String>();
		
		list1.add("牛肉");
		list1.add("羊肉");
		list1.add("鸡肉");
		list1.add("鸭肉");
		
		MyArrayList<String> list2 = new MyArrayList<String>();
		
		list2.add("酸汤肥牛");
		list2.add("荷叶白羊");
		list2.add("叫花鸡");
		list2.add("老鸭煲");
		
		System.out.println(list1);
		System.out.println(list2);
		
		list1.addAll(list2);
		System.out.println(list1);
		
		list1.remove(3);
		System.out.println(list1);
		
		list1.remove("叫花鸡");
		System.out.println(list1);
		
		System.out.println(list1.contains("满汉全席"));
		
		System.out.println(list1.get(0));
		
		System.out.println(list1.size());
		
		System.out.println(list1.indexOf("酸汤肥牛"));
		System.out.println(list1.lastIndexOf("羊肉"));
		
		MyArrayList<String> subList = list1.subList(0, 5);
		System.out.println(subList);
		
		System.out.println(list1.set(4, "佛跳墙"));
		System.out.println(list1);
		
		list1.addAll(1,list2);
		System.out.println("------------------");
		System.out.println(list1);
	}
}
