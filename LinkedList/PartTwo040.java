package com.ouc.algorithem.CodingGuideInterviewPartTwo;

import com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.*;

/**
 * 反转单向链表和双向链表
 * @author 蓝云甫
 *
 */
public class PartTwo040 {
	
	public static Node reverseList(Node head){			//反转单向链表
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
	
	public static DoubleNode reverseList(DoubleNode head){			//反转双向链表
		DoubleNode pre = null;
		DoubleNode next = null;
		while(head != null){
			next = head.back;
			head.back = pre;					//就是在变换当前前后指针的时候略有不同
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
