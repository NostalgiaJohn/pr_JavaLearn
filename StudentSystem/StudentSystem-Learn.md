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

##### 准备--分析

```
根据需求建立如下包：
包名结构：
	com.system.studetn.fs.entity
		--| 实体类 Student.java
		学生类格式确定/数据规范
	com.system.studetn.fs.manager
		--| 管理类 StudentManager.java
		*核心*
		存储学生信息，操作学生信息，具体实现增删改查等功能
	com.system.studetn.fs.test
		--| 测试类 SystemTest.java
		测试功能
	com.system.studetn.fs.mainProject
		--| main方法所在类 Index.java
		对外
```

##### 实现内容

```
Student.java
	--基本完成Student类各必要属性设置:
	id + name + age + gander + mathScore + chnScore + engScore + totalScore + rank
StudentManger.java
	以数组形式保存学生数据，按照实际生活经验设置数组初始容量。并正确输出Student类数据--.StudentManager() & .StudentManager(int initCapacity) & .get(int id) & .grow(int minCapacity) & .show()
	实现数据增加方法，以及数组扩容方法。*但增加方法只能顺序添加。--.add()
SystemTest.java
	正确输出学生信息--成功
	测试增加方法--成功
```

### StudentSystemV1.1

##### 继续实现

```
StudentManger.java
	完善增加方法：通过尾插法，实现指定下标位置添加指定数据--.add(Student student) & .add(int index, Student stu) & .findIndexById(int id)
	在增加数据方法的基础上。实现删除数据方法--.remove(int id)
	在增加数据方法的基础上，实现Student类的属性值更改--.modify()
	实现简单条件排序--.selectSortByAgeDesc()
```

### StudentSystemV1.2

##### 继续实现

```
StudentManger.java.selectSortByAgeDesc()
	对V1.1中的排序方法--进行普适性修改
```



#### 项目中引出匿名内部类

##### 目前项目中的问题：

```
	排序算法需要的条件，要求非常多，但是排序算法的格式，过程，内容是一致的，只有【核心-比较方式】不同
	插件式比较方式，使用插件的思想完成对于【核心比较方式的替换过程】
	
	游戏机，可以【更换不同的卡片】，完成不同的游戏体验，但是要求卡片【接口是一致的】
	
	从生活角度发现问题，把核心比较方式，规定成一个接口，来满足开发要求。同时使用了多态思想！！！
```

##### 尝试使用接口来完成对于核心比较方法的处理

```java
// 两个学生类对象中的年龄比较
if (sortTemp[index].getAge() < sortTemp[j].getAge()) {
	index = j;                                        
}                                                     

/*
总结:
	1. 比较的对象是两个Student类对象
	2. 只不过是从类对象中，更改不同的比较内容
	3. 当前条件需要的是一个boolean类型
	4. 这里可以使用一个方法：方法名compare
	
	boolean compare(Student stu1, Student stu2);
	
可以把该方法封装到接口中，指定一个规范，使用实现类完成对于当前操作的要求。

interface MyComparator {
	boolean compare(Student stu1, Student stu2);
}
年龄升序
年龄降序
成绩升序
成绩降序....
*/
```

##### 使用接口和接口的实现类完成对于选择排序算法的普适性优化过程

![类比游戏机解释接口实现类的普适性](C:/Users/pc/Desktop/类比游戏机解释接口实现类的普适性.png)

##### 过程中出现的问题

```
	当下使用接口约束[比较]规程，使用实现类作为方法的参数完成比较，的确解决了排序算法多样的情况。
	但是也出现了大量内容相似的实现类。对于代码运行而言，类文件太多，降低效率

目标：
	1. 使用方法来完成比较方式，从而满足复用
	2. 类名只是因为Java中所有的代码都在类内，所以需要这样的条件。

能不能有一种方式:
	只完成方法，类名就不需要了，代码符合接口规范！！！
```

#####  匿名内部类

Anonymous Inner Type  (没有名字的类！)

![匿名内部类](C:/Users/pc/Desktop/匿名内部类.png)



## 【补充知识】

#### 快速修改版本号

复制原先文件，粘贴重命名版本号。

点击新版本文件内的==.project==文件，

修改其中`<name>StudentSystemV1.1</name>`  

保存，然后在开发环境中导入即可。

