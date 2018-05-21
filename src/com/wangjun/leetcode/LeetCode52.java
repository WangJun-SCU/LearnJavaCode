package com.wangjun.leetcode;
/*
题目：买卖股票的最佳时机2

 */
public class LeetCode52 {

	public static void main(String[] args) {
		
	}
	
	class Solution {
		//解法1 根据两天差价得到长度为len-1的数组，将所有正数加起来 1ms  99.94%
	    public int maxProfit(int[] prices) {
	        int max = 0;
	        for(int i = 1; i < prices.length; i++){
	            int tem = prices[i] - prices[i-1];
	            if(tem > 0){
	                max += tem;
	            }
	        }
	        return max;
	    }
	}

}
