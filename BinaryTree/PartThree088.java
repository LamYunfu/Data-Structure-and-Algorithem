package com.ouc.algorithem.CodingInterviewGuidePart3;

import java.util.Stack;

import com.ouc.algorithem.CodingInterviewGuidePart3.Function.*;

/*
 * �Ѷȣ�����У
 * �÷ǵݹ�ķ�ʽʵ�ֶ��������������������������������
 * �����ң������ң�������
 */
public class PartThree088 {
	
	/*
	 * ���÷ǵݹ�ķ���ʵ��ǰ�����
	 * ����Ҫ�㣺����ջ
	 * ÿ�ε���ջ���Ľ���Ժ�
	 * ��ջ˳������������ջ˳����������ˣ�
	 * ÿ�ε���ջ���Ͱ�������������ջ
	 * ����������˳�����ǰ�������
	 */
	public void preOrderUnRecur(Node root){
		System.out.println("ǰ�������");
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
	 * ���÷ǵݹ����ʽʵ���������
	 * Ҳ������ջ
	 * 1.һ��ʼһֱ����߽��ѹջ��ֱ�����Ϊ��
	 * Ȼ���ջ����㵯�������
	 * ����������ұ��ǲ��ǿգ�������ǣ��Ͱ��ҽ����ջ
	 * �ظ�1��ֱ��ջΪ��
	 */
	public void inOrderUnRecur(Node root){
		System.out.println("���������");
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
			else{					//һ��null,ǰһ�����,����null,ǰһ������ǰһ�����
				cur = stack.pop();						//ֻ���ڳ�ջ�Ժ�ſ�ʼ�����ƶ�
				System.out.println(cur.value + " ");
				cur = cur.right;
			}
		}	
	}
	
	/*
	 * ���ѵģ� �ǵݹ鷽��ʵ�ֺ������
	 * ����1��˫ջ��
	 * 1.��������ջ s1 �� s2����ͷ���ѹ��s1
	 * 2.��s1����һ����㣬���������������ҽ����ջ
	 * 3.��s1�е����Ľ��ŵ�ջs2��
	 * 4.�ظ�2 3��ֱ��ջ1Ϊ��Ϊֹ
	 * 5.��ջs2��������������Ǻ��������˳��
	 * 
	 * ��s1�е�����˳���� ������ ��ô��s2�е�����˳�����������
	 */
	public void posOrderUnRecur1(Node head){
		System.out.println("���������");
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
