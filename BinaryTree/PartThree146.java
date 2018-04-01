package com.ouc.algorithem.CodingInterviewGuidePart3;
/*
 * ��Ŀ������һ����������arr,��֪����û���ظ�ֵ���ж�arr�Ƿ�����ǽ������Ϊ���͵�������������
 * ������������
 * ���ף������������arr��û���ظ�ֵ������֪��һ�Ŷ������ĺ�����������ͨ������arr�ع�������
 * 
 */
public class PartThree146 {

	/*
	 * ���׽��ⷽʽ�������������ĺ�����������������ʣ����ڵ�һ���������ĩ�ˣ���ΪX0
	 * Ȼ�������������������ʣ��ڳ��˸����������л����һ���ֽ��ߣ��ֽ��ߵ���ߵ���С��X0
	 * �ֽ����ұߵ���ȫ������X0,���߷ֱ��������������������������������ͬ����Էֱ������������
	 * ���ݹ�������������õ������
	 * ��չ���������������������������ǰ��������������ƣ������������򵥣�ֱ�ӿ����������Ƿ��������
	 */
	public boolean isPostArray(int[] arr){
		if(arr == null || arr.length == 0){
			return false;
		}
		//�������飬�������εĿ�ʼλ�úͽ���λ��
		return isPost(arr, 0, arr.length - 1);
	}
	
	public boolean isPost(int[] arr, int start, int end){
		if(start >= end){			//�����ǿ��ǵ���һ��ֻ������ֵ�����
			return true;
		}
		int middle = arr[end];			//���߲ο���׼��
		int i = start;
		while(arr[i] < middle){
			i++;
		}
		for(int j = i; j <= end; j++){
			if(arr[j] < middle)
				return false;         //���ߵ��ұ߳����˱ȸ��ڵ��С������ֱ���ж���������������
		}
		return isPost(arr, start, i - 1) && isPost(arr, i, end - 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
