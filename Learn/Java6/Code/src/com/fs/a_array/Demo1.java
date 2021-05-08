package com.fs.a_array;

/**
 * ���ص㡿
 * 
 * @author fStardust
 */
public class Demo1 {
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 6, 1, 6 , 564, 3 , 4, 5, 2, 7};
		int[] indexArr = new int[arr.length];
		
		int count = allIndexOf(arr, indexArr, 3);
		
		// count=0ʱ����֪����Ƿ��������ʾ
		if (count == 0) {
			System.out.println("û�и�ֵ");
		}
		// count�ǲ�ѯ����ָ��Ԫ�ظ�����ͬʱ��������ѭ��,��indexArr�������ҵ�������Ԫ��--�±�
		for (int i = 0; i < count; i++) {
			System.out.println(indexArr[i]);
		}
	}
	/*
	Ҫ��
		a. �������ڷ����ڴ�ӡչʾ
		b. ���Ƕ���������
		c. ��Ҫ�ڷ������ȡ���±�������Ϣ
		d. ������ʹ��������Ϊ����ֵ
	���ص㡿
		1. β�巨˼�룬������ͬʱҲ����һ�δ�����ݵ�λ��
		2. ������Ϊ��������֮���ǿ��Խ������ݴ���
		
	����������
		public static 
		����ֵ����:
			int �����ҵ���ָ��Ԫ�ظ���
			void ���úںз���
		��������
			allIndexOf
			�ҳ�����ָ��Ԫ�ص��±�λ��
		��ʽ�����б���
			1. ��ѯ���ݵ�Դ�������� int[] arr
			2. ָ����ѯ��Ԫ�� int find
			3. Դ������������һ�µ�int�������飬�����Ӧ���±�λ��
			(int[] arr, int[] indexArr, int find)
	˼��:
		1. �����ѯ���ݵ��±�λ��һ����ʹ�õ�����
		2. �����±����������������int����
	���������
		ͨ������Ϊ������ʽ����һ�����飬int���ͣ������ҵ����±�λ��
	˼����
		�����±��������������
	���������
		��ֵ˼�룺���������Դ������������һ��
		
	���⣺
		����ж�0����Ч�±껹����Ч����	
	˼����
		��Ҫһ�����ݣ���֪�ҵ������ݵ����ж��ٸ�
		����ֵΪ�ҵ���ָ��Ԫ�صĸ�������û���ҵ�������0
		
	����������
		public static int allIndexOf(int[] arr, int[] indexArr, int find)
		
	*/	
	/**
	 * �ҵ�ָ��ԭ����������ָ��Ԫ�������±�λ�ã����浽indexArr�У����ҷ���ֵ���ҵ���Ԫ�ظ���
	 * 
	 * @param arr Դ�������飬int����
	 * @param indexArr �ҵ����±�λ�ô洢���飬Ҫ���������������С��Դ��������
	 * @param find ��Ҫ��ѯ��ָ������
	 * @return ����ֵ����0���ҵ������ݸ�����û���ҵ�����0
	 */
	public static int allIndexOf(int[] arr, int[] indexArr, int find)  {
		// �����Ϸ����ж�
		if (arr.length > indexArr.length) {
			System.out.println("Input Paramter is Invalid!");
			// �������Ϸ�������0--û���ҵ�����
			return 0;
		}
		
		/*
		 * ����һ������
		 * 	1. ����������¼�ҵ���Ԫ�ظ���
		 * 	2. β�巨������һ�δ��Ԫ�ص�λ��
		 */
		int count = 0;
		
		// ����forѭ����������Դ����arr����
		for (int i = 0; i < arr.length; i++) {
			// �ҵ��˶�Ӧ��Ԫ�أ���Ҫ�����±�i
			if (find == arr[i]) {
				// ���浽indexArr������
				// ��Ҫʹ��β�巨��������һ�δ�����ݵ�λ��
				indexArr[count] = i;
				// ������ += 1
				count += 1;
			}
		}
		
		return count;
	}
	
}