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

