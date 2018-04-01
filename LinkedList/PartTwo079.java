package com.ouc.algorithem.CodingGuideInterviewPartTwo;
import static com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.*;

/*
 * �Ѷȣ�һ��ʿ
 * ����һ������ĵ������ͷ���head,ʵ�ֵ������ѡ������
 * ����Ŀռ临�Ӷ�ΪO(1)
 */
public class PartTwo079 {
	/*
	 * ÿ�δ�������ѡ��һ����ֵ��С���������Ұ�����ԭ����������ɾ��
	 * ��������ӵ��µ�������
	 */
	public static Node selectionSort(Node head){
		Node newHead = null;
		Node smallPre = null;		//��С����ǰһ�����
		Node small = head;
		Node newLast = null;
		while(head.next != null){
			smallPre = getSmallestNode(head);
			if(smallPre == null){			//˵����С�����ͷ�ڵ�
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
		//������Ҫ���ǵ�ɾ���Ľ���ǵ�һ��������������������������������������ˣ���Ϊ���ܹ������µ�head
		//��˷���smallPre,����ĵ����ŵ��ϲ�ȥ��
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
