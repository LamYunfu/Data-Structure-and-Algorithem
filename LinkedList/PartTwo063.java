package com.ouc.algorithem.CodingGuideInterviewPartTwo;
import static com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.*;
/*
 * 最大难度：将
 * 两个单链表，可能有环，也可能无环
 * 给定两个链表的头节点，判断这两个链表是否相交
 * 如果两个链表相交，返回相交的第一个结点
 * 如果不相交，那就返回null
 * 如果第一个链表的长度是M,第二个链表的长度是N,要求时间复杂度为O(M+N),额外的空间复杂度为O(1)
 */

/*
 * 两个链表相交，要么两个都有环，要么两个都无环，不可能出现一个有环而另一个没有环的情况
 */
public class PartTwo063 {
	
	/*
	 * 判断一个链表是不是含有环，有的话返回环的入口，没有返回null
	 * 设置一个慢指针slow和一个快指针fase,都从head开始
	 * fast一次走两步，slow一次走一步，
	 * 如果这个链表没有回路，那最后fast会先到达null.
	 * 如果有回路，最后它们两个肯定会在环中的某个地方相遇
	 * 这个时候fast回到head，改为一次走一步，slow仍然环里面兜圈子
	 * 当fast到达环的入口的时候，slow也会到达入口，两者再次相遇
	 */
	public static Node getLoopNode(Node head){
		//构不成环的情况
		if(head == null || head.next == null || head.next.next == null){
			return null;
		}
		Node fast = head;
		Node slow = head;
		while(fast != slow){
			fast = fast.next.next;				//快指针一次走两步
			slow = slow.next;					//慢指针一次走一步
			if(fast == null || fast.next == null){					//说明链表没有环
				return null;
			}
		}
		//确定链表存在环，接下来要找到环的入口位置
		fast = head;
		while(head != slow){
			head = head.next;
			slow = slow.next;
		}
		return fast;
	}
	
	/*
	 * 判断两个无环的链表是否相交
	 * 如果两个链表相交，那么从相交的结点开始，两个链表就是重合的（相交结点只有一个后继结点）
	 * 因此，只要两个链表的最后一个结点相同，那这两个链表就是相交的
	 * 为了找到相交的结点，在遍历两个链表的过程中记录下两个链表的长度
	 * num = legth1 - length2;
	 * 让更长的那个链表先走num布，然后两个链表一起走，知道遇到第一个重合的结点
	 */
	public static Node noLoop(Node head1, Node head2){
		Node cur1 = head1;
		Node cur2 = head2;
//		int length1 = 1;
//		int length2 = 1;
		int n = 0;			//妙啊
		while(cur1.next != null){
			cur1 = cur1.next;
			n++;
		}
		while(cur2.next != null){
			n--;
		}
		if(cur1 != cur2){
			return null;
		}
		cur1 = n > 0 ? head1 : head2;						//cur1为更长的链表的头
		cur2 = cur1 == head1 ? head1 : head2;				//cur2为更短链表的头
		n = Math.abs(n);
		while(n != 0){
			cur1 = cur1.next;
			n--;
		}
		while(cur1 != cur2){
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}
	
	/*
	 * 对于两个有环的链表相交，形成的合链表只有两种情况
	 * 1.像是一个吊坠，两个链表在进入环之前相交
	 * 2.像是一个有天线的电视机，两个链表在环上相交，这个时候返回两个入环结点中的任意一个都可以
	 * 不存在两个链表环相交的情形，这违背了链表的定义规则
	 * 如何判断两个链表相交是属于上面两个中的哪一个情形
	 * 看两个进入链表的结点是否相等就可以了
	 * 
	 * 对于两个链表不相交
	 * 只需要任意选一个入环结点，在环上走一圈，如果没有碰到另外一个入环结点，那就是不相交
	 */
	public static Node bothLoop(Node head1, Node head2, Node loop1, Node loop2){
		Node cur1 = null;
		Node cur2 = null;
		if(loop1 == loop2){				//必定相交
			//吊坠类型，处理方法与无环链表类似
			int n = 0;
			while(cur1.next != loop1){
				cur1 = cur1.next;
				n++;
			}
			while(cur2.next != loop2){
				cur2 = cur2.next;
				n--;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while(n != 0){
				cur1 = cur1.next;
				n--;
			}
			while(cur1 != cur2){
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		}
		else{					//可能是电视类型，也可能不相交
			cur1 = loop1.next;
			while(cur1.next != loop1){
				if(cur1 == loop2){					//电视机类型
					return loop1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}
	
	//综合程序
	public static Node getIntersetNode(Node head1, Node head2){
		if(head1 == null || head2 == null){
			return null;
		}
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		if(loop1 == null && loop2 == null){
			return noLoop(head1, head2);
		}
		else if(loop1 != null && loop2 != null){
			return bothLoop(head1, head2, loop1, loop2);
		}
		else
			return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
