# Object类

[toc]

## Object概述

```
Java中所有类的基类！！！
	Java中所有的类都是间接或者直接继承Object类。
	Object类的引用数据类型变量可以保存Java中任意数据类型空间的首地址。
Object类内规定了一些方法:
	String toString();
		当前对象建议String类型描述。默认情况是当前类所属包名.类名@十六进制内存地址
		如果对于数据类型展示有要求，可以重写toString方法，在展示的方法中会默认执行toString方法
	int hashCode();
		内存中当前对象的唯一索引值，默认情况下是当前对象所处空间首地址的十进制展示。
	boolean equals(Object obj);
		比较方法，判断两个对象是否一致，Object类内默认情况下比较的方式是地址比较。
		两个对象地址一致，表示肯定是相同对象。如果我们期望修改equals比较规则，可以在当前类内重写
		【注意】
        	Java中规定，如果两个对象的equals比较方法结果为true，要求hashCode值必须一致
	
	线程有关方法
	void wait();
	void notify();
	void notifyAll();
	
	反射有关方法
	Class<?> getClass();
```

#### toString方法

```
食之无味，弃之可惜！！！
	目前大家展示数据时，需要考虑使用的方法，可以通过Sout方法直接展示出对应的对象内容。

后期使用DEBUG工具或者一些辅助的可视化工具使用。

Eclipse Alt + Shift + S
```

#### equals方法

```
	比较两个对象是否一致，在Object类内默认方式是比较两个对象的地址是否一致。

	代码中存在一些情况，需要比较的是两个对象中保存的内容是一直，但是使用Object类内继承而来的equals方法，是不合理的！！！
	【实现】
		这里需要重写equals方法
```

##### 重写equals方法

```java
/** 
 * 重写equals方法 
 * 	1. 判断两个对象是不是同一个对象
 * 		如果调用方法的类对象和传入参数类对象地址一致，那就是同一个对象，返回true 
 * 	2. equals方法参数是Object类型，即任何类型的数据都可以作为参数
 * 		两个数据类型不一致，不需要进行比较操作 
 * 		--> 判断数据类型是否一致
 * 		--> 使用关键字instanceof，同数据类型继续运行，非同类型返回false                           
 * 		格式:    
 * 			类对象instanceof 类名 
 *           
 * 	3. 判断对象中保存的数据
 * 		Student中我们比较id, name, age, gender即可
 *
 */ 
@Override  
public boolean equals(Object obj) {
	// 1. 判断是否是同地址对象
	if (this ==  obj) {
		return true;
	}  
    
	// 2. 类型是否一致
	if (!(obj instanceof Student)) {
		return false;         
	}
    
    /*
     另一种方法：涉及反射
     if (null == obj || o.getClass != Student.class) {
     	return false;
     }
     */
	// 数据类型强制转换
	Student stu = (Student) obj; 
	return this.id == stu.id 
			// this.name.equals(stu.name) 该equals方法是String类equals方法
			&& this.name.equals(stu.name)  
			&& this.age == stu.age 
			&& this.gender == stu.gender; 
}
```

#### hashCode方法

```
	在Object类内，hashCode方法，返回的内容是当前对象的空间首地址十进制展示方式。	
	当前类重写equals方法之后，两个当前类对象比较结果为true，那么要求这两个对象的hashCode必须一致！！！
	[hashCode使用]有一个唯一原则。
	一般会参考参与equals比较的所有成员变量来组成对应的hashCode，这里会使用到一些Java中提供的计算哈希值的方法。
	
【注意】
	hashCode使用未进行重写的情况下，会使用地址作为hashCode对应的数据，重写之后，不再使用地址。重写之后hashCode 不对应当前对象所在地址。
```

修改hashCode值

```java
@Override
public int hashCode() {
	// 这里通过Objects 工具类内的hash方法，传入所有参与equals比较的成员变量
	// 得到对应的hashCode值
	return Objects.hash(id, name, age, gender);
}
```

