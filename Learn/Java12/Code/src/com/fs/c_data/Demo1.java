package com.fs.c_data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Demo1 {
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
