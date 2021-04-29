# Notepad++使用

<center>前期建议使用Notepad++ 等文本编辑器</center>

#### 早期使用简易代码编辑器的原因

```
早期学习Java最好要通过命令窗口进行编译码。
	熟悉 javac和java命令，
	分辨*.java 跟*.class文件的区别
在初期阶段减少对代码自动补全的依赖
```

#### Notepad++优势

```
tab键 稳定4空格

清晰的缩进参考线
左列行数计数
语法高亮：适配绝大数多数代码
体量小巧
```



#### Notepad++设置

```
a. 设置 --> 首选项 --> 新建
	环境选择 windows 
	编码集 ANSI
b. 设置 --> 首选项 --> 自动完成
	全部反选
	减少对代码自动补全的依赖
```

#### 第一个代码

```java
class FirstJava {
	public static void main(String[] args) {
		System.out.println("HelloWord");
	}
}
```

#### 编译与执行命令

```
以下命令要在文件当前目录下运行
编译命令：
	javac FirstJava.java
	--通过该命令生成FirstJava.class字节码文件
执行命令：
	java FirstJava
	--执行的是FirstJava.class文件，但不需要文件后缀
```

[Notepad++下载地址](https://notepad-plus-plus.org/downloads/) 

