package com.system.studetn.fs.mainProject;

import com.system.studetn.fs.entity.Student;

/**
 * 学生管理类
 *  
 * @author fStardust
 *
 */
public class StudentManager {
	/**
	 * 保存学生数据的Student类型数组
	 * 这里只有一个数组的引用，并没有数组的真实空间
	 */
	private Student[] allStus;
	
	/**
	 * 这里是允许的数组的最大值
	 */
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	
	/**
	 * 定义一个成员变量，私有化静态final修饰，描述默认初始化容量
	 */
	private static final int DEFAULT_CAPACITY = 10;
	
	/**
	 * 数组有效元素计数器，记录当前数组中有效元素数量
	 */
	private int size = 0;
	
	/**
	 * 构造方法
	 * 这里需要提供一个数组的初始化容量进行数据的保存和操作
	 */
	public StudentManager() {
		// 给予初始化容量，可以保存10个学生数据
		allStus = new Student[DEFAULT_CAPACITY];
	}
	
	/**
	 * 给予用户初始化底层保存数据的数组容量大小空间
	 * 
	 * @param initCapacity 用户指定的初始化容量，不能小于等于0，不能大于MAX_ARRAY_SIZE
	 * 	MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8
	 */
	public StudentManager(int initCapacity) {
		// 不允许
		if (initCapacity <= 0 || initCapacity > MAX_ARRAY_SIZE) {
			System.out.println("超过合理范围，给予一个默认的初始化容量使用");
			allStus = new Student[DEFAULT_CAPACITY];
		} else {
			// 满足要求，按照用户指定的容量穿件对应的数组
			allStus = new Student[initCapacity];
		}
	}
	
	/*
	 * 增加学生方法
	 * 方法分析：
	 * 	权限修饰符 public
	 * 	不需要static修饰
	 * 	返回值类型：
	 * 		添加成功返回ture，失败返回false
	 * 	方法名：
	 * 		add
	 * 	形式参数列表：
	 * 		Student类对象
	 * 		(Student stu)
	 * 方法声明:
	 * 	public boolean add(Student student)
	 */
	/**
	 * 添加一个学生类对象到底层Student数组allStus中
	 * 
	 * @param student Student类型对象
	 * @return 添加成功返回true，否则返回false
	 */
	public boolean add(Student student) {
		// 调用指定下标插入元素的方法，只不过制定下标位置是size
		// 等价于尾插法！
		add(size,student);
		
		return true;
	}
	
	/*
	 * 需求：
	 * 	在指定下标位置添加指定学生类对象
	 * 方法分析：
	 * 	权限修饰符：public
	 * 	非静态修饰，需要使用类内非静态成员
	 * 	返回值：
	 * 		boolean
	 * 	方法名：
	 * 		add 方法的重载机制，方法参数不一致，满足重载要求
	 * 	形式参数列表;
	 * 		1. 指定下标位置，0 <= index <= size
	 * 		2. 指定的Student类对象
	 * 方法声明：
	 * 	public boolean add(int index, Student stu)
	 */
	/**
	 * 在指定下标位置添加指定元素
	 * 
	 * @param index 指定下标位置 0 <= index <= size
	 * @param stu Student类对象
	 * @return 添加成功返回true 失败返回false
	 */
	public boolean add(int index, Student stu) {
		// 判断用户传入的index数据是否合法
		if (index > size || index < 0) {
			System.out.println("Input Parameter is Invalid");
			return false;
		}
		
		// 容量不足可以扩容操作
		if (size == allStus.length) {
			grow(size + 1);
		}
		/*
		 * eg:数组插队操作
		 */
		for (int i = size; i > index; i--) {
			allStus[i] = allStus[i - 1];
		}
		
		allStus[index] = stu;
		size += 1;
		return true;
	}
	
	/*
	 * 需求
	 * 	根据学生ID号，删除对应的学生信息
	 * 
	 * 方法分析:
	 * 	权限修饰符：public
	 * 	非静态成员方法
	 * 	返回值类型：
	 * 		Student类对象，删除的Student类对象，用于后期的数据暂存服务
	 * 		给用户提供一个可以缓冲的余地
	 * 	方法名：
	 * 		remove 
	 * 	形式参数列表：
	 * 		Student ID号
	 * 		int id
	 * 方法声明：
	 * 	public Student remove(int id)
	 */
	/**
	 * 根据学生ID号，删除学生信息
	 * 
	 * @param id 指定的学生ID号
	 * @return 被删除的学生类对象，如果删除失败，返回null
	 */
	public Student remove(int id) {
		// 参数合法性判定
		if (id < 0) {
			System.out.println("Input Paramter is Invalid!");
			return null;
		}
		
		// 数组中的存放的学生类对象的ID比较
		int index = -1;
		
		// 循环结束可以找指定的下标位置
		for (int i = 0; i < size; i++) {
			if (allStus[i].getId() == id) {
				index = i;
				break;
			}
		}
		
		Student stu = null;
		
		if (index >= 0) {
			// 保存被删除学生类对象信息
			stu = allStus[index];
			// 删除操作
			for (int i = index; i < size - 1; i++) {
				allStus[i] = allStus[i + 1];
			}
			
			allStus[size - 1] = null;
			size -= 1;
		} 
		
		return stu;
	}
	
	public void show() {
		for (int i = 0; i < size; i++) {
			System.out.println(allStus[i]);
		}
 	}
	
	/*
	 * 添加方法需要考虑扩容问题
	 * 添加数据时会调用当前扩容方法、
	 * 	1. 自动调用
	 * 类外是否可以使用
	 * 	2. 不允许类外使用，只允许在add方法中发现容量不足时使用
	 * 	private方法
	 * 考虑最小扩容容量
	 * 	3. 满足当前添加操作的最小容量要求
	 * 
	 * 方法分析：
	 * 	private修饰，类外不能使用
	 * 	非静态方法，需要使用类内成员变量
	 * 	返回值类型：
	 * 		void
	 *	方法名：
	 *		grow
	 *	形式参数列表：
	 *		int minCapacity 最小容量要求
	 * 方法声明：
	 * 		private void grow(int minCapacity)
	 * 流程：
	 * 	数组的容量从基本语法要求，是不可以更改的！
	 * 	这里需要一个新的数组
	 * 	源数据数组中能够提供：
	 * 		1. 原始容量
	 * 		2. 原始数据
	 * 	1. 获取原数组容量
	 * 	2. 计算新数组容量，新数组容量是源数据数组的1.5倍左右
	 * 	3. 判断新数组容量要求是否满足最小容量要求
	 *  4. 创建新数组
	 *  5. 复制源数据数组中的内容到新数组中
	 *  6. 保存新数组首地址
	 */
	/**
	 * 底层保存Student数据数组扩容方法
	 * 
	 * @param minCapacity
	 */
	private void grow(int minCapacity) {
		// 1. 获取原数组容量
		int oldCapacit = allStus.length;
		// 2. 计算新数组容量，新数组容量是源数据数组的1.5倍左右
		// oldCapacit >> 1 当前数据右移一位 ==> 相当于 / 2;位移操作效率高一点
		int newCapacity = oldCapacit + (oldCapacit >> 1);
		
		// 3. 判断新数组容量要求是否满足最小容量要求
		if (minCapacity > newCapacity) {
			newCapacity = minCapacity;
		}
		
		// 4. 创建新数组
		Student[] temp = new Student[newCapacity];
		
		// 5. 复制源数据数组中的内容到新数组中
		for (int i = 0; i < size; i++) {
			temp[i] = allStus[i];
		}
		
		// 6. 保存新数组首地址
		allStus = temp;
 	}
}












