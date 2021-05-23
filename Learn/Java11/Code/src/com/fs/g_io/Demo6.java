package com.fs.g_io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 使用文件操作字符流量拷贝非文本文件问题
 * 【要求】
 * 		禁止使用字符流操作非文本文件，记事本打开乱码文件都不可以
 */
public class Demo6 {
	public static void main(String[] args) {
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		
		
		try {
			fileReader = new FileReader(new File("E:/1/1.png"));
			fileWriter = new FileWriter(new File("E:/1/3.png"));
			
			char[] buf = new char[1024 * 4];
			int length = -1;
			
			while ((length = fileReader.read(buf)) != -1) {
				fileWriter.write(buf, 0, length);
			}
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
