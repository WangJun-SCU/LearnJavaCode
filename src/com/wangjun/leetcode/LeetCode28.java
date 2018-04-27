package com.wangjun.leetcode;
/*
给出一个整数，写一个函数来确定这个数是不是3的一个幂。

后续挑战：
你能不使用循环或者递归完成本题吗？
 */
public class LeetCode28 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isPowerOfThree(30));
	}
	
	//解法2，不使用循环或者递归 21ms  30.1%
	//根据 log(10)N / log(10)3  =  log(3)N  换底公式
	static class Solution2 {
	    public boolean isPowerOfThree(int n) {
	    		return (Math.log10(n)/Math.log10(3))%1 == 0;
	    }
	}
	
	//解法1  超出时间限制
	static class Solution {
	    public boolean isPowerOfThree(int n) {
	        int tem = 1;
	        while(tem < n) {
	        		tem *= 3;
	        }
	        return tem == n;
	    }
	}
}
