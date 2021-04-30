# Java7·面向对象

[toc]

#### 面向对象与面向过程

```
面向对象：
	想吃烤羊排
	--去店里点单等待吃付款走人
	
面向过程：
	自己烤羊排
	1. 买齐材料
	2. 解冻羊排准备辅料
	3. 腌制，烤箱预热，烤制
	4. 吃
	5. 收拾

从生活角度看面向对象：
	找合适的人做合适的事！
从生活角度看面向过程：
	亲历亲为，自力更生！
	
代码中：
	Arrays.toSting();
	Arrays.sort();
	Arrays.binarySearch();
```

#### 类和对象

|   类   |            对象            |
| :----: | :------------------------: |
|  人类  | 鲁迅，乔布斯（具体的个体） |
|  狗类  |          忠犬八公          |
| 汽车类 |          1949红旗          |
| 电脑类 |       自己的个人电脑       |



```
类：
	对于一类事物的统称，对当前事物的一些描述，属性描述和行为描述
对象：
	独立，唯一，独特的个体
```

#### Java中定义类的格式

```java
/*
class ClassName{
	// 属性描述
	// 行为描述
}
要求：
	1. ClassName 符合大驼峰命名法
	2. 属性描述，用于描述当前类拥有的一些特征，可以使用变量
		该变量有一个特定的名字【成员变量】 Field
	3. 行为描述，是用于描述当前类可以做到的一些事情，这里使用方法
		该方法有一个特定的名字【成员方法】 Method
	
*/
```

##### Java中定义变量

```java
class Person{
	// 属性描述，这里使用成员变量Field
	// 使用String类型描述Person类的姓名属性
	String name;
	
	// 使用int类型数据描述Person类的年龄属性
	int age;
	
	// 使用char类型数据描述Person类的性别属性
	char gender;
}
```

##### Java中定义类【成员方法】

```java
// 使用方法描述Person类的吃饭行为
public void eat(String food) {
    System.out.println("吃" + food);
}

// 使用方法描述Person类的睡觉行为
public void sleep() {
    System.out.println("说出来你可能不信，是床先动的手");
}

/*
特征：
	1. 目前没有使用static关键字
	2. 方法和之前所学方式形式一致，同样有三大元素：
		返回值，方法名，形式参数列表
*/
```

#### 类对象的使用

##### Java中创建类对象的形式

```java
/*
new 对象！
*/
// 获取一个扫描器的类对象！
Scanner sc = new Scanner(System.in);
/*
java.util.Scanner : 
	数据类型，Scanner类型。
	创建的【变量】是Scanner的类对象，同时也是一个引用数据类型
sc :
	类对象，变量
	Scanner的类对象，sc是对象名
new :
	申请内存的【堆区】空间，并且清理整个空间中的所有数据
	代码中只要有new关键字，一定会使用到内存的堆区空间，并且是新的内存空间
Scanner(System.in) :
	1. 这里是一个方法，因为有小括号
	2. 方法名字和类名一致
	3. 该方法称为构造方法--Constructor 构造方法

总结：
	类名 对象名 = new 构造方法(所需参数);
*/
// 这里创建了一个Person类对象，对象名person
Person person = new Person();
System.out.println(person);
/*
* com.fs.a_object.Person@4926097b
* com.fs.a_object --> 完整的包名
* Person 数据类型，这里创建的对象是一个Person类对象
* @4926097b 当前类对象在内存空间中的首地址/哈希码！十六进制展示方式 
*/

Person person1 = new Person();
System.out.println(person1);
/*
* com.fs.a_object.Person@762efe5d
* 发现第二个Person类对象 person1首地址空间@762efe5d 和第一个对象不一致
* 两个对象首地址不一致，意味着不是同一个对象！
*/
```

