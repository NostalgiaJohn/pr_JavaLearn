class Demo4{
	public static void main(String[] args) {
		int[] array = new int[10];
		
		// ���ø�ֵ������Ԫ�صķ���
		// ���ò�����һ���������͵ķ�������Ҫ�����������������
		assignIntArray(array);
		printIntArray(array);
	}
	
	/*
	����
		��ֵһ��int��������
	����������
		public static
		����ֵ����:
			void �޷���ֵ
		��������
			assignIntArray
		��ʽ�����б�;
			��Ҫһ��int��������
			(int[] arr)
	����������
		public static void assignIntArray(int[] arr)
	*/
	/**
	* ��ֵһ��ָ����int��������
	* 
	* @param arr ������Ҫ�Ĳ�����һ��int��������
	*/
	public static void assignIntArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
	}
	
	/*
	����
		չʾһ��int���������б��������
	����������
		public static
		����ֵ����:
			void �޷���ֵ
		��������
			printIntArray
		��ʽ�����б�;
			չʾһ��int���������б��������
			(int[] arr)
	����������
		public static void printIntArray(int[] arr)
	*/
	/**
	* չʾһ��int���������б��������
	* 
	* @param arr ������Ҫһ��int��������
	*/
	public static void printIntArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("array[" + i +"]=" + arr[i]);
		}
	}
	
}
