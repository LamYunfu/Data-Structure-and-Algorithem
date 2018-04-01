package com.ouc.algorithem.CodingGuideInterviewPartTwo;
import com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.*;
/**
 * ��ת���ֵ�������
 * @author ���Ƹ�
 *
 */
public class PartTwo042 {
	public static Node reversePart(Node head, int from, int to){
		int len = 0;
		Node node1 = head;
		Node fPre = null;
		Node fPos = null;
		while(node1 != null){			//Ѱ�ҷ�ת���ֵ�ǰһ�����ͺ�һ�����
			len++;
			if(len == from - 1){
				fPre = node1;
			}
			if(len == to + 1){
				fPos = node1;
			}
			node1 = node1.next;
		}
		//fPre = null,˵��ͷ���Ҳ�μ��˷�ת
		Node pHead;
		if(fPre == null)	pHead = head;			//�õ���ת���ֵ�ͷ
		else pHead = fPre.next;
		Node pre = pHead;
		pHead = pHead.next;
		pre.next = fPos;			//��ʱ��ͷ�ڷ�ת�Ժ�ͱ���˷�ת���β,
		//�ֶ���ɷ�ת���ֵ�һ�����ָ���ָ���Զ���ת�ӵڶ�����㿪ʼ
		Node next = null;
		while(pHead != fPos){
			next = pHead.next;
			pHead.next = pre;
			pre = pHead;
			pHead = next;
		}
		//���ͷ���μ��˷�ת����ô����Ҫ��ǰ�ӹ�����
		//ֻҪ�����µ�ͷ��㣬Ҳ���Ƿ�ת���ֵ����һ����㣬��ʱΪpre
		if(fPre == null){			
			return pre;
		}
		//ͷ���û�вμӷ�ת����Ҫ����ǰ�ӹ���
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
