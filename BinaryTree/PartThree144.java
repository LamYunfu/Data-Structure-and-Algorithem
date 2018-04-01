package com.ouc.algorithem.CodingInterviewGuidePart3;
import static com.ouc.algorithem.CodingInterviewGuidePart3.Function.*;

/*
 * 难度：一星士
 * 题目：给定一颗二叉树，判断二叉树是否为平衡二叉树，要求时间复杂度为O(N)
 * 解法：后序遍历二叉树，遍历的时候边判断以这个结点为头节点的子树是不是一颗平衡二叉树
 * （由于是后序遍历，所以是最后来进行判断），一旦发现某一个子树不是平衡二叉树，那么就可以说明
 * 这颗二叉树不是平衡二叉树。
 * 同时为了加速遍历的过程，避免在已经发现某一颗子树不是平衡二叉树的情况下继续往下遍历，需要在发现
 * 子树不是二叉树的时候就立马返回。
 */
public class PartThree144 {
	public boolean isBalance(Node head){
		boolean res[] = {true};      //结果为了用数组是为了能够在递归的时候结果能在不通的层级之间进行传递
		getHeight(head, 1, res);
		return res[0];
	}
	
	public int getHeight(Node head, int height, boolean[] res){
		if(head == null){
			return height;
		}
		int lHeight = getHeight(head.left, height + 1, res);
		if(res[0] == false){	//当发现子树已经不是平衡二叉树的时候，停止往下搜索，快速返回
			return 0;
		}
		int rHeight = getHeight(head.right, height + 1, res);
		if(res[0] == false){
			return 0;
		}
		if(Math.abs(lHeight - rHeight) > 1){
			res[0] = false;
		}
		return Math.max(lHeight, rHeight);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
