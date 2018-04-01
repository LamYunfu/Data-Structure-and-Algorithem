package com.ouc.algorithem.CodingInterviewGuidePart3;
import static com.ouc.algorithem.CodingInterviewGuidePart3.Function.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 难度： 一星士
 * 二叉树的序列化和反序列化
 * 也就是二叉树被记录成文件，通过文件内容来重二叉树
 */
public class PartThree103 {
	static Scanner in = new Scanner(System.in);
	/*
	 * 通过先序遍历的顺序来记录二叉树的顺序
	 * 1.左右子树为空通过#来代替
	 * 2.每个值的最后要加上!,用来防止数字产生歧义
	 */
	public static String serialByPre(Node head){
		if(head == null){
			return "#!";
		}
		String result;
		result = head.value + "!";
		result += serialByPre(head.left);
		result += serialByPre(head.right);
		return result;
	}
	
	/*
	 * 通过前序遍历的顺序来还原原来的二叉树
	 * 既然是通过递归的方式得到序列的，那么也通过递归的方式来还原序列
	 */
	public static Node reconByPreString(String preStr){
		String[] values = preStr.split("!");
		Queue<String> queue = new LinkedList<String>();
		for(int i = 0;i < values.length; i++){
			queue.add(values[i]);
		}
		Node head = reconByPreOrder(queue);
		return head;
	}
	private static Node reconByPreOrder(Queue<String> queue){
		//由于树的结构和队列的大小是挂钩的，因此无需判断队列是否为空的情况
		String value = queue.poll();
		if(value == "#"){
			return null;				//叶子空结点
		}
		Node cur = new Node(Integer.valueOf(value));
		cur.left = reconByPreOrder(queue);
		cur.right = reconByPreOrder(queue);
		return cur;
	}
	
	
	/*
	 * 通过层序遍历来实现序列化和反序列化
	 */
	public static String serialByLevel(Node head){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(head);
		Node cur = null;
		String result = "";
		while(!queue.isEmpty()){
			cur = queue.poll();
			result += (cur.value + "!");
			if(cur.left != null){
				queue.add(cur.left);
			}
			else{
				result += "#!";
			}
			if(cur.right != null){
				queue.add(cur.right);
			}
			else{
				result += "#!";
			}
		}
		return result;
	}
	
	/*
	 * 层序遍历二叉树的还原
	 * 1.通过数组下标可以建立，但是需要先把String数组里面的'#'，去掉
	 * 2.既然是通过层序遍历拆毁二叉树,那也可以通过层序遍历来建立回来二叉树
	 */
	public static Node reconByLevelString(String levelStr){
		String[] values = levelStr.split("!");
		Queue<Node> queue = new LinkedList<Node>();
		int index = 0;
		Node head = generateNode(values[index++]);	
		queue.add(head);
		Node cur;
		while(!queue.isEmpty()){
			cur = queue.poll();
			cur.left = generateNode(values[index++]); 	 	//进的时候是左边结点先进，出的时候也是左边先出
			cur.right = generateNode(values[index++]);
			if(cur.left != null){				//把不为空的左右结点放入队列中继续构造
				queue.add(cur.left);
			}
			if(cur.right != null){
				queue.add(cur.right);
			}
		}
		return head;
	}
	private static Node generateNode(String str) {
		// TODO Auto-generated method stub
		if(str == null){
			return null;
		}
		return new Node(Integer.valueOf(str));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Node head = createTree(arr);
		String str = serialByPre(head);
		System.out.println(str);
	}

}
