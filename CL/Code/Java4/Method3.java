class Method3 {
	public static void main(String[] args) {
		int num  = 0;
		
		System.out.println("Before call the method:" + num);
		// �����Ǳ�һ�������ķ���ֵ�޸���
		num = giveMeFive();
		System.out.println("After call the method:" + num);
	}
	
	/*
	return�ؼ���
		1. ������ǰ����������
			�������е�returnʱ���������н�����return֮��Ĵ��벻��ִ��
		2. ���Է��ص�����֮�������
			��return�ؼ���֮������ݣ����Է��ص�����֮�⣬���÷���ֵ
			
	����ֵ��
		����ֵ�ǵ�ǰ�������ڷ���֮���ṩ�����ݺͱ��֡�
		��Ҫ��Ӧ���ص����ݣ�������Ӧ�ķ���ֵ����
		
	��ע�⡿
		�����������Ҫ����ֵ������һ����ȷ��return
		�����з���ֵ������void����ô����ʹ��return��Ϊ�����Ľ�������return֮�������κ����ݡ�
		
	����
		give Me Five
		��Ҫ����һ��int��������5

	����������
		public static
		����ֵ���ͣ�
			5 ��һ��int����
		��������
			giveMeFive
		�βΣ�
			����Ҫ����
	����������
		public static int giveMeFive()
	*/
	/**
	* ����һ��int��������5
	*
	*@return ����ֵΪint��������5
	*
	*/
	public static int giveMeFive() {
		// return֮������ݻر����ص�������
		return 5;
	}
}