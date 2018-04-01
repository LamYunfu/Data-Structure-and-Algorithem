package com.ouc.algorithem.CodingGuideInterviewPartTwo;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

public class PartTwo056 {

	public static class Node{
		public int value;
		public Node next;
		public Node rand;				//这个指针可能指向链表的任意一个结点，也可能是null
		
		public Node(int data){
			this.value = data;
		}
	}
	
	public static void outputWithRand(Node head) {
		// TODO Auto-generated method stub
		while(head.next != null){
			System.out.print(head.value + " " + head.rand.value + "->");
			head = head.next;
		}
		System.out.println(head.value);
	}
	
	//实现rand的效果
	public static void createRand(Node head){
		int i = 0;
		Node cur = head;
		Vector<Node> nodeArr = new Vector<Node>();
		while(cur != null){
			cur = cur.next;
			nodeArr.add(cur);
			i++;
		}
		cur = head;
		int randNum;
		Random random = new Random();
		while(cur != null){
			randNum = random.nextInt(i);
			cur.rand = nodeArr.get(randNum);
			cur = cur.next;
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
	
	/*
	 * 方法1：利用hashMap()时间复杂度O(N), 额外的空间复杂度O(N)
	 */
	public static Node copyListWithRand1(Node head){
		HashMap <Node, Node> map = new HashMap<Node, Node>();
		Node cur = head;
		while(cur != null){
			map.put(cur, new Node(cur.value));
			cur = cur.next;
		}
		cur = head;
		//借用hashMap，利用原来的关系来创建新的链表
		while(cur != null){
			map.get(cur).next = map.get(cur.next);			//设置next结点
			map.get(cur).rand = map.get(cur.rand);			//设置rand结点
			cur = cur.next;
		}
		return map.get(head);
	}
	
	/*
	 * 方法2：
	 * 再原来的链表上把复制的结点插入到原来结点的后面
	 * 最后利用这个链表的特性可以比较方便地设定新生成结点地next指针
	 */
	public static Node copyListWithRand2(Node head){
		if(head == null){
			return null;
		}
		Node cur = head;
		Node next = null;
		//复制新的结点，并且把它插入到原来结点的后面
		while(cur != null){
			next = cur.next;
			Node newNode = new Node(cur.value);
			cur.next = newNode;
			newNode.next = next;
			cur = next;
		}
		//为新插入的结点来寻找设置它们的rand指针,就是原结点的rand值的下一个值
		cur = head;
		Node newRand;
		while(cur != null){
			newRand = cur.rand == null ? null : cur.rand.next;
			cur.next.rand = newRand;
			cur = cur.next.next;
		}
		//将新老结点分离
		cur = head;
		Node res = null;
		res = cur.next;				//生成新的链表的头结点
		Node curNew = res;
		while(cur != null){
			cur.next = cur.next.next;
			cur = cur.next;
			if(curNew.next != null){				//为了最后一个新结点而设置
				curNew.next = curNew.next.next;
				curNew = curNew.next;
			}
			else{
				curNew.next = null;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5};
		Node head = createList(arr);
		createRand(head);
		System.out.println("生成的链表是：");
		outputWithRand(head);
		head = copyListWithRand2(head);
		System.out.println("复制完以后的链表是：");
		outputWithRand(head);
	}

}
