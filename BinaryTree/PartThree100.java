package com.ouc.algorithem.CodingInterviewGuidePart3;
import static com.ouc.algorithem.CodingInterviewGuidePart3.Function.*;
/*
 * �Ѷȣ�����ξ
 * ��Ϊֱ�۵ش�ӡ������������״
 */
public class PartThree100 {

	/*
	 * ����������ʱ����ת90������ӡ������
	 * 1.���һ����ӡ�����ǰ׺�ͺ�׺���С�H������������ͷ���
	 * 2.���һ����ӡ����ǰ׺�ͺ�׺���С�v��,����������ڵ�ǰ���ڽ���ǰһ��
	 * 3.���һ����ӡ����ǰ׺���׺���С�^�����������ڵ��ڵ�ǰ���ڽڵ�ĺ�һ��
	 * 
	 * ��Ҫ��֤ÿ��������ݴ�ӡʱ��ռ�õ�ͳһ���ȣ��Ա�֤����
	 * ����涨ÿ�����ռ17��λ�ã������ĵط��ÿո񲹳�
	 * 
	 * ʵ��ʹ���� �� ��ı���������������������ڲ�Ϊi,�ȴ�ӡi * 17 ���ո���
	 */
	public static void printTree(Node head){
		System.out.println("Binary Tree:");
		//��ʼ��ӡ����
		printInOrder(head, 0, "H", 5);
		System.out.println();
	}
	
	/*
	 * height����ʾ��ǰ��������ĸ߶ȣ���������ǰ����Ҫ��ӡ�����ȵ��ո�
	 * to: ������valueǰ��ı�ʶ���� ��H��, ��^��, 'v'
	 * len: �����ռ�ĳ���
	 * ���ڴ�ӡ�Ǵ�������һ��һ�д�ӡ�ģ����ݶ�������ת��Ľṹ����ӡ˳�������������
	 * �����˳ʱ�룬��ӡ˳�����������
	 */
	private static void printInOrder(Node head, int height, String to, int len) {
		// TODO Auto-generated method stub
		if(head == null){
			return;
		}
		printInOrder(head.left, height + 1, "v", len);
		
		String val = to + head.value + to;
		int lenM = val.length();						//�м��ַ�����
		int lenL = (len - lenM) / 2;					//��߿ո񳤶�
		int lenR = len - lenL - lenM;					//�ұ߿ո񳤶�
		val = getSpace(lenL) + val + getSpace(lenR);	//��װ
		System.out.println(getSpace(height * len) + val);
		
		printInOrder(head.right, height + 1, "^", len);
	}

	private static String getSpace(int length) {
		// TODO Auto-generated method stub
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for(int i = 0;i < length; i++){
			buf.append(space);
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Node head = createTree(arr);
		printTree(head);
	}

}
