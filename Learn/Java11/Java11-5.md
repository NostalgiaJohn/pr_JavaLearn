# IO流

[toc]

## I/O流

#### 什么是I/O流

```
I
	input 输入流
	read 读取数据
O
	output 输出流
	write 写入数据
```



> 一般情况下都是按照当前程序使用的内存为参照物来考虑数据的走向问题。
>
> 文件操作为例
>
> ​	从内存中保存数据到硬盘 output
> ​	从硬盘中读取数据到内存 input
>
> 
>
> 文件操作为例
>
> ​	1GB完整的文件拷贝过程，要远远高于1GB散文件的拷贝过程。
>
>   1.    打开文件，关闭文件消耗资源较少
>
>   2.    1GB散文件就需要不断的打开，关闭资源
>
>         ——操作时间的消耗和打开文件，关闭文件或者说打开硬盘，关闭硬盘有直接关系
>
> 看视频，缓冲
>
> ——使用缓冲可以让用户体验提高，相对来说较为平稳的观看体验。
> ——网页第一次访问时，加载时间较慢，第二次打开，速度很快

```
IO流基类

InputStream
	输入流基类
		read
OutputStream
	输出流基类
		write
```

#### I/O流分类

```
流向分类
	输入输出
文件操作处理单元分类
	字节流和字符流

FileInputStream
	文件操作输入字节流
FileOutputStream
	文件操作输出字节流
	
FileReader
	文件操作输入字符流
Filewriter
	文件操作输出字符流
```

#### 文件操作字节流

##### 文件操作输入字节流

```
FileInputStream	文件操作输入字节流

Constructor构造方法
	FileInputStream(File file);
		这里是根据提供的File类对象创建对应的文件操作输入字节流。
	FileInputSteam(String pathName);
	这里是根据提供的String类型文件路径，创建对应的文件操作输入字节流。
	这些方法都会抛出异常：
		FileNotFoundException 文件未找到异常。
		
Method 成员方法	
	int read();
		从文件中读取[一个字节]数据返回到方法外。
		虽然返回值是一个int类型，但是在整个int类型当中存储的数据是一个byte类型，有且只有低8位数据有效
		
	int read(byte[] buf);
		读取文件的内容是存储在byte类型数组中，返回值是读取到的字节个数
		
	int read(byte[] buf, int offset, int count);
		读取文件的内容是存储在byte类型数组中，要求从byte数组offset位置开始，到
		count长度结束，返回值是读取到的字节个数
	
	以上方法如果读取到文件末尾，返回值都是 -1 /EOF (End Of File)
	以上方法都要异常抛出
		IOException IO异常
```

##### 使用演示

```java
package com.fs.g_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * 文件操作输入字节流
 * 	1. 确认读取哪一个文件
 * 	2. 创建对应文件的FileInputSteam
 * 	3. 读取数据
 * 	4. 关闭资源【重点】
 */
public class Demo1 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		readTest2();
		long end = System.currentTimeMillis();
		System.out.println("Time :" + (end - start));
	}

	private static void readTest2() {
		// 1. 确定操作文件
		File file = new File("G:\\1\\1.txt");
		
		// 2. 字符输入读取文件对象
		FileInputStream fileInputSteam = null;
		
		try {
			// 3. 根据File类对象创建对应的字节输入流
			fileInputSteam = new FileInputStream(file);
			
			// 4. 准备一个8KB字节缓冲数组-->提升速度
			byte[] buf = new byte[1024 * 8];
			int length = -1;
			
			// 5. 读取数据
			while ((length = fileInputSteam.read(buf)) != -1) {
				System.out.println(new String(buf, 0, length));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 在finally代码块中关闭资源
			if (fileInputSteam != null) {
				try {
					fileInputSteam.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/* 
	 * 速度很慢
	 */
	public static void readTest1() {
		// 1. 确定操作文件
		File file = new File("G:\\1\\1.txt");
		
		// 2. 字符输入读取文件对象
		FileInputStream fileInputSteam = null;
		
		
		try {
			// 3. 根据File类对象创建对应的字节输入流
			fileInputSteam = new FileInputStream(file);
			
			// 4. 读取文件
			int content = -1;
			while ((content = fileInputSteam.read()) != -1) {
				System.out.println((char)content);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 用于处理代码中使用到资源，无法发生什么样的错误，finally中的代码一定会执行
			// 这里发现fileInputSteam不是null，证明已经打开了文件资源，关闭资源，捕获异常
			if (fileInputSteam != null) {
				try {
					fileInputSteam.close();
				}catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}	
	}
	
}

```

##### 文件读取使用缓冲和非缓冲差距

