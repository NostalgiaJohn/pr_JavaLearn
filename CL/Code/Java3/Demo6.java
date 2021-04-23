// 展示break关键字使用方式
class Demo6 {
	public static void main(String[] args) {
		// while 循环
		int i = 10;
		
		while (i > 0) {
			System.out.println("蛋炒饭");
			i -= 1;
			
			// 使用if分支结构加入条件！
			// 在开发中使用==判断，尽量满足常量在前，变量在后
			if (5 == i) {
				System.out.println("饿了");
				// 跳出循环！
				break;
			}
		}
		
		int j = 10;
		
		do {
			System.out.println("扬州炒饭");
			j -= 1;
			
			if (5 == j) {
				System.out.println("真饿了");
				break;
			}
		} while (j > 0);
		
		for (int k = 0; k < 10; k++) {
			System.out.println("如果有羊，就做红烧羊肉");
			if (5 == k) {
				System.out.println("做梦吧");
				break;
			}
		}
	}
}