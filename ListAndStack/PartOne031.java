package com.ouc.algorithm.CodingInterviewGuidePartOne;
import java.util.LinkedList;
/**
 * 难度： 校级三星
 * 时间复杂度要求： O(N)
 * 解题的方法类似于多个窗口的右移PartOne019
 * 给定数组arr和整数num，共返回有多少个子数组满足如下情况：
 * max(arr[i...j) - min(arr[i...j]) <= num
 * max(arr[i...j])表示子数组arr[i...j]中的最大值，min(arr[i...j])表示子数组arr[i...j]中的最小值
 */
import java.util.Scanner;

public class PartOne031 {
	
	public static int getNum(int arr[], int num){
		if(arr == null || num <= 0)
			return 0;
		int result;
		/**
		 * 为什么要使用双向队列，直接用单个的max和Min不是更好吗？
		 * 因为在下一次循环中，当i + 1后，前面的得到的最大值队列和最小值队列仍然是有用的
		 * 这个时候只需要把队头过期的元素去掉就可以了（i以前的数）
		 * 这个时候再从当前位置开始逐个扫描时，不必再重复地将元素加入栈中，大大节省了时间
		 */
		LinkedList<Integer> qmin = new LinkedList<Integer>();
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int i = 0;					//子数组开始位置
		int j = 0;					//子数组结束位置
		int res = 0;				//最终结果
		for(; i < arr.length; i++){
			while(j < arr.length){
				//每进来一个元素，分别对最大栈和最小栈进行修改
				while(!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]){
					qmin.pollLast();
				}
				qmin.add(j);
				while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]){
					qmax.pollLast();
				}
				qmax.add(j);
				if(arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num){
					break;
				}
				j++;
			}
			res += (j - i);
			/**
			 * 为下一次的计算做准备，将在下一次计算会过期的栈顶元素弹出
			 * 如果栈中有下一次的过期元素，那一定只有当前的i(之前的i已经被弹出栈了)
			 * 而且i一定会在栈顶，这是由队列的性质所决定的
			 * 因此只需要检出当前的栈顶是不是i如果是的话，那就直接弹出
			 */
			if(qmin.peekFirst() == i){
				qmin.pollFirst();
			}
			if(qmax.peekFirst() == i){
				qmax.peekFirst();
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("输入你想要生成的数组的大小");
		int n = in.nextInt();
		int arr[] = new int[n];
		for(int i = 0;i < n;i++){
			arr[i] = in.nextInt();
		}
		System.out.println("输入num:");
		int num = in.nextInt();
		int result = getNum(arr, num);
		System.out.println("一共有" + result + "个子数组满足要求情况");
	}

}
