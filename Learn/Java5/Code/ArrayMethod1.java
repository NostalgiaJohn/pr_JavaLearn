import java.util.Arrays;
class ArrayMethod1 {
	public static void main(String[] args) {
		int[] arr = {1,3,4,5,6,7,8,9,1024};
		
		reverse(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	��̬����
		int[] arr = {1,7,3,5,9};
		������ɣ�
			{9,5,3,7,1}
	�����ķ�����
		public static
		����ֵ����:
			void
		��������
			���� reverse
		��ʽ�����б�
			int[] arr
	��������;
		public static void reverse(int[] arr)
	*/

	/**
	* ��ɶ���int����������������
	* 
	* @param arr int ��������
	*/
	public static void reverse(int[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			int temp = 0;
			/*
			arr[0] = arr [9]
			����
			*/
			temp = arr[i];
			arr[i] = arr[arr.length - 1 -i];
			arr[arr.length - 1 -i] = temp;
		}
	}
}

