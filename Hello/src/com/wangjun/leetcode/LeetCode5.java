package com.wangjun.leetcode;

import java.util.Arrays;

/*
将包含 n 个元素的数组向右旋转 k 步。 1,2  1
例如，如果  n = 7 ,  k = 3，给定数组  [1,2,3,4,5,6,7]  ，向右旋转后的结果为 [5,6,7,1,2,3,4]。
 */
public class LeetCode5 {

	public static void main(String[] args) {
		int[] arr = {1,2};
		new LeetCode5().rotate(arr, 1);
		System.out.println(Arrays.toString(arr));
	}
	
	// 解法1 用时：1ms
	public void rotate(int[] nums, int k) {
		int len = nums.length;
        int[] tem = Arrays.copyOf(nums, len);
        for(int i = 0; i < len; i++) {
        		nums[(i+k)%len] = tem[i];
        }
    }

}
