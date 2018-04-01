package com.ouc.algorithm.CodingInterviewGuidePartOne;

import java.util.Scanner;
import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序
 * 只能申请一个辅助栈help，利用这个辅助栈完成对另一个栈从栈顶到栈底从大到小的顺序排序
 * @author 蓝云甫
 *
 *将stack栈中元素逐一弹出，如果该元素小于或者等于help栈顶元素，则压入栈中
 *由于stack栈最后要求从大到小，因此help栈反过来就是从小到大
 *如果该元素大于stack栈中栈顶元素，那么将help栈中元素逐个压回stack栈中，直到该元素小于help栈栈顶元素为止
 *最后再将help栈中的元素压回stack栈中
 */
public class PartOne013 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		System.out.println("请你输入想要进栈的数字的个数");
		int N = in.nextInt();
		for(int i = 0;i < N;i++)
			stack.push(in.nextInt());
		stackSort(stack);
		System.out.println("拍完序后的栈的序列是（从栈底到栈顶）：");
		System.out.println(stack.toString());
	}

	private static void stackSort(Stack<Integer> stack) {
		// TODO Auto-generated method stub
		Stack<Integer> help = new Stack<Integer>();
		while(!stack.isEmpty()){
			int cur = stack.pop();
			//妙处所在，先处理cur大于help栈顶的情况
			while(!help.isEmpty() && cur > help.peek()){
				stack.push(help.pop());
			}
			help.push(cur);
		}
		//最后把help栈压回stack栈中
		while(!help.isEmpty()){
			stack.push(help.pop());
		}
	}

}
