# Map和File类

[toc]

## Map双边队列

#### Map是什么

```
键(Key)值(Value)对--1对1的关系
	吴京=战狼

	表格：
        姓名：张三
        年龄：16
        性别：男
	
程序开发大部分数据都是键值对形式的
	MySQL JSON XML 类对象成员变量和存储的数据
	从前端发送的数据也可以转成Map格式 ==> 一键生成生成的类对象 ==> 一键存储入数据库
	
interface Map<K, V>
--| class HashMap<K, V> 哈希表结构
--| class TreeMap<K, V> 底层是树形结构，存储要求K有对应的排序方式
	Map双边队列中键(Key)是唯一的，但是值(Value)可以重复
```

#### Map双边队列方法

```
增
	put(K k, V v);
		存入一个键值对类型， K和V都要符合泛型约束
	putAll(Map<? extends K, ? extends V> map);
		存入另一个Map双边队列，并且要求添加的Map双边队列对接中的K和V都要和当前Map中存储的K和V一致
删
	remove(Object k);
		删除对应的键值对	
改
	put(K k, V v);
		对应的K存在，修改V
查
	int size();
		当前Map双边队列中，有效键值对个数
	boolean containsKey(Object key);
		判断指定Key值是否存在
	boolean containsValue(Object value);
		判断指定value值是否存在
	Set<K> keySet();
		返回整个Map双边队列中所有Key对应的Set集合
		【注意】一个方法使用set结尾，表示改方法返回的是一个集合类型，大多数情况是set
	Collection<V> values();
		返回整个Map双边队列中所有Value对应的Collection集合
		【注意】方法名如果是一个复数，返回值类型集合或者是数组的情况居多
		
```

#### EntrySet

```
Entry 可以认为是键值对对象
定义在Map类内
	class Entry<K, V> {
		K k;
		V v;
	}
	K,V是完全依赖于Map约束的，这里可以Entry里面保存的是每一个键值对类对象

Map中提供了一个方法
	Set<Map.Entry<K, V>> entrySet
	返回值是键值对类对象Set集合
	Set集合中存储的是Entry类型
	Entry类型是带有泛型的
```

###### 代码

```java
package com.fs.d_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo2 {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("吴京", "战狼");
		map.put("黄磊", "暗恋桃花源");
		map.put("刘慈欣", "三体");
		map.put("鲁迅", "狂人日记");
		
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		
		System.out.println(entrySet);
		
	}
}

```

#### `TreeMap<K, V>` 以及`Comparable`和`Comparator`

```
K是需要有对应的比较方式，如果没有比较方式，无法存入。

推荐使用Comparator接口
```

代码

```java
package com.fs.d_map;

import java.util.Comparator;
import java.util.TreeMap;

public class Demo3 {
	public static void main(String[] args) {
		TreeMap<String, String> map = new TreeMap<String, String>();
		
		map.put("faa", "1");
		map.put("fbb", "1");
		map.put("fcc", "1");
		map.put("fdd", "1");
		
		System.out.println(map);
		
		TreeMap<Dog, String> map2 = new TreeMap<Dog, String>(new Comparator<Dog>() {

			@Override
			public int compare(Dog o1, Dog o2) {
				return o1.getAge() - o2.getAge();
			}
			
		});
		
		map2.put(new Dog("八公", 2),"111");
		map2.put(new Dog("旺财", 5),"111");
		
		System.out.println(map2);
	}
}

```

## File类

#### `File`类是什么