![文件读取使用缓冲和非缓冲差距](https://i.loli.net/2021/05/22/JYo9mMA4CgaBGsq.png)

```
内存的运作速度看做是火箭
硬盘就是一个自行车
	以上代码中，使用缓冲之后，从硬盘中一口气读取8KB数据存储在内存中，供程序使用。
	
选择8KB的原因
	固态硬盘：4KB对齐。固态硬盘中每一个扇区都是4KB。缓冲8KB是要求CPU读取两个4KB数据，对于CPU而言没有太多压力。
	如果是一个字节一个字节读取，CPU会取出4KB数据，但只有一字节有效剩下的4095无效，要重新读取。
```

##### 文件操作输出字节流

```
FileOutputStream 文件操作输出字节流

Constructor 构造方法
	FileOutputStream(File file);
		根据File类对象创建对应的文件输出字节流对象
	FileOutputStream(String pathName);
		根据String类型文件路径创建对应的文件输出字节流对象
	
	以上两个构造方法，创建的FileOutputStream是删除写/清空写操作，会将原文件中的内容全部删除之后，写入数据。
	
	FileOutputStream(File file, boolean append);
		根据File类对象创建对应的文件输出字节流对象。创建对象时给予append参数为true，表示追加写。
	FileOutputStream(String pathName, boolean append);
		根据String类型文件路径创建对应的文件输出字节流对象，创建对象时给予append参数为true，表示追加写。
	
	FileOutputStream构造方法是拥有创建文件的内容，如果文件存在，不创建，文件不存在且路径正确，创建对应文件。否则抛出异常FileNotFoundException
Method 成员方法	
	void write(int b);
		写入一个字节数据到当前文件中，参数是int类型，但是有且只会操作对应的低八位数据
	void write(byte[] buf);	
		写入字节数组中的内容到文件中
	void write(byte[] buf, int offset, int length);	
		写入字节数组中的内容到文件中，从指定的offset开始，到指定长度length
		
	以上方法会抛出异常：IOException
```

##### 使用演示

```java
package com.fs.g_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 文件操作输出字节流
 * 		1. 确定文件
 * 		2. 创建FileOutputStream
 * 		3. 写入数据到文件中
 * 		4. 关闭资源 
 */
public class Demo2 {
	public static void main(String[] args) {
		writeTest2();
	}

	public static void writeTest2() {
		// 1. 确定文件
		File file = new File("C:/aaa/中国加油.txt");
		
		// 2. 文件操作字节输出流对象
		FileOutputStream fileOutputStream = null;
		
		try {
			// 3. 创建FileOutputStream 
			fileOutputStream = new FileOutputStream(file);
			
			// 4. 准备byte类型数组
			byte[] bytes = "中国加油！".getBytes();
			byte[] arr = {65, 66, 67, 68, 69, 70, 71};
			
			fileOutputStream.write(bytes);
			fileOutputStream.write(arr, 2, 3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭资源
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void wrietTest1() {
		// 1. 确定文件
		File file = new File("C:/aaa/加油.txt");
		
		// 2. 文件操作字节输出流对象
		FileOutputStream fileOutputStream = null;
		try {
			// 3. 创建FileOutputStream
			fileOutputStream = new FileOutputStream(file, true);
			
			// 4. 写入数据
			fileOutputStream.write('D');
			fileOutputStream.write('D');
			fileOutputStream.write('D');
			fileOutputStream.write('D');
			fileOutputStream.write('D');
			fileOutputStream.write('D');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭资源
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	} 
}

```

#### 文件操作字符流

##### 字符流特征

```
字符流 = 字节流 + 解码过程
	字节组合操作 ==> 对应当前环境编码集的一个字符
	如果字符找不到，该数据无效，需要被删除。

如果是字符内容操作，效率还可以！！！
如果是非字符操作，凶多吉少！！！

字符流操作文件
	个人建议，该文件可以使用notepad 记事本打开无乱码，可以使用字符流操作。
	视频文件，图片文件，特定格式的文件，都无法使用字符操作。
```

##### 文件操作输入字符流

```
FileReader 文件操作输入字符流

Constructor 构造方法
	FileReader(File file)
		根据File类对象创建对应的FileReader字符流输入对象
	FileReader(String pathName)
		根据String类型文件路径创建对应的FileReader字符流输入对象
	如果文件不存在，抛出异常FileNotFoundException

Method 成员方法	
	int read();
		读取文件中的一个字符数据，通过返回值返回，返回值类型是int类型，但是在int类型中有且只有低16位数据有效
	int read(char[] arr);
		读取文件中的数据保存到字符数组中，返回值类型是读取到的字符个数
	int read(char[] arr, int off, int len);
		读取文件中的数据保存到字符数组中，要求从数组中下标offset开始，到len结束，返回值类型是读取到的字符个数
	
	以上方法，如果读取到文件默认，返回值为-1 EOF End Of File
	如果读取操作工作中，出现问题，抛出异常IOException
```

##### 使用演示

```java
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

```

##### 文件操作输出字符流

```
FileWriter文件操作输出字符流

Constructor 构造方法
	FileWriter(File file);
		根据File类对象创建对应文件的文件操作输出字符流
	FileWriter(String pathName);
		根据String类型文件路径创建对应文件的文件操作输出字符流
	FileWriter(File file, boolean append);
		根据File类对象创建对应文件的文件操作输出字符流，并要求为追加写
	FileWriter(String pathName, boolean append);
		根据String类型文件路径创建对应文件的文件操作输出字符流，并要求为追加写
	
	如果创建FileWrite对象时，这里文件不存在，路径合法，这里会创建对应的操作文件。如果路径不合法，抛出异常 FileNotFoundException 
	
Method 成员方法	
	void write(int ch);
		写入一个char类型数据到文件中
	void write(char[] arr);
		写入一个char类型数组到文件中
	void write(char[] arr, int offset, int length);	
		写入一个char类型数组到文件中，要求从offset下标位置开始读取数组数据，长度为
		length
	void write(String str);
		写入一个字符串到文件中
	void write(String str, int offset, int lenght);
		写入一个字符串到文件中，要求从指定字符串offset下标位置开始，长度为length
	如果写入数据操作过程中，发生问题，这里会有一个IOException
```

###### 使用演示

```java
package com.fs.g_io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 文件操作字符输出流
 */
public class Demo1 {
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

```

#### 字符流文件拷贝

![字符拷贝图片失败问题](https://i.loli.net/2021/05/23/jockEamBO7KShAF.png)

```java 
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

```

