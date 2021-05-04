package com.fs.c_car;

/**
 * ������
 * 	��Ա����
 * 	Engine�����
 * 	Tyre�����
 * @author fStardust
 *
 */
public class Car {
	/**
	 * ������Ҫһ��Engine�����
	 */
	private Engine engine;
	
	/**
	 * Tyre��̥�����
	 */
	private Tyre tyre;
	
	public Car() {}
	
	
	/**
	 * ���в�����Car�๹�췽������Ҫ�Ĳ���������Engine������Tyre�����
	 * 
	 * @param engine ���������һ�������ķ�����
	 * @param tyre ��̥�����һ����������̥
	 */
	public Car(Engine engine, Tyre tyre) {
		this.engine = engine;
		this.tyre = tyre;
	}

	/**
	 * ��ȡ��ǰCar�������Engine���󣬿������Ϊ�鿴����������
	 * 
	 * @return	Engine�����
	 */
	public Engine getEngine() {
		return engine;
	}

	/**
	 * �������� ��Ҫһ��Engine�����
	 * 
	 * @param engine Engine�����
	 */
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	/**
	 * �鿴��̥
	 * 
	 * @return	��ȡTyre��̥�����
	 */
	public Tyre getTyre() {
		return tyre;
	}

	/**
	 * ������̥
	 * 
	 * @param tyre Tyre�����
	 */
	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}
	
	public void show() {
		System.out.println("Engine Name:" + engine.getName() + " Capacity:" + engine.getCapacity());
		System.out.println("Tyre Name:" + tyre.getName() + " Size:" + tyre.getSize());
	}
	

}
