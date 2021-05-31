package com.fs.a_api;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * 日历/时间类演示
 */
public class Demo4 {
	public static void main(String[] args) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String format = simpleDateFormat.format(new Date());
		
		System.out.println(format);
		
		Calendar calendar1 = Calendar.getInstance();
		
		int year = calendar1.get(Calendar.YEAR);
		int month = calendar1.get(Calendar.MONTH) + 1;
		int day = calendar1.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(year + "-" + month + "-" + day);	
	}
}
