package com.fs.a_throwable;

/*
 * 自定义异常
 */
class NoGirlFriendException extends Exception {
	/**
	 * 无参数构造方法
	 */
	public NoGirlFriendException() {}
	
	/**
	 * 带有String类型参数的构造方法
	 * 
	 * @param message 描述当前的异常信息
	 */
	public NoGirlFriendException(String message) {
		super(message);
	}
}


public class Demo3 {
	public static void main(String[] args) throws NoGirlFriendException {
		try {
			buyOneFreeOne(false);
		} catch (NoGirlFriendException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		buyOneFreeOne(false);
	}
	
	/**
	 * 买一送一方法，需要判断是不是单身狗
	 * 
	 * @param singleDog boolean类型数据，true是单身，false表示有女朋友
	 * @throws NoGirlFriendException 没有女朋友异常
	 */
	public static void buyOneFreeOne(boolean singleDog) 
			throws NoGirlFriendException {
		if (singleDog) {
			throw new NoGirlFriendException("你还没有女朋友");
		}
		
		System.out.println("买一送一");
	}
}