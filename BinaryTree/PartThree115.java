package com.ouc.algorithem.CodingInterviewGuidePart3;
import static com.ouc.algorithem.CodingInterviewGuidePart3.Function.*;

import java.util.HashMap;
/*
 * ����һ�Ŷ�������ͷ�ڵ�head��һ��32λ����sum,�������Ľ��ֵ���������ͣ�����ۼӺ�Ϊsum
 * ���·���ĳ��ȡ�·����ָ��ĳ���������ÿ�����ѡ��һ�����ӽ����߲�ѡ���γɵĽ����
 */
public class PartThree115 {

	public static int getMaxLength(Node head, int sum){
		HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
		sumMap.put(0, 0);			//��Ҫ
		return preOrder(head, sum, 0, 1, 0, sumMap);
	}
	/*
	 * maxLen���ڼ�¼��󳤶�
	 * ������PartEight355,�ѴӶ��������ڵ㵽ÿ��Ҷ����ÿһ��·����ά��һ��HashMap
	 * Ҳ���ǰ�������һ�����飬keyֵ���·���ϵ�һ�γ������sumֵ���ܺͣ�value��ŵ�һ�γ��ֶ�Ӧ�Ĳ���
	 * 
	 */
	private static int preOrder(Node head, int sum, int preSum, int level, 
			int maxLen, HashMap<Integer, Integer> sumMap){
		if(head == null){
			return maxLen;
		}
		int curSum = preSum + head.value;
		if(!sumMap.containsKey(curSum)){
			sumMap.put(curSum, level);
		}
		if(sumMap.containsKey(curSum - sum)){
			maxLen = Math.max(level - sumMap.get(curSum - sum), maxLen);
		}
		maxLen = preOrder(head.left, sum, curSum, level + 1, maxLen, sumMap);  //����������������HashMap������һ��Ͳ�һ����
		maxLen = preOrder(head.right, sum , curSum, level + 1, maxLen, sumMap);
		/*
		 * ����hashMap��һ���������͵ı���
		 * ���е�·�����ǹ���һ��HashMap
		 * �����ڷ���֮ǰ��Ҫ�Ѹռӽ�ȥ��ֵ�Ƴ�
		 * �����ڷ�����һ�������������ʱ��Ų����������
		 */
		if(level == sumMap.get(curSum)){
			sumMap.remove(curSum);
		}
		return maxLen;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
