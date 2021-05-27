package com.system.studetn.fs.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.system.studetn.fs.entity.Student;
import com.system.studetn.fs.mainProject.StudentManager;

public class DataUtils {
	/**
	 * 从文件中读取数据到StudentManager对象中
	 * @param studentManager 学生管理类对象
	 */
	public static void readDate(StudentManager studentManager) {
		/*
		 * [1,faa,116,男,9,95,98,202,0]
		 * ...
		 */
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(new File("./data/students.txt")));
			
			String data = null;
	
			while ((data = br.readLine()) != null) {
				if ('[' == data.charAt(0)) {
					// 学生数据
					String[] split = data.substring(1, data.length() - 1).split(",");
					
					// 解析数据中每一个元素对应的数据
					int id = Integer.parseInt(split[0]);
					String name = split[1];
					int age = Integer.parseInt(split[2]);
					char gender = split[3].charAt(0);
					int mathScore = Integer.parseInt(split[4]);
					int chnScore = Integer.parseInt(split[5]);
					int engScore = Integer.parseInt(split[6]);
					int totalScore = Integer.parseInt(split[7]);
					int rank = Integer.parseInt(split[8]);
					
					// 创建Student类对象，存储到StudentManager中
					Student stu = new Student(id, name, age, gender, mathScore, chnScore, engScore, totalScore, rank);
					studentManager.add(stu);
					
				} else if('c' == data.charAt(0)) {
					// count数据 count:20
					Student.setCount(Integer.parseInt(data.split(":")[1]));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 从StudentManager中保存数据到文件
	 * @param studentManager 学生管理类对象
	 */
	public static void saveDate(StudentManager studentManager) {
		BufferedWriter bw = null;
		
		try {
			// 选择写入文件的方式是删除写！
			bw = new BufferedWriter(new FileWriter(new File("./data/students.txt")));
			
			// 获取StudentManager对象中保存的所有学生类对象数据
			Student[] allStudents = studentManager.getAllStudents();
			for (int i = 0; i < allStudents.length; i++) {
				// 写入学生数据
				bw.write(allStudents[i].getData());
				bw.newLine();
			}
			
			bw.write("count:" + Student.getCount());
			
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
}
