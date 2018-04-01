package com.ouc.algorithem.CodingGuideInterviewPartTwo;

import com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.*;

/**
 * ��ת���������˫������
 * @author ���Ƹ�
 *
 */
public class PartTwo040 {
	
	public static Node reverseList(Node head){			//��ת��������
		Node pre = null;
		Node next = null;
		while(head != null){
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	
	public static DoubleNode reverseList(DoubleNode head){			//��ת˫������
		DoubleNode pre = null;
		DoubleNode next = null;
		while(head != null){
			next = head.back;
			head.back = pre;					//�����ڱ任��ǰǰ��ָ���ʱ�����в�ͬ
			head.front = next;
			pre = head;
			head = next;
		}
		return pre;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3,4,5,6,7,8,9};
		Node head = Function.createList(arr);
		Function.output(head);
		head = reverseList(head);
		Function.output(head);
	}

}
