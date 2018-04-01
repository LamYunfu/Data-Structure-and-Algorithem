package com.ouc.algorithem.CodingInterviewGuidePart3;
/*
 * 题目：给定一个整型数组arr,已知其中没有重复值，判断arr是否可能是结点类型为整型的搜索二叉树的
 * 后序遍历结果。
 * 进阶：如果整型数组arr中没有重复值，且已知是一颗二叉数的后序遍历结果，通过数组arr重构二叉树
 * 
 */
public class PartThree146 {

	/*
	 * 初阶解题方式：搜索二叉树的后序遍历根据它的性质，根节点一定在数组的末端，记为X0
	 * 然后结合搜索二叉树的性质，在除了根结点的数组中会存在一条分界线，分界线的左边的数小于X0
	 * 分界线右边的数全部大于X0,二者分别代表搜索二叉数的左子树和右子树，同理可以分别对这两颗子树
	 * 做递归分析操作，最后得到结果。
	 * 拓展：如果给的数组是搜索二叉树的前序遍历，方法类似，而中序遍历最简单，直接看整个数组是否有序就行
	 */
	public boolean isPostArray(int[] arr){
		if(arr == null || arr.length == 0){
			return false;
		}
		//传入数组，检查数组段的开始位置和结束位置
		return isPost(arr, 0, arr.length - 1);
	}
	
	public boolean isPost(int[] arr, int start, int end){
		if(start >= end){			//大于是考虑到上一层只有两个值的情况
			return true;
		}
		int middle = arr[end];			//划线参考标准点
		int i = start;
		while(arr[i] < middle){
			i++;
		}
		for(int j = i; j <= end; j++){
			if(arr[j] < middle)
				return false;         //划线的右边出现了比根节点更小的数，直接判定不是搜索二叉树
		}
		return isPost(arr, start, i - 1) && isPost(arr, i, end - 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
