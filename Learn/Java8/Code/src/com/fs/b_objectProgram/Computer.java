package com.fs.b_objectProgram;
/**
 * ������
 * 
 * @author fStardust
 *
 */
public class Computer {
	// ��Ա����--��Ļ�Ƿ�ok
	private boolean screenShow;
	
	public Computer() {}
	
	public Computer(boolean screenShow) {
		this.screenShow = screenShow;
	}

	public boolean isScreenShow() {
		return screenShow;
	}

	public void setScreenShow(boolean screenShow) {
		this.screenShow = screenShow;
	}



	/*
	 * �жϵ�ǰ��Ļ�Ƿ�ok��ok���Կ�ֱ���������ok�����ܿ�ֱ��
	 */
	public void computerRunning() {
		// �жϵ�����Ļ״̬
		if(screenShow) {
			System.out.println("ѧJava");
		} else {
			System.out.println("�޷�ѧJava...�޵���");
		}
		
	}
}
