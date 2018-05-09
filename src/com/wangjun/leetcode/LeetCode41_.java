package com.wangjun.leetcode;

import java.util.List;

/*
题目：子集
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class LeetCode41_ {

	public static void main(String[] args) {
		
	}
	
	class Solution {
		//FIXME 数组全排列
	    public List<List<Integer>> subsets(int[] nums) {
	        int len = nums.length;
	        for(int i = 0; i <= len; i++) {
	        	for(int j = 0; j <= i; j++) {
	        		
	        	}
	        }
	        
	        return null;
	    }
	}

}
