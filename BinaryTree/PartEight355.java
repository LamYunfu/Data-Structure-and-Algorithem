package com.ouc.algorithem.CodingInterviewGuidePart3;

import java.util.HashMap;

/*
 * 难度：二星尉
 * 未排序数组中累加和为给定值的最长数组系列问题
 * 1.给定一个数组，其中元素可正，可负，可0，给定一个整数，求arr所有的子数组中累加和为 k 的最长子数组长度
 * 2.求arr中所有的子数组中正数与负数相等的最长子数组长度
 * 3.元素只能是0或者1，求0和1个数相等的最长子数组长度k
 */

/*
 * 解决办法
 * 利用HashMap + 最大窗口的特性
 * HashMap(sum, i)
 * key:  从开始累加到下标i的一个sum值
 * value:  第一次出现这个sum值的下标
 * s(i)代表子数组arr[0...i]的累加和
 * 所以arr[i...j]的累加和代表的是s(j)- s(i-1)
 * 遍历一遍数组，每往前挪进一个数就计算从开始到这个数的所有元素的和
 * 1.查看当前的Map中是否存在key为sum - k
 * 	 如果有说明从（sumMap.get(sum-k)+1 , i）这段子数组的累加和为k
 * 	计算当前的len，看它是否大于当前求得的最大len,如果是那就对len进行更新
 *  如果没有，那说明以i结尾的所有的子数组没有一个累加和是k的
 * 
 * 2.查看当前累加值sum是否在HashMap里面有了，如果没有就在hashMap中新增(sum, 当前下标)
 *   如果没有，那就跳过
 *   为什么？
 *   这样可以保证每个sum值都是第一次出现的也就是最早出现的位置，i的下标也就越靠前，这样得到的子数组越长
 * 
 * 3.注意要从sumMap.put(0, -1)开始,也就是从下标-1开始计算，否则如果从下标0开始的话，
 *   会在后面的计算中忽略以 0 开始的所有子数组（那个 +1）
 */



/*
 * 卧槽6666666666666666666666666666666666666666666666666666666
 * 这样一来解决这两个问题
 * 2.求arr中所有的子数组中正数与负数相等的最长子数组长度
 * 3.元素只能是0或者1，求0和1个数相等的最长子数组长度k
 * 就变得非常简单
 * 2.把正数变为1，负数变为-1，求累加和是0的最长子串长度。
 * 3.把0变成-1，求累加和是0的最长子串的长度。
 */
public class PartEight355 {
	/*
	 * k代表需要寻找的总和定值k
	 * HashMap
	 * key: 从数组开始位置到某一个下标所有数字的累加和sum
	 * value: 数组中第一次出现sum的下标位置i
	 */
	public static int maxLength(int[] arr, int k){
		HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
		int maxLen = 0;
		sumMap.put(0, -1);					//很重要
		int sum = 0;
		for(int i = 0;i < arr.length;i++){
			sum += arr[i];
			if(sumMap.containsKey(sum - k)){
				maxLen = Math.max(i - sumMap.get(sum - k), maxLen); 
			}
			//之前从未出现过这个sum值，加入这个sum值和下标信息
			if(!sumMap.containsKey(sum)){
				sumMap.put(sum, i);
			}
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		int[] arr = {-1, 0, 1, 2, 0, 3 ,-1, 2, 1};
		System.out.println(maxLength(arr, 3));
	}
}
