package com.fs.d_anonymousObject;

class SingleDog{
	String name;

	public SingleDog() {}

	public SingleDog(String name) {
		this.name = name;
	}
	
	public void test() {
		System.out.println("SingleDog���Ա����");
	}
}

public class Demo {
	public static void main(String[] args) {
		SingleDog singleDog = new SingleDog();
		
		singleDog.name = "һ";
		singleDog.test();
		
		// ��������ֱ�ӵ������ڵĳ�Ա����
		new SingleDog().test();
		new SingleDog().name = "��";
		System.out.println(new SingleDog().name);
		
		// ������Դ���һ��SingleDog����
		testObject(singleDog);
		// ����һ������������Ϊ�����Ĳ���
		testObject(new SingleDog());
		
		/*
		 * ������ʽ--�õ����������ࣻ���油��
		 * BufferedInputStream bufferedInputStream = new BufferedInputStream( 
		 * 	new FileInputStream( new File("C:/aa/1.txt")));
		 */
	}
	
	/**
	 * ���Է���
	 * @param singleDog ��Ҫһ��SingleDog��������
	 */
	public static void testObject(SingleDog singleDog) {
//		System.out.println(singleDog);
	}
}
