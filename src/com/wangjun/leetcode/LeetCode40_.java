package com.wangjun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
题目：全排列
给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class LeetCode40_ {

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		Solution s = new Solution();
		s.permexec(nums, 0, nums.length);
		System.out.println("全排列后，原数组：" + Arrays.toString(nums));
	}
	
	static class Solution {
		List<List<Integer>> list = new ArrayList<>();
		// 解法1，使用递归  4ms  98.73%
		// REVIEW 经典算法：数组全排列
	    public List<List<Integer>> permute(int[] nums) {
	    	permexec(nums, 0, nums.length);
	        return list;
	    }
	    public void permexec(int[] nums, int start, int len) {
	    	if(start == len - 1) {
	    		List<Integer> listItem = new ArrayList<>();
	    		for(int i = 0; i < len; i++) {
	    			listItem.add(nums[i]);
	    		}
	    		list.add(listItem);
	    	}else {
	    		for(int i = start; i < len; i++) {
	    			swap(nums, start, i);
	    			permexec(nums, start + 1, len);
	    			swap(nums, start, i);
	    		}
	    	}
	    }
	    public void swap(int[] nums, int i, int j) {
	    	int tem = nums[i];
	    	nums[i] = nums[j];
	    	nums[j] = tem;
	    }
	}

}
