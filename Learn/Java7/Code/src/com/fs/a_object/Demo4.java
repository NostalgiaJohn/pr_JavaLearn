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
 * this�ؼ��ֱ�ʾ���õ�ǰ����������󣬻����ǵ�ǰ���췽���г�ʼ���������
 */
public class Demo4 {
	public static void main(String[] args) {
		SingleDog singleDog = new SingleDog();
		
		System.out.println("Instance" + singleDog);
		singleDog.test();
	}
}
