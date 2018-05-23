package com.wangjun.leetcode;

/*
题目：加1
给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。

最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
 */
public class LeetCode54 {

	public static void main(String[] args) {

	}

	class Solution {
		//解法1 从最后一位，逢10加1  0ms
		public int[] plusOne(int[] digits) {
			int len = digits.length;
			for (int i = len - 1; i >= 0; i--) {
				int tem = digits[i] + 1;
				if (tem < 10) {
					digits[i] = tem;
					return digits;
				} else {
					digits[i] = 0;
				}
			}
			int[] result = new int[len + 1];
			result[0] = 1;
			// 根据discuss优化，不用写下面的for逻辑了，除了第一位，其他位都是0！我咋没想到！
			// 所以直接return result就行了啊！
			for (int i = 0; i < len; i++) {
				result[i + 1] = digits[i];
			}
			return result;
		}
	}

}
