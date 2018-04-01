package com.ouc.algorithem.CodingGuideInterviewPartTwo;
import java.util.Stack;

import com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.*;
/*
 * 判断一个链表是不是回文
 */
public class PartTwo049 {
	/*
	 * 将整个链表都入栈，然后一个一个出栈和链表比较
	 */
	public static boolean isPlindrome1(Node head){
		Stack<Node> stack = new Stack<Node>();
		Node cur = head;
		while(cur != null){
			stack.push(cur);
			cur = cur.next;
		}
		while(head != null){
			if(head.value == stack.pop().value){
				head = head.next;
			}
			else{
				return false;
			}
		}
		return true;
	}
	
	/*
	 * 将链表右半部分入栈，然后一个一个出栈和链表的左半部分来进行比较
	 */
	public static boolean isPlindrome2(Node head){
		if(head == null || head.next == null){
			return true;
		}
		//找到右半部分开始入栈的开始位置
		Node right = head.next;					//存放右边开始位置
		Node cur = head;						//参考标记
		//cur.next != null 为链表结点数目是奇数个而设计，cur.next.next != null 为偶数个而设计
		while(cur.next != null && cur.next.next != null){
			right = right.next;
			cur = cur.next.next;
		}
		
		Stack<Node> stack = new Stack<Node>();
		while(right != null){
			stack.push(right);
			right = right.next;
		}
		while(!stack.isEmpty()){
			if(stack.pop().value != head.value){
				return false;
			}
			else{
				head = head.next;
			}
		}
		return true;
	}
	
	/*
	 * 将这个链表的右半部份逆序，然后从左右端点开始往中间靠拢
	 * 如果这个链表的大小是一个偶数，那么最后右边会更长一个
	 * 不过这个不要紧，先让中间结点的下一个指向null,只要最后左边先到达，就停止比较
	 */
	public static boolean isPlindrome3(Node head){
		if(head == null || head.next == null){
			return true;
		}
		
		//将链表以中间结点为基础奥成两半，首先需要找到一个链表的中间结点，方法和isPlindform2一样
		Node middle = head;
		Node cur = head;
		while(cur.next != null && cur.next.next != null){
			middle = middle.next;
			cur = cur.next.next;
		}
		
		//这个时候找到的中间结点:1.如果结点的总数是奇数，那就是中间的那个结点，如果结点的数目是偶数的话，就是前一半的最后一个结点
		//将这个链表的后半部分反转
		cur = middle.next;
		middle.next = null;
		Node pre = middle;
		Node next = null;
		while(cur != null){
			next = cur.next;
			cur.next = pre;
			pre = cur;							//到最后pre是最后一个结点
			cur = next;
		}
		
		//同时从链表的两边往中间靠拢。如果靠到最后有任意的一方为null(奇数个双方都为null,偶数个左方为null)，那就说明这个链表是回文的
		Node left = head;
		Node right = pre;
		boolean res = true;
		while(left != null && right != null){
			if(left.value != right.value){
				res = false;
				break;
			}
			left = left.next;
			right = right.next;
		}
		
		//最后还要把这个链表恢复原状
		cur = pre.next;
		pre.next = null;
		while(cur != null){
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 2, 1};
		Node head = Function.createList(arr);
		boolean result = isPlindrome3(head);
		if(result){
			System.out.println("这个数是回环数");
			Function.output(head);
		}
		else{
			System.out.println("这个数不是回环数");
		}
	}

}
