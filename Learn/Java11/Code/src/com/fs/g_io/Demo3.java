package com.fs.g_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 文件拷贝操作
 */
public class Demo3 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		copyTest2();

		long end = System.currentTimeMillis();
		System.out.println("Time : " + (end - start));
	}

	// 138000 ms
	public static void copyTest2() {

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			// 1. 创建文件输入字节流
			fis = new FileInputStream("C:/aaa/1.mp4");
			// 2. 创建文件输出字节流
			fos = new FileOutputStream("C:/aaa/2.mp4");

			// 3. 每一次读取一个字节，写入一个字节
			int content = -1;

			// 4. 读取文件数据
			while ((content = fis.read()) != -1) {
				// 5. 写入数据
				fos.write(content);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 先开后关，后开先关
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// 47ms
	public static void copyTest1() {

		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			// 1. 创建文件输入字节流
			fis = new FileInputStream("C:/aaa/1.mp4");
			// 2. 创建文件输出字节流
			fos = new FileOutputStream("C:/aaa/2.mp4");

			// 3. 准备一个缓冲数组 8KB
			byte[] buf = new byte[1024 * 8];
			int length = -1;

			// 4. 读取文件数据
			while ((length = fis.read(buf)) != -1) {
				// 5. 写入数据
				fos.write(buf, 0, length);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 先开后关，后开先关
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
