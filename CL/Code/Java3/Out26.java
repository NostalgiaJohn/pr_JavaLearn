class Out26 {
	public static void main(String[] args) {
		// while循环
		char ch1 = 'a';
		
		while (ch1 <= 'z') {
			System.out.println(ch1);
			
			// ch1 = ch1 + 1 // 报错
			// ch1++; // 正确
			ch1 += 1; // 正确
		}
	}
}