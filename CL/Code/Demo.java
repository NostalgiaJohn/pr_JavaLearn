class Demo {
	public static void main(String[] args) {
		/* �����������ʾ */
		int num1 = 10;
		int num2 = 20;
		
		/*
		1. �������������У�ע�������ֵ�Ƿ�������
		2. ����ֻ�и�ֵ���������޸ı��������ݣ�û�и�ֵ�޷�����
		*/
		num2 = num1 + num2; // num1 = 10 num2 = 30
		num2 = num1 + num2; // num1 = 10 num2 = 300
		num2 = num1 / num2; // num1 = 10 num2 = 0
		num2 = num1 * num2; // num1 = 10 num2 = 0
		
		num1 = 10;
		num2 = 20;
		num2 += num1;
		System.out.println(num2); // num2 = 30
		System.out.println(num1); // num1 = 10
	}
}