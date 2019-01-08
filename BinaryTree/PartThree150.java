package com.ouc.algorithem.CodingInterviewGuidePartThree;

import com.ouc.algorithem.CodingInterviewGuidePartThree.Function.Node;

/**
 * 通过有序数据生成平衡搜索二叉树
 * 给定一个有序数据sortArr,已知其中没有重复值，用这个有序数组生成一棵平衡搜索二叉树
 * 并且该搜索二叉树中序遍历结果和sortArr一致
 * 解法: 利用递归操作，将数组中位数作为头节点，左半部分数组作为左子树，右半部分数组作为右子树
 * @author 蓝云甫
 *
 */
public class PartThree150 {
	
	public static Node generateTree(int[] arr){
		if(arr == null){
			return null;
		}
		else{
			return generate(arr, 0, arr.length-1);
		}
	}
	
	public static Node generate(int[] arr, int start, int end){
		if(start > end){
			return null;
		}
		if(start == end){
			Node node = new Node(arr[start]);
			return node;
		}
		int middle = (start + end) / 2;
		Node node = new Node(arr[middle]);
		node.left = generate(arr, start, middle - 1);
		node.right = generate(arr, middle+1,  end);
		return node;
	}
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5 ,6 ,7};
		Node head = generateTree(arr);
		Function.midOrderRecur(head);
	}

}
