/* 
��һ�����������зֽ������ֽ��������������90 ��� 2,3,3,5
90 ==�� 2 ��2 ������
45 ==�� 2 ��2 ������
45 ==�� 3 ��3 ������
15 ==�� 3 ��3 ������
5  ==�� 3 ��3 ������
������
1  ==�� ѭ������

*/
class Decomposition {
	public static void main(String[] args) {
		System.out.println("��һ�ַ���");
		intDecomposition1(90);
		System.out.println("�ڶ��ַ���");
		intDecomposition2(90);
	}
	
	/*
	����
		���������зֽ��������������õ����
	����������
		public static
		����ֵ���ͣ�
			void --��ӡ���������Ϊ�Լ�
		��������
			factoringInt
		��ʽ�����б�
			��Ҫһ��int����--(int num)
	����������
		public static void factoringInt(int num);
	*/
	/**
	* ��һ��int�������ݽ�����ʽ�ֽ⣬���õ����
	* 
	* @param num int�������� ������Ҫ��ʽ�ֽ��������
	* @param i int�������� ��¼ͨ������õ�������
	* @param j int�������� ��¼�÷��������ѭ������
	*/
	public static void intDecomposition1(int num){
		int j = 0;

		// num�ᶯ̬�ı��Լ���ѭ������
		for (int i = 2; i <= num; i++) {
			j += 1;
			if (num % i == 0) {
				System.out.println(i);
				num /= i;
				i -= 1;
			}
		}
		System.out.println("ѭ��������" + j);
	}
	
	public static void intDecomposition2(int num){
		int j = 0;
		
		// ѭ���Ż� �ڸ�������Ҳ��������� 
		// numΪ1ʱ�������ѭ���������
		// num/2 ���� Math.sqrt(num) ���Դ������ѭ������
		for (int i = 2; i <= num/2; i++) {
			j += 1;
			if (num % i == 0) {
				System.out.print(i + " ");
				num /= i;
				i -= 1;
			}
		}
		System.out.print(num);
		System.out.println("\n"+"ѭ��������" + j);
	}
}