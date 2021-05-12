package com.fs.c_collection;

import java.util.ArrayList;
import java.util.List;

public class Demo4 {
	public static void main(String[] args) {
		// 注意List包为java.util.List
		List<String> list = new ArrayList<String>();
		
		list.add("酱油炒饭");
		list.add("扬州炒饭");
		list.add("黄金炒饭");
		list.add("香菇鸡丁炒饭");
		list.add("蛋炒饭");
		
		System.out.println(list);
		list.add("鱼香肉丝");
		System.out.println(list);
		
		List<String> list2 = new ArrayList<String>();
		
		list2.add("干炒牛河");
		list2.add("西红柿炒饭");
		
		list.addAll(list2);
		System.out.println(list);
		
		System.out.println(list.remove(5));
		System.out.println(list);
		
		String str = list.set(6,"白灼虾");
		System.out.println(str);
		System.out.println(list);
		
		int index = list.indexOf("干炒牛河");
		System.out.println(index);
		
		int lastIndex = list.lastIndexOf("干炒牛河");
		System.out.println(lastIndex);
		System.out.println(list);
		
		// 重点
		// Java中所有范围约束都是要头不要尾
		List<String> subList = list.subList(0, 5);
		System.out.println(subList);
		
	}
}
