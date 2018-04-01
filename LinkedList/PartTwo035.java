package com.ouc.algorithem.CodingGuideInterviewPartTwo;

import java.util.Scanner;

/**
 * 删除链表的倒数第K个结点
 * 问题在于，怎么样找到倒数第K个结点
 * @author 蓝云甫
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
		else if(K == 0){					//如果K==0, 说明要删的是第一个结点
			return head.next;
		}
		//重新从头节点开始走，每走一步，就让K的值加1
		//当K为0时候，移动停止，此时的的结点就是要删除结点的前一个结点
		else{
			cur = head;
			while(++K != 0){				//特别注意，一开始的时候K需要先加一次1
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
		System.out.println("请输入你要删除的倒数的数K");
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
