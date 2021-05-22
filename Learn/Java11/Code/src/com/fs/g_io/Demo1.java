package com.fs.g_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * 文件操作输入字节流
 * 	1. 确认读取哪一个文件
 * 	2. 创建对应文件的FileInputSteam
 * 	3. 读取数据
 * 	4. 关闭资源【重点】
 */
public class Demo1 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		readTest1();
		long end1 = System.currentTimeMillis();
		System.out.println("readTest1()Time :" + (end1 - start));

		readTest2();
		long end2 = System.currentTimeMillis();
		System.out.println("readTest1()Time :" + (end1 - start));
		System.out.println("readTest2()Time :" + (end2- end1));
	}

	private static void readTest2() {
		// 1. 确定操作文件
		File file = new File("G:\\1\\1.txt");
		
		// 2. 字符输入读取文件对象
		FileInputStream fileInputSteam = null;
		
		try {
			// 3. 根据File类对象创建对应的字节输入流
			fileInputSteam = new FileInputStream(file);
			
			// 4. 准备一个8KB字节缓冲数组-->提升速度
			byte[] buf = new byte[1024 * 8];
			int length = -1;
			
			// 5. 读取数据
			while ((length = fileInputSteam.read(buf)) != -1) {
				System.out.println(new String(buf, 0, length));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 在finally代码块中关闭资源
			if (fileInputSteam != null) {
				try {
					fileInputSteam.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/* 
	 * 速度很慢
	 */
	public static void readTest1() {
		// 1. 确定操作文件
		File file = new File("G:\\1\\1.txt");
		
		// 2. 字符输入读取文件对象
		FileInputStream fileInputSteam = null;
		
		
		try {
			// 3. 根据File类对象创建对应的字节输入流
			fileInputSteam = new FileInputStream(file);
			
			// 4. 读取文件
			int content = -1;
			while ((content = fileInputSteam.read()) != -1) {
				System.out.println((char)content);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 用于处理代码中使用到资源，无法发生什么样的错误，finally中的代码一定会执行
			// 这里发现fileInputSteam不是null，证明已经打开了文件资源，关闭资源，捕获异常
			if (fileInputSteam != null) {
				try {
					fileInputSteam.close();
				}catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}	
	}
	
}
