# 缓冲流和序列化

[toc]

## 缓冲流

#### 缓冲流有什么作用？

```
使用缓冲数组以后，整体的读取，写入效率提升很大！！！
降低了CPU通过内存访问硬盘的次数。提高效率，降低磁盘损耗。

字节输入缓冲
	BufferedInputStream
字节输出缓冲
	BufferedOutputStream
字符输入缓冲
	BufferedReader
字符输出缓冲
	BufferedWrite
	
【重点】
	所有的缓冲流都没有任何的读取写入能力，都需要对应的输入流和输出流来提供对应的能力。
	在创建缓冲流对象时，需要传入对应的输入流对象和输出流对象。
	底层就是提供了一个默认大小的缓冲数组，用于提高效率
```

#### 字节缓冲流

```
输入
	BufferedInputStream(InputStream in);	
		这里需要一个字节输入流基类对象。同时也可也传入InputStream子类对象
输出
	BufferedOutputStream(OutputStream out);
		这里需要的对象是一个字节输出流基类对象。同时也可也传入OutputStream子类对象

以上传入的InputStream和OutputStream都是用于提供对应文件的读写能力。
```

#### 字节输入流缓冲效率问题

```
1. 在BufferedInputStream底层中有一个默认容量为8KB的byte类型缓冲数组。
2. fill方法是一个操作核心
	a. 从硬盘中读取数据，读取的数据容量和缓冲数组容量一致。
	b. 所有的read方法，都是从缓冲数组中读取数据
	c. 每一次读取数据之前，都会检查缓冲区内是否有数据，如果没有，fill方法执行，填充数据。

3. 利用缓冲，fill方法，可以极大的降低CPU通过内存访问硬盘的次数。同时程序操作的数据是在内存中进行交互的。
```

##### 字节输出流缓冲效率问题

```
1. 在BufferedOutputStream类对象，默认有一个8KB的byte类型缓冲数组
2. 数据写入文件时并不是直接保存到文件中，而是保存在内存8KB字节缓冲数组中
3. 如果8KB空间填满，会直接flush缓冲区，数据保存到硬盘中，同时清空整个缓冲区。
4. 在BufferedOutputStream关闭时，首先会调用flush方法，保存数据到文件，清空缓冲区，并且规划缓冲区占用内存，同时关闭缓冲流使用的字节输出流。
```

##### 缓冲流拷贝和非缓冲拷贝时间效率区别

```java
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
```

#### 字符缓冲流

```
BufferedReader
	字符缓冲输入流
	BufferedReader(Reader reader);
BufferedWriter
	字符缓冲输出流
	BufferedWriter(Writer writer);
```

##### 字符缓冲流效率问题

```
1. 字符缓冲输入流，底层有一个8192个元素的缓冲字符数组，而且使用fill方法从硬盘中读取数据填充缓冲数组

2. 字符缓冲输出流，底层有一个8192个元素的缓冲字符数组，使用flush方法将缓冲数组中的内容写入到硬盘当中。

3. 使用缓冲数组之后，程序在运行的大部分时间内都是内存和内存直接的数据交互过程。内存直接的操作效率是比较高的。并且降低了CPU通过内存操作硬盘的次数

4. 关闭字符缓冲流，都会首先释放对应的缓冲数组空间，并且关闭创建对应的字符输入流和字符输出流。

5. 
字符缓冲输入流中
	String readLine(); 读取一行数据
字符缓冲输出流中
	void newLine(); 换行
```

## 序列化

#### 序列化概述

```
Java中提供了一种序列化操作的方式，用一个字节序列化来表示一个对象，该字节序列化中保存了【对象的属性】，【对象的类型】和【对象的数据】。把字节序列化保存到文件中，就可以做到持久化保存数据内容。

从文件中读取字节序列化数据，可以直接得到对应的对象。
```

![序列化和反序列化](https://i.loli.net/2021/05/28/Gwd5gFoql93NyMb.png)

##### ObjectOutputStream类

```
将对象数据序列化，保存到文件中

构造方法 Constructor
	ObjectOutputStream(OutputStream out);
		输出字节流对象作为当前方法的参数
```

##### ObjectInputStream类

```
从文件中读取被序列化之后的字节数据，提供反序列化操作，得到一个对象。

构造方法 Constructor
	ObjectInputStream(InputStream in);
		需要提供一个字节输入流对象来进行操作
```

##### 【序列化注意事项】

```
1. 如果一个类需要进行序列化操作，必须遵从。java.io.Serializable。不遵从无法进行序列化操作

2. 序列化之后从文件中读取序列化内容，转换成对应的对象，
	ClassNotFoundException 对应类没有找到。
		对应的类型没有导包，不存在...
	InvalidClassException 类型不一样
		序列化之后的每一个类都会有一个serialVersionUID，该编号在使用过程中，序列化和反序列化必须一致
	
3. transient 修饰的成员变量不能被序列化 
```

##### 代码

###### Person

```java
package com.fs.m_objectSerializable;

import java.io.Serializable;

/*
 * 如果一个类需要进行序列化操作，必须遵从Serializable接口
 */
public class Person implements Serializable{
	/**
	 * 序列化编号
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private int age;
	// 瞬态修饰成员变量，不能被序列化
	//	private transient int age;
	
	public Person() {}

	public Person(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
```

###### Demo1

```java
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

```

###### Demo2

```java
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

```



