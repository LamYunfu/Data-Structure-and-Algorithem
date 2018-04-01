package com.ouc.algorithem.CodingGuideInterviewPartTwo;

import static com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.*;

/*
 * �Ѷȣ�һ��ʿ
 * �����Ұ����ķ�ʽ�����������
 * ��һ��������м�ֿ�������Ϊ����������
 * ÿ�δ�����һ�������ó�һ��������һ���µ�����
 */
public class PartTwo086 {
	/*
	 * ��һ�����ҵ��Ұ벿�ֵĿ�ʼ���
	 * ����������㣬һ��midÿ�������ƶ�һ����һ��rightÿ�������ƶ�����
	 * ���right����һ����null������һ������һ����null,�ͽ����ƶ�
	 * ��Ϊ�����Ҫ���������ֶϿ��������Ҫ�ҵ���벿�ֵ����һ�����
	 * ������ȥ���Ұ벿�ݵĿ�ʼ���
	 * ���mid��ָ����벿�ֵ����һ�����
	 */
	public static void relocate(Node head){
		if(head == null || head.next == null){
			return;
		}
		Node mid = head;
		Node leap = head.next;
		while(leap.next != null && leap.next.next != null){
			mid = mid.next;
			leap = leap.next.next;
		}
		leap = mid.next;				//leapָ���Ҷ˿�ʼ
		mid.next = null;				//�Ͽ���������
		merger(head, leap);
	}
	/*
	 * ֱ�Ӱ��ұ�������뵽���ȥ
	 */
	private static void merger(Node left, Node right) {
		Node next = null;
		/*
		while(right != null){
			next = left.next;
			left.next = right;
			left = right;
			right = right.next;
			left.next = next;
			left = next;
		}
		�����midָ���ұ߿�ʼ��ʱ�������,����ȡ�����������������ʱ�������⣩
		*/
		while(left.next != null){
			next = left.next;
			left.next = right;
			left = right;
			right = right.next;
			left.next = next;
			left = next;
			/*
			next = right.next;
			right.next = left.next;
			left.next = right;
			left = right.next;
			right = next;
			*/
		}
		left.next = right;				//�����Ƕ�һ�����Ƕ�����������ô��
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5};
		Node head = createList(arr);
		output(head);
		relocate(head);
		output(head);
		
	}

}
