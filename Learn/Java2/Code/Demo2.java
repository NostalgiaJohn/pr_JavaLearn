class Demo2 {
	public static void main(String[] args) {
		int num = 10;
		
		// ��ִ�и����(��ӡ���)����ִ����������
		System.out.println("num++ : " + num++); // 10 
		System.out.println("num : " + num); // 11
		
		// Ч��ͬ��
		System.out.println("num : " + num); // 11 
		num++;
		System.out.println("num : " + num); // 12
		
		// ��ִ��������������ִ�и����(��ӡ���)
		System.out.println("num++ : " + ++num); // 13
		System.out.println("num : " + num); // 13
	}
}