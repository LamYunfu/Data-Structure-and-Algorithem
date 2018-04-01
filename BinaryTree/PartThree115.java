package com.ouc.algorithem.CodingInterviewGuidePart3;
import static com.ouc.algorithem.CodingInterviewGuidePart3.Function.*;

import java.util.HashMap;
/*
 * 给定一颗二叉树的头节点head和一个32位整数sum,二叉树的结点值类型是整型，求得累加和为sum
 * 的最长路径的长度。路径是指从某个结点往下每次最多选择一个孩子结点或者不选所形成的结点链
 */
public class PartThree115 {

	public static int getMaxLength(Node head, int sum){
		HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
		sumMap.put(0, 0);			//重要
		return preOrder(head, sum, 0, 1, 0, sumMap);
	}
	/*
	 * maxLen用于记录最大长度
	 * 类似于PartEight355,把从二叉树根节点到每个叶结点的每一条路径都维持一个HashMap
	 * 也就是把它看成一个数组，key值存放路径上第一次出现这个sum值的总和，value存放第一次出现对应的层数
	 * 
	 */
	private static int preOrder(Node head, int sum, int preSum, int level, 
			int maxLen, HashMap<Integer, Integer> sumMap){
		if(head == null){
			return maxLen;
		}
		int curSum = preSum + head.value;
		if(!sumMap.containsKey(curSum)){
			sumMap.put(curSum, level);
		}
		if(sumMap.containsKey(curSum - sum)){
			maxLen = Math.max(level - sumMap.get(curSum - sum), maxLen);
		}
		maxLen = preOrder(head.left, sum, curSum, level + 1, maxLen, sumMap);  //这样子左右子数的HashMap到了下一层就不一样了
		maxLen = preOrder(head.right, sum , curSum, level + 1, maxLen, sumMap);
		/*
		 * 由于hashMap是一个引用类型的变量
		 * 所有的路径都是共享一个HashMap
		 * 所以在返回之前需要把刚加进去的值移除
		 * 这样在返回上一层遍历右子树的时候才不会出现问题
		 */
		if(level == sumMap.get(curSum)){
			sumMap.remove(curSum);
		}
		return maxLen;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
