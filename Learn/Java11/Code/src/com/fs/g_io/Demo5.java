package com.fs.g_io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 文件操作字符输出流
 */
public class Demo5 {
	public static void main(String[] args) {
		FileWriter fileWriter = null;
		
		try {
			fileWriter = new FileWriter(new File("文件位置"), true);
			char[] charArray = "现在".toCharArray();
			fileWriter.write(charArray);
			fileWriter.write("乐观");
			fileWriter.write("\r\n");
			fileWriter.write(charArray, 0, 5);
			fileWriter.write("乐观",0,1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	private static void writeTest1() {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(new File("文件位置"), true); // true追加写，无删除写
			fileWriter.write('加');
			fileWriter.write('油');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
