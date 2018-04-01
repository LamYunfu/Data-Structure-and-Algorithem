package com.ouc.algorithem.CodingGuideInterviewPartTwo;
import static com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.*;

import java.util.Stack;

/*
 * �����������ֵΪ���͵�����ת����һ������Ȼ����ӣ��õ���ֵ����һ���µ�����
 * ����9->3->7 + 6->3 = 1->0->0->0 
 */
public class PartTwo059 {
	
	/*
	 * ����ջ���������������Ϊ��ӵĲ����ǴӺ��濪ʼ�ģ�
	 * Ȼ���ջ��ӣ��ڵõ�����Ĺ��������ɽ���Ľ�㣬��������
	 */
	public static Node addList1(Node head1, Node head2){
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		//�ֱ��������������ݷŵ�����ջ����
		while(head1 != null){
			s1.push(head1.value);
			head1 = head1.next;
		}
		while(head2 != null){
			s2.push(head2.value);
			head2 = head2.next;
		}
		
		int ca = 0;					//��ʾ��λ
		int num1, num2, num3;
		Node pre = null;
		Node next = null;
		while(!s1.isEmpty() || !s2.isEmpty()){
			num1 = s1.isEmpty() ? 0 : s1.pop();						//�������һ��ջ�ǿյĻ����Ǿ��ò�������ֵ��0
			num2 = s2.isEmpty() ? 0 : s2.pop();
			num3 = num1 + num2 + ca;
			/*
			res.push(num3 % 10);
			ca = num3 / 10;				��ʵ�������ý��ջ������ֱ���ڼ����ͬʱ���ɽ�㣬��������
			*/
			pre = new Node(num3 % 10);
			pre.next = next;
			next = pre;
			ca = num3 / 10;
		}
		//���Ҫ�ж����λ��û�н�λ
		if(ca == 1){
			pre = new Node(1);
			pre.next = next;
		}
		return pre;
	}
	
	/*
	 * �Ȱ�������������Ȼ�����
	 * �����������������ԭ�������ӣ��õ��Ľ���������򷵻أ�
	 */
	public static Node addList2(Node head1, Node head2){
		//�ȶ����������������
		head1 = reverseList(head1);
		head2 = reverseList(head2);
		
		//��������������
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
		if(ca != 0){					//�������н�λ�Ļ�
			pre = new Node(1);
			pre.next = next;
		}
		
		//�Ѵ���������������ת����
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
		System.out.println("��һ�������ǣ�");
		output(head1);
		System.out.println("�ڶ��������ǣ�");
		output(head2);
		Node res = addList2(head1, head2);
		System.out.println("��ӵĽ���ǣ�");
		output(res);
	}

}
