class Method4 {
	public static void main(String[] args) {
		int sum = 0;
		
		System.out.println("Before call the method:" + sum);
		sum = getSumOfTwoNumber(10,20);
		
		System.out.println("After call the method:" + sum);
	}
	
	/*
	����
		��������int��������֮�ͣ����ؽ��
	����������
		public static
		����ֵ���ͣ�
			int ����
		��������
			getSumOfTwoNumber
		��ʽ�����б�
			��Ҫ����int����--(int num1, int num2)
	����������
		public static int getSumOfTwoNumber(int num1, int num2);
	*/
	/**
	* ��������int�������ݣ���ͨ������ֵ����
	* 
	* @param num1 int��������
	* @param num2 int��������
	* @return ����int��������֮�ͣ�����ֵ����Ϊint����
	*/
	public static int getSumOfTwoNumber(int num1, int num2){
		return num1 + num2;
	}
}