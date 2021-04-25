class Demo7 {
	public static void main(String[] args) {
		int i = 0;
		
		while (i < 10) {
			System.out.println("饿了吃肉");
			i += 1;
			if (5 == i) {
				System.out.println("continue");
				continue;
			}
			
			// while循环中变更条件若在这，会在5==i之后被跳过而 陷入无限循环
			// i += 1; 
			
		}
		
		for (int j = 0; j < 10; j++) {
			System.out.println("酱牛肉");
			if (5 == j) {
				System.out.println("continue");
				continue;
			}
			
			System.out.println("兰州牛肉面");
		}
	}
}