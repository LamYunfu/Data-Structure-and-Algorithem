package com.ouc.algorithm.CodingInterviewGuidePartOne;
import java.util.LinkedList;
/**
 * �Ѷȣ� У������
 * ʱ�临�Ӷ�Ҫ�� O(N)
 * ����ķ��������ڶ�����ڵ�����PartOne019
 * ��������arr������num���������ж��ٸ��������������������
 * max(arr[i...j) - min(arr[i...j]) <= num
 * max(arr[i...j])��ʾ������arr[i...j]�е����ֵ��min(arr[i...j])��ʾ������arr[i...j]�е���Сֵ
 */
import java.util.Scanner;

public class PartOne031 {
	
	public static int getNum(int arr[], int num){
		if(arr == null || num <= 0)
			return 0;
		int result;
		/**
		 * ΪʲôҪʹ��˫����У�ֱ���õ�����max��Min���Ǹ�����
		 * ��Ϊ����һ��ѭ���У���i + 1��ǰ��ĵõ������ֵ���к���Сֵ������Ȼ�����õ�
		 * ���ʱ��ֻ��Ҫ�Ѷ�ͷ���ڵ�Ԫ��ȥ���Ϳ����ˣ�i��ǰ������
		 * ���ʱ���ٴӵ�ǰλ�ÿ�ʼ���ɨ��ʱ���������ظ��ؽ�Ԫ�ؼ���ջ�У�����ʡ��ʱ��
		 */
		LinkedList<Integer> qmin = new LinkedList<Integer>();
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int i = 0;					//�����鿪ʼλ��
		int j = 0;					//���������λ��
		int res = 0;				//���ս��
		for(; i < arr.length; i++){
			while(j < arr.length){
				//ÿ����һ��Ԫ�أ��ֱ�����ջ����Сջ�����޸�
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
			 * Ϊ��һ�εļ�����׼����������һ�μ������ڵ�ջ��Ԫ�ص���
			 * ���ջ������һ�εĹ���Ԫ�أ���һ��ֻ�е�ǰ��i(֮ǰ��i�Ѿ�������ջ��)
			 * ����iһ������ջ���������ɶ��е�������������
			 * ���ֻ��Ҫ�����ǰ��ջ���ǲ���i����ǵĻ����Ǿ�ֱ�ӵ���
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
		System.out.println("��������Ҫ���ɵ�����Ĵ�С");
		int n = in.nextInt();
		int arr[] = new int[n];
		for(int i = 0;i < n;i++){
			arr[i] = in.nextInt();
		}
		System.out.println("����num:");
		int num = in.nextInt();
		int result = getNum(arr, num);
		System.out.println("һ����" + result + "������������Ҫ�����");
	}

}
