package com.fs.h_buffered;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo4 {
	public static void main(String[] args) {
		BufferedWriter bw = null;
		
		try {
			bw = new BufferedWriter(new FileWriter(new File("D:/ProgramTest/2.txt")));
			
			bw.write("咖啡");
			bw.newLine();
			bw.write("星冰乐");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}		
		}
	}

	private static void bufferedReader() {
		BufferedReader br = null;
				
		try {
			br = new BufferedReader(new FileReader(new File("D:/ProgramTest/1.txt")));
			
			System.out.println(br.readLine());
			System.out.println(br.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
	}
}
