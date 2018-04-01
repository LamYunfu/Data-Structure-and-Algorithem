package com.ouc.algorithem.CodingGuideInterviewPartTwo;

import com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.*;

/**
 * 环形链表的约瑟夫问题
 * 要求在O(n)的时间内完成
 * @author 蓝云甫
 *
 */
public class PartTwo043 {
	/**
	 * 约瑟夫问题的简单解决方式
	 * 但是时间复杂度比较高，为O(n * m)
	 * @param head
	 * @param m
	 * @return
	 */
	public static Node josephusKillSimpleWay(Node head, int m){
		//判断传进来的链表是否需要调整
		if(head == null || head.next == head || m < 1){
			return head;
		}
		int count = 0;
		while(head.next != head){
			while(++count != m - 1){
				head = head.next;
			}
			head.next = head.next.next;
			head = head.next;
			count = 0;
		}
		return head;
	}
	
	public static Node josephusKill2(Node head, int m){
		if(head == null || head.next == head || m < 1){
			return head;
		}
		int temp = 1;
		//得出总的结点的个数
		Node cur = head.next;
		while(cur != head){
			temp++;
			cur = cur.next;
		}
		//通过公式递归得到最后留下来的结点在初始链表的编号
		temp = getLive(temp, m);
		while(--temp != 0){
			head = head.next;
		}
		return head;
	}
	
	
	private static int getLive(int temp, int m) {			//temp表示当前链表中结点的个数
		// TODO Auto-generated method stub
		if(temp == 1){				
			return 1;
		}
		return(getLive(temp - 1, m) + m - 1) % temp + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3 ,4 ,5};
		Node head = Function.createCircleList(arr);
		head = josephusKill2(head, 3);
		System.out.println("最后一个活下来的人是：" + head.value);
		
	}

}
