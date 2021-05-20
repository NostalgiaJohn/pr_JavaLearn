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