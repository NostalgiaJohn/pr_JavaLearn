class Demo3 {
	public static void main(String[] args) {
		int num = 10;
		boolean ret = 10 > 5 && num++ > 10;
		
		
		System.out.println("num : " + num); // 11
		System.out.println("ret : " + ret); // F --ִ�����жϺ���ִ������
		
		int num1 = 10;
		boolean ret1 = 10 > 15 && num++ >= 10;
		/*
		��·ԭ�����⣺
			�߼����·ԭ������
			���߼�����ʽ�У����ֵ�һ��Ϊfalse����ʱ���������ʽ����Ѿ���ȷ������Ҫ����ִ��--��Լ������Դ�����Ч�ʡ�
		*/
		System.out.println("num1 : " + num1); // 10
		System.out.println("ret1 : " + ret1); // F
		
		int num2 = 10;
		boolean ret2 = 10 > 5 || ++num2 > 5;
		/*
		��·ԭ�����⣺
			�߼����·ԭ������
			���߼�����ʽ�У����ֵ�һ��Ϊtrue����ʱ���������ʽ����Ѿ���ȷ������Ҫ����ִ��--��Լ������Դ�����Ч�ʡ�
		*/
		System.out.println("num2 : " + num2); // 10 
		System.out.println("ret2 : " + ret2); // T
	}
}