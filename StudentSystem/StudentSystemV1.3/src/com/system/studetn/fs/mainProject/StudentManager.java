package com.system.studetn.fs.mainProject;

import java.util.ArrayList;
import java.util.Scanner;

import com.system.studetn.fs.compare.MyComparator;
import com.system.studetn.fs.entity.Student;
import com.system.studetn.fs.util.MyArrayList;

/**
 * 学生管理类
 *  
 * @author fStardust
 *
 */
public class StudentManager {
	
	/**
	 * 保存学生数据的MyArrayList类型数组
	 * 这里只有一个数组的引用，并没有数组的真实空间
	 */
	private MyArrayList<Student> allStus;
	
	/**
	 * 构造方法
	 * 这里需要提供一个数组的初始化容量进行数据的保存和操作
	 */
	public StudentManager() {
		// 给予初始化容量，可以保存10个学生数据
		allStus = new MyArrayList<Student>();
	}
	
	/**
	 * 给予用户初始化底层保存数据的数组容量大小空间
	 * 
	 * @param initCapacity 用户指定的初始化容量，不能小于等于0，不能大于MAX_ARRAY_SIZE
	 * 	MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8
	 */
	public StudentManager(int initCapacity) {
		allStus = new MyArrayList<Student>(initCapacity);
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
		return add(allStus.size(), student);
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
		allStus.add(index, stu);
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
	 * 问题：
	 * 	当前方法行数超过要求的代码行数过多！！！
	 * 
	 * @param id 指定的学生ID号
	 * @return 被删除的学生类对象，如果删除失败，返回null
	 */
	public Student remove(int id) {
		
		// 调用类内私有化方法，提供指定ID对应的下标位置
		int index = findIndexById(id);
		
		return allStus.remove(index);
	}
	
	/*
	 * 需求：
	 * 	修改指定ID学生的信息
	 * 方法分析：
	 * 	权限修饰符：public
	 * 	非静态成员方法修饰
	 * 	返回值：
	 * 		boolean 操作成功返回true 失败返回false
	 * 	方法名：
	 * 		modify
	 * 	形式参数列表：
	 * 		int id 指定学生ID号
	 * 方法声明：
	 * 	public boolean modify(int id)
	 */
	/**
	 * 修改指定ID学生的信息
	 * 
	 * @param id 指定的学生ID号
	 * @return 修改成功返回true，失败返回false
	 */
	public boolean modify(int id) {
		// 调用类内私有化方法，提供指定ID对应的下标位置
		int index = findIndexById(id);
		
		// 不存在指定元素
		if (-1 == index) {
			return false;
		}
		
		// 获取指定下标的元素
		Student stu = allStus.get(index);
		
		int choose = 0;
		// 退出标记
		boolean flag = false;
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			// 展示当前Student类对象数据情况
			System.out.println("ID:" + stu.getId());
			System.out.println("Name:" + stu.getName() + "Age:" + stu.getAge() + "Gender:" + stu.getGander());
			System.out.println("MathScore:" + stu.getMathScore() + "ChnScore:" + stu.getChnScore() + "EngScore:" + stu.getEngScore());
			System.out.println("TotalScore:" + stu.getTotalScore() + "Rank:" + stu.getRank());
			System.out.println("1. 修改学生姓名");
			System.out.println("2. 修改学生年龄");
			System.out.println("3. 修改学生性别");
			System.out.println("4. 修改学生数学成绩");
			System.out.println("5. 修改学生语文成绩");
			System.out.println("6. 修改学生英语成绩");
			System.out.println("7. 退出");

			choose = sc.nextInt();
			// 除去输入1 \n 之后的\n
			sc.nextLine();
			
			switch (choose) {
			case 1:
				System.out.println("请输入学生姓名：");
				String name = sc.nextLine();
				
				stu.setName(name);
				break;
			case 2:
				System.out.println("请输入学生年龄：");
				int age = sc.nextInt();
				
				stu.setAge(age);
				break;
			case 3:
				System.out.println("请输入学生性别：");
				char gender = sc.nextLine().charAt(0);
				
				stu.setGander(gender);
				break;
			case 4:
				System.out.println("请输入学生数学成绩：");
				int mathScore = sc.nextInt();
				
				stu.setMathScore(mathScore);
				break;
			case 5:
				System.out.println("请输入学生语文成绩：");
				int chnScore = sc.nextInt();
				
				stu.setChnScore(chnScore);
				break;
			case 6:
				System.out.println("请输入学生英语成绩：");
				int engScore = sc.nextInt();
				
				stu.setEngScore(engScore);
				break;
			case 7:
				flag = true;
				break;
				
			default:
				System.out.println("选择错误");
				break;
			}
			
			if (flag) {
				// 跳出循环结构！
				break;
			}
		}
		
		return true;
	}
	
