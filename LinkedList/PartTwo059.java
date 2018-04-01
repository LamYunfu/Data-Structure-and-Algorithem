package com.ouc.algorithem.CodingGuideInterviewPartTwo;
import static com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.*;

import java.util.Stack;

/*
 * 将两个结点数值为整型的链表转化成一个整数然后相加，得到的值生成一个新的链表
 * 比如9->3->7 + 6->3 = 1->0->0->0 
 */
public class PartTwo059 {
	
	/*
	 * 利用栈来存放两个链表（因为相加的操作是从后面开始的）
	 * 然后出栈相加，在得到结果的过程中生成结果的结点，依次连接
	 */
	public static Node addList1(Node head1, Node head2){
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		//分别把两个链表的数据放到两个栈里面
		while(head1 != null){
			s1.push(head1.value);
			head1 = head1.next;
		}
		while(head2 != null){
			s2.push(head2.value);
			head2 = head2.next;
		}
		
		int ca = 0;					//表示进位
		int num1, num2, num3;
		Node pre = null;
		Node next = null;
		while(!s1.isEmpty() || !s2.isEmpty()){
			num1 = s1.isEmpty() ? 0 : s1.pop();						//如果其中一个栈是空的话，那就让参与计算的值是0
			num2 = s2.isEmpty() ? 0 : s2.pop();
			num3 = num1 + num2 + ca;
			/*
			res.push(num3 % 10);
			ca = num3 / 10;				其实不用设置结果栈，可以直接在计算的同时生成结点，并且连接
			*/
			pre = new Node(num3 % 10);
			pre.next = next;
			next = pre;
			ca = num3 / 10;
		}
		//最后还要判断最高位有没有进位
		if(ca == 1){
			pre = new Node(1);
			pre.next = next;
		}
		return pre;
	}
	
	/*
	 * 先把两个链表逆序，然后相加
	 * 最后把两个链表逆序回原来的样子，得到的结果链表逆序返回；
	 */
	public static Node addList2(Node head1, Node head2){
		//先对两个链表进行逆序
		head1 = reverseList(head1);
		head2 = reverseList(head2);
		
		//两个链表进行相加
		Node pre = null;
		Node next = null;
		int num1, num2, num3, ca = 0;
		while(head1 != null || head2 != null){
			num1 = head1 == null ? 0 : head1.value;
			num2 = head2 == null ? 0 : head2.value;
			num3 = num1 + num2 + ca;
			pre = new Node(num3 % 10);
			pre.next = next;
			next = pre;
			head1 = head1 == null ? null : head1.next;
			head2 = head2 == null ? null : head2.next;
			ca = num3 / 10;
		}
		if(ca != 0){					//如果最后还有进位的话
			pre = new Node(1);
			pre.next = next;
		}
		
		//把传进来的两个链表反转回来
		head1 = reverseList(head1);
		head2 = reverseList(head2);
		return pre;
	}
	
	public static Node reverseList(Node head){
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1, 2, 3, 5, 8};
		int[] arr2 = {2, 0, 3, 3};
		Node head1 = createList(arr1);
		Node head2 = createList(arr2);
		System.out.println("第一个链表是：");
		output(head1);
		System.out.println("第二个链表是：");
		output(head2);
		Node res = addList2(head1, head2);
		System.out.println("相加的结果是：");
		output(res);
	}

}
