## XML介绍IDEA使用和XML

#### 1. XML

##### 1.1 XML概述

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

##### 1.2 基本语法

```
1. XML文件后缀名是.xml
2. XML第一行是对于当前文件的定义声明
3. XML文件中有且只有一个根标签
4. 属性值必须使用引号包含，这里推荐使用双引号
5. 标签必须正确匹配，正确开始和关闭
6. XML标签内严格区分大小写
```

##### 1.3 XML文件组成部分

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

