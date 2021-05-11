package com.system.studetn.fs.compare;

import com.system.studetn.fs.entity.Student;


/**
 * 自定义学生类比较器接口
 * 
 * @author fStardust
 *
 */
public interface MyComparator {
	/**
	 * 自定义学生属性比较方式接口
	 * 要求比较的是两个Student类型，比较方式由MyComparator接口实现类对象来完成
	 * 
	 * @param stu1 Student类对象
	 * @param stu2 Student类对象
	 * @return 满足条件返回true， 不满足条件返回false
	 */
	boolean compare(Student stu1, Student stu2);
}
