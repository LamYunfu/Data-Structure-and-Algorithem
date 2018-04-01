package com.ouc.algorithem.CodingGuideInterviewPartTwo;
import com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.*;
/**
 * 反转部分单向链表
 * @author 蓝云甫
 *
 */
public class PartTwo042 {
	public static Node reversePart(Node head, int from, int to){
		int len = 0;
		Node node1 = head;
		Node fPre = null;
		Node fPos = null;
		while(node1 != null){			//寻找反转部分的前一个结点和后一个结点
			len++;
			if(len == from - 1){
				fPre = node1;
			}
			if(len == to + 1){
				fPos = node1;
			}
			node1 = node1.next;
		}
		//fPre = null,说明头结点也参加了反转
		Node pHead;
		if(fPre == null)	pHead = head;			//得到反转部分的头
		else pHead = fPre.next;
		Node pre = pHead;
		pHead = pHead.next;
		pre.next = fPos;			//此时的头在反转以后就变成了反转后的尾,
		//手动完成反转部分第一个结点指针的指向，自动反转从第二个结点开始
		Node next = null;
		while(pHead != fPos){
			next = pHead.next;
			pHead.next = pre;
			pre = pHead;
			pHead = next;
		}
		//如果头结点参加了反转，那么不需要做前接工作，
		//只要返回新的头结点，也就是反转部分的最后一个结点，此时为pre
		if(fPre == null){			
			return pre;
		}
		//头结点没有参加反转，需要进行前接工作
		fPre.next = pre;			
		return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3,4,5,6,7,8,9};
		Node head = Function.createList(arr);
		Function.output(head);
		head = reversePart(head, 1,4);
		Function.output(head);
	}

}
