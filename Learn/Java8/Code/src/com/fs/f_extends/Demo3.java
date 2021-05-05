package com.fs.f_extends;

final class A {
	
	// The blank final field name may not have been initialized
	// ��ǰ��final���εĳ�Ա����nameû�б���ʼ����
	// -->final���εĳ�Ա�����ڶ���ʱ�����ʼ��
	public final String name = "����";
	
	// final���εķ������ܱ�������д��Ϊ����ģʽ
	public final void testA() {
		System.out.println("A��ĳ�Ա����");
	}
}

// The type B cannot subclass the final class A
// B�಻�ܼ̳�final���ε�A��
//class B extends A {
	// ��дA���е�testA����
	// The method testA() of type B must override or implement a supertype method
	// ������дA���еķ���
//	@Override
//	private void testA() {
//		System.out.println("B����дA����");
//	}
//}

public class Demo3 {
	public static void main(String[] args) {
		final int num = 10;
		/*
		 * The final local variable num cannot be assigned. It must be blank and not using a compound assignment
		 * final���εľֲ�����һ������ֵ��֮���޷�����
		 */
//		num = 20;
	}
}
