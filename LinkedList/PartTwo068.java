package com.ouc.algorithem.CodingGuideInterviewPartTwo;
import static com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.*;

import java.util.Stack;

import com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.Node;
/*
 * �Ѷȣ�����ξ
 * ����һ���������ͷ�ڵ�head,ʵ��һ������������ĺ�����ʹ��ÿK�����֮������
 * �����󲻹�K�����һ�飬�򲻵�����󼸸����
 */
public class PartTwo068 {
	
	/*
	 * ����һ������ջ�Ľṹ�������Ҳ��ϱ����������ջ�Ĵ�С��ΪK,������ջ
	 * �����ú�����ջ�е�Ԫ�ذ��ճ�ջ��˳�����ӣ�������ӵ�ԭ����������
	 */
	public static Node reverseNodes1(Node head, int K){
		if(K < 2){
			return head;
		}
		Stack<Node> stack = new Stack<Node>();
		int n = 0;
		Node cur = head;
		Node pre = null;			//���淴ת���ֵ�ǰһ�����
		Node next = null;			//���淴ת���ֵ���һ�����
		Node newHead = head;		//���ص��µ�ͷ���
		while(cur != null){
			next = cur.next;
			stack.push(cur);
			if(stack.size() == K){
				pre = resign1(stack, pre, next);				//���ⲿ�ֽ��з�ת�����ط�ת��ĩβ��㣬��Ϊ��һ�η�ת��ǰһ�����
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
	 * ��������ֱ����ԭ��������������з�ת
	 * �Ƚ�ȡһ�Σ�����start��end,�����ǰһ�����ұ�ǰһ�����з�ת
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
