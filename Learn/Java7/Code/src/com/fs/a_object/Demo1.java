package com.fs.a_object;

/**
 * ���ﶨ�����һ��Person��
 * 
 * @author fStardust
 *
 */
class Person{
	// ��������������ʹ�ó�Ա����Field
	// ʹ��String��������Person�����������
	String name;
	
	// ʹ��int������������Person�����������
	int age;
	
	// ʹ��char������������Person����Ա�����
	char gender;
	
	// ʹ�÷�������Person��ĳԷ���Ϊ
	public void eat(String food) {
		System.out.println("��" + food);
	}
	
	// ʹ�÷�������Person���˯����Ϊ
	public void sleep() {
		System.out.println("˵��������ܲ��ţ��Ǵ��ȶ�����");
	}
	

}
public class Demo1 {
	public static void main(String[] args) {
		// ���ﴴ����һ��Person����󣬶�����person
		Person person = new Person();
		System.out.println(person);
		/*
		 * com.fs.a_object.Person@4926097b
		 * com.fs.a_object --> �����İ���
		 * Person �������ͣ����ﴴ���Ķ�����һ��Person�����
		 * @4926097b ��ǰ��������ڴ�ռ��е��׵�ַ/��ϣ�룡ʮ������չʾ��ʽ 
		 */
		
		Person person1 = new Person();
		System.out.println(person1);
		/*
		 * com.fs.a_object.Person@762efe5d
		 * ���ֵڶ���Person����� person1�׵�ַ�ռ�@762efe5d �͵�һ������һ��
		 * ���������׵�ַ��һ�£���ζ�Ų���ͬһ������
		 */
		
		// ͨ��Person����� person�������ڳ�Ա����
		// ����ֵ��Person�������person�ж�Ӧ�ĳ�Ա����
		person.name = "�ǲ�˹";
		person.age = 26;
		person.gender = '��';
		
		// ��ȡֵ��չʾPerson�����person�б���ĳ�Ա��������
		System.out.println("Name:" + person.name);
		System.out.println("Age:" + person.age);
		System.out.println("Gender" + person.gender);
		
		// ͨ��Person�����person�������ڳ�Ա����
		person.eat("������");
		person.sleep();
		
	}
}

























