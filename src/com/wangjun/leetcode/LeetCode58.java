package com.wangjun.leetcode;

/*
题目：颠倒整数
给定一个 32 位有符号整数，将整数中的数字进行反转。

输入: 123
输出: 321
输入: -123
输出: -321
输入: 120
输出: 21
注意:
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。
根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class LeetCode58 {

	public static void main(String[] args) {
		int a = Integer.MAX_VALUE;
		System.out.println(a + 1);
		System.out.println(Integer.MIN_VALUE);
	}
	class Solution {
		// 解法2 discuss  27ms  94.85%
		public int reverse2(int x) {
			int result = 0;
			while(x != 0) {
				int tail = x % 10;
				int tem = result;
				result = result * 10 + tail;
				if(result/10 != tem) return 0;  // 如果溢出就和原数不相等了
				x = x / 10;
			}
			return result;
		}
		
		// 解法1  很烂！  40ms  36.34%
	    public int reverse(int x) {
	    	StringBuffer sb = new StringBuffer("" + x);
	    	int start = x < 0? 1 : 0;
	    	int left = start;
	    	int right = sb.length();
	    	while(left < right) {
	    		char tem = sb.charAt(left);
	    		sb.setCharAt(left, sb.charAt(right));
	    		sb.setCharAt(right, tem);
	    		left++;
	    		right--;
	    	}
	    	int result = 0;;
	    	try {
	    		result = Integer.parseInt(sb.toString());
	    	}catch(Exception e){
	    		return 0;
	    	}
	    	return result;
	    }
	}

}
