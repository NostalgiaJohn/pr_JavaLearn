class ArrayMethod3 {
	public static void main(String[] args) {
		int[] arr = {1,3,453};
		
		int index = indexOf(arr,324);
		if (index >= 0) {
			System.out.println("index:" + index);
		} else {
			System.out.println("Not Found");
		}
		
	}
	/**
	* �ҳ�ָ�������У�ָ��Ԫ�ص��±�λ�ã���ͨ������ֵ����
	* 
	* @param arr ָ����int������������
	* @param find ָ����Ҫ��ѯ������
	* @return ����ֵ���ڵ���0��-1��ʾδ�ҵ���Ӧ����
	*/
	public static int indexOf(int[] arr, int find) {
		
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			if (find == arr[i]) {
				index = i;
				break;
			}
		}
		
		return index;
	}
}