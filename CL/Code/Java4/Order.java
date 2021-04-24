/*
实现点菜功能
	
方法功能单一性问题
	功能越单一，整个方法的复用度、可移植性都会很好！
	模块化开发的思想！
*/
class Order {
	public static void main(String[] args) {
			
	}
	
	/*
	需求：
		展示菜单的方法
	方法分析;
		public static
	返回值类型;
		void
	方法名：
		showMenu 展示彩带你
	形参列表：
		无参数--()
	*/
	/**
	* 展示菜单的方式
	*/
	public static void showMenu () {
		System.out.println("1. 酱牛肉 88");
		System.out.println("2. 蛋炒饭 18");
		System.out.println("3. 拍黄瓜 12");
		System.out.println("4. 大盘鸡 68");
		System.out.println("5. 烤羊排 138");
		System.out.println("6. 下单");
	}
	
}