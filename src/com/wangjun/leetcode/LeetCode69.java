package com.wangjun.leetcode;
/**
 * @author wangjun
 * @date 2019-01-14
 * @version 1.0
 * 
 * 缺失数字
 * 
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

示例 1:

输入: [3,0,1]
输出: 2
示例 2:

输入: [9,6,4,2,3,5,7,0,1]
输出: 8
说明:
你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */
public class LeetCode69 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Solution {
		
		//解法1 2ms 56.37%
	    public int missingNumber(int[] nums) {
	        int len = nums.length;
	        int sum1 = len * (len + 1) / 2;
	        
	        int sum2 = 0;
	        for(int i = 0; i < len; i++) {
	        	sum2 += nums[i];
	        }
	        
	        return sum1 - sum2;
	    }
	}
}
