package com.ouc.algorithm.CodingInterviewGuidePartOne;

import java.util.Scanner;
import java.util.Stack;

/**
 * ��һ��ջʵ����һ��ջ������
 * ֻ������һ������ջhelp�������������ջ��ɶ���һ��ջ��ջ����ջ�״Ӵ�С��˳������
 * @author ���Ƹ�
 *
 *��stackջ��Ԫ����һ�����������Ԫ��С�ڻ��ߵ���helpջ��Ԫ�أ���ѹ��ջ��
 *����stackջ���Ҫ��Ӵ�С�����helpջ���������Ǵ�С����
 *�����Ԫ�ش���stackջ��ջ��Ԫ�أ���ô��helpջ��Ԫ�����ѹ��stackջ�У�ֱ����Ԫ��С��helpջջ��Ԫ��Ϊֹ
 *����ٽ�helpջ�е�Ԫ��ѹ��stackջ��
 */
public class PartOne013 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		System.out.println("����������Ҫ��ջ�����ֵĸ���");
		int N = in.nextInt();
		for(int i = 0;i < N;i++)
			stack.push(in.nextInt());
		stackSort(stack);
		System.out.println("��������ջ�������ǣ���ջ�׵�ջ������");
		System.out.println(stack.toString());
	}

	private static void stackSort(Stack<Integer> stack) {
		// TODO Auto-generated method stub
		Stack<Integer> help = new Stack<Integer>();
		while(!stack.isEmpty()){
			int cur = stack.pop();
			//����ڣ��ȴ���cur����helpջ�������
			while(!help.isEmpty() && cur > help.peek()){
				stack.push(help.pop());
			}
			help.push(cur);
		}
		//����helpջѹ��stackջ��
		while(!help.isEmpty()){
			stack.push(help.pop());
		}
	}

}
