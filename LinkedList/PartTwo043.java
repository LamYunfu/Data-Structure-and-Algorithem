package com.ouc.algorithem.CodingGuideInterviewPartTwo;

import com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.*;

/**
 * ���������Լɪ������
 * Ҫ����O(n)��ʱ�������
 * @author ���Ƹ�
 *
 */
public class PartTwo043 {
	/**
	 * Լɪ������ļ򵥽����ʽ
	 * ����ʱ�临�ӶȱȽϸߣ�ΪO(n * m)
	 * @param head
	 * @param m
	 * @return
	 */
	public static Node josephusKillSimpleWay(Node head, int m){
		//�жϴ������������Ƿ���Ҫ����
		if(head == null || head.next == head || m < 1){
			return head;
		}
		int count = 0;
		while(head.next != head){
			while(++count != m - 1){
				head = head.next;
			}
			head.next = head.next.next;
			head = head.next;
			count = 0;
		}
		return head;
	}
	
	public static Node josephusKill2(Node head, int m){
		if(head == null || head.next == head || m < 1){
			return head;
		}
		int temp = 1;
		//�ó��ܵĽ��ĸ���
		Node cur = head.next;
		while(cur != head){
			temp++;
			cur = cur.next;
		}
		//ͨ����ʽ�ݹ�õ�����������Ľ���ڳ�ʼ����ı��
		temp = getLive(temp, m);
		while(--temp != 0){
			head = head.next;
		}
		return head;
	}
	
	
	private static int getLive(int temp, int m) {			//temp��ʾ��ǰ�����н��ĸ���
		// TODO Auto-generated method stub
		if(temp == 1){				
			return 1;
		}
		return(getLive(temp - 1, m) + m - 1) % temp + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3 ,4 ,5};
		Node head = Function.createCircleList(arr);
		head = josephusKill2(head, 3);
		System.out.println("���һ�������������ǣ�" + head.value);
		
	}

}
