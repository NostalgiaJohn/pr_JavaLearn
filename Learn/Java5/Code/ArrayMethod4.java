class ArrayMethod4 {
	public static void main(String[] args) {
		int[] arr = {1,23,4,534,87};
		System.out.println(get(arr, 2));
	}
	/**
	* �ҳ�����ָ���±��Ԫ��
	* 
	* @param arr ָ����int��������
	* @param int ָ����ѯ���±�λ��
	* @return ���ض�Ӧ�±��Ԫ��
	*/
	public static int get(int[] arr, int index) {
		if (index < 0 || index > arr.length - 1) {
			System.out.println("Input Parameter is Invalid");
			System.exit(0); // �˳�����
		}
		
		return arr[index];
	}
	
}