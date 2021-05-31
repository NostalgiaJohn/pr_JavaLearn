package com.fs.a_api;

import java.io.IOException;

/*
 * Runtime类演示
 */
public class Demo6 {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		Runtime runtime = Runtime.getRuntime();
		
		System.out.println(runtime.totalMemory());
		System.out.println(runtime.freeMemory());
		System.out.println(runtime.maxMemory());
		
		Process exec = runtime.exec("D:\\Program Files\\Notepad++\\notepad++.exe");
		
		Thread.sleep(5000);
		
		exec.destroy();
		
		runtime.gc();
		
	}
}
