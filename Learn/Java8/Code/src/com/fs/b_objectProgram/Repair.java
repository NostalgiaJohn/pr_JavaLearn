package com.fs.b_objectProgram;
/**
 * �������
 * @author fStardust
 *
 */
public class Repair {
	private String name;
	private String addr;
	private String tele;
	
	public Repair() {}

	public Repair(String name, String addr, String tele) {
		this.name = name;
		this.addr = addr;
		this.tele = tele;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}
	
	/*
	 * ����ҵ���޵���
	 * ����������
	 * 	public ������
	 * 	����ֵ���ͣ�
	 * 		void
	 * 	��ʽ�����б�:
	 * 		������Ҫ������ǵ��ԣ���Ҫ��������
	 * 		��Computer�����
	 * 		(Computer computer)
	 * ����������
	 * 	public void repair(Computer computer)
	 */
	/**
	 * �����������Եķ�������Ҫ�Ĳ�����һ�������ĵ��Զ���
	 * 
	 * @param computer Computer�������һ̨����
	 * @throws InterruptedException 
	 */
	public void repair(Computer computer) throws InterruptedException {
		if (false == computer.isScreenShow()) {
			System.out.println("������...");
			Thread.sleep(2000);
			
			// ��������ԣ��ı����״̬
			computer.setScreenShow(true);
			System.out.println("������ϣ���Ǯ");
		} else {
			System.out.println("û��������ɶ��");
		}
	}
}
