package com.ouc.algorithem.CodingGuideInterviewPartTwo;

import java.util.LinkedList;
import java.util.Queue;


/*
 * 难度：二星尉
 * 将搜索二叉树转化成一个双向链表
 */
public class PartTwo074 {

	public static class Node{					//二叉树和双向链表复用
		public int value;
		public Node left;
		public Node right;
		public Node(int data){
			this.value = data;
		}
	}
	
	/*
	 * 方法一：时间复杂度O(N),额外空间复杂度O(N)
	 * 设置一个队列，对这颗二叉树进行中序遍历，把遍历的结点依次进入队列
	 * 最后按照进队列的顺序连接起来，最后返回链表头
	 */
	public static Node convert1(Node head){
		Queue<Node> queue = new LinkedList<Node>();
		inOrderToQueue(queue, head);		//结点入队列
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
	 * 方法二：利用递归函数，时间复杂度O(N),空间复杂度为O(h)
	 * 将一颗二叉树的左右子树分别转换成一个双向链表，返回最右边的指针
	 * 其中最右边的指针的right指针指向第一个头结点，这样做能够快速定位找到链表的开始和结束
	 * 然后把左右子树和中间的根结点连接起来
	 * 由此递归下去，递归结束的条件是，最后结点为null;
	 */
	public static Node convert2(Node head){
		if(head == null){
			return null;
		}
		Node last = process(head);
		head = last.right;				//把链表恢复到正常
		last.right = null;
		return head;
	}
	
	public static Node process(Node head) {
		// TODO Auto-generated method stub
		if(head == null){
			return null;
		}
		Node leftE = process(head.left);				//左子树结束
		Node rightE = process(head.right);
		Node leftS = leftE == null ? null : leftE.right;		//左子树开始
		Node rightS = rightE == null ? null : rightE.right;
		//针对左右子树是否为空的不同最后的处理方法也是不同
		if(leftE == null && rightE == null){		//左右子树都是空，也就是叶子结点
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
