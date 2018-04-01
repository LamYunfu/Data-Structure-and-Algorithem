package com.ouc.algorithem.CodingGuideInterviewPartTwo;
import static com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.*;
/*
 * �Ѷȣ�һ��ʿ
 * ������(����)�Ļ��������в���һ���µĽ��
 * ������󷵻��µ�head���
 */
public class PartTwo082 {
    
	/*
	 * �ر�ע�����Ľ����head֮ǰ�����һ�����֮�����������
	 */
	public static Node insertNum(Node head, int num){
		Node node = new Node(num);
		if(head == null){		//��������ǿյ�
			head = node;
			head.next = head;
			return head;
		}
		Node cur = head;
		Node next = null;
		while(cur.next != head){
			if(cur.value <= num && cur.next.value >= num){
				next = cur.next;
				cur.next = node;
				node.next = next;
				return head;
			}
			cur = cur.next;
		}
		//��������ִ�е����˵��Ҫ����Ľ��Ӧ��Ҫ�������һ�����֮�󣬵�һ�����֮ǰ
		cur.next = node;
		node.next = head;
		return num >= cur.value ? head : node;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 5, 6, 7, 8};
		Node head = createCircleList(arr);
		outputCircle(head);
		head = insertNum(head, 9);
		outputCircle(head);
	}

}
