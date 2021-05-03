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
|  狗类  |       忠犬八公,小七        |
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

##### Java中使用类对象调用成员变量

```java
/*
int[] arr = new int[10];
获取数组的容量：
	arr.length
	获取一个数组中【的】length属性
	
格式：
	对象名.属性名、成员变量名
	. ==> 的
	可以操作取值或者赋值操作。	
*/
// 通过Person类对象 person调用类内成员变量
// 【赋值】Person；类对象person中对应的成员变量
person.name = "乔布斯";
person.age = 26;
person.gender = '男';

// 【取值】展示Person类对象person中保存的成员变量数据
System.out.println("Name:" + person.name);
System.out.println("Age:" + person.age);
System.out.println("Gender" + person.gender);
```

##### Java中使用类对象调用成员方法

```java
/*
得到一个Scanner类对象sc
Scanner sc = new Scanner(System.in);
使用以下方法：
	sc.nextInt();
	sc.nextFloat();
	sc.nextLine().charAt(0);
	
格式：
	类对象.方法名(必要的参数);
	. ==> 的
*/
// 通过Person类对象person调用类内成员方法
person.eat("烤羊排");
person.sleep();
```

##### 类对象内存分析图

![类对象内存分析图](.\img\类对象内存分析图.png)

#### 类对象内存转移问题

```java
dog1.name = "八公";
dog1.age = 5;
dog1.gender = '雄';

dog2.name = "小七";
dog2.age = 2;
dog2.gender = '雌';
```

##### 类对象内存转移问题分析图

![类对象内存转移问题分析图](.\img\类对象内存转移问题分析图.png)

#### 构造方法

Java编译器提供的默认构造方法

```java
类名 对象名 = new 构造方法();
问题：
	代码中没有显式定义构造方法-->为什么可以使用一个无参数的构造方法？
	
Java反编译工具：
	javap -c -l -private xxx.class
	
```

![Java反编译内容](E:\ProgramLearning\JavaLearn\Learn\Java7\img\Java反编译内容.png)

```
	通过反编译工具，发现的一些不存在于代码中的内容，这段内容是Java编译器，为了方便程序开发，提供的一个必要的无数构造方法。
总结：
	Java编译器如果发现当前class没有显式自定义构造方法，会默认提供一个无参数构造方法给予使用。
	如果代码中有任何一个构造方法，都不会再提供对应的无参数构造方法。
```

##### 自定义使用构造方法

```
构造方法功能有且只有一个：
	初始化当前类对象中保存的成员变量数据
目前创建对象的方式：
	new 构造方法(有可能需要的参数);
	
new：
	1. 根据构造方法提供的数据类型申请对应的堆区内存空间
	2. 擦除整个空间中所有的数据
构造方法:
	初始化在当前内存堆区空间的成员变量对应的数据
	
格式：
	public 类名(初始化形式参数列表) {
		初始化赋值语句;
	}
	
要求：
	1. 无论什么时候一定要留有一个无参数构造方法备用
	2. 根据所需情况完成构造方法参数选择
	3. 一个class可以有多个构造方法【方法的重载】
```

#### 方法的重载

![多个构造方法](.\img\多个构造方法.png)

```
总结:
	1. 所有的方法名字都是一致的！
	2. 所有的方法承诺书都不一样！
	3. 都在同一个类内

这就是方法的重载！
	
优点：
	1. 简化了开发压力！
	2. 简化了记忆压力！
	3. 更快捷的调用方法，同时又瞒住了不同的情况！
	
规范：
	重载情况下，在同一个类内，不可以出现相同方法名和相同参数数据类型的方法！

基本原理：
	方法名一致的情况下，通过形式参数列表数据类型的不同来选择不同的方法执行
	反射 ==> Constructor; Method
```

#### this关键字

##### this关键字特征

![就近原则报错](.\img\就近原则报错.png)

