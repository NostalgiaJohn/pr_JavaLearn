# String类和IO流



[toc]

## 常用`API-String`

#### String字符串冗余问题

```java
String str = "孜然肉片";
str += "麻辣香锅";
str += "番茄鸡蛋";
str += "土豆牛肉";
str += "烤羊排";
str += "金汤肥牛";
str += "油麦菜";

System.out.println("这里有几个字符串");

/*
这里有14个字符串
	使用双引号包含的字符串都是字符串常量！！！常量的概念中要求不可以修改。
	双引号包含的字符串都是存在于内存的【数据区】
	+ 在字符串常量操作时，使用原本的两个字符串拼接之后完成的一个新的字符串常量。
	
	这里导致的字符串冗余问题，后期使用StringBuffer StringBuilder来解决问题
*/
```

![字符串反编译结果](https://i.loli.net/2021/05/19/RHCsOK4nMreDXL9.png)

#### 字符串比较

```java
package com.fs.f_string;

/*
 * 字符串比较问题
 */
public class Demo2 {
	public static void main(String[] args) {
		String str1 = "学习";
		String str2 = "学习";
		// 以下两种new String不推荐
		String str3 = new String("学习");
		String str4 = new String(str1);
		
		System.out.println("str1 == str2 : " + (str1 == str2));
		System.out.println("str1 == str4 : " + (str1 == str4));
		System.out.println("str2 == str3 : " + (str2 == str3));
		System.out.println("str3 == str4 : " + (str3 == str4));
		
		System.out.println("-----------------------------------");
		
		// 无论什么时候字符串比较有且只能使用equals方法
		System.out.println("str1.equals(str2) : " + str1.equals(str2));
		System.out.println("str1.equals(str4) : " + str1.equals(str4));
		System.out.println("str2 == str3 : " + str2.equals(str3));
		System.out.println("str3 == str4 : " + str3.equals(str4));
	}
}
```

![字符串比较要求](https://i.loli.net/2021/05/21/7vP6DxOlVsIHUiT.png)

#### 获取方法

>int length();
>
>——获取字符串长度""
>
>char charAt(int index);
>
>——获取String字符串中指定下标位置的char类型字符，如果index超出有效范围StringIndexOutOfBoundsException
>
>int idnexOf(char ch);
>
>int indexOf(String str);
>
>int indexOf(char ch, int fromIndex);
>
>int indexOf(String str, int fromIndex);
>
>——这些方法都是获取指定元素所在的下标位置，元素可以是char也可以是String。此处找的是指定元素在字符串中第一次出现的位置。也可以添加约束，表示从哪个位置开始找——fromIndex
>
>int lastIndexOf(char ch);
>
>int lastIndexOf(String str);
>
>int lastIndexOf(char ch, int fromIndex);
>
>int lastIndexOf(String str, int fromIndex);
>
>——这些方法都是获取指定元素所在的下标位置，元素可以是char，也可以是String。这里找出的是指定元素在字符串中最后一次出现的位置，当然可以通过一定的约束，从哪个位置开始找fromIndex
>**tips: 最后两个方法有坑！！！

#### 判断方法

> boolean endsWith(String str);
>
> ——判断当前字符串是不是以指定字符串结尾
>
> boolean isEmpty();
>
> ——判断字符串是否为空 ""空串 ；JDK1.6之后 null不能读取，不能写入，不能调用方法
>
> boolean equals(Object obj);
>
> ——继承重写Object类内的方法，完成字符串要求的比较方式
>
> boolean equalsIgnoreCase(String str);
>
> ——不区分大小写比较
>
> boolean contains(String str);
>
> ——判断指定字符串是否存在

#### 转换方法

> String(char[] arr);
>
> ——使用字符数组中内容创建一个字符串对象
>
> String(char[] arr, int offset, int length);
>
> String(char[] arr, int off, int len);
>
> String(char[] arr, int off, int cou);
>
> String(char[] arg0, int arg1, int arg2);
>
> ——使用字符数组中内容创建一个字符串对象，offset是从char类型数组中指定下标位置开始获取数据，获取的数据长度是length
>
> 
>
> static String valueOf(char[] arr);
>
> ——通过类名调用的静态方法，实际执行的是String(char[] arr);
>
> static String valueOf(char[] arr, int offset, int length);
>
> ——通过类名调用的静态方法，实际执行的是String(char[] arr, int offset, int length);
>
> char[] toCharArray();
>
> ——返回当前字符串对应的字符数组

#### 其他方法

> String replace(char oldChar, char newChar) 
>
> ——替换，替换不会修改原始的字符串，会创建一个新字符串返回，并且替换效果是所有的对应的oldChar全部替换成newChar ???
>
> String[] split(String regex) 
>
> ——按照指定的字符串切割当前字符串
>
> ——[00:00:15]XXXXXXX
>
> String substring(int beginIndex) 
>
> ——从指定位置开始，截取子字符串，到字符串末尾
>
> String substring(int beginIndex, int endIndex)
>
> ——从指定位置开始beginIndex，到endIndex结束，要头不要尾
>
> String toUpperCase() 
>
> ——字符串小写转大写
>
> String toLowerCase() 
>
> ——字符串大写转小写
>
> String trim() 去除空格
>
> ——去除字符串两边的无用空格

#### 补充知识--码点和码点单元

![码点数和码点单元](https://i.loli.net/2021/05/21/kzg8r637YF2QBHn.png)

> Java字符串由char值系列值序列组成。
>
> 最常用的Unicode字符使用一个代码单元就可以表示，而辅助字符需要一对代码单元表示。
>
> 如：🚗 （emoji表情）
>
> ** 不能忽略`U+FFFF`及以上代码单元的字符 --> 尽量不要使用char类型获取字符串内容。

-------

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
>        ——操作时间的消耗和打开文件，关闭文件或者说打开硬盘，关闭硬盘有直接关系
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

