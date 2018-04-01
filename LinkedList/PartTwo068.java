package com.ouc.algorithem.CodingGuideInterviewPartTwo;
import static com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.*;

import java.util.Stack;

import com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.Node;
/*
 * 难度：二星尉
 * 给定一个单链表的头节点head,实现一个调整单链表的函数，使得每K个结点之间逆序，
 * 如果最后不够K个结点一组，则不调整最后几个结点
 */
public class PartTwo068 {
	
	/*
	 * 方法一：利用栈的结构，从左到右不断遍历链表，如果栈的大小不为K,继续入栈
	 * 最后调用函数把栈中的元素按照出栈的顺序连接，最后连接到原来的链表上
	 */
	public static Node reverseNodes1(Node head, int K){
		if(K < 2){
			return head;
		}
		Stack<Node> stack = new Stack<Node>();
		int n = 0;
		Node cur = head;
		Node pre = null;			//保存反转部分的前一个结点
		Node next = null;			//保存反转部分的下一个结点
		Node newHead = head;		//返回的新的头结点
		while(cur != null){
			next = cur.next;
			stack.push(cur);
			if(stack.size() == K){
				pre = resign1(stack, pre, next);				//对这部分进行反转，返回反转的末尾结点，作为下一次反转的前一个结点
				newHead = newHead == head ? cur : newHead;
			}
			cur = next;
		}
		return newHead;
	}
	private static Node resign1(Stack<Node> stack, Node left, Node right) {
		// TODO Auto-generated method stub
		Node pre = stack.pop();
		if(left != null){
			left.next = pre;
		}
		Node cur = null;
		while(!stack.isEmpty()){
			cur = stack.pop();
			pre.next = cur;
			pre = cur;
		}
		cur.next = right;
		return cur;
	}
	
	/*
	 * 方法二：直接在原来的链表上面进行反转
	 * 先截取一段，传入start和end,和左边前一个和右边前一个进行反转
	 */
	
	public static Node reverseNodes2(Node head, int K){
		if(K < 2){
			return head;
		}
		Node newHead = head;
		int n = 0;
		Node start = head;
		Node pre = null;
		Node next = null;
		Node cur = head;
		while(cur!= null){
			next = cur.next;
			n++;
			if(n == K){
				resign2(pre, start, cur, next);
				newHead = newHead == head ? cur : newHead;
				pre = start;
				start = next;
				n = 0;
			}
			cur = next;
		}
		return newHead;
	}
	private static void resign2(Node left, Node start, Node end, Node right) {
		// TODO Auto-generated method stub
		Node pre = start;
		Node cur = start.next;
		Node next = null;
		while(pre != end){
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		if(left != null){
			left.next = end;
		}
		start.next = right;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Node head = createList(arr);
		output(head);
		head = reverseNodes2(head, 3);
		output(head);
	}

}
