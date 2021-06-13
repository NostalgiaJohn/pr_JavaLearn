package com.fs.e_lambda;

interface Cook {
	void cooking();
}

public class Demo1 {
	public static void main(String[] args) {
		invokeCook(new Cook() {

			@Override
			public void cooking() {
				System.out.println("炒青菜");				
			}
		});
		
		invokeCook(() -> {
			System.out.println("土豆牛肉");
		});
		invokeCook(() -> System.out.println("孜然牛肉"));
	}
	
	/**
	 * 执行Cook实现类对象方法
	 * 
	 * @param cook
	 */
	public static void invokeCook(Cook cook) {
		cook.cooking();
	}
}
