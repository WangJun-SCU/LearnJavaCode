package com.wangjun.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
题目：存在重复
给定一个整数数组，判断是否存在重复元素。

如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

示例 1:

输入: [1,2,3,1]
输出: true
示例 2:

输入: [1,2,3,4]
输出: false
示例 3:

输入: [1,1,1,3,3,4,3,2,4,2]
输出: true

 */
public class LeetCode53 {

	public static void main(String[] args) {
		int[] nums = {1,2,1};
		Solution s = new Solution();
		System.out.println(s.containsDuplicate(nums));
	}
	
	static class Solution {
		//解法3 discuss 使用hashset  17ms  62.63%
		//和解法2 思路一样，只不过hashset的存储更加动态化，动态扩容等。
		public boolean containsDuplicate3(int[] nums) {
			Set<Integer> set = new HashSet<>();
			for(Integer i: nums) {
				if(set.contains(i)) {
					return true;
				}
				set.add(i);
			}
			return false;
		}
		//解法2  空间换时间  3ms  100%
		//选出最大值和最小值，建立区间，遍历一个，值就作为下角表赋值数组，如果遍历的时候发现有值，就说明重复了
		public boolean containsDuplicate2(int[] nums) {
			if(null == nums || nums.length == 0) {
				return false;
			}
			int len = nums.length;
			int max = nums[0];
			int min = nums[0];
			for(int i = 1; i < len; i++) {
				if(nums[i] < min) {
					min = nums[i];
				}
				if(nums[i] > max) {
					max = nums[i];
				}
			}
			/*
			int[] arr = new int[max - min + 1];
			boolean hasZero = false;  //特殊值0的处理
			for(int i = 0; i < len; i++) {
				if(nums[i] == 0) {
					if(hasZero) {
						return true;
					}else {
						hasZero = true;
					}
				}else {
					if(arr[nums[i] - min] != 0) {
						return true;
					}else {
						arr[nums[i] - min] = nums[i];
					}
				}
			}
			*/
			//优化，使用Integer数组就不需要特殊处理0了
			Integer[] arr = new Integer[max - min + 1];
			for(int i = 0; i < len; i++) {
				if(arr[nums[i] - min] != null) {
					return true;
				}
				arr[nums[i] - min] = nums[i];
			}
			return false;
		}
		
		
		//解法1 两个for  超出时间限制
	    public boolean containsDuplicate(int[] nums) {
	    	List<Integer> list = new ArrayList<>();
	        int len = nums.length;
	        for(int i = 0; i < len; i++){
	            if(list.contains(nums[i])){
	                return true;
	            }
	            list.add(nums[i]);
	        }
	        return false;
	    }
	}

}
