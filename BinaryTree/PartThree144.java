package com.ouc.algorithem.CodingInterviewGuidePart3;
import static com.ouc.algorithem.CodingInterviewGuidePart3.Function.*;

/*
 * �Ѷȣ�һ��ʿ
 * ��Ŀ������һ�Ŷ��������ж϶������Ƿ�Ϊƽ���������Ҫ��ʱ�临�Ӷ�ΪO(N)
 * �ⷨ�����������������������ʱ����ж���������Ϊͷ�ڵ�������ǲ���һ��ƽ�������
 * �������Ǻ������������������������жϣ���һ������ĳһ����������ƽ�����������ô�Ϳ���˵��
 * ��Ŷ���������ƽ���������
 * ͬʱΪ�˼��ٱ����Ĺ��̣��������Ѿ�����ĳһ����������ƽ�������������¼������±�������Ҫ�ڷ���
 * �������Ƕ�������ʱ��������ء�
 */
public class PartThree144 {
	public boolean isBalance(Node head){
		boolean res[] = {true};      //���Ϊ����������Ϊ���ܹ��ڵݹ��ʱ�������ڲ�ͨ�Ĳ㼶֮����д���
		getHeight(head, 1, res);
		return res[0];
	}
	
	public int getHeight(Node head, int height, boolean[] res){
		if(head == null){
			return height;
		}
		int lHeight = getHeight(head.left, height + 1, res);
		if(res[0] == false){	//�����������Ѿ�����ƽ���������ʱ��ֹͣ�������������ٷ���
			return 0;
		}
		int rHeight = getHeight(head.right, height + 1, res);
		if(res[0] == false){
			return 0;
		}
		if(Math.abs(lHeight - rHeight) > 1){
			res[0] = false;
		}
		return Math.max(lHeight, rHeight);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
