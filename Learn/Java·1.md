# Java·1

[toc]

## 第一讲 · 首个代码

### 1.1HelloWord

#### 代码编写

```java
class FirstJava {
	public static void main(String[] args) {
		System.out.println("HelloWord");
	}
}
```

#### 编译执行

```
javac -编译工具
	javac 源文件名.java
		编译后生成 FirstJava.class 文件
		.class 字节码文件，二进制文件，需要借助JVM执行解释给CPU
		
java -执行工具
	java 类名
		终端：输出
```

### 1.2代码规范

#### 代码注释

```
1.  //单行注释
2.  /*多行注释*/
3.  /**文档注释*/ 
	-->生成外部文档：
	javadoc -d . HelloWorld.java
```

#### AJCG规范

<center style="color:red;font-size:20px">阿里巴巴Java开发规范</center>

```
1.  标识符：
	开发中标识符就是名字
	类名、方法名、变量名
	
2.	规范--部分
a.	字符范围：英文字母(A~Z a~z)数字() 唯一可以使用的标点符号_
b.	标识符要求必须英文字幕开头
c.	标识符严格区分大小写
d.	标识符没有严格的长度限制，但是会根据实际需求来限制标识符的长度
e.	标识符需要做到见名知意，动宾结构！！！
	规范格式
        studentAge	见名知意
        getStudentAge	动宾结构
	不允许：混拼 简评 拼音
f. 	推荐使用驼峰命名法和下划线命名法
	小驼峰：适用于 变量名、方法名
		首字母小写，只有每个单词首字母大写
	大驼峰：适用于 类名、接口名
		每个单词首字母大写
	下划线命名法：
		所有字母都是大写的情况下，为了区分单词之间的间隔
		JAVA_HOME DEFAULT_CAPACIYT
g.	已经被Java使用的关键字和保留字不得用于自定义标识符

```

### 1.3变量基本概念

#### 变量

变量组成：数据类型+变量名+值

定义流程：

```
//声明：
//	数据类型 变量名;
	int money; //开辟整数变量空间

//赋值
	//变量名 = 值;
	money = 100;//将指数值赋给变量

数据类型：
	基本数据类型--八大基本数据类型
		整数 *int为整数默认类型，若需为long类型赋值，须在值后加L ...
		小数/浮点数--科学计算法表示 *double为浮点数默认类型，若需为float类型赋值，须在值后加F
		布尔
		字符	
	引用数据类型
		字符串
		数组
		对象
```

注意：Java是强类型语言，**变量类型**必须与**数据类型**保持一致

 

| 整型  | 占用内存空间大小 | 取值范围              |
| :---- | :--------------- | :-------------------- |
| byte  | 1字节            | -2^7~2^7-1； -128~127 |
| short | 2字节            | -2^15~2^15-1          |
| int   | 4字节            | -2^31~2^31-1          |
| long  | 8字节            | -2^63~2^63-1          |

| 浮点型 | 占用内存空间大小 | 取值范围 |
| :----- | :--------------- | :------- |
| float  | 4字节            | 10^308   |
| double | 8                | 10^+308  |

| 布尔类型            | 占用内存空间大小 | 取值范围   |
| :------------------ | :--------------- | :--------- |
| boolean  ture/false | 1字节            | ture/false |

| 字符型 | 占用内存空间大小 | 取值范围                |
| :----- | :--------------- | :---------------------- |
| char   | 2字节            | Unicode字符集（万国码） |



#### 定义变量的第一行代码

##### 代码实录

```java
class VariableTest {
	public static void main(String[] args) {
		/* 整形变量 */
		byte bytNumber = 10;
		short shortNumber = 20;
		int intNumber = 30;
		long longNumber = 40L;
		
		/* 整型变量展示 */
		System.out.println(bytNumber);
		System.out.println(shortNumber);
		System.out.println(intNumber);
		System.out.println(longNumber);
		
		/* 浮点数变量 */
		float floatNumber = 3.14F;
		double doubeleNumber = 0.618;
		
		/* 浮点数变量展示 */
		System.out.println(floatNumber);
		System.out.println(doubeleNumber);
		
		/* 
		字符型变量
		字符常量：
			单引号包含的单个元素 'a'
		*/
		char ch1 = 'A';
		char ch2 = '中';
		
		/* 字符型变量展示 */
		System.out.println(ch1);
		System.out.println(ch2);
		
		/* 布尔变量 */
		boolean ret1 = true;
		boolean ret2 = false;
		
		/* 布尔变量展示 */
		System.out.println(ret1);
		System.out.println(ret2);
		
		// int num;
		// System.out.println(num);
		
		// num = 10;
		
		
	}
}
```



