package com.ouc.algorithm.CodingInterviewGuidePartOne;

import java.util.LinkedList;
import java.util.Scanner;

public class PartOne019 {
	
	//时间复杂度是O(N * w)显然不能让面试官满意。。。。。
	public static int[] getMaxWindow1(int arr[], int n, int w){
		int res[] = new int[n-w+1];
		for(int i = 0;i <= n-w;i++){				//比较的窗口前标
			int max = arr[i];
			for(int j = i;j < i + w;j++){
				if(arr[j] > max) max = arr[j];
			}
			res[i] = max;
		}
		return res;
	}
	
	//每个下标最多进qmax一次，出qmax一次，因此时间复杂度是O(N)的
	public static int[] getMaxWindow2(int arr[], int n, int w){
		if(n <= 0 || w <=0){
			throw new RuntimeException("Error");
		}
		int res[] = new int[n - w + 1];
		int index = 0;
		LinkedList<Integer> qmax = new LinkedList<Integer>();		//存放下标
		for(int i = 0;i < n;i++){
			//除去双向队列小于当前数的队尾
			while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){			
				qmax.pollLast();
			}
			qmax.addLast(i);
			/**
			 * 如果队头已经超过了比较范围就应该除去，
			 * 这里最多除去一个，因为每次窗口只会向后移动一次
			 */
			if(qmax.peekFirst() <= i - w){
				qmax.pollFirst();
			}
			//如果i已经到了可以开始计算最大值w-1的位置，那就开始计算
			if(i >= w -1){
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("请输入数组长度和窗口长度");
		int n = in.nextInt();
		int w = in.nextInt();
		int arr[] = new int[n];
		System.out.println("请输入数组对应的值：");
		for(int i = 0;i < n;i++){
			arr[i] = in.nextInt();
		}
		int res[] = getMaxWindow2(arr, n, w);				//最终结果
		System.out.println("得到的窗口最大值的序列是:");
		for(int i = 0;i < n-w;i++){
			System.out.print(res[i] + " ");
		}
		System.out.println(res[n - w]);
	}

}
