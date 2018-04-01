package com.ouc.algorithem.CodingGuideInterviewPartTwo;

import java.util.LinkedList;
import java.util.Queue;


/*
 * �Ѷȣ�����ξ
 * ������������ת����һ��˫������
 */
public class PartTwo074 {

	public static class Node{					//��������˫��������
		public int value;
		public Node left;
		public Node right;
		public Node(int data){
			this.value = data;
		}
	}
	
	/*
	 * ����һ��ʱ�临�Ӷ�O(N),����ռ临�Ӷ�O(N)
	 * ����һ�����У�����Ŷ�������������������ѱ����Ľ�����ν������
	 * ����ս����е�˳��������������󷵻�����ͷ
	 */
	public static Node convert1(Node head){
		Queue<Node> queue = new LinkedList<Node>();
		inOrderToQueue(queue, head);		//��������
		Node pre = null;
		head = queue.poll();
		pre = head;
		Node cur = null;
		while(!queue.isEmpty()){
			cur = queue.poll();
			pre.right = cur;
			cur.left = pre;
			pre = cur;
		}
		pre.right = null;
		return head;
	}
	
	public static void inOrderToQueue(Queue<Node> queue, Node head) {
		if(head == null){
			return;
		}
		inOrderToQueue(queue, head.left);
		queue.add(head);
		inOrderToQueue(queue, head.right);
	}
	
	/*
	 * �����������õݹ麯����ʱ�临�Ӷ�O(N),�ռ临�Ӷ�ΪO(h)
	 * ��һ�Ŷ����������������ֱ�ת����һ��˫�������������ұߵ�ָ��
	 * �������ұߵ�ָ���rightָ��ָ���һ��ͷ��㣬�������ܹ����ٶ�λ�ҵ�����Ŀ�ʼ�ͽ���
	 * Ȼ��������������м�ĸ������������
	 * �ɴ˵ݹ���ȥ���ݹ�����������ǣ������Ϊnull;
	 */
	public static Node convert2(Node head){
		if(head == null){
			return null;
		}
		Node last = process(head);
		head = last.right;				//������ָ�������
		last.right = null;
		return head;
	}
	
	public static Node process(Node head) {
		// TODO Auto-generated method stub
		if(head == null){
			return null;
		}
		Node leftE = process(head.left);				//����������
		Node rightE = process(head.right);
		Node leftS = leftE == null ? null : leftE.right;		//��������ʼ
		Node rightS = rightE == null ? null : rightE.right;
		//������������Ƿ�Ϊ�յĲ�ͬ���Ĵ�����Ҳ�ǲ�ͬ
		if(leftE == null && rightE == null){		//�����������ǿգ�Ҳ����Ҷ�ӽ��
			head.left = null;
			head.right = head;
			return head;
		}
		else if(leftE == null && rightE != null){
			head.left = null;
			head.right = rightS;
			rightS.left = head;
			rightE.right = head;
			return rightE;
		}
		else if(leftE != null && rightE == null){
			head.left = leftE;
			leftE.right = head;
			head.right = leftS;
			return head;
		}
		else{
			head.left = leftE;
			leftE.right = head;
			head.right = rightS;
			rightS.left = head;
			rightE.right = leftS;
			return rightE;
		}
	}

	public static Node createTree(int[] arr, int i, int N){
		if(i >= N){
			return null;
		}
		Node node = new Node(arr[i]);
		node.left = createTree(arr, 2 * i + 1, N);
		node.right = createTree(arr, 2 * i + 2, N);
		return node;
	}
	
	public static void output(Node head) {
		// TODO Auto-generated method stub
		while(head.right != null){
			System.out.print(head.value + "->");
			head = head.right;
		}
		System.out.println(head.value);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3, 4, 5, 6};
		Node root = createTree(arr, 0, arr.length);
		root = convert2(root);
		output(root);
	}

}
