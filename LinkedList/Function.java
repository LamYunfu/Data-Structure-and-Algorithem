package com.ouc.algorithem.CodingGuideInterviewPartTwo;

public class Function {
	
	public static class Node{
		public int value;
		public Node next;
		public Node(int data){
			this.value = data;
		}
	}
	
	public class DoubleNode{
		public int value;
		public DoubleNode front;
		public DoubleNode back;
		public DoubleNode(int value){
			this.value = value;
		}
	}
	
	
	public static void output(Node head) {
		// TODO Auto-generated method stub
		while(head.next != null){
			System.out.print(head.value + "->");
			head = head.next;
		}
		System.out.println(head.value);
	}
	
	public static void outputCircle(Node head) {
		// TODO Auto-generated method stub
		Node cur = head;
		while(cur.next != head){
			System.out.print(cur.value + "->");
			cur = cur.next;
		}
		System.out.println(cur.value);
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
	
	public static Node createCircleList(int arr[]){
		Node head = new Node(arr[0]);
		Node temp = head;
		for(int i = 1;i < arr.length; i++){
			Node newNode = new Node(arr[i]);
			temp.next = newNode;
			temp = newNode;
		}
		temp.next = head;
		return head;
	}
}
