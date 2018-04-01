package com.ouc.algorithm.CodingInterviewGuidePartOne;
//难度：校级三星
import java.util.Scanner;
import java.util.Stack;

public class PartOne026 {
	public static int maxRecSize(int map[][]){
		if(map == null || map.length == 0 || map[0].length == 0){
			return 0;
		}
		int maxArea = 0;
		int height[] = new int[map[0].length];						//每一次切割的高度（以当前行为基础行，向上连续1的个数）
		for(int i = 0;i < map.length;i++){          	//做N次切割，每次切割完以后都要计算一下当前的最大子矩阵
			for(int j = 0;j < height.length;j++){
				if(map[i][j] == 0) height[j] = 0;				//如果当前行是0，则上面的作废
				else height[j] += 1;				//如果是1那就再上面的基础上再加一
				//计算当前高度所能组成的最大子矩阵;
			}
			maxArea = Math.max(maxRecFromBottom(height), maxArea);
		}
		return maxArea;
	}
	
	private static int maxRecFromBottom(int[] height) {
		if(height.length == 0)
			return 0;
		int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();			//存放下标
		for(int i = 0;i < height.length;i++){
			//代表栈顶的子矩阵不能够再往右延伸，
			//出栈的元素可以往右延伸到当前的位置
			while(!stack.isEmpty() && height[stack.peek()] >= height[i]){		//如果当前栈顶对应的值大于当前要入栈的值
				int j = stack.pop();
				//出栈元素往右衍生，这里要考虑栈为空的极端情况,k为当前栈顶的元素下标
				int k = stack.isEmpty() ? -1 : stack.peek();
				int curArea = (i - k - 1) * height[j];
				maxArea = Math.max(curArea, maxArea);
			}
			stack.push(i);
		}
		//这里考虑所有的元素进栈以后，最后栈中仍然有元素，继续要计算以这些列为基准的矩阵大小
		//最后剩的一个元素，它的前面所有的高度一定都比它大，要不然就不会被这个元素逼出栈了
		while(!stack.isEmpty()){
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			//这个时候相当于在队尾入了一个极小的高度（也就是0）
			int curArea = (height.length - k - 1) * height[j];
			maxArea = Math.max(curArea, maxArea);

		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("请输入你要建立的矩阵的行数和列数：");
		int N = in.nextInt();
		int M = in.nextInt();
		int map[][] = new int[N][M];
		for(int i = 0;i < N;i++){
			for(int j = 0;j < M;j++){
				map[i][j] = in.nextInt();
			}
		}
		int maxArea = maxRecSize(map);
		System.out.println("最大的子矩阵的大小是： " + maxArea);
	}

}
