package com.wangjun.leetcode;

import java.util.Arrays;

/*
打乱一个没有重复元素的数组。

示例:

// 以数字集合 1, 2 和 3 初始化数组。
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
solution.shuffle();

// 重设数组到它的初始状态[1,2,3]。
solution.reset();

// 随机返回数组[1,2,3]打乱后的结果。
solution.shuffle();
 */
public class LeetCode25_ {

	public static void main(String[] args) {
		 int[] nums = {1,2,3,4,5,6};
		 Solution obj = new Solution(nums);
		 int[] param_1 = obj.reset();
		 int[] param_2 = obj.shuffle();
		 System.out.println(Arrays.toString(param_1));
		 System.out.println(Arrays.toString(param_2));
	}
	
	//解法2  211ms 88.1%
	public class Solution2 {

	    private int[] nums;
	    
	    public Solution2(int[] nums) {
	        this.nums = nums;
	    }
	    
	    /** Resets the array to its original configuration and return it. */
	    public int[] reset() {
	        return nums;
	    }
	    
	    /** Returns a random shuffling of the array. */
	    public int[] shuffle() {
	        int[] rand = new int[nums.length];
	        for (int i = 0; i < nums.length; i++){
	            int r = (int) (Math.random() * (i+1));
	            rand[i] = rand[r];
	            rand[r] = nums[i];
	        }
	        return rand;
	    }
	}

	//解法1  236ms  60.71%
	static class Solution {
		
		private int[] nums;
		private int[] original;

	    public Solution(int[] nums) {
	        this.nums = nums;
	        original = new int[nums.length];
	        for(int i = 0; i < nums.length; i++) {
	        	original[i] = nums[i];
	        }
	    }
	    
	    /** Resets the array to its original configuration and return it. */
	    public int[] reset() {
	    	for(int i = 0; i < nums.length; i++) {
	        	nums[i] = original[i];
	        }
	        return nums;
	    }
	    
	    /** Returns a random shuffling of the array. */
	    public int[] shuffle() {
	    	int len = nums.length;
	    	for(int i = 0; i < len; i++) {
	    		int tem = (int) (Math.random() * len);
	    		int temInt = nums[i];
	    		nums[i] = nums[tem];
	    		nums[tem] = temInt;
	    	}
	    	return nums;
	    }
	}
}
