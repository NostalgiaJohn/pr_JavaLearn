class Demo1 {
	public static void main(String[] args) {
		// ����һ��int���͵�����
		int[] arr = new int[10];
		
		// ���ȸ�ֵ�������±�Ϊ0,5��Ԫ��
		// ������[��Ч�±�] = ���������;
		arr[0] = 10;
		arr[5] = 20;
		
		/*
		���и�������������Զ��ǷǷ��±�
		Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: -1
        at Demo1.main(Demo1.java:11)
		*/
		// arr[-1] = 5;
		
		arr[10] = 20;
		
		// ����ȡֵ
		System.out.println("arr[0]:" + arr[0]);
		System.out.println("arr[5]:" + arr[5]);
	}
}