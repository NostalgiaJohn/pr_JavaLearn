package com.fs.g_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 文件操作输出字节流
 * 		1. 确定文件
 * 		2. 创建FileOutputStream
 * 		3. 写入数据到文件中
 * 		4. 关闭资源 
 */
public class Demo2 {
	public static void main(String[] args) {
		writeTest2();
	}

	public static void writeTest2() {
		// 1. 确定文件
		File file = new File("C:/aaa/中国加油.txt");
		
		// 2. 文件操作字节输出流对象
		FileOutputStream fileOutputStream = null;
		
		try {
			// 3. 创建FileOutputStream 
			fileOutputStream = new FileOutputStream(file);
			
			// 4. 准备byte类型数组
			byte[] bytes = "中国加油！".getBytes();
			byte[] arr = {65, 66, 67, 68, 69, 70, 71};
			
			fileOutputStream.write(bytes);
			fileOutputStream.write(arr, 2, 3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭资源
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void wrietTest1() {
		// 1. 确定文件
		File file = new File("C:/aaa/加油.txt");
		
		// 2. 文件操作字节输出流对象
		FileOutputStream fileOutputStream = null;
		try {
			// 3. 创建FileOutputStream
			fileOutputStream = new FileOutputStream(file, true);
			
			// 4. 写入数据
			fileOutputStream.write('D');
			fileOutputStream.write('D');
			fileOutputStream.write('D');
			fileOutputStream.write('D');
			fileOutputStream.write('D');
			fileOutputStream.write('D');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭资源
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	} 
}










