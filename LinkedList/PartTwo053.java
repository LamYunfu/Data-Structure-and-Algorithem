package com.ouc.algorithem.CodingGuideInterviewPartTwo;
import com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.*;
/*
 * 将单向链表按某值划分成左边小，中间相等，右边大的形式
 */
public class PartTwo053 {
	
	/*
	 * 先遍历一遍链表，得到链表的长度N
	 * 生成长度为N的数组，在遍历一遍链表，将链表中的元素放到数组中去
	 * 在数组中利用pivot用类似与快速排序的方法实现题目要求
	 * 最后把数组中的每一个元素连接起来
	 */
	public static Node listPartition1(Node head, int pivot){
		if(head == null){
			return head;
		}
		int N = 0;
		Node cur = head;
		while(cur != null){
			N++;
			cur = cur.next;
		}
		Node[] nodeArr = new Node[N];
		cur = head;
		N = 0;
		while(cur != null){
			nodeArr[N++] = cur;
			cur = cur.next;
		}
		int left = -1, right = N;
		int index = 0;
		/*
		 * index所指的值永远是与pivot相等的值
		 * 只有在当前值小于pivot的时候，index才会发生变化+1
		 * 使得更小的值换到pivot集群的前面去
		 * left指向pivot集群的右端
		 */
		while(index != right){					//交换对应的值
			/*
			while(nodeArr[left].value < pivot && left < right)
				left++;
			while(nodeArr[right].value > pivot && right > left)
				right--;
			if(left < right){
				Node temp = nodeArr[left];
				nodeArr[left] = nodeArr[right];
				nodeArr[right] = temp;
				left++;
				right--;
			}
			*/
			if(nodeArr[index].value < pivot){
				swap(nodeArr, ++left, index);				//在这里index指向的值为pivot集群的第一个，把它换到pivot的后面去
			}
			else if(nodeArr[index].value == pivot){
				index++;
			}
			else{
				swap(nodeArr, index, --right);
			}
			int i;
			for(i = 1;i < nodeArr.length;i++){
				nodeArr[i - 1].next = nodeArr[i];
			}
			nodeArr[i - 1].next = null;
			System.out.print(index + "   " + left + "  " + right + "  ");
			Function.output(nodeArr[0]);
		}
		int i;
		for(i = 1;i < nodeArr.length;i++){
			nodeArr[i - 1].next = nodeArr[i];
		}
		nodeArr[i - 1].next = null;
		return nodeArr[0];
	}
	
	public static void swap(Node[] nodeArr, int left, int right){
		Node temp = nodeArr[left];
		nodeArr[left] = nodeArr[right];
		nodeArr[right] = temp;
	}
	
	/**
	 * 方法二：将原来的链表依次划分为三个链表，然后再将它们连接起来
	 * @param args
	 */
	public static Node listPartition2(Node head, int pivot){
		Node sH = null;							//小的头
		Node sT = null;
		Node eH = null;
		Node eT = null;
		Node bH = null;
		Node bT = null;
		Node next = null;			//下一个结点
		while(head != null){
			next = head.next;
			head.next = null;			//为进入三个链表中的一个做准备
			if(head.value < pivot){
				if(sH == null){					//如果链表还未初始化
					sH = head;
					sT = head;
				}
				else{
					sT.next = head;
					sT = head;
				}
			}
			else if(head.value == pivot){
				if(eH == null){
					eH = head;
					eT = head;
				}
				else{
					eT.next = head;
					eT = head;
				}
			}
			else{
				if(bH == null){
					bH = head;
					bT = head;
				}
				else{
					bT.next = head;
					bT = head;
				}
			}
			head = next;
		}
		//再把三个链表连接起来

		if(sH != null){
			if(eH != null){				//如果第二个链表不为空
				sT.next = eH;
				eT.next = bH;
			}
			else{
				sT.next = bH;
			}
			return sH;
		}
		else if(eH != null){
			eH.next = bH;
			return eH;
		}
		else{
			return eH;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5, 6, 7, 1, 11,3, 4,2, 4,5,6,7,8,9, 3};
		Node head = Function.createList(arr);
		Function.output(head);
		Node newHead = listPartition2(head, 3);
		Function.output(newHead);
	}

}
