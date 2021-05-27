package com.fs.h_buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo3 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		copy();
		
		long end = System.currentTimeMillis();
		// 总耗时
		System.out.println("Time:" + (end - start));
	}

	public static void useBuffered() {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			bis = new BufferedInputStream(new FileInputStream(new File("D:/ProgramTest/1.txt")));
			bos = new BufferedOutputStream(new FileOutputStream(new File("D:/ProgramTest/buffered.txt")));
			
			int content = -1;
			
			while ((content = bis.read()) != -1) {
				bos.write(content);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
		
	public static void copy() {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("D:/programTest/1.txt");
			fos = new FileOutputStream("D:/programTest/copy.txt");
			
			int content = -1;
			
			while ((content = fis.read()) != -1) {
				fos.write(content);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (fis != null) {
				try {
					fis.close();
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
