package com.wangjun.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个整数数组，除了某个元素外其余元素均出现两次。请找出这个只出现一次的元素。
备注：
你的算法应该是一个线性时间复杂度。 你可以不用额外空间来实现它吗？
 */
public class LeetCode4 {

	public static void main(String[] args) {
		int[] arr = {2,2,1};
		System.out.println(new LeetCode4().singleNumber(arr));
	}
	
	//解法1 用时：158ms
	public int singleNumber(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < nums.length; i++) {
			int tem = nums[i];
			if(list.contains(tem)) {
				list.remove(new Integer(tem));
			}else {
				list.add(tem);
			}
		}
		return list.get(0);
    }
	//解法2，使用异或 用时：1ms
	//知道这个就好办了。0 ^ X = X;  X ^ X = 0;
	public int singleNumber2(int[] nums) {
		int result = 0;
		int len = nums.length;
		for(int i = 0; i < len; i++) {
			result ^= nums[i];
		}
		return result;
    }

}
