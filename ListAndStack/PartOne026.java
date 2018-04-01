package com.ouc.algorithm.CodingInterviewGuidePartOne;
//�Ѷȣ�У������
import java.util.Scanner;
import java.util.Stack;

public class PartOne026 {
	public static int maxRecSize(int map[][]){
		if(map == null || map.length == 0 || map[0].length == 0){
			return 0;
		}
		int maxArea = 0;
		int height[] = new int[map[0].length];						//ÿһ���и�ĸ߶ȣ��Ե�ǰ��Ϊ�����У���������1�ĸ�����
		for(int i = 0;i < map.length;i++){          	//��N���иÿ���и����Ժ�Ҫ����һ�µ�ǰ������Ӿ���
			for(int j = 0;j < height.length;j++){
				if(map[i][j] == 0) height[j] = 0;				//�����ǰ����0�������������
				else height[j] += 1;				//�����1�Ǿ�������Ļ������ټ�һ
				//���㵱ǰ�߶�������ɵ�����Ӿ���;
			}
			maxArea = Math.max(maxRecFromBottom(height), maxArea);
		}
		return maxArea;
	}
	
	private static int maxRecFromBottom(int[] height) {
		if(height.length == 0)
			return 0;
		int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();			//����±�
		for(int i = 0;i < height.length;i++){
			//����ջ�����Ӿ����ܹ����������죬
			//��ջ��Ԫ�ؿ����������쵽��ǰ��λ��
			while(!stack.isEmpty() && height[stack.peek()] >= height[i]){		//�����ǰջ����Ӧ��ֵ���ڵ�ǰҪ��ջ��ֵ
				int j = stack.pop();
				//��ջԪ����������������Ҫ����ջΪ�յļ������,kΪ��ǰջ����Ԫ���±�
				int k = stack.isEmpty() ? -1 : stack.peek();
				int curArea = (i - k - 1) * height[j];
				maxArea = Math.max(curArea, maxArea);
			}
			stack.push(i);
		}
		//���￼�����е�Ԫ�ؽ�ջ�Ժ����ջ����Ȼ��Ԫ�أ�����Ҫ��������Щ��Ϊ��׼�ľ����С
		//���ʣ��һ��Ԫ�أ�����ǰ�����еĸ߶�һ����������Ҫ��Ȼ�Ͳ��ᱻ���Ԫ�رƳ�ջ��
		while(!stack.isEmpty()){
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			//���ʱ���൱���ڶ�β����һ����С�ĸ߶ȣ�Ҳ����0��
			int curArea = (height.length - k - 1) * height[j];
			maxArea = Math.max(curArea, maxArea);

		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("��������Ҫ�����ľ����������������");
		int N = in.nextInt();
		int M = in.nextInt();
		int map[][] = new int[N][M];
		for(int i = 0;i < N;i++){
			for(int j = 0;j < M;j++){
				map[i][j] = in.nextInt();
			}
		}
		int maxArea = maxRecSize(map);
		System.out.println("�����Ӿ���Ĵ�С�ǣ� " + maxArea);
	}

}
