package com.fs.m_objectSerializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Demo1 {
	public static void main(String[] args) {
		readObject();
	}

	private static void writeObject() {
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:/ProgramTest/person.txt"));
			
			// 序列化对象，并且写入到文件中
			objectOutputStream.writeObject(new Person(1, "faa", 16));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (objectOutputStream != null) {
				try {
					objectOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private static void readObject() {
		ObjectInputStream objectInputStream = null;
		
		try {
			objectInputStream = new ObjectInputStream(new FileInputStream("D:/ProgramTest/person.txt"));
			
			// 从保存字节序列数据的文件中读取一个对象返回，返回值类型是Object类型
			// 但是我们知道，这里保存的实际是Person类型，可以进行强转操作
			Person p = (Person) objectInputStream.readObject();
			
			System.out.println(p);
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (objectInputStream != null) {
				try {
					objectInputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
