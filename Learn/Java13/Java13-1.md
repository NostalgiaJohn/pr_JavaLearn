## XML介绍

### 1. XML

配置文件的基本要求：看懂即可

#### 1.1 XML概述

```
Extensible Markup Language
可拓展标记语言

用途:
	1. 数据存储，小型数据库，存在一定的CRUD操作可行性
	2. 网络端数据的传输
	3. JavaWEB框架项目配置文件
		Spring Druid ....

W3C万维网联盟指定的规范
```

#### 1.2 基本语法

```
1. XML文件后缀名是.xml
2. XML第一行是对于当前文件的定义声明
3. XML文件中有且只有一个根标签
4. 属性值必须使用引号包含，这里推荐使用双引号
5. 标签必须正确匹配，正确开始和关闭
6. XML标签内严格区分大小写
```

#### 1.3 XML文件组成部分

演示：

以下内容可拷贝到文本文件中，并用浏览器打开——后缀名注意为.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<users>
	<user id="1"> 
        <name>张三</name>
        <age>16</age>
        <gender>male</gender>
    </user>
    <user id="2"> 
        <name>foo</name>
        <age>16</age>
        <gender>male</gender>
    </user>
</users>
```

组成结构介绍：

```
1. 文档声明:
	a. 格式:
		 <?xml 属性列表 ?>
		 <?xml version="1.0" encoding="utf-8" ?>
		 version: 当前XML文件版本号
		 encoding: 编码方式，这里建议XML文件的保存编码集和对应的解析编码集一致。
		 standalone:是否依赖于其他文件  [了解]
		 	yes 不依赖， no 依赖
		 	
2. 指令(了解)
	这里可以导入一些CSS样式
		<?xml-stylesheet type="text/css" href="test.css" ?>
		
3. 标签内容自定义
	规则:	
		a. 自定义标签允许使用英文字母，数字和其他标点符号(_ - .)
		b. 只能用英文字母开头
		c. 不允许在自定义标签内使用xml标记，XML也不行
		d. 名字不允许出现空格

4. 属性
	可以给标签一个属性，有时候要求ID属性是惟一的

5. 文本(了解)
	CDATA区，所见即所得，CDATA区内容是完整展示的
	格式:
		<![CDATA[ 数据 ]]>

6. 注释
	<!-- 文件注释 -->
```

#### 1.4 XML文件约束

```
1. DTD
	一种简单的约束方式
	但是存在一定的约束问题
2. Schema
	一种复杂XML文件约束方式
	非常严谨
```

#### 1.4.1 DTD约束

```dtd
<!-- students 根标签 要求根标签内存放student -->
<!ELEMENT students (student*) >
<!-- student标签包含子标签的内容 -->
<!ELEMENT student (name,age,sex)>
<!-- 所有子标签当前数据都都是文本形式 -->
<!ELEMENT name (#PCDATA)>
<!ELEMENT age (#PCDATA)>
<!ELEMENT sex (#PCDATA)>
<!-- ATTLIST Attribute List 属性列表 student id ID -->
<!ATTLIST student id ID #REQUIRED>

<!-- dtd文件及其对应xml文件，见Code\com\fs\b_dtd -->
```

##### 1.4.2 Schema约束

```

```

