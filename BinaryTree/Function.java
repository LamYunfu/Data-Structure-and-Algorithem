package com.ouc.algorithem.CodingInterviewGuidePart3;
/*
 * 二叉树相关方法
 */
public class Function {
	public static class Node{
		public int value;
		public Node left;
	    public Node right;
	    
	    public Node(int data){
	    	this.value = data;
	    }
	}
	
	public static Node createTree(int[] arr){
		Node[] nodeArr = new Node[arr.length];
		int N = arr.length;
		for(int i = 0; i < N; i++){
			nodeArr[i] = new Node(arr[i]);
		}
		for(int i = 0;i < N;i++){
			if(2 * i + 1 < N){
				nodeArr[i].left = nodeArr[2*i+1];
			}
			if(2 * i + 2 < N){
				nodeArr[i].right = nodeArr[2*i+2];
			}
		}
		return nodeArr[0];
	}
	
	public static void preOrderRecur(Node root){
		if(root == null){
			return;
		}
		System.out.print(root.value + " ");
		preOrderRecur(root.left);
		preOrderRecur(root.right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Node root = createTree(arr);
		preOrderRecur(root);
	}

}
