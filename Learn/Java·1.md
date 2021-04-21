# Java·1

[toc]

## 第一个Java应用程序

### 1.1第一行代码

```java
class FirstJava {
	public static void main(String[] args) {
		System.out.println("欢迎");
	}
}
```

### 1.2编译执行



```
javac -编译工具
	javac 源文件名.java
		编译后生成 FirstJava.class 文件
		.class 字节码文件，二进制文件，需要借助JVM执行解释给CPU
		
java -执行工具
	java 类名
		终端：输出
```



### 1.3代码规范



```
代码注释：
1.  //单行注释
2.  /*多行注释*/
3.  /**文档注释*/ 
	-->生成外部文档：
	javadoc -d . HelloWorld.java
```

