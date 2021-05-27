package com.fs.h_buffered;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 输出字节缓冲流
 */
public class Demo2 {
	public static void main(String[] args) throws IOException {
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("D:\\ProgramTest\\2.txt")));
		
		for  (int i = 0; i < 10000; i++) {
			bos.write('A');
		}
		bos.close();
	}
}
