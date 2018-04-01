package com.ouc.algorithm.CodingInterviewGuidePartOne;

import java.util.Scanner;
import java.util.Stack;
/**
 * 利用递归反转一个栈，不能使用其它任何数据结构
 * @author 蓝云甫
 *
 */
public class PartOne008 {
	/**
	 * 返回并且移除栈的最后一个元素
	 * @param stack
	 */
	public static int getAndRemoveLastElement(Stack<Integer> stack){
		int result = stack.pop();
		if(stack.isEmpty()){			//如果是栈底的数，那就返回这个数,不压回栈（从栈中移除）
			return result;
		}
		else{							//否则递归调用这个程序，得到栈底，得到后把pop出的数压回去
			int bottom = getAndRemoveLastElement(stack);
			stack.push(result);				
			return bottom;
		}
	}
	
	/**
	 * 为什么这里会要用递归？
	 * 栈的反转：最后得到的栈底（也就是原来的栈顶），最先被压入栈
	 * 而这正好符合递归的特点，最后一步最先执行下一步
	 * @param stack
	 */
	public static void reverse(Stack<Integer> stack){
		if(!stack.isEmpty()){
			int i = getAndRemoveLastElement(stack);		//先得出来的后被压入
			reverse(stack);	
			stack.push(i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		System.out.println("请输入需要压入栈的数字的个数");
		int N = in.nextInt();
		for(int i = 0;i < N;i++){
			stack.push(in.nextInt());
		}
		//栈反转
		reverse(stack);
		System.out.println("反转完后的结果是");
		System.out.println(stack.toString());
	}

}
