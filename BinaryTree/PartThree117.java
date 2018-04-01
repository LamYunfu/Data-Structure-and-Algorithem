package com.ouc.algorithem.CodingInterviewGuidePart3;
import static com.ouc.algorithem.CodingInterviewGuidePart3.Function.*;

import com.ouc.algorithem.CodingInterviewGuidePart3.Function.Node;

/*
 * 难度：二星尉
 * 找到二叉树中的最大搜索二叉子树
 * 
 * 给定一颗二叉树的头结点head,已知其中所有结点的值都不一样，找到含有结点最多的搜索二叉子树
 * 并返回这颗子树的头结点
 */
public class PartThree117 {
	/*
	 * 以节点node为头结点的树中，最大的搜索二叉树只可能来自以下两种情况
	 * 1. 假如node 结点左子树的最大搜索子树是以node.left为头结点并且左子树最大值小于node.value
	 * 		右子树是以node.right为头节点并且右子树最小值大于node.value，那么以node为头结点的整
	 * 		棵二叉树都是搜索二叉树
	 * 2.倘若不满足，那最大搜索二叉树就是左子树和右子树中最大搜索二叉树中结点较多的那个。
	 */
	public static Node biggestSubBST(Node head){
		int[] record = new int[3];
		return posOrder(head, record);
	}
	
	/*
	 * 使用后序遍历，这样才能在获得左右子树的信息以后再进行比较
	 * 需要分别获得左右子树的四个信息
	 * 1.最大搜索二叉树头结点
	 * 2.最大搜索二叉树结点数
	 * 3.最大值
	 * 4.最小值
	 * 
	 * 为什么同时要获得最大值和最小值？
	 * 虽然从当前层次往下看，当前结点知道这个值是左子树还是右子树返回的
	 * 但是往上一层返回的时候，就不知道是左子树还是右边下来的，
	 * 自然也就不知道往上层返回哪一个数了，是最大值还是最小值呢。所以还是同时记录两个数
	 * 虽然表面看起来有一些多余
	 * 
	 * 利用左右子树的这些值和当前结点比较,就知道是属于第一种情况还是第二种情况了
	 * 从而知道返回什么内容
	 * 
	 * 利用record引用类型变量，可以把下层函数的结果直接返回上层，而不用通过return的方式
	 */
	private static Node posOrder(Node head, int[] record) {
		// TODO Auto-generated method stub
		//空结点直接返回
		if(head == null){
			record[0] = 0;
			record[2] = Integer.MAX_VALUE;				//初始化值,作用是无论如何都能让上一层更新，所以取值要注意
			record[1] = Integer.MIN_VALUE;
			return null;
		}
		int value = head.value;
		Node lBST = posOrder(head.left, record);		//返回左边最大搜索二叉树的结点
		int lSize = record[0];					//record带回来的值需要先接收下来，要不然下一次会消失
		int lMax = record[1];
		int lMin = record[2];
		Node rBST = posOrder(head.right, record);		//返回右边最大搜索二叉树的结点
		int rSize = record[0];
		int rMax = record[1];
		int rMin = record[2];
		//更新以当前结点为根节点的子树的record信息，用于向上一层返回
		//只有在当前结点也能加入到最大搜索二叉树的时候，这两条信息才有效
		record[1] = Math.max(value, rMax);
		record[2] = Math.min(value, lMin);
		//判断是属于第一种情况还是第二种情况，由此决定record[0], 和返回的最大子树的头节点
		if(head.left == lBST && head.right == rBST && lMax < value && value < rMin ){
			//属于第一种情况
			record[0] = lSize + rSize + 1;
			return head;
		}
		//属于第二种情况
		record[0] = Math.max(lSize, rSize);
		return lSize > rSize ? lBST : rBST;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 4, 14, 2, 5, 11, 15};
		Node head = createTree(arr);
//		System.out.println(head.value);
		Node maxSearchBinaryTreeSize =  biggestSubBST(head);
		System.out.println(maxSearchBinaryTreeSize.value);
	}

}