```java
/*
我们期望使用比较直观的参数名方式，告知调用者这里需要的数据，但这么做会导致【就近原则】问题--如上图
	在构造方法中所有的name，age都会被看做是一个局部变量而不是成员变量
我们期望：
	可以有一种参数方式告知编译器这里操作的是一个成员变量，而不是一个局部变量！
	
*/

package com.fs.a_object;

class SingleDog {
	public SingleDog() {
		System.out.println("Constructor:" + this);
	}
	
	public void test() {
		System.out.println("Method Called:" + this);
	}
}
/*
 * this关键字特征：
 * this关键字表示调用当前方法的类对象，
 * 	或者是当前构造方法中初始化的类对象
 */
public class Demo4 {
	public static void main(String[] args) {
		SingleDog singleDog = new SingleDog();
		
		System.out.println("Instance" + singleDog);
		singleDog.test();
	}
}

```

##### 解决就近原则问题

```java
public Cat(String name, int age) {
    /*
		 * 使用this关键字明确告知编译器这里使用的是一个成员变量，
		 * 而不是局部变量
		 * 解决就近原则问题
		 */
    this.name = name;
    this.age = age;
    System.out.println("带有两个参数的构造方法");
}
```

##### this关键字调用其他构造方法【之后讲解】

#### 成员变量和局部变量的对比

![成员变量和局部变量的对比](.\img\成员变量和局部变量的对比.png)

#### 【补充知识点·零值】

```
new关键字申请内存空间，并且擦除的一干二净-->用0覆盖
对应每一个数据类型的"零"值
基本数据类型
	byte short int   0
	long             0L
	float            0.0F
	double           0.0
	char             '\0' ==> nul
	boolean          false
引用数据类型
	全部为null
	Person person  null
	String str     null
	int[] arr      null

null 
	是内存地址中非常特殊的东西！！！
```

#### 【补充知识点·JVM的GC机制--简述】

![图书管理员简述回收机制](.\img\图书管理员简述回收机制.png)

```
Java中内存管理机制GC就类似与图书管理员
	1. 在单位时间内，检查当前Java程序使用的内存中是否存在无主内存
	2. 标记无主内存，多次标记的情况下，会将无主内存释放，归还内存空间
好处：
	1. 让程序员管理内存更加方便
	2. 内存管理是完全自动化的
劣势：
	1. 内存回收效率不高
	2. 内存管理出现泄漏问题
```

#### 二分法查找

```
特征：
	1. 要求查询的数组必须有序
	2. 多个指定数据情况下，无法告知到底是第几个数据出现
	3. 没有找到数据返回负数
演示:
	1 3 5 7 9 11 13 15 17 19
例如:
	查询元素 13的下标位置
	第一步:
		中间下标元素-->下标为4 元素值=9 
		最小下标为0
		最大下标为9
		9 < 13 
		需要修改最小下标 ==> 中间下标 + 1 ==> 5
	第二步:
		中间下标元素是 下标为7 元素值=15
		最小下标为5
		最大下标为9
		15 > 13
		需要修改最大下标 ==> 中间下标 - 1 ==> 6
	如此循环，直到得到结果。
```

代码

```java
package com.fs.a_array;

/*
 * 二分法查找
 */
public class Demo1 {
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
		
		int halfSearch = halfSearch(arr, 13);
		System.out.println(halfSearch);
	}
	
	/*
	 * 方法分析：
	 * 		public static 不要问
	 * 		返回值类型：
	 * 			int
	 * 		方法名:
	 * 			halfSearch
	 * 		形式参数列表:
	 * 			(int[] sortedArray, int find)
	 * 方法声明：
	 * 		public static int halfSearch(int[] sortedArray, int find)
	 */
	/**
	 * 二分法查找算法
	 * 
	 * @param sortedArray 这里要求是一个int类型数组，并且是进过排序之后的升序数组
	 * @param find 需要查询的元素
	 * @return 返回值大于等于0找到元素下标位置，没有找返回-1
	 */
	public static int halfSearch(int[] sortedArray, int find) {
		int minIndex = 0;
		int maxIndex = sortedArray.length - 1;
		int mid = (minIndex + maxIndex) / 2;
		
		while (minIndex <= maxIndex ) {
			if (sortedArray[mid] > find) {
				maxIndex = mid - 1;
			} else if(sortedArray[mid] < find) {
				minIndex = mid + 1;
			} else {
				return mid;
			}
			mid = (minIndex + maxIndex) / 2;
		}
		
		return -1;
	}
}
```

