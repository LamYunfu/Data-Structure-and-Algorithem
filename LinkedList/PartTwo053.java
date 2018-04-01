package com.ouc.algorithem.CodingGuideInterviewPartTwo;
import com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.*;
/*
 * ����������ĳֵ���ֳ����С���м���ȣ��ұߴ����ʽ
 */
public class PartTwo053 {
	
	/*
	 * �ȱ���һ�������õ�����ĳ���N
	 * ���ɳ���ΪN�����飬�ڱ���һ�������������е�Ԫ�طŵ�������ȥ
	 * ������������pivot���������������ķ���ʵ����ĿҪ��
	 * ���������е�ÿһ��Ԫ����������
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
		 * index��ָ��ֵ��Զ����pivot��ȵ�ֵ
		 * ֻ���ڵ�ǰֵС��pivot��ʱ��index�Żᷢ���仯+1
		 * ʹ�ø�С��ֵ����pivot��Ⱥ��ǰ��ȥ
		 * leftָ��pivot��Ⱥ���Ҷ�
		 */
		while(index != right){					//������Ӧ��ֵ
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
				swap(nodeArr, ++left, index);				//������indexָ���ֵΪpivot��Ⱥ�ĵ�һ������������pivot�ĺ���ȥ
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
	 * ����������ԭ�����������λ���Ϊ��������Ȼ���ٽ�������������
	 * @param args
	 */
	public static Node listPartition2(Node head, int pivot){
		Node sH = null;							//С��ͷ
		Node sT = null;
		Node eH = null;
		Node eT = null;
		Node bH = null;
		Node bT = null;
		Node next = null;			//��һ�����
		while(head != null){
			next = head.next;
			head.next = null;			//Ϊ�������������е�һ����׼��
			if(head.value < pivot){
				if(sH == null){					//�������δ��ʼ��
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
		//�ٰ�����������������

		if(sH != null){
			if(eH != null){				//����ڶ�������Ϊ��
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