	/*
	 * 需求：
	 * 	根据指定的ID获取的Student类对象
	 * 方法分析：
	 * 	公开方式：public 
	 * 	非静态成员方法
	 * 	返回值类型：
	 * 		Student类对象
	 * 	方法名：
	 * 		get
	 * 	形式参数列表：
	 * 		用户指定ID号
	 * 方法声明:
	 * 	public Student get(int id)
	 */
	/**
	 * 根据指定的ID获取的Student类对象
	 * 
	 * @param id 指定的ID号
	 * @return 找到返回对应的Student类对象，没有找到返回null
	 */
	public Student get(int id) {
		int index  = findIndexById(id);
		
		return allStus.get(index);
	}
	
	/*
	 * 排序算法
	 * 需求：
	 * 	年龄降序排序
	 * 方法分析：
	 * 	权限修饰符：public
	 * 	非静态成员方法
	 * 	返回值类型：
	 * 		void
	 * 	方法名：
	 * 		selectSortByAgeDesc
	 * 	形式参数列表：
	 * 		不需要参数
	 * 方法声明：
	 * 	public void selectSortByAgeDesc()
	 */
	/**
	 * 选择排序算法
	 * 但是需要依赖于MyComparator接口来提供排序算法核心比较内容
	 * 
	 * @param com MyComparator，遵从MyComparator接口实现类对象
	 */
	public void selectSortUsingComparator(MyComparator com) {
		// 这里不能在源数据数组中进行排序，需要保护数据
		// 拷贝一个新数组
		int size = allStus.size();
		Student[] sortTemp = new Student[size];
		
		for (int i = 0; i < sortTemp.length; i++) {
			sortTemp[i] = allStus.get(i);
		}
		
		// 选择排序算法
		for (int i = 0; i < size -1; i++) {
			int index = i;
			
			for (int j = i + 1; j < size; j++) {
				// 学生年龄比较
				// if(sortTemp[index].getAge() < sortTemp[j].getAge()) {index = j;}
				// 【核心比较方式】
				if (com.compare(sortTemp[index], sortTemp[j])) {
					index = j;
				}
			}
			
			if (index != i) {
				Student temp = sortTemp[index];
				sortTemp[index] = sortTemp[i];
				sortTemp[i] = temp;
			}
		}
		
		// 展示数据的过程
		for (int i = 0; i < sortTemp.length; i++) {
			System.out.println(sortTemp[i]);
		}
	}

	public void show() {
		for (int i = 0; i < allStus.size(); i++) {
			System.out.println(allStus.get(i));
		}
 	}

	/*
	 * 需求
	 * 	发现很多地方都需要使用一个通过学生ID获取当前学生
	 * 	在数组中下标位置的方法
	 * 方法分析：
	 * 	权限修饰符 private
	 * 		数组的下标位置是一个核心数据，如果提供给类外使用有可能导致其它问题
	 * 		该方法只有类内删除，修改，查询使用
	 * 	非静态成员方法
	 * 	返回值类型：
	 * 		int
	 * 	方法名：
	 * 		findIndexById
	 * 	形式参数列表
	 * 		int id
	 * 方法声明
	 * 	private int findIndexById(int id)
	 */
	/**
	 * 类内私有化成员方法，用于根据用户指定的ID号获取对应的学生类对象在底层数组中的下标位置，
	 * 提供给类内其他方法使用
	 * 
	 * @param id 指定的学生ID号
	 * @return 如果找到学生对象返回值大于等于0，没有找到返回-1
	 */	
	private int findIndexById(int id) {
		// 参数合法性判定，id不可能小于0
		if (id < 0) {
			System.out.println("Input Paramter is Invalid!");
			return -1;
		}
		
		int index = -1;
		int size = allStus.size();
		
		for (int i = 0; i < size; i++) {
			if (allStus.get(i).getId() == id) {
				index = i;
				break;
			}
		}
		
		return index;
	}	
}
