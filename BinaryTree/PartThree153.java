package com.ouc.algorithem.CodingInterviewGuidePartThree;

import com.ouc.algorithem.CodingInterviewGuidePartThree.Function.Node;

/**
 * 在二叉树中找到两个结点的最近公共祖先
 * 给定一颗二叉树的头节点head,以及这棵树的两个结点o1和o2，请返回o1和o2的最近公共祖先结点
 * 方法：使用一个后序遍历：
 * 1.如果node == null || node == o1 || node == o2 直接返回node
 * 2.如果node.left != null && node.right != null,说明o1和o2第一次在node相遇，返回node
 * 3.如果node的左右结点只有一个为空，说明只可能有两种情况，要么返回的是o1或者o2之一，要么返回的是最近公共祖先，
 * 		直接返回不为空的结点。
 * 4. 如果node 左右都为空，说明以node为头节点的子树中不存在o1和o2,直接返回null
 * @author 蓝云甫
 *
 */
public class PartThree153 {
	public static Node findClosestAncestor(Node cur, Node o1, Node o2){
		if(cur == null || cur == o1 || cur == o2){
			return cur;
		}
		Node left = findClosestAncestor(cur.left, o1, o2);
		Node right = findClosestAncestor(cur.right, o1, o2);
		if(left != null && right != null){
			return cur;
		}
		return left == null ? right : left;
	}
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
		Node[] nodes = Function.createTrees(arr);
		Node ancestor = findClosestAncestor(nodes[0], nodes[5], nodes[6]);
		System.out.println(ancestor.value);
	}

}
