package com.ouc.algorithem.CodingInterviewGuidePart3;
import static com.ouc.algorithem.CodingInterviewGuidePart3.Function.*;

import com.ouc.algorithem.CodingInterviewGuidePart3.Function.Node;

/*
 * �Ѷȣ�����ξ
 * �ҵ��������е����������������
 * 
 * ����һ�Ŷ�������ͷ���head,��֪�������н���ֵ����һ�����ҵ����н������������������
 * ���������������ͷ���
 */
public class PartThree117 {
	/*
	 * �Խڵ�nodeΪͷ�������У���������������ֻ�������������������
	 * 1. ����node ��������������������������node.leftΪͷ��㲢�����������ֵС��node.value
	 * 		����������node.rightΪͷ�ڵ㲢����������Сֵ����node.value����ô��nodeΪͷ������
	 * 		�ö�������������������
	 * 2.���������㣬�������������������������������������������������н��϶���Ǹ���
	 */
	public static Node biggestSubBST(Node head){
		int[] record = new int[3];
		return posOrder(head, record);
	}
	
	/*
	 * ʹ�ú�����������������ڻ��������������Ϣ�Ժ��ٽ��бȽ�
	 * ��Ҫ�ֱ��������������ĸ���Ϣ
	 * 1.�������������ͷ���
	 * 2.������������������
	 * 3.���ֵ
	 * 4.��Сֵ
	 * 
	 * ΪʲôͬʱҪ������ֵ����Сֵ��
	 * ��Ȼ�ӵ�ǰ������¿�����ǰ���֪�����ֵ���������������������ص�
	 * ��������һ�㷵�ص�ʱ�򣬾Ͳ�֪���������������ұ������ģ�
	 * ��ȻҲ�Ͳ�֪�����ϲ㷵����һ�����ˣ������ֵ������Сֵ�ء����Ի���ͬʱ��¼������
	 * ��Ȼ���濴������һЩ����
	 * 
	 * ����������������Щֵ�͵�ǰ���Ƚ�,��֪�������ڵ�һ��������ǵڶ��������
	 * �Ӷ�֪������ʲô����
	 * 
	 * ����record�������ͱ��������԰��²㺯���Ľ��ֱ�ӷ����ϲ㣬������ͨ��return�ķ�ʽ
	 */
	private static Node posOrder(Node head, int[] record) {
		// TODO Auto-generated method stub
		//�ս��ֱ�ӷ���
		if(head == null){
			record[0] = 0;
			record[2] = Integer.MAX_VALUE;				//��ʼ��ֵ,������������ζ�������һ����£�����ȡֵҪע��
			record[1] = Integer.MIN_VALUE;
			return null;
		}
		int value = head.value;
		Node lBST = posOrder(head.left, record);		//���������������������Ľ��
		int lSize = record[0];					//record��������ֵ��Ҫ�Ƚ���������Ҫ��Ȼ��һ�λ���ʧ
		int lMax = record[1];
		int lMin = record[2];
		Node rBST = posOrder(head.right, record);		//�����ұ���������������Ľ��
		int rSize = record[0];
		int rMax = record[1];
		int rMin = record[2];
		//�����Ե�ǰ���Ϊ���ڵ��������record��Ϣ����������һ�㷵��
		//ֻ���ڵ�ǰ���Ҳ�ܼ��뵽���������������ʱ����������Ϣ����Ч
		record[1] = Math.max(value, rMax);
		record[2] = Math.min(value, lMin);
		//�ж������ڵ�һ��������ǵڶ���������ɴ˾���record[0], �ͷ��ص����������ͷ�ڵ�
		if(head.left == lBST && head.right == rBST && lMax < value && value < rMin ){
			//���ڵ�һ�����
			record[0] = lSize + rSize + 1;
			return head;
		}
		//���ڵڶ������
		record[0] = Math.max(lSize, rSize);
		return lSize > rSize ? lBST : rBST;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 4, 14, 2, 5, 11, 15};
		Node head = createTree(arr);
//		System.out.println(head.value);
		Node maxSearchBinaryTreeSize =  biggestSubBST(head);
		System.out.println(maxSearchBinaryTreeSize.value);
	}

}
