package com.fs.f_extends;

class Father {
	public void game() {
		System.out.println("�ƽ��");
	}
	
	public void work() {
		System.out.println("��е����ʦ");
	}
}

class Son extends Father{
	/*
	 * @Override ע��
	 * 	������д�ϸ��ʽ���
	 */
	@Override
	public void game() {
		// ���յ�ǰ�����������ɴ���
		System.out.println("LOL");
	}
	
	@Override
	public void work() {
		System.out.println("���ʦ");
	}
}

public class Demo1 {
	public static void main(String[] args) {
		Son son = new Son();
		
		son.game();
		son.work();
	}
}
