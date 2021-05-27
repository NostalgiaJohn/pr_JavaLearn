package com.system.studetn.fs.manager;

import org.junit.Test;

import com.system.studetn.fs.compare.MyComparator;
import com.system.studetn.fs.entity.Student;
import com.system.studetn.fs.mainProject.StudentManager;

/**
 * 功能测试类
 * 
 * @author fStardust
 *
 */
public class SystemTest {
	@Test
	public void testStudent() {
		Student student1 = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		Student student4 = new Student();
		Student student5 = new Student();
		Student student6 = new Student("张三", 16, '男', 99, 95, 98);
		
		System.out.println(student1);
		System.out.println(student2);
		System.out.println(student3);
		System.out.println(student4);
		System.out.println(student5);
		System.out.println(student6);
			
	}
	
	@Test
	public void testAdd() {
		StudentManager studentManager = new StudentManager();
		                 
		studentManager.add(new Student());                         
		studentManager.add(new Student());                         
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		
		
		studentManager.show();
	}
	
	@Test
	public void testInsert() {
		StudentManager studentManager = new StudentManager();
		
		studentManager.add(new Student());                         
		studentManager.add(new Student());                         
		studentManager.add(new Student());                         
		studentManager.add(new Student());                         
		studentManager.add(new Student());                         
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		
		studentManager.add(5,new Student("张三", 16, '男', 99, 95, 98));
		
		studentManager.show();
	}
	
	@Test
	public void testRomve() {
		StudentManager studentManager = new StudentManager();
		
		studentManager.add(new Student());                         
		studentManager.add(new Student());                         
		studentManager.add(new Student());                         
		studentManager.add(new Student());                         
		studentManager.add(new Student());                         
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		
		studentManager.add(5,new Student("张三", 16, '男', 99, 95, 98));
		
		System.out.println(studentManager.remove(18));
		
		System.out.println();
		studentManager.show();
	}

	@Test
	public void testModify() {
		StudentManager studentManager = new StudentManager();
		
		studentManager.add(new Student());                         
		studentManager.add(new Student());                         
		studentManager.add(new Student());                         
		studentManager.add(new Student());                         
		studentManager.add(new Student());                         
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		
		studentManager.add(7,new Student("张三", 16, '男', 99, 95, 98));
		
		studentManager.modify(6);
		
		System.out.println();
		studentManager.show();
	}

	@Test
	public void testSort() {
		StudentManager studentManager = new StudentManager();
		                      
		studentManager.add(new Student("张三", 116, '男', 9, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 19, 95, 98));
		studentManager.add(new Student("张三", 126, '男', 29, 95, 98));
		studentManager.add(new Student("张三", 163, '男', 39, 95, 98));
		studentManager.add(new Student("张三", 1, '男', 129, 95, 98));
		studentManager.add(new Student("张三", 13, '男', 9, 95, 98));
		studentManager.add(new Student("张三", 16, '男', 99, 95, 98));
		studentManager.add(new Student("张三", 12, '男', 89, 95, 98));
		studentManager.add(new Student("张三", 15, '男', 39, 95, 98));
		studentManager.add(new Student("张三", 19, '男', 59, 95, 98));
		
		// MyComperator匿名内部类的匿名对象直接作为方法参数
		studentManager.selectSortUsingComparator(new MyComparator() {
			
			@Override
			public boolean compare(Student stu1, Student stu2) {
				
				return stu1.getMathScore() > stu2.getMathScore();
			}
		});
		
		
	}
}
