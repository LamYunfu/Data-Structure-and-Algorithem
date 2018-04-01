package com.ouc.algorithem.CodingInterviewGuidePart3;
import static com.ouc.algorithem.CodingInterviewGuidePart3.Function.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * �Ѷȣ� һ��ʿ
 * �����������л��ͷ����л�
 * Ҳ���Ƕ���������¼���ļ���ͨ���ļ��������ض�����
 */
public class PartThree103 {
	static Scanner in = new Scanner(System.in);
	/*
	 * ͨ�����������˳������¼��������˳��
	 * 1.��������Ϊ��ͨ��#������
	 * 2.ÿ��ֵ�����Ҫ����!,������ֹ���ֲ�������
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
	 * ͨ��ǰ�������˳������ԭԭ���Ķ�����
	 * ��Ȼ��ͨ���ݹ�ķ�ʽ�õ����еģ���ôҲͨ���ݹ�ķ�ʽ����ԭ����
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
		//�������Ľṹ�Ͷ��еĴ�С�ǹҹ��ģ���������ж϶����Ƿ�Ϊ�յ����
		String value = queue.poll();
		if(value == "#"){
			return null;				//Ҷ�ӿս��
		}
		Node cur = new Node(Integer.valueOf(value));
		cur.left = reconByPreOrder(queue);
		cur.right = reconByPreOrder(queue);
		return cur;
	}
	
	
	/*
	 * ͨ�����������ʵ�����л��ͷ����л�
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
	 * ��������������Ļ�ԭ
	 * 1.ͨ�������±���Խ�����������Ҫ�Ȱ�String���������'#'��ȥ��
	 * 2.��Ȼ��ͨ�����������ٶ�����,��Ҳ����ͨ�������������������������
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
			cur.left = generateNode(values[index++]); 	 	//����ʱ������߽���Ƚ�������ʱ��Ҳ������ȳ�
			cur.right = generateNode(values[index++]);
			if(cur.left != null){				//�Ѳ�Ϊ�յ����ҽ���������м�������
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
