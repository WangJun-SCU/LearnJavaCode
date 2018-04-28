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
		System.out.println(s.hammingWeight2(10));
	}
	static class Solution {
	    // you need to treat n as an unsigned value
		//解法2 1ms 100%
		public int hammingWeight2(int n) {
			int result = 0;
			while(n != 0) {
				result = result + (n & 1);
				n = n >>> 1;
			}
			return result;
		}
		// 解法1  2ms  4.62%
	    public int hammingWeight(int n) {
	    		int result = 0;
	    		String s = Integer.toBinaryString(n);
	    		for(int i = 0; i < s.length(); i++) {
	    			if(s.charAt(i) == '1') {
	    				result++;
	    			}
	    		}
	    		return result;
	    }
	}

}
