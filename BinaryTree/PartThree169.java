package com.ouc.algorithem.CodingInterviewGuidePartThree;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import com.ouc.algorithem.CodingInterviewGuidePartThree.Function.Node;

/**
 * 难度：二星尉
 * 题目：二叉树的结点间的最大距离问题
 * 从二叉树的结点A出发，可以向上或者向下走，但是沿途的结点只能经过一次，当到达结点B的时候，路径上的结点数叫做A到B的距离。
 * 给定一颗二叉树的头结点head求整棵树上结点间的最大距离。
 * 最大距离只可能来自于三种情况
 * 1. h的左子树上的最大距离
 * 2. h的右子树上的最大距离
 * 3. 跨h的最大距离 = 左子树上距h.left最远点 + 1 + 右子树上距h.right最远点 
 * @author 蓝云甫
 *
 */
public class PartThree169 {
	
	public static int maxDistance(Node head, int record[]){
		if(head == null){
			record[0] = 0;
			return 0;
		}
		int lMax = maxDistance(head.left, record);		//左子树最大距离
		int maxFromLeft = record[0];				//左子数距离head最远距离
		int rMax = maxDistance(head.right, record);
		int maxFromRight = record[0];
		int viaCurrentNodeMax = maxFromLeft + 1 + maxFromRight;		//经过当前结点的最大距离
		record[0] = Math.max(maxFromRight, maxFromLeft) + 1;		//距离父结点最远结点距离，用于返回
		return Math.max(Math.max(lMax, rMax), viaCurrentNodeMax);	//三个距离比较，返回最大	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3, 4, 5, 5, 6, 8};
		Node head = Function.createTree(arr);
		System.out.println(maxDistance(head, new int[1]));
	}

}
