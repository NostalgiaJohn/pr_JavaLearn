# StudentSystem

[toc]

## 完成一个学生管理系统

```
需求：
有一个Student类
	其中的成员变量(Field)如下 :
	id, name, age, mathScore, chnScore, engScore, totalScore, rank	
	提示：通过数组管理类
需要实现的功能：
	增	删	改	查
```

### StudentSystemV1.0

```
根据需求建立如下包：
包名结构：
	com.system.studetn.fs.entity
		--| 实体类 Student.java
	com.system.studetn.fs.manager
		--| 管理类 StudentManager.java
	com.system.studetn.fs.test
		--| 测试类 SystemTest.java
	com.system.studetn.fs.mainProject
		--| main方法所在类 Index.java
```

#### StudentManger.java

```
保存学生数据
	数组方式存储学生属性，数组的类型是Student类型数组
增，删，改，查，排序，过滤……
```

### StudentSystemV1.1



## 【补充知识】

#### 快速修改版本号

复制原先文件，粘贴重命名版本号。

点击新版本文件内的==.project==文件，

修改其中`<name>StudentSystemV1.1</name>`  

保存，然后在开发环境中导入即可。

