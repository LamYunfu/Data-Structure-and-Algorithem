package com.ouc.algorithem.CodingInterviewGuidePart3;
/*
 * 难度：二星尉
 * 求未排序正数数组中累加和为给定值的最长子数组长度
 * 这种方法只适用于所有的值是正值的 情况，只要right已经超过给定值，就没有必要再往右判断
 */
public class PartEight354 {
	
	/*
	 * left:当前窗口左边缘
	 * right： 当前窗口右边缘
	 * len: 当前记录的最长长度
	 * sum: 当前窗口的总和
	 * 从左往右移动窗口
	 * 1.先固定左边，当当前窗口值小于k时，右边边缘一直往右移动
	 * 2.当窗口总和为k时，右边边缘往前移动，重复1
	 * 注意当right >= arr.length时查找结束
	 */
	public static int getMaxLength(int[] arr, int k){
		if(arr == null || arr.length == 0 || k <= 0){
			return 0;
		}
		int left = 0;
		int right = 0;
		int len = 0;
		int sum = 0;
		while(right < arr.length){
			if(sum == k){
//				System.out.println(right - left);
				len = Math.max(len, right - left);
				sum -= arr[left];
				left++;
			}
			else if(sum < k){
				sum += arr[right];
				right++;
			}
			else{
				sum -= arr[left];
				left++;
			}
		}
		return len;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 2, 1, 1, 1, 1, 3, 5};
		int len = getMaxLength(arr, 2);
		System.out.println(len);
	}

}