##### 问题总结

1. 数据类型不兼容问题

   ```
   VariableTest.java:16: 错误: 不兼容的类型: 从double转换到float可能会有损失
                   float floatNumber = 3.14;
                                       ^
   1 个错误
   
   计算机为了保证数据的精度，同时为了数据后期的延展性，会默认使用double类型。若需为float类型赋值，须在值后加F
   	修改：
   		float floatNumber = 3.14F;
   
   类似的--此处属于优化/规划
   	long类型变量赋值操作要求：在常量后加L。
   	修改：
   		long longNumber = 40L;
   		
   ** L,F,...要求用大写--用于区分 eg：l & 1；
   ```

2. Java中变量未赋值不能使用

   ```
   VariableTest.java:44: 错误: 可能尚未初始化变量num
                   System.out.println(num);
                                      ^
   1 个错误
   
   Java中规定变量未赋值情况，不能参与除赋值外的其他任何操作。避免了C中没有必要的野值问题
   
   ```

3. Java未定义不能使用

   ```
   VariableTest.java:46: 错误: 找不到符号
                   num = 10;
                   ^
     符号:   变量 num
     位置: 类 VariableTest
   1 个错误
   ```

##### 字符

1. 字符实录

   ```java
   class Demo {
   	public static void main(String[] args) {
   		char ch = '\'';
   		
   		System.out.println(ch);
   		
   		System.out.println("测试\n测试");
   		System.out.println("测试\t测试");
   		System.out.println("测试\\测试");
   		System.out.println("测试\\\\测试");
   		
   	}
   }
   ```

   

2. 字符常量基本概念

   ```
   英文单引号包含的单个元素
   ```

3. 转义字符

   ```
   \ -->转义字符标记
   	将有特定含义字符转换为无意义字符
   	或者把无意义字符转换为有含义字符
   	
   常用:
   	\'
   	\"
   	\n 换行，回车
   	\t tab键，制表符
   转义字符有且只能处理一个字符
   	\\ 表示一个反斜杠
   	\\\\ 表示两个反斜杠
   	
   ```

4. 字符常量的使用

   ```
   有且只允许使用字符本身！！！ eg：'A'
   
   优势：
   	1. 阅读性好
   	2. 保证数据类型一致化
   	3. 减少没有必要的歧义
   ```

##### **字符串【初次相识】**

1. 字符串数据类型

   ```
   字符和字符串的区别 --单 多 eg：羊肉和羊肉串
   
   字符串特定标记
   	"" 英文双引号包含的所有内容都是字符串本身
   String字符串数据类型	
   ```

#### 类型转换

1. 自动类型转换

   ```
   目标类型大于源类型
   ```

2. 强制类型转换 代码

   ```java
   // 正确代码：
   class Demo {
   	public static void main(String[] args) {
   		double num1 = 3.5;
   		
   		// 这里存在数据精度丢失，且不可逆
   		int num2 = (int) num1;
   		
   		System.out.println(num1);
   		System.out.println(num2);
   		
   		double num3 = (double) num2;
   		System.out.println(num3);
   		
   	}
   }
   
   //输出：3.5; 3; 3.0
   ```

3. 强制类型转换

   ```
   目标类型小于源类型 --精度缺失
   eg:
   	double类型保存到int类型，这里
   	
   普通转换 报错-->
   Demo.java:5: 错误: 不兼容的类型: 从double转换到int可能会有损失
                   int num2 = num1;
                              ^
   1 个错误
   
   【个人建议】
   	对于基本数据类型的强制转换，不建议使用，会导致数据精度的丢失，也可能导致其他问题。
   	eg：上述函数num1 = 3.9999999999999时；num2会输出为 4
   	
   【用处】
   	强制类型转化在面向对象开发中，可以用来操作对象间的关系。
   ```



