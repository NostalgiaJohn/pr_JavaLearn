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
