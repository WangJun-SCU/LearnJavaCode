package com.wangjun.leetcode;
/*
买股票的最佳时机
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

注意你不能在买入股票前卖出股票。

示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
示例 2:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

 */
public class LeetCode24 {

	public static void main(String[] args) {
		
	}
	//解法2 3ms  55.08%
	//REVIEW 将其转换成：求最大子列的Kadane算法解决
	public int maxProfit2(int[] prices) {
		int max = 0;
		int maxCur = 0;
		for(int i = 1; i < prices.length; i++) {
			maxCur = Math.max(0, maxCur += (prices[i] - prices[i -1]));
			max = Math.max(maxCur, max);
		}
		return max;
	}
	//解法2 直观一点，先转成最长子序列问题  4ms  37.46%
	public int maxProfit22(int[] prices) {
		if(prices.length < 2) {
			return 0;
		}
		int[] buff = new int[prices.length - 1];
		for(int i = 1; i < prices.length; i++) {
			buff[i - 1] = prices[i] - prices[i - 1];
		}
		return kadane(buff);
	}
	//使用kanane算法求最长子序列
	public int kadane(int[] arr) {
		int max = arr[0];
		int maxCur = arr[0];
		for(int i = 1; i < arr.length; i++) {
			maxCur = Math.max(maxCur, maxCur + arr[i]);
			max = Math.max(max, maxCur);
		}
		return max > 0? max : 0;
	}
	
	//解法1  冒泡思想，依次遍历 122ms  6.95%
	public int maxProfit(int[] prices) {
        int len = prices.length;
        int max = 0;
        for(int i = 0; i < len - 1; i++) {
        		for(int j = i + 1; j < len; j++) {
        			if(max + prices[i] < prices[j]) {
        				max = prices[j] - prices[i];
        			}
        		}
        }
        return max;
    }
}
