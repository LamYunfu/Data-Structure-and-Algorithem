package com.ouc.algorithem.CodingInterviewGuidePartThree;

import java.util.HashMap;

import com.ouc.algorithem.CodingInterviewGuidePartThree.Function.Node;

/**
 * 题目：先序、中序、后序数组两两结合重构二叉树
 * 已知一颗二叉树所有结点的值都不同，给定这颗二叉树的先序、中序和后序数组。请分别用三个
 * 函数实现任意两种数组结合重构原来的二叉树。
 * @author 蓝云甫
 *
 */
public class PartThree171 {
	
	/**
	 * 通过先序和中序数组生成二叉树
	 * @param pre
	 * @param in
	 * @return
	 */
	public static Node preInToTree(int[] pre, int[] in){
		//先生成中序结点内容和下标的一个对应关系，以便于定位结点的下标，这里用HashMap
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0;i < in.length;i++){
			map.put(in[i], i);
		}
		return preIn(pre, in, 0, pre.length-1, 0, in.length-1,  map);
	}
	public static Node preIn(int[] pre, int[] in, int pStart, int pEnd, int iStart, int iEnd, HashMap<Integer, Integer> map){
		if(pStart > pEnd){
			return null;
		}
		Node node = new Node(pre[pStart]);
		int headIndex = map.get(pre[pStart]);		//获得在中序遍历中头节点的下标
		int lLength = headIndex - iStart;          //得到左子树长度
		//截取左子树和右边子树长度进行递归
		node.left = preIn(pre, in, pStart + 1, pStart + lLength, iStart, iStart + lLength, map);
		node.right = preIn(pre, in,pStart + lLength + 1, pEnd, headIndex + 1, iEnd, map);
		return node;
	}
	 
	/**
	 * 通过中序和后序生成二叉树
	 * @param args
	 */
	public static Node inPosTree(int[] in, int[] pos){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0;i < in.length;i++){
			map.put(in[i], i);
		}
		return inPos(in, pos, 0, in.length-1, 0, pos.length - 1, map);
	}
	public static Node inPos(int[] in, int[] pos, int iStart, int iEnd, int pStart, int pEnd, HashMap<Integer, Integer> map){
		if(iStart > iEnd)
			return null;
		Node node = new Node(pos[pEnd]);
		int headIndex = map.get(pos[pEnd]);
		int lLength = headIndex - iStart;		//左子树长度
		node.left = inPos(in, pos, iStart, headIndex - 1, pStart, pStart + lLength - 1, map );
		node.right = inPos(in, pos, headIndex + 1, iEnd, pStart + lLength, pEnd - 1, map);
		return node;
	}
	
	/**
	 * 通过前序遍历和后序遍历来生成二叉树，注意要求不存在单孩子子树
	 * @param pre
	 * @param pos
	 * @return
	 */
	public static Node prePosTree(int[] pre, int[] pos){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0;i < pos.length;i++){
			map.put(pos[i], i);
		}
		return prePos(pre, pos, 0, pre.length-1, 0, pos.length - 1, map);
	}
	public static Node prePos(int[] pre, int[] pos, int preStart, int preEnd, int posStart, int posEnd, HashMap<Integer, Integer> map){
		if(preStart > preEnd)
			return null;
		else if(preStart == preEnd){
			return new Node(pre[preStart]);
		}
		Node node = new Node(pre[preStart]);
		int headIndex = map.get(pre[preStart + 1]);   //获得左子树头节点在后序遍历中的位置
		int lLength = headIndex - posStart + 1;
		//System.out.println(pre[preStart]);
		node.left = prePos(pre, pos, preStart + 1, preStart + lLength, posStart, headIndex, map);
		node.right = prePos(pre, pos, preStart + lLength + 1, preEnd, headIndex + 1, posEnd - 1, map);
		return node;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pre = {1, 2, 4, 5, 3, 6, 7};
		int[] in = {4, 2, 5, 1, 6, 3, 7};
		int[] pos = {4, 5, 2, 6, 7, 3, 1};
		//Node head = preInToTree(pre, in);
		//Node head = inPosTree(in, pos);
		Node head = prePosTree(pre, pos);
		Function.preOrderRecur(head);
	}

}
