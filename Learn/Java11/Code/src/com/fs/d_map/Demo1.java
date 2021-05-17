package com.fs.d_map;

import java.util.Collection;
import java.util.HashMap;

public class Demo1 {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("吴京", "战狼");
		map.put("黄磊", "暗恋桃花源");
		map.put("刘慈欣", "三体");
		map.put("鲁迅", "狂人日记");
		
		System.out.println(map);
		
		HashMap<String, String> map2 = new HashMap<String, String>();
		
		map.put("海明威", "老人与海");
		map.put("马尔克斯", "百年孤独");
		map.put("孔子", "春秋");
		map.put("老子", "道德经");
		
		map.putAll(map2);
		System.out.println(map);
		
		System.out.println(map.remove("春秋"));
		System.out.println(map);
		
		System.out.println(map.remove("黄磊", "暗恋桃花源"));
		System.out.println(map);
		
		map.put("鲁迅", "呐喊");
		System.out.println(map);
		
		System.out.println(map.containsKey("刘德华"));
		System.out.println(map.containsValue("三体"));
		
		Collection<String> values = map.keySet();
		System.out.println(values);
		
	}
}