```
SUN公司提供给开发者操作文件和文件夹的一个类对象。
	Java中万物皆对象，计算机中万物皆文件

获取File类有三种方式【Constructor 构造方法】
	File(String pathName);
		根据对应的文件路径创建获取对应的File类对象，可以是文件，可以是文件夹。
	File(String parent, String child);
		根据对应的父目录文件夹路径，以及子文件名或者子文件夹名，创建对应的File类对象
	File(File parent, String child);
		根据对应的父目录文件夹File类对象，以及子文件名或者子文件夹名，创建对应File类对象

路径:
	相对路径
		. 当前工作目录
		..  父目录/上级目录
		针对于当前工作目录和其他文件或者文件夹之间的最小路径
	绝对路径
		唯一的路径
		Windows操作系统；每一个盘符都是一个根目录开始
			C:/Windows/System32
		Linux UNIX macOS 
			存在一个 / 根目录文件
			/user/pc/appliction

路径有一个很重要的东西
	路径分隔符
	Windows 分隔符 默认是 \
	Linux UNIX macOS 分隔符 默认是 / 
	
	Windows是支持Linux分隔符 / 
	
	根据当前系统来区分不同的分隔符 File.separatorChar 
```

代码

```java
package com.fs.e.file;

import java.io.File;

public class Demo1 {
	public static void main(String[] args) {
		/*
		 * 1. 路径分隔符\\ or / or File.separator
		 * 2. 操作文件必须带有文件的后缀名
		 */
		File file = new File("E:\\ProgramLearning");
		File file1 = new File("E:" + File.separator + "ProgramLearning");
		
	}
}

```



#### 创建文件和文件夹

```
boolean createNewFile();
	通过File类对象调用，创建对应File类对象中保存的路径的普通文件。
	创建成功返回true，创建失败返回false
	返回false的原因:
		1. 路径不合法。
		2. 对应的文件夹没有写入权限。
		3. 对应文件已经存在。

boolean mkdir();
	通过File类对象调用，创建对应File类对象中保存路径的文件夹
	创建成功返回true，创建失败返回false
	返回false的原因
		1. 路径不合法。
		2. 对应的文件夹没有写入权限。
		3. 对应当前的文件夹已经存在。

boolean mkdirs();
	通过File类对象创建其中保存的文件目录的所有对应文件夹，包括中间路径
	如果创建失败，返回false

boolean renameTo(File dest);
	通过File类对象调用，转为目标File类对象dest
	文件/文件夹移动，重命名
```

##### 删除文件或者文件夹

```
boolean delete();
	通过File类对象调用，删除对应的文件或者文件夹
	【要求】
		1. 删除的文件或者文件夹都是直接抹掉数据，不是放入回收站
		2. 无法删除非空文件夹，文件夹中存在其他内容无法整体删除。
void deleteOnExit();
	程序退出时删除对应的文件或者文件夹
	用于删除程序运行过程中，留下的日志文件，缓冲文件，操作日志...
```

##### 文件属性判断[有用]

```
boolean isFile();
	判断是否是一个普通文件
boolean isDirctory();
	判断是否是一个文件夹
boolean isAbsolute();
	判断是否使用了绝对路径，跟文件是否存在无关
boolean isHidden();
	判断是否是隐藏文件
boolean exists();
	判断文件是否存在
```

##### 获取文件属性

```
唬人方法
	以下方法和文件是否存在没有一分钱关系，可以使用字符串操作直接得到我们想要的结果
	String getPath();
		获取File类对象保存的路径
	String getName();
		获取当前File类对象中保存的文件名或者文件夹名
	String getParent();
		获取当前File类对象对应文件或者文件夹的父目录路径
	String getAbsolutePath();
		获取当File类对象对应文件或者文件夹的绝对路径

有用方法：
	long lastModified()
		获取文件的最后一次修改时间，返回值是一个时间戳类型。
		从1970年01月01日 00:00:00到现在的秒数。计算机元年
	long length();
		获取文件的大小，占用硬盘空间字节数。
		如果操作的是文件夹，返回0L
```

##### 列表方法

```
static File[] listRoots();
	通过File类调用，获取当前电脑内所有根盘符对象，有且针对于Windows操作系统有效

File[] listFiles();
	通过File类对象调用，获取当前File类对象对应文件夹下的所有子文件或者子文件夹的File类对象数组

String[] list();
	通过File类对象调用，获取当前File类对象对应文件夹下的所有子文件或者子文件夹的String类型文件名或者文件夹名字数组
```

##### FilenameFilter文件名过滤器

```java
interface FilenameFilter
	boolean accept(File dir, String name);
```

