package com.ouc.algorithem.CodingInterviewGuidePartThree;

import java.util.HashMap;

/**
 * 题目：通过先序和中序数组生成后序数组
 * 描述：已知一颗二叉树所有结点的值都不同，给定这颗二叉树正确的先序和中序遍历数组，不要重构
 * 整棵树，而是通过这两个数组直接生成正确的后序遍历数组。
 * 难度：一星
 * @author 蓝云甫
 *
 */
public class PartThree174 {
	public static int[] getPosArray(int[] pre, int[] in){
		int[] pos = new int[pre.length];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		//构建中序遍历数组元素和下标的映射关系
		for(int i = 0;i < in.length;i++){
			map.put(in[i], i);
		}
		getPos(pre, in, pos, 0, pre.length-1, 0, in.length -1, in.length - 1, map);
		return pos;
	}
	/**
	 * 这里插值直接从后向前生成相应值
	 * 返回下一个应该要插入的位置
	 * 更好的办法：之间将insert设置为一个全局变量，这样就不用每次都返回了
	 */
	public static int getPos(int[] pre, int[] in, int[] pos, int preStart, 
			int preEnd, int inStart, int inEnd, int insert, HashMap<Integer, Integer> map){
		if(preStart == preEnd){
			pos[insert] = pre[preStart];
			return --insert; //当右子树只有一个值并且插入完毕后返回给左子树下次位置
		}
		pos[insert] = pre[preStart];
		insert--;			//准备下一次插入的位置
		int headIndex = map.get(pre[preStart]);  //获取先序遍历头节点在中序遍历的下标
		int lLength = headIndex - inStart;
		//由于是从后往前构造后序遍历数组，因此需要先构造右子树
		insert = getPos(pre, in, pos, preStart + lLength + 1, preEnd, headIndex + 1, inEnd, insert, map);
		//将左子树对应值插入，并返回上一层递归左子树下一次要插入位置
		return getPos(pre, in, pos, preStart + 1, preStart + lLength, inStart, headIndex -1, insert ,map);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pre = {1, 2, 4, 5, 3, 6, 7};
		int[] in = {4, 2, 5, 1, 6, 3, 7};
		int[] pos = getPosArray(pre, in);
		for(int i = 0;i < pos.length;i++){
			System.out.print(pos[i] + " ");
		}
	}

}
