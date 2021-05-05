package com.fs.f_extends;

 /*
 * abstractʹ��
 * 
 * ��һ������
 * 	Abstract methods do not specify a body
 * 	abstract��������һ��������
 * �����޸���ʾ����ݼ�ctrl+1
 * 	Remove method body
 * 
 * �ڶ�������
 * 	The abstract method Q in type LOLHero can only be defined by an abstract class
 * 	��LOLHero��ʹ��abstract���εķ���Q��ֻ�ܶ�����abstract���ε�����
 * �����޸���ʾ��
 * 	Make Type 'LOLHero' abstract
 * 
 * ����������
 * 	The type Yasuo must implement the inherited abstract method LOLHero.Q()
 * 	���ࣨ�����ࣩ����ʵ�ּ̳ж�����abstract LOLHero.Q()����
 * �����޸���ʾ��
 * 	Add unimplemented method
 * 	���û��ʵ�ֵĸ�����abstract����
 */
abstract class LOLHero {
	abstract public void Q();
	
	abstract public void W();
	
	abstract public void E();
	
	abstract public void R();
}

/*
 * ����̳и������ֱ��ʹ�ø���ķ�����
 * ������ʵ�������
 * 	(����LOL��Ӣ�۸���--������Ӣ������������)��
 * 		���ǿ��Է��ָ���ķ�����һ��������������ʹ�õ�
 * 		������û��һ��ǿ��Ҫ��(������ͨ����)
 * 
 * ����;
 * 	���﷨Լ����ǿ��Ҫ��������д����ķ���
 */
class Yasuo extends LOLHero {

	@Override
	public void Q() {
		System.out.println("ն����");
	}

	@Override
	public void W() {
		System.out.println("��֮�ϱ�");
	}

	@Override
	public void E() {
		System.out.println("̤ǰն");
	}

	@Override
	public void R() {
		System.out.println("����Ϣն");
	}
	
}

class Garen extends LOLHero {

	@Override
	public void Q() {
		System.out.println("�������");
	}

	@Override
	public void W() {
		System.out.println("����");
	}

	@Override
	public void E() {
		System.out.println("����");
	}

	@Override
	public void R() {
		System.out.println("������������");
	}
	
}

public class Demo2 {
	public static void main(String[] args) {
		Yasuo yasuo = new Yasuo();
		
		yasuo.Q();
		yasuo.W();
		yasuo.E();
		yasuo.R();
		
		Garen garen = new Garen();
		
		garen.Q();
		garen.W();
		garen.E();
		garen.R();
	}
}