## 1.4运算符和分支结构

#### 算术运算符

1. 算术运算符

   ```
   + - * / % () 
   
   1. 算术原则：数学
   2. % 取余
   	
   优先级问题：
   	简单粗暴：加括号
   	
   = 赋值号
   	作用是将赋值号右侧的数据，赋值给左侧的【变量】
   	
   算术运算符优化
   	+=, -=, *=, /=, %=,
   
   ```

2. 代码实例

   ```java
   class Demo {
   	public static void main(String[] args) {
   		/* 算术运算符演示 */
   		int num1 = 10;
   		int num2 = 20;
   		
   		/*
   		1. 变量操作过程中，注意变量的值是否发生更改
   		2. 有且只有赋值操作可以修改变量的内容，没有赋值无法更改
   		*/
   		num2 = num1 + num2; // num1 = 10 num2 = 30
   		num2 = num1 + num2; // num1 = 10 num2 = 300
   		num2 = num1 / num2; // num1 = 10 num2 = 0
   		num2 = num1 * num2; // num1 = 10 num2 = 0
   		
   		num1 = 10;
   		num2 = 20;
   		num2 += num1;
   		System.out.println(num2); // num2 = 30
   		System.out.println(num1); // num1 = 10
   	}
   }
   ```

#### 其他运算符

   1. 关系运算符
   
      ```java
      /*
      <  <=  >  >=
      == != == !=
      关系运算符的结果有且只有true / false
      用于在开发中的条件判断使用
      */
      
      class Demo1 {
      	public static void main(String[] args) {
      		boolean ret = 10 > 5;
      		System.out.println(ret); // F  
      		
      		ret = 5 >= 5; 
      		System.out.println(ret); // T 
      		
      		ret = 10 < 5;
      		System.out.println(ret); // F
      		
      		ret = 10 <= 5;
      		System.out.println(ret); // T
      		
      		ret = 10 == 5;
      		System.out.println(ret); // F
      		
      		ret = 10 != 5;
      		System.out.println(ret); // T
      	}
      }
      ```
   
   2. 逻辑运算符
   
      ```java
      /*
      && 
      	与，并且
      	同真为真，有假即假
      ||
      	或，或者
      	有真即真，同假为假
      !
      	非，取反
      
      逻辑运算符：
          一般用于组合条件的判断，条件过滤，多情况分析。
      */   
      class Demo1 {
      	public static void main(String[] args) {
      		boolean ret = 5 > 3 && 10 > 5;
      		System.out.println(ret); // T
      		
      		ret = 5 > 10 && 10 > 8;
      		System.out.println(ret); // F
      		
      		ret = 5 > 10 || 10 > 8;
      		System.out.println(ret); // T
      		
      		ret = 5 > 10 || 10 > 20;
      		System.out.println(ret); // F
      		
      		ret = !(10 > 5);
      		System.out.println(ret); // F
      	}
      }
      ```
   
      
   
   3. 自增自减运算符
   
      ```
      【注意事项】
      	1. 自增自减运算符有且只能操作变量！！
      	2. 自增自减运算符独立存在！！
      	3. 【建议】使用+= 1和-= 1 代替自增自减运算符 --eg：Swift取消自增自减运算符
      	
      ++ ：自增1，num++ 运行顺序为后执行
      -- ：自减1
      ```
   
   4. 自增自减代码实例
   
      ```java
      class Demo2 {
      	public static void main(String[] args) {
      		int num = 10;
      		
      		// 先执行该语句(此处为：打印语句)，再执行自增操作
      		System.out.println("num++ : " + num++); // 10 
      		System.out.println("num : " + num); // 11
      		
      		// 效果同上
      		System.out.println("num : " + num); // 11 
      		num++;
      		System.out.println("num : " + num); // 12
      		
      		// 先执行自增操作，再执行该语句
      		System.out.println("num++ : " + ++num); // 13
      		System.out.println("num : " + num); // 13
      	}
      }
      ```
   
      
   
   5. 【逻辑运算符断路原则问题】
   
      ```java
      class Demo3 {
      	public static void main(String[] args) {
      		int num = 10;
      		boolean ret = 10 > 5 && num++ > 10;
      		
      		
      		System.out.println("num : " + num); // 11
      		System.out.println("ret : " + ret); // F --执行完判断后再执行自增
      		
      		int num1 = 10;
      		boolean ret1 = 10 > 15 && num++ >= 10;
      		/*
      		断路原则问题：
      			逻辑与断路原则问题
      			在逻辑与表达式中，出现第一个为false条件时，整个表达式结果已经明确，不需要继续执行--节约计算资源，提高效率。
      		*/
      		System.out.println("num1 : " + num1); // 10
      		System.out.println("ret1 : " + ret1); // F
      		
      		int num2 = 10;
      		boolean ret2 = 10 > 5 || ++num2 > 5;
      		/*
      		断路原则问题：
      			逻辑或断路原则问题
      			在逻辑或表达式中，出现第一个为true条件时，整个表达式结果已经明确，不需要继续执行--节约计算资源，提高效率。
      		*/
      		System.out.println("num2 : " + num2); // 10 
      		System.out.println("ret2 : " + ret2); // T
      	}
      }
      ```
   
      

