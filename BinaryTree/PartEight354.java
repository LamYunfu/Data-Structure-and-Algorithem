package com.ouc.algorithem.CodingInterviewGuidePart3;
/*
 * �Ѷȣ�����ξ
 * ��δ���������������ۼӺ�Ϊ����ֵ��������鳤��
 * ���ַ���ֻ���������е�ֵ����ֵ�� �����ֻҪright�Ѿ���������ֵ����û�б�Ҫ�������ж�
 */
public class PartEight354 {
	
	/*
	 * left:��ǰ�������Ե
	 * right�� ��ǰ�����ұ�Ե
	 * len: ��ǰ��¼�������
	 * sum: ��ǰ���ڵ��ܺ�
	 * ���������ƶ�����
	 * 1.�ȹ̶���ߣ�����ǰ����ֵС��kʱ���ұ߱�Եһֱ�����ƶ�
	 * 2.�������ܺ�Ϊkʱ���ұ߱�Ե��ǰ�ƶ����ظ�1
	 * ע�⵱right >= arr.lengthʱ���ҽ���
	 */
	public static int getMaxLength(int[] arr, int k){
		if(arr == null || arr.length == 0 || k <= 0){
			return 0;
		}
		int left = 0;
		int right = 0;
		int len = 0;
		int sum = 0;
		while(right < arr.length){
			if(sum == k){
//				System.out.println(right - left);
				len = Math.max(len, right - left);
				sum -= arr[left];
				left++;
			}
			else if(sum < k){
				sum += arr[right];
				right++;
			}
			else{
				sum -= arr[left];
				left++;
			}
		}
		return len;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 2, 1, 1, 1, 1, 3, 5};
		int len = getMaxLength(arr, 2);
		System.out.println(len);
	}

}