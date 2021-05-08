package com.fs.a_interface;

interface C {
	void testC();
}

interface D {
	void testD();
}

/**
 * 接口之间可以多继承
 * @author fStardust
 *
 */
interface E extends C, D {
	void testE();
}

class TypeB implements E {

	@Override
	public void testC() {
		// 5V1A
		System.out.println("C协议");
	}

	@Override
	public void testD() {
		// 5V2A
		System.out.println("D协议");
	}

	@Override
	public void testE() {
		// 8V2A
		System.out.println("E协议");
	}
	
}

public class Demo2 {

}
