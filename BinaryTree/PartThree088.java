package com.ouc.algorithem.CodingInterviewGuidePart3;

import java.util.Stack;

import com.ouc.algorithem.CodingInterviewGuidePart3.Function.*;

/*
 * 难度：三星校
 * 用非递归的方式实现二叉树的先序遍历、中序遍历、后序遍历
 * 中左右，左中右，左右中
 */
public class PartThree088 {
	
	/*
	 * 利用非递归的方法实现前序遍历
	 * 技术要点：利用栈
	 * 每次弹出栈顶的结点以后
	 * 入栈顺序：右左（这样出栈顺序就是左右了）
	 * 每次弹出栈顶就吧它的右左结点入栈
	 * 这样遍历的顺序就是前序遍历了
	 */
	public void preOrderUnRecur(Node root){
		System.out.println("前序遍历：");
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		Node node = null;
		while(!stack.isEmpty()){
			node = stack.pop();
			System.out.print(node.value + " ");
			if(node.right != null){
				stack.push(node.right);
			}
			if(node.left != null){
				stack.push(node.left);
			}
		}
		System.out.println();
	}
	
	/*
	 * 利用非递归的形式实现中序遍历
	 * 也是利用栈
	 * 1.一开始一直把左边结点压栈，直到结点为空
	 * 然后把栈顶结点弹出，输出
	 * 看这个结点的右边是不是空，如果不是，就把右结点入栈
	 * 重复1，直到栈为空
	 */
	public void inOrderUnRecur(Node root){
		System.out.println("中序遍历：");
		Node cur = root;
		Stack<Node> stack = new Stack<Node>();
		while(stack != null && cur != null){
			/*
			while(cur != null){
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			System.out.println(cur.value);
			cur = cur.right;
			*/
			if(cur != null){
				stack.push(cur);
				cur = cur.left;
			}
			else{					//一次null,前一个结点,两次null,前一个结点的前一个结点
				cur = stack.pop();						//只有在出栈以后才开始往右移动
				System.out.println(cur.value + " ");
				cur = cur.right;
			}
		}	
	}
	
	/*
	 * 最难的， 非递归方法实现后序遍历
	 * 方法1：双栈法
	 * 1.申请两个栈 s1 和 s2，将头结点压入s1
	 * 2.从s1弹出一个结点，把这个结点的左结点和右结点入栈
	 * 3.把s1中弹出的结点放到栈s2中
	 * 4.重复2 3，直到栈1为空为止
	 * 5.在栈s2中逐个弹出，就是后序遍历的顺序
	 * 
	 * 从s1中弹出的顺序是 中右左 那么从s2中弹出的顺序就是左右中
	 */
	public void posOrderUnRecur1(Node head){
		System.out.println("后序遍历：");
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.push(head);
		Node node = null;
		while(!s1.isEmpty()){
			node = s1.pop();
			if(node.left != null){
				s1.push(node.left);
			}
			if(node.right != null){
				s2.push(node.right);
			}
			s2.push(node);
		}
		while(!s2.isEmpty()){
			node = s2.pop();
			System.out.print(node.value + " ");
		}
		System.out.println();
	}
	
	/*
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
