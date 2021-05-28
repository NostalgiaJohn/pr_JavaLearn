package com.fs.m_objectSerializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Demo2 {
	public static void main(String[] args) {
		readList();
	}

	private static void readList() {
		ObjectInputStream objectInputStream = null;
		
		try {
			objectInputStream = new ObjectInputStream(new FileInputStream("D:/ProgramTest/personlist.txt"));
			
			ArrayList<Person> list = (ArrayList<Person>) objectInputStream.readObject();
			
			for (Person person : list) {
				System.out.println(person);
			}
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

	private static void writeList() {
		ArrayList<Person> arrayList = new ArrayList<Person>();
		
		arrayList.add(new Person(1, "faa", 60));
		arrayList.add(new Person(2, "fbb", 55));
		arrayList.add(new Person(3, "fcc", 45));
		
		ObjectOutputStream objectOutputStream = null;
		
		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:/ProgramTest/personlist.txt"));
			
			objectOutputStream.writeObject(arrayList);

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
}
