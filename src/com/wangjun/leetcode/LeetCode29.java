package com.wangjun.leetcode;
/*
编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。

示例 :

输入: 11
输出: 3
解释: 32位整数 11 的二进制表示为 00000000000000000000000000001011 。
 */
public class LeetCode29 {

	public static void main(String[] args) {
		Solution s = new Solution();
		s.hammingWeight(-2);
	}
	
	static class Solution {
	    // you need to treat n as an unsigned value
	    public int hammingWeight(int n) {
	    		String s = Integer.toBinaryString(n);
	    		System.out.println(s);
	    		return 0;
	    }
	}

}
