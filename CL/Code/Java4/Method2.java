class Method2 {
	public static void main(String[] args) {
		// ���в����ķ���һ��Ҫ�ṩ��Ӧ����������--ʵ�ʲ���
		// ���ô��η�������ʵ�ʲ���ʱ����������Ҫһ��
		printIntNumber(10);
		
		// ��������ķ����У���Ҫ�����β��б������Ӧ�ĺ������
		// �����ĸ���������ȱ��,˳��Ҳ�����������
		// method(int num1, float num2, char ch, double num3);
		printSumOfTwoNumber(5,10);
	}
	
	/*
	����:
		��ǰ����ִ��������ⲿ����
		���磺��¼ʱ��Ҫ���˺ź�����
		
	����
		չʾһ��int����
	����������
		public static
		����ֵ���ͣ�
			void û�з���ֵ��Syout����һ��չʾ���ݵķ�ʽ����һ�ַ�����
		��������
			printIntNumber ����֪�⣬С�շ�����
		�β��б�
			��Ҫ��ӡint����--int num
			
	����������
		public static void printIntNumber(int num);

	*/
	/**
	* չʾһ��int��������
	* 
	* @param num Ҫ���û�����һ����int��������
	*/
	public static void printIntNumber(int num) {
		System.out.println("�û��ṩ��int��������Ϊ��" + num);
	}
	
	/*
	����
		��ӡ����int��������֮��
	����������
		public static
		����ֵ����;
			������չʾ/��ӡ���ݣ�����Ҫ����ֵ
		��������
			printSumOfTwoNumber
		��ʽ�����б�
			������Ҫ����int����--int num1, int num2
		
	����������
		public static void printSumOfTwoNumber(int num1, int num2)
	*/
	/**
	* ��ӡ����int�������ݵĺ�
	*
	* @param num1 ��Ҫ�û��ṩ��int��������
	* @param num2 ��Ҫ�û��ṩ��int��������
	*/
	public static void printSumOfTwoNumber(int num1, int num2) {
		System.out.println("Sum : " + (num1 + num2));
	}
}