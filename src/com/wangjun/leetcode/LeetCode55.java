package com.wangjun.leetcode;

/*
题目：移动0
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。
 */
public class LeetCode55 {

	public static void main(String[] args) {

	}

	class Solution {
		// 解法2 使用一个index指示放置不为0的数的位置  3ms  57.2%
		public void moveZeroes2(int[] nums) {
			if (null == nums || nums.length == 0) {
				return;
			}
			int len = nums.length;
			int index1 = 0;
			for (int i = 0; i < len; i++) {
				if (nums[i] != 0) {
					if (index1 == i) {
						index1++;
					} else {
						nums[index1++] = nums[i];
						nums[i] = 0;
					}
				}
			}
		}

		// 解法1 拷贝一个新的数组 然后赋值 不符合题目要求（不能拷贝额外数组）  3ms  57.2%
		public void moveZeroes(int[] nums) {
			if (null == nums || nums.length == 0) {
				return;
			}
			int len = nums.length;
			int[] tem = new int[len];
			for (int i = 0; i < len; i++) {
				tem[i] = nums[i];
			}
			for (int i = 0, j = 0; i < len || j < len;) {
				if (i == len) {
					nums[j] = 0;
					j++;
				} else if (tem[i] != 0) {
					nums[j] = tem[i];
					j++;
					i++;
				} else {
					i++;
				}
			}
		}
	}

}
