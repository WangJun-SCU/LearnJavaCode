package com.wangjun.leetcode;

import java.util.HashMap;

/*
题目：两数之和 II - 输入有序数组
给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。请注意，返回的下标值（index1 和 index2）不是从零开始的。
你可以假设每个输入都只有一个解决方案，而且你不会重复使用相同的元素。
输入：数组 = {2, 7, 11, 15}, 目标数 = 9
输出：index1 = 1, index2 = 2
*/
public class LeetCode3 {

	public static void main(String[] args) {
		
	}
	
	// 解法1：通过双重for循环 用时：146ms
	public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        for(int i = 0; i < length - 1; i++) {
        		for(int j = i + 1; j < length ; j++) {
        			if(numbers[i] + numbers[j] == target)
        				return new int[]{i+1,j+1};
        		}
        }
        return null;
    }
	// 解法2：通过hashMap 用时：6ms
	// 数组的值作为key，下角标作为value
	public int[] twoSum2(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < numbers.length; i++) {
			if(map.keySet().contains(target - numbers[i])) {
				return new int[] {map.get(target - numbers[i]) + 1,i + 1};
			}
			map.put(numbers[i], i);
		}
		return null;
    }

}
