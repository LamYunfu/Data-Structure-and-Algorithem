package com.ouc.algorithem.CodingGuideInterviewPartTwo;
import static com.ouc.algorithem.CodingGuideInterviewPartTwo.Function.*;
/*
 * ����Ѷȣ���
 * ���������������л���Ҳ�����޻�
 * �������������ͷ�ڵ㣬�ж������������Ƿ��ཻ
 * ������������ཻ�������ཻ�ĵ�һ�����
 * ������ཻ���Ǿͷ���null
 * �����һ������ĳ�����M,�ڶ�������ĳ�����N,Ҫ��ʱ�临�Ӷ�ΪO(M+N),����Ŀռ临�Ӷ�ΪO(1)
 */

/*
 * ���������ཻ��Ҫô�������л���Ҫô�������޻��������ܳ���һ���л�����һ��û�л������
 */
public class PartTwo063 {
	
	/*
	 * �ж�һ�������ǲ��Ǻ��л����еĻ����ػ�����ڣ�û�з���null
	 * ����һ����ָ��slow��һ����ָ��fase,����head��ʼ
	 * fastһ����������slowһ����һ����
	 * ����������û�л�·�������fast���ȵ���null.
	 * ����л�·��������������϶����ڻ��е�ĳ���ط�����
	 * ���ʱ��fast�ص�head����Ϊһ����һ����slow��Ȼ�����涵Ȧ��
	 * ��fast���ﻷ����ڵ�ʱ��slowҲ�ᵽ����ڣ������ٴ�����
	 */
	public static Node getLoopNode(Node head){
		//�����ɻ������
		if(head == null || head.next == null || head.next.next == null){
			return null;
		}
		Node fast = head;
		Node slow = head;
		while(fast != slow){
			fast = fast.next.next;				//��ָ��һ��������
			slow = slow.next;					//��ָ��һ����һ��
			if(fast == null || fast.next == null){					//˵������û�л�
				return null;
			}
		}
		//ȷ��������ڻ���������Ҫ�ҵ��������λ��
		fast = head;
		while(head != slow){
			head = head.next;
			slow = slow.next;
		}
		return fast;
	}
	
	/*
	 * �ж������޻��������Ƿ��ཻ
	 * ������������ཻ����ô���ཻ�Ľ�㿪ʼ��������������غϵģ��ཻ���ֻ��һ����̽�㣩
	 * ��ˣ�ֻҪ������������һ�������ͬ������������������ཻ��
	 * Ϊ���ҵ��ཻ�Ľ�㣬�ڱ�����������Ĺ����м�¼����������ĳ���
	 * num = legth1 - length2;
	 * �ø������Ǹ���������num����Ȼ����������һ���ߣ�֪��������һ���غϵĽ��
	 */
	public static Node noLoop(Node head1, Node head2){
		Node cur1 = head1;
		Node cur2 = head2;
//		int length1 = 1;
//		int length2 = 1;
		int n = 0;			//�
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
		cur1 = n > 0 ? head1 : head2;						//cur1Ϊ�����������ͷ
		cur2 = cur1 == head1 ? head1 : head2;				//cur2Ϊ���������ͷ
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
	 * ���������л��������ཻ���γɵĺ�����ֻ���������
	 * 1.����һ����׹�����������ڽ��뻷֮ǰ�ཻ
	 * 2.����һ�������ߵĵ��ӻ������������ڻ����ཻ�����ʱ�򷵻������뻷����е�����һ��������
	 * ���������������ཻ�����Σ���Υ��������Ķ������
	 * ����ж����������ཻ���������������е���һ������
	 * ��������������Ľ���Ƿ���ȾͿ�����
	 * 
	 * �������������ཻ
	 * ֻ��Ҫ����ѡһ���뻷��㣬�ڻ�����һȦ�����û����������һ���뻷��㣬�Ǿ��ǲ��ཻ
	 */
	public static Node bothLoop(Node head1, Node head2, Node loop1, Node loop2){
		Node cur1 = null;
		Node cur2 = null;
		if(loop1 == loop2){				//�ض��ཻ
			//��׹���ͣ����������޻���������
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
		else{					//�����ǵ������ͣ�Ҳ���ܲ��ཻ
			cur1 = loop1.next;
			while(cur1.next != loop1){
				if(cur1 == loop2){					//���ӻ�����
					return loop1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}
	
	//�ۺϳ���
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