#### 控制台输入

1. 从键盘上获取用户录入的数据

   ```
   1. 导包
   	import java.util.Scanner;
   	class Demo1 {}
   	
   2. 获取Scanner的变量,扫描器的一个变量
   	Scanner sc = new Scanner(System.in);
   	
   3. 使用Scanner其中的方法
   	获取int类型 sc.nextInt();
   	获取double类型 sc.nextDouble();
   	获取String类型 sc.next(); sc.nextLine();
   	获取一个char类型 sc.next().charAt(0); sc.nextLine().charAt(0);
   	
   ```

2. 代码

   ```java
   // 导包，让当前代码拥有可以使用Scanner的能力
   import java.util.Scanner;
   
   class Demo4 {
   	public static void main(String[] args) {
   		/*
   		int num = 0;
   		Scanner sc = new Scanner(System.in);
   		
   		System.out.println("请输入一个整数：");
   		num = sc.nextInt();
   		
   		System.out.println("num : " + num);
   		*/
   		char ch = '\0'; // 控制符
   		Scanner sc = new Scanner(System.in);
   		
   		System.out.println("请输入一个字符：");
   		ch = sc.next().charAt(0);
   		
   		System.out.println("ch : " + ch);
   	}
   }
   ```

#### 分支结构

##### 基本if选择结构

```java
if(/* 布尔类型的表达式 true or false */){
    // 语句体
}
// 后续代码

/*
执行流程
	首先判断布尔类型的表达式 true 还是false
	true 先执行语句体。再执行后续代码
	false 直接执行后续代码
*/

class Demo5 {
	public static void main(String[] args) {
		boolean flag = false;
		
		if (flag) {
			System.out.println("语句体");
		}
		
		System.out.println("后续代码");
	}
}
```

##### if-else选择结构

```java
if(/* 布尔类型的表达式 */){
    // true语句体
}else {
	// false语句体
}

/*
执行流程：
	首先判断if后的布尔类型数据是什么
	如果是true，执行true语句体
	如果是false，执行false语句体
*/

class Demo6{
	public static void main(String[] args) {
		boolean flag = true;
		
		if (flag) {
			System.out.println("true语句块");
		}else {
			System.out.println("false语句块");
		}
		
		System.out.println("后续代码...");
	}
}
```

##### if - else  if选择结构

```java
/*
学生成绩划分
	>= 90 优秀
	>= 80 良好
	>= 70 中等
	>= 60 合格
	< 60 不合格
*/
if(/* 布尔类型的表达式 */){
    // 处理方式1
}else if {
	// 处理方式2
}else if {
	// 处理方式3
}else {
	// 无匹配项处理方式
}

/*
执行流程：
	使用已有条件匹配if之后的布尔条件
	匹配到任何一个布尔条件，执行对应结果，结束判断结果，然后执行后续代码
	如果没有任何一个条件匹配，执行else里面的语句，然后执行后续代码
	
	语法上可以省去else
*/

```

学生成绩代码Demo7

