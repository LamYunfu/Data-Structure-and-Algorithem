package com.ouc.algorithem.CodingGuideInterviewPartTwo;
import static com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.*;
/*
 * 难度：一星士
 * 向有序(升序)的环形链表中插入一个新的结点
 * 函数最后返回新的head结点
 */
public class PartTwo082 {
    
	/*
	 * 特别注意插入的结点在head之前和最后一个结点之后这两种情况
	 */
	public static Node insertNum(Node head, int num){
		Node node = new Node(num);
		if(head == null){		//如果链表是空的
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
		//如果程序会执行到这里，说明要插入的结点应该要放在最后一个结点之后，第一个结点之前
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
