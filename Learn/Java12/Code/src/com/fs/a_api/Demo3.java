package com.fs.a_api;

/*
 * math工具类--抽奖演示
 */
public class Demo3 {
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			double num = Math.random() * 100;
			
			if (0.0 <= num && num < 50) {
				System.out.println("普通卡");
			} else if (50 <= num && num < 80) {
				System.out.println("高端卡");
			} else if (80 <= num && num < 98) {
				System.out.println("传说卡");
			} else {
				System.err.println("史诗卡");
			}	
		}
	}
}
