class ArrayMethod2 {
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 7, 19, 2, 4, 19, 8, 10};
		
 		int index = maxIndexOf(arr);
		System.out.println("index:" + index);
	}
	
	/*
	����
		��int�����������ҳ���Ӧ�����ֵ�±�λ��
	��������:
		public static ��Ҫ��
		����ֵ���ͣ�
			������±�����������int����
			int
		������:
			maxIndexOf
		��ʽ�����б�
			(int[] arr)
	����������
		public static int maxIndexOf(int[] arr)
	*/

	/**
	* ����ָ��int�������������ֵ���±�λ��
	*
	* @param arr int��������
	* @return ����ֵ�����ֵ���ڵ��±�λ��
	*/
	public static int maxIndexOf(int[] arr) {
		// ���ȣ��ٶ��±�Ϊ0��Ԫ�������������ֵ
		int maxIndex = 0;
		
		// ��Ϊѭ�������У��±�Ϊ0��Ԫ��û�б�Ҫ���Լ��Ƚ�
		// ѭ��������1��ʼ
		for (int i = 1; i < arr.length; i++) {
			/*
			�������maxIndex������±��ӦԪ�أ���С��i��
			�����Ӧ��iֵ
			*/
			if (arr[maxIndex] < arr[i]) {
				maxIndex = i;
			}
		}
		
		return maxIndex;
	}
}

