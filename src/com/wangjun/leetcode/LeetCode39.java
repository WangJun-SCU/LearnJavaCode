package com.wangjun.leetcode;

/*
题目：最大子序列
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class LeetCode39 {

	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(new Solution().maxSubArrayIndex(nums));
	}

	// 解法1 Kadane算法求最大子序列 20ms 28.95%
	// REVIEW 经典算法：Kadane
	static class Solution {
		public int maxSubArray(int[] nums) {
			if (nums.length < 1) {
				return 0;
			}
			int max = nums[0];
			int maxCur = nums[0];
			for (int i = 1; i < nums.length; i++) {
				maxCur = Math.max(maxCur + nums[i], nums[i]);
				max = Math.max(maxCur, max);
			}
			return max;
		}
		//求出最大子序列并打印出来起始位置
		public int maxSubArrayIndex(int[] nums) {
			if (nums.length < 1) {
				return 0;
			}
			int max = nums[0];
			int maxCur = nums[0];
			int start = 0;
			int end = 0;
			int indexStart = 0;
			int indexEnd = 0;
			for (int i = 1; i < nums.length; i++) {
				if(maxCur + nums[i] > nums[i]) {
					maxCur = maxCur + nums[i];
				}else {
					maxCur = nums[i];
					indexStart = i;
				}
				indexEnd = i;
				if(maxCur > max) {
					max = maxCur;
					start = indexStart;
					end = indexEnd;
				}
			}
			System.out.println("start：" + start +";end：" + end);
			return max;
		}
	}

}
