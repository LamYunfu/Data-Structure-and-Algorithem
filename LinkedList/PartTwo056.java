package com.ouc.algorithem.CodingGuideInterviewPartTwo;

import java.util.HashMap;
import java.util.Random;
import java.util.Vector;

public class PartTwo056 {

	public static class Node{
		public int value;
		public Node next;
		public Node rand;				//���ָ�����ָ�����������һ����㣬Ҳ������null
		
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
	
	//ʵ��rand��Ч��
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
	 * ����1������hashMap()ʱ�临�Ӷ�O(N), ����Ŀռ临�Ӷ�O(N)
	 */
	public static Node copyListWithRand1(Node head){
		HashMap <Node, Node> map = new HashMap<Node, Node>();
		Node cur = head;
		while(cur != null){
			map.put(cur, new Node(cur.value));
			cur = cur.next;
		}
		cur = head;
		//����hashMap������ԭ���Ĺ�ϵ�������µ�����
		while(cur != null){
			map.get(cur).next = map.get(cur.next);			//����next���
			map.get(cur).rand = map.get(cur.rand);			//����rand���
			cur = cur.next;
		}
		return map.get(head);
	}
	
	/*
	 * ����2��
	 * ��ԭ���������ϰѸ��ƵĽ����뵽ԭ�����ĺ���
	 * ������������������Կ��ԱȽϷ�����趨�����ɽ���nextָ��
	 */
	public static Node copyListWithRand2(Node head){
		if(head == null){
			return null;
		}
		Node cur = head;
		Node next = null;
		//�����µĽ�㣬���Ұ������뵽ԭ�����ĺ���
		while(cur != null){
			next = cur.next;
			Node newNode = new Node(cur.value);
			cur.next = newNode;
			newNode.next = next;
			cur = next;
		}
		//Ϊ�²���Ľ����Ѱ���������ǵ�randָ��,����ԭ����randֵ����һ��ֵ
		cur = head;
		Node newRand;
		while(cur != null){
			newRand = cur.rand == null ? null : cur.rand.next;
			cur.next.rand = newRand;
			cur = cur.next.next;
		}
		//�����Ͻ�����
		cur = head;
		Node res = null;
		res = cur.next;				//�����µ������ͷ���
		Node curNew = res;
		while(cur != null){
			cur.next = cur.next.next;
			cur = cur.next;
			if(curNew.next != null){				//Ϊ�����һ���½�������
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
		System.out.println("���ɵ������ǣ�");
		outputWithRand(head);
		head = copyListWithRand2(head);
		System.out.println("�������Ժ�������ǣ�");
		outputWithRand(head);
	}

}
