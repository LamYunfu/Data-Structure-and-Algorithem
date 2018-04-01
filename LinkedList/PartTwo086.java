package com.ouc.algorithem.CodingGuideInterviewPartTwo;

import static com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.*;

/*
 * 难度：一星士
 * 按左右半区的方式重新组合链表
 * 将一个链表从中间分开来，成为左右两部分
 * 每次从其中一个部分拿出一个结点组成一个新的链表
 */
public class PartTwo086 {
	/*
	 * 第一步：找到右半部分的开始结点
	 * 设置两个结点，一个mid每次往后移动一个，一个right每次往后移动两个
	 * 如果right的下一个是null或者下一个的下一个是null,就结束移动
	 * 因为最后需要把两个部分断开，因此需要找到左半部分的最后一个结点
	 * 而不能去找右半部份的开始结点
	 * 最后mid会指向左半部分的最后一个结点
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
		leap = mid.next;				//leap指向右端开始
		mid.next = null;				//断开两个链表
		merger(head, leap);
	}
	/*
	 * 直接把右边链表插入到左边去
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
		这个是mid指向右边开始的时候的做法,不可取（结点数量是奇数的时候会出问题）
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
		left.next = right;				//无论是多一个还是多两个都是这么接
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