###### 源码

```java
@FunctionalInterface
public interface FilenameFilter {
    /**
     * Tests if a specified file should be included in a file list.
     *
     * @param   dir    the directory in which the file was found.
     * @param   name   the name of the file.
     * @return  <code>true</code> if and only if the name should be
     * included in the file list; <code>false</code> otherwise.
     */
    boolean accept(File dir, String name);
}
```

代码

```java
package com.fs.e.file;

import java.io.File;
import java.io.FilenameFilter;

/*
 * FilenameFilter 过滤器演示
 */
public class Demo2 {
	public static void main(String[] args) {
		File file = new File("E:\\Code\\c_file");
		
		// 使用匿名内部类的匿名对象直接作为方法的参数
		File[] listFiles = file.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				/*
				 * dir是当前操作的文件夹类对象
				 * name是当前文件夹下的子文件或者子文件夹名字
				 * 
				 * 获取对应的java文件
				 * 		1. 判断是不是普通文件
				 * 		2. 判断当前文件名是不是.java结尾
				 */

				return new File(dir, name).isFile()
						// endsWith字符串方法，判断当前字符串是不是已指定要求结尾
						&& name.endsWith(".java");
			}
		});
		
		// Lambda表达式 JDK1.8新特征 
		File[] listFile = file.listFiles((dir, name) -> 
			new File(dir, name).isFile() 
			&& name.endsWith(".java")
		);
		
		for (File file2 : listFile) {
			
			System.out.println(file2.getName());
		}
	}
}

```

## 实例：Java实现文件归档

```
实现将杂乱无章的不同类型文件、文件夹；按照类型存放。具体要求见图。

进阶：归档后，再次归档无操作。
```

![原始情况](https://i.loli.net/2021/05/20/elr43C5nKIXhfWQ.png)

![最终情况](https://i.loli.net/2021/05/20/Kf8lHPaUxvhuBD9.png)

代码：

```java
package com.fs.e_file;

import java.io.File;
import java.io.IOException;

/**
 * 文件归档
 * 	1. 获取对应当前文件的所有子文件和子文件夹list or listFiles
 * 	2. 遍历判断是普通文件还是文件夹isFile or isDirctory
 * 	3. 分门别类处理
 * 		3.1 文件处理
 * 			3.1.1 获取文件后缀名 substring lastindexOf
 * 			3.1.2 创建对应当前文件后缀名的全大写文件夹
 * 			3.1.3 移动文件到指定文件夹
 * 		3.2 文件夹处理
 * 			3.2.1 创建subDir文件夹
 * 			3.2.2 移动文件夹到subDir下
 * 
 * @author fStardust
 *
 */
public class CollatFile {
	public static void main(String[] args) throws IOException {
		// 目标文件夹的File类对象
		File file = new File("G:\\1\\c");
		
		// 需要创建的文件夹
		File toBeCreateDir = null;
		
		// 判断是否是文件夹
		if (!file.isDirectory()) {
			return;
		}
		
		// 当前文件夹已经归档完成，无需再次归档
		if(new File(file, "1.lock").exists()) {
			System.out.println("已归档文件");
			return;
		}
		
		// 当前文件夹下所有子文件和子文件夹的File类对象组
		File[] listFiles = file.listFiles();
		
		// 遍历File类对象数组
		for (File srcFile : listFiles) {
			// 如果是普通文件。获取文件后缀名
			if (srcFile.isFile()) {
				
				String fileName = srcFile.getName();
				String upperSuffix = fileName.substring(fileName.lastIndexOf('.') + 1)
						.toUpperCase();
				toBeCreateDir = new File(file, upperSuffix);
				
			} else {
				toBeCreateDir = new File(file, "subDir");
			}
			
			// 创建文件夹
			toBeCreateDir.mkdir();
			
			// 移动文件或文件夹
			srcFile.renameTo(new File(toBeCreateDir, srcFile.getName()));
		}
		
         // 进阶
		// 创建一个锁文件
		new File(file, "1.lock").createNewFile();
	}
}

```

