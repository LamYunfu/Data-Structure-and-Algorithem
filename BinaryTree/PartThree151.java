package com.ouc.algorithem.CodingInterviewGuidePartThree;
/**
 * 给定一棵二叉树，除了有左右结点之外，每个结点还有一个存储父亲节点的parent指针
 * 要求给定一个结点，找出它中序遍历的后继节点。
 * 解法：
 * 1.如果该结点有右子树，那么后继节点就是右子树的最左结点
 * 2.如果该结点没有右子树，并且是父节点的左孩子，那么后继结点就是父节点
 * 3.如果该结点没有右子树，且不是父节点的左孩子，那就一直回溯到刚访问节点pre是当前结点的左子树。
 * @author 蓝云甫
 *
 */
public class PartThree151 {
	static class Node{
		public int value;
		public Node left;
		public Node right;
		public Node parent;
		public Node(int value){
			this.value = value;
		}
	}
	
	static Node[] createTree(int[] arr){
		Node[] nodeArr = new Node[arr.length];
		int arrLength = arr.length;
		int leftIndex;
		int rightIndex;
		int parentIndex;
		for(int i = 0;i < arrLength;i++){
			nodeArr[i] = new Node(i);
		}
		for(int i = 0;i < arrLength;i++){
			leftIndex = 2*(i+1) - 1;
			rightIndex = 2*(i+1);
			parentIndex = (i+1)/2 - 1;
			if(leftIndex < arrLength){
				nodeArr[i].left = nodeArr[leftIndex];
			}
			if(rightIndex < arrLength)
				nodeArr[i].right = nodeArr[rightIndex];
			if(parentIndex >= 0)
				nodeArr[i].parent = nodeArr[parentIndex];
		}
		return nodeArr;
	}
	
	static void preOrder(Node head){
		if(head == null)		
			return;
//		if(head.left != null){
//			System.out.print(" left:" + head.left.value);
//		}else{
//			System.out.print(" left: null");
//		}
//		if(head.right != null){
//			System.out.print(" right:" + head.right.value);
//		}else{
//			System.out.print(" right: null");
//		}
//		if(head.parent != null){
//			System.out.println(" parent:" + head.parent.value);
//		}else{
//			System.out.println(" parent: null");
//		}
		preOrder(head.left);
		System.out.print(head.value + " ");
		preOrder(head.right);
	}
	
	static Node getNextNode(Node node){
		if(node.right != null)					//如果该结点的右结点不为空
			return getLeftMost(node.right);
		else{
			while(node.parent != null && node.parent.left != node){
				node = node.parent;
			}
			return node.parent;
		}
	}
	
	//获得右子树最左结点
	static Node getLeftMost(Node node){
		while(node.left != null)
			node = node.left;
		return node;
	}
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
		Node nodes[] = createTree(arr);
		preOrder(nodes[0]);
		System.out.println();
		for(int i = 0;i < arr.length;i++){
			Node next = getNextNode(nodes[i]);
			if(next != null){
				System.out.println(nodes[i].value + " next: " + next.value);
			}else{
				System.out.println(nodes[i].value + " next: " + "null");
			}
			
		}
	}

}
