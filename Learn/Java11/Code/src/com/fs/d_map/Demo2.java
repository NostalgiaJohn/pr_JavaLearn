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