```java
import java.util.Scanner;

class Demo7 {
	public static void main(String[] args) {
		int score = 0;
		//Scanner扫描器变量
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入学生的成绩：");
		score = sc.nextInt();
		
		// 用户输入数据合法性判断问题
		if (score < 0 || score > 100) {
			System.out.println("输入错误");
			// 程序退出
			System.exit(0);
		}
		//if - else if
		if (score >= 90) {
			System.out.println("优秀");
		} else if (score >= 80) {
			System.out.println("良好");
		} else if (score >= 70) {
			System.out.println("中等");
		} else if (score >= 60) {
			System.out.println("及格");
		} else {
			System.out.println("不及格");
		}
	}
}
```

【补充--用于输入数据的合法性判断问题】

```
在实际要求中，存在生活中的数据合法性和程序运行的语法要求冲突的问题。
在程序的运行过程中，我们需要对用户输入的数据进行合法性判断，如果用户输入的数据不在合法范围内，需要给予用户提示，并不可以进入正常的代码运行过程中。

对于学生成绩--demo7而言,0~100以外都是不合法的！
1. 不能大于100 score > 100
2. 不能小于0 score < 0
3. 满足任何一项都非法 score > 100 || score < 0
4. if判断
```

##### 嵌套if选择结构

```java
class Demo10 {
	public static void main(String[] args) {
		int score = 100;
		
		if (score >= 90) {
			if (score >= 95) {
				System.out.println("A+");
			} else {
				System.out.println("A-");
			} 
		} else {
			System.out.println("A--");
		}	
	}
}
/* 嵌套最多不超三层 */
```

##### switch- case分支结构

```java
switch (/* 变量|表达式 */) {
    case 值1:
        // 处理方式1
        break;
    case 值2:
        // 处理方式2
        break;
    default:
        // 最终处理方式
        break;
}
/*
执行流程
	取出switch小括号中的数据匹配对应的case选择
	如果存在case匹配，执行对应的处理方式
	如果没有任何的一个case匹配。
	执行default处理方式。

switch case使用注意事项
	1. break关键字作用是用于跳出对应的case选项
	2. break省略后，执行对应的case选择，会继续运行至下一个break或者大括号结尾终止switch - case运行
	3. 在case选项中不允许出现相同选项，语法不允许
	4. 在switch-case语句体中，能够执行的有且只有csae 和default后的语句
	5. default可以省略，按照自己的业务逻辑需要考虑是否省略default选择，default可以处理用户在输入过程中超过case选项的一些特殊情况
*/

import java.util.Scanner;

class Demo8 {
	public static void main(String[] args) {
		int choose = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. 肥宅快乐水");
		System.out.println("2. 咖啡");
		System.out.println("3. 果汁");
		System.out.println("4. 奶茶");
		System.out.println("请输入您的选择：");
		choose = sc.nextInt();
		
		switch (choose) {
			case 1:
				System.out.println("3RM 肥宅快乐水");
				break;
			case 2:
				System.out.println("42RM 咖啡");
				break;
			case 3:
				System.out.println("5RM 果汁");
				break;
			case 4:
				System.out.println("10RM 奶茶");
				break;
			default:
				System.out.println("并没有这一项哦");
				break;
				
		}
	}
}
```

##### 条件运算符/三目运算符

```java
/*
格式：
	条件判断? ture处理方式 : false 处理方式
*/

class Demo9 {
	public static void main(String[] args) {
		// 可以取巧，但不要多次使用
        int num = 10 > 5 ? 888 : 666;
		
		// 类似if - else 结构 但三目运算符局限性很大
		System.out.println(num); // 888
	}
}
```



##### 局部变量

```java
局部变量：存在于代码块中的变量！

class Demo11 {
	public static void main(String[] args) {
		int num = 10;
		
		if (num > 5) {
			// num2 是一个局部变量，有且只能在当前if大括号中使用
			int num2 = 20;
			
			// 可以使用num 其作用范围是整个main方法代码框
			// 在一个变量的作用域范围内，不能重定义同名变量。
			// int num = 10;
			
		}
		
		System.out.println(num);
		// System.out.println(num2);
		
	}
}
```









