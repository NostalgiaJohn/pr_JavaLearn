package com.fs.g_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo4 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		readTest2();
		
		long end = System.currentTimeMillis();
		System.out.println("Time : " + (end - start));
	}

	// 10
	public static void readTest2() {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(new File("C:/aaa/3.txt"));
			
			char[] buf = new char[1024 * 4];
			int length = -1;
			
			while ((length = fileReader.read(buf)) != -1) {
				System.out.println(new String(buf, 0, length));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// 300
	public static void readTest1() {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(new File("C:/aaa/3.txt"));
			
			int content = -1;
			
			while ((content = fileReader.read()) != -1) {
				System.out.println((char) content);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
