package com.ouc.algorithem.CodingGuideInterviewPartTwo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 打印两个有序链表的公共部分
 * 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分
 * @author 蓝云甫
 *
 */
public class PartTwo034 {
	
	public static class Node{
		public int value;
		public Node next;
		public Node(int data){
			this.value = data;
		}
	}
	
	public static Node createList(int arr[]){
//		Node head = new Node(0);
//		Node temp = head;
		Node head = new Node(arr[0]);
		Node temp = head;
		for(int i = 1;i < arr.length; i++){
			Node newNode = new Node(arr[i]);
			temp.next = newNode;
			temp = newNode;
		}
		return head;
	}
	
	public static void printCommonValue(Node head1, Node head2){
		System.out.println("The Common Part of two List:");
		while(head1 != null && head2 != null){
			if(head1.value < head2.value){
				head1 = head1.next;
			}
			else if(head1.value > head2.value){
				head2 = head2.next;
			}
			else{
				System.out.print(head1.value + " ");
				head1 = head1.next;
				head2 = head2.next;
			}
		}
	}
	
	public static String output(int arr[]){
		StringBuffer s = new StringBuffer();
		for(int i = 0;i < arr.length;i++){
			s.append(arr[i] + " ");
		}
		return s.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int arr1[] = {1,5,8,3,5,23,53,32,7,9,6};
		int arr2[] = {6,4,5,7,5,3,33,75,74,35,3,25,24,67,4};
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		Node head1 = createList(arr1);
		Node head2 = createList(arr2);
		System.out.println("第一个链表是:" + output(arr1));
		System.out.println("第二个链表是：" + output(arr2));
		printCommonValue(head1, head2);
	}

}
