package com.ouc.algorithm.CodingInterviewGuidePartOne;

import java.util.LinkedList;
import java.util.Scanner;

public class PartOne019 {
	
	//ʱ�临�Ӷ���O(N * w)��Ȼ���������Թ����⡣��������
	public static int[] getMaxWindow1(int arr[], int n, int w){
		int res[] = new int[n-w+1];
		for(int i = 0;i <= n-w;i++){				//�ȽϵĴ���ǰ��
			int max = arr[i];
			for(int j = i;j < i + w;j++){
				if(arr[j] > max) max = arr[j];
			}
			res[i] = max;
		}
		return res;
	}
	
	//ÿ���±�����qmaxһ�Σ���qmaxһ�Σ����ʱ�临�Ӷ���O(N)��
	public static int[] getMaxWindow2(int arr[], int n, int w){
		if(n <= 0 || w <=0){
			throw new RuntimeException("Error");
		}
		int res[] = new int[n - w + 1];
		int index = 0;
		LinkedList<Integer> qmax = new LinkedList<Integer>();		//����±�
		for(int i = 0;i < n;i++){
			//��ȥ˫�����С�ڵ�ǰ���Ķ�β
			while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){			
				qmax.pollLast();
			}
			qmax.addLast(i);
			/**
			 * �����ͷ�Ѿ������˱ȽϷ�Χ��Ӧ�ó�ȥ��
			 * ��������ȥһ������Ϊÿ�δ���ֻ������ƶ�һ��
			 */
			if(qmax.peekFirst() <= i - w){
				qmax.pollFirst();
			}
			//���i�Ѿ����˿��Կ�ʼ�������ֵw-1��λ�ã��ǾͿ�ʼ����
			if(i >= w -1){
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("���������鳤�Ⱥʹ��ڳ���");
		int n = in.nextInt();
		int w = in.nextInt();
		int arr[] = new int[n];
		System.out.println("�����������Ӧ��ֵ��");
		for(int i = 0;i < n;i++){
			arr[i] = in.nextInt();
		}
		int res[] = getMaxWindow2(arr, n, w);				//���ս��
		System.out.println("�õ��Ĵ������ֵ��������:");
		for(int i = 0;i < n-w;i++){
			System.out.print(res[i] + " ");
		}
		System.out.println(res[n - w]);
	}

}
