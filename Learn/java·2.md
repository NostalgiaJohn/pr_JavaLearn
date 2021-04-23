# Java·2

[toc]



# 第二讲·运算符和分支结构

## 2.1算术运算符

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

## 2.2其他运算符

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

      

## 2.3控制台输入

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

## 2.4分支结构

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



## 2.5局部变量

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



## 练习

判断是否是闰年

```
// 能被4整除，但不能被100正确；或者能被400整除。
(year % 4 == 0 && year % 100 != 0) || year % 400 == 0
// LeapYear.java
```

判断一个字符是不是大写英文字符

```
// A~Z 
// 注意:不要使用ASCII吗 --字符就用字符
ch >= 'A' && ch <= 'Z'
```

