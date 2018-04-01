package com.ouc.algorithem.CodingGuideInterviewPartTwo;
import java.util.Stack;

import com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.*;
/*
 * �ж�һ�������ǲ��ǻ���
 */
public class PartTwo049 {
	/*
	 * ������������ջ��Ȼ��һ��һ����ջ������Ƚ�
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
	 * �������Ұ벿����ջ��Ȼ��һ��һ����ջ���������벿�������бȽ�
	 */
	public static boolean isPlindrome2(Node head){
		if(head == null || head.next == null){
			return true;
		}
		//�ҵ��Ұ벿�ֿ�ʼ��ջ�Ŀ�ʼλ��
		Node right = head.next;					//����ұ߿�ʼλ��
		Node cur = head;						//�ο����
		//cur.next != null Ϊ��������Ŀ������������ƣ�cur.next.next != null Ϊż���������
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
	 * �����������Ұ벿������Ȼ������Ҷ˵㿪ʼ���м俿£
	 * ����������Ĵ�С��һ��ż������ô����ұ߻����һ��
	 * ���������Ҫ���������м������һ��ָ��null,ֻҪ�������ȵ����ֹͣ�Ƚ�
	 */
	public static boolean isPlindrome3(Node head){
		if(head == null || head.next == null){
			return true;
		}
		
		//���������м���Ϊ�����³����룬������Ҫ�ҵ�һ��������м��㣬������isPlindform2һ��
		Node middle = head;
		Node cur = head;
		while(cur.next != null && cur.next.next != null){
			middle = middle.next;
			cur = cur.next.next;
		}
		
		//���ʱ���ҵ����м���:1.��������������������Ǿ����м���Ǹ���㣬���������Ŀ��ż���Ļ�������ǰһ������һ�����
		//���������ĺ�벿�ַ�ת
		cur = middle.next;
		middle.next = null;
		Node pre = middle;
		Node next = null;
		while(cur != null){
			next = cur.next;
			cur.next = pre;
			pre = cur;							//�����pre�����һ�����
			cur = next;
		}
		
		//ͬʱ��������������м俿£�������������������һ��Ϊnull(������˫����Ϊnull,ż������Ϊnull)���Ǿ�˵����������ǻ��ĵ�
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
		
		//���Ҫ���������ָ�ԭ״
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
			System.out.println("������ǻػ���");
			Function.output(head);
		}
		else{
			System.out.println("��������ǻػ���");
		}
	}

}
