class Demo2 {
	public static void main(String[] args) {
		// ����һ��int��������
		int[] arr = new int[10];
		
		// ʹ��forѭ�����������е�ÿһ�����и�ֵ����
		for (int i = 0; i < arr.length; i++) {
			// i��ѭ����������0~9
			arr[i] = i + 1;
			
		}
		
		// ʹ��forѭ�����������е�Ԫ�ؽ���ȡֵչʾ����
		for (int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "]=" + arr[i]);
		}
	}
}