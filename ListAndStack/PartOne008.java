package com.ouc.algorithm.CodingInterviewGuidePartOne;

import java.util.Scanner;
import java.util.Stack;
/**
 * ���õݹ鷴תһ��ջ������ʹ�������κ����ݽṹ
 * @author ���Ƹ�
 *
 */
public class PartOne008 {
	/**
	 * ���ز����Ƴ�ջ�����һ��Ԫ��
	 * @param stack
	 */
	public static int getAndRemoveLastElement(Stack<Integer> stack){
		int result = stack.pop();
		if(stack.isEmpty()){			//�����ջ�׵������Ǿͷ��������,��ѹ��ջ����ջ���Ƴ���
			return result;
		}
		else{							//����ݹ����������򣬵õ�ջ�ף��õ����pop������ѹ��ȥ
			int bottom = getAndRemoveLastElement(stack);
			stack.push(result);				
			return bottom;
		}
	}
	
	/**
	 * Ϊʲô�����Ҫ�õݹ飿
	 * ջ�ķ�ת�����õ���ջ�ף�Ҳ����ԭ����ջ���������ȱ�ѹ��ջ
	 * �������÷��ϵݹ���ص㣬���һ������ִ����һ��
	 * @param stack
	 */
	public static void reverse(Stack<Integer> stack){
		if(!stack.isEmpty()){
			int i = getAndRemoveLastElement(stack);		//�ȵó����ĺ�ѹ��
			reverse(stack);	
			stack.push(i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		System.out.println("��������Ҫѹ��ջ�����ֵĸ���");
		int N = in.nextInt();
		for(int i = 0;i < N;i++){
			stack.push(in.nextInt());
		}
		//ջ��ת
		reverse(stack);
		System.out.println("��ת���Ľ����");
		System.out.println(stack.toString());
	}

}
