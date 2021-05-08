package com.fs.b_polym;

/*
从生活映射USB接口
	interface USB
		规定USB设备必须完成的方法
		void connect();
		
鼠标类 implements USB 
	鼠标是一个USB设备，必须完成connect方法
键盘类 implements USB
	键盘是一个USB设备，必须完成connect方法

USB接口在电脑上，我们需要使用USB接口
 */
/**
 * USB接口
 * 
 * @author fStardust
 *
 */
interface USB {
	/*
	 * 要求所有USB设备必须完成的方法，
	 * 告知USB接口连接之后完成的功能是什么
	 */
	void connect();
}
/**
 * 鼠标类，遵从USB接口，实现connect方法
 * 
 * @author fStardust
 *
 */
class Mouse implements USB {

	@Override
	public void connect() {
		System.out.println("鼠标连接USB，控制光标");
	}
}

/**
 * Logi类， 继承Mouse鼠标类
 * 	1. 鼠标设备
 * 	2. Logi间接遵从USB接口，是一个USB设备
 * @author fStardust
 *
 */
class Logi extends Mouse {
	
}

/**
 * 键盘类，遵从USB接口，实现connect方法
 * 
 * @author fStardust
 *
 */
class Keyboard implements USB {

	@Override
	public void connect() {
		System.out.println("键盘连接USB，输入设备");
		
	}
}

/**
 * IKBC继承Keyboard类
 * 		1. 键盘设备
 * 		2. 间接遵从USB接口，也是一个USB设备
 * @author fStardust
 *
 */
class IKBC extends Keyboard {
	@Override
	public void connect() {
		System.out.println("IKBC C87 静音红轴");
	}
}

/**
 * PC电脑类，使用USB接口，通过USB接口连接一个USB设备
 * @author fStardust
 *
 */
class PC {
	/**
	 * 电脑类连接USB接口方法，需要一个USB接口
	 * 
	 * @param usb USB接口对应设备
	 */
	public void usbConnect(USB usb) {
		// usb设备执行connect方法
		usb.connect();
	}
}
public class Demo {
	public static void main(String[] args) {
		
		// 电脑中有一个方法是使用USB接口连接USB设备
		PC pc = new PC();
		
		// 鼠标和键盘都是USB设备
		Mouse mouse = new Mouse();
		Keyboard keyboard = new Keyboard();
		
		// 多态的使用-->父类引用指向子类
		// 电脑需要通过USB接口连接USB设备。mouse鼠标就是USB设备
		pc.usbConnect(mouse);
		// keyboarde是USB设备
		pc.usbConnect(keyboard);
		
		// 传入一个Logi类对象
		pc.usbConnect(new Logi());
		// 传入一个IKBC类对象
		pc.usbConnect(new IKBC());
		
	}
}
