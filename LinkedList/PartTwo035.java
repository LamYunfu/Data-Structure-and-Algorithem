package com.ouc.algorithem.CodingGuideInterviewPartTwo;

import java.util.Scanner;

/**
 * ɾ������ĵ�����K�����
 * �������ڣ���ô���ҵ�������K�����
 * @author ���Ƹ�
 *
 */
public class PartTwo035 {
	public static class Node{
		public int value;
		public Node next;
		public Node(int data){
			this.value = data;
		}
	}
	
	public static Node createList(int arr[]){
		Node head = new Node(arr[0]);
		Node temp = head;
		for(int i = 1;i < arr.length; i++){
			Node newNode = new Node(arr[i]);
			temp.next = newNode;
			temp = newNode;
		}
		return head;
	}
	
	public static Node removeLastKthNode(Node head, int K){
		if(head == null || K < 1){
			return head;
		}
		Node cur = head;
		while(cur != null){
			cur = cur.next;
			K--;
		}
		if(K > 0){
			return head;
		}
		else if(K == 0){					//���K==0, ˵��Ҫɾ���ǵ�һ�����
			return head.next;
		}
		//���´�ͷ�ڵ㿪ʼ�ߣ�ÿ��һ��������K��ֵ��1
		//��KΪ0ʱ���ƶ�ֹͣ����ʱ�ĵĽ�����Ҫɾ������ǰһ�����
		else{
			cur = head;
			while(++K != 0){				//�ر�ע�⣬һ��ʼ��ʱ��K��Ҫ�ȼ�һ��1
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Node head = createList(arr);
		output(head);
		System.out.println("��������Ҫɾ���ĵ�������K");
		int K = in.nextInt();
		head = removeLastKthNode(head, K);
		output(head);
	}

	private static void output(Node head) {
		// TODO Auto-generated method stub
		while(head.next != null){
			System.out.print(head.value + "->");
			head = head.next;
		}
		System.out.println(head.value);
	}

}
