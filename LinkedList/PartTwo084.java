package com.ouc.algorithem.CodingGuideInterviewPartTwo;
import static com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.*;
/*
 * �Ѷȣ�һ��ʿ
 * �ϲ���������ĵ�����
 * ���غϲ����ͷ���
 */
public class PartTwo084 {
	/*
	 * ֱ����ԭ������������������е���
	 */
	public static Node merger(Node head1, Node head2){
		if(head1 == null || head2 == null){
			return head1 == null ? head2 : head1;
		}
		Node head = head1.value > head2.value ? head2 : head1;
		//����cur1ָ�������Ϊ�����������cur2Ϊ��ժ���������
		Node cur1 = head;
		Node cur2 = head == head1 ? head2 : head1;
		Node pre = null;
		Node next = null;
		while(cur1 != null && cur2 != null){
			if(cur1.value <= cur2.value){
				pre = cur1;
				cur1 = cur1.next;
			}
			else{
				next = cur2.next;
				pre.next = cur2;
				cur2.next = cur1;
				pre = cur2;
				cur2 = next;
			}
		}
		if(cur2 != null){
			pre.next = cur2;
		}
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {0, 2, 3, 7};
		int[] arr2 = {1, 3, 5, 7, 9};
		Node head1 = createList(arr1);
		Node head2 = createList(arr2);
		head1 = merger(head1, head2);
		output(head1);
	}

}
