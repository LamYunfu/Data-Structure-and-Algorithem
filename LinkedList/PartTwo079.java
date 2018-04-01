package com.ouc.algorithem.CodingGuideInterviewPartTwo;
import static com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.*;

/*
 * 难度：一星士
 * 给定一个无序的单链表的头结点head,实现单链表的选择排序
 * 额外的空间复杂度为O(1)
 */
public class PartTwo079 {
	/*
	 * 每次从链表中选择一个数值最小的数，并且把它从原来的链表上删除
	 * 把这个结点加到新的链表上
	 */
	public static Node selectionSort(Node head){
		Node newHead = null;
		Node smallPre = null;		//最小结点的前一个结点
		Node small = head;
		Node newLast = null;
		while(head.next != null){
			smallPre = getSmallestNode(head);
			if(smallPre == null){			//说明最小结点是头节点
				small = head;
				head = head.next;
			}
			else{
				small = smallPre.next;
				smallPre.next = smallPre.next.next;
			}
			if(newHead == null){
				newHead = small;
				newLast = newHead;
			}
			else {
				newLast.next = small;
				newLast = small;
			}
		}
		newLast.next = head;
		return newHead;
		
	}
	
	public static Node getSmallestNode(Node head){
		Node smallest = head;
		Node smallPre = null;
		Node cur = head;
		Node pre = null;
		while(cur != null){
			if(cur.value < smallest.value){
				smallest = cur;
				smallPre = pre;
			}
			pre = cur;
			cur = cur.next;
		}
		/*
		if(smallest != head){
			smallPre.next = smallest.next;
		}
		return smallest;
		*/
		//这里需要考虑到删除的结点是第一个结点的情况，这样不能在这个函数里调整链表了，因为不能够返回新的head
		//因此返回smallPre,链表的调整放到上层去做
		return smallPre;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {9, 8, 7, 6, 1, 3, 2, 5};
		Node head = createList(arr);
		output(head);
		head = selectionSort(head);
		output(head);
	}

}
