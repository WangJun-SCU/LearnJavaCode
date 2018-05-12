package com.wangjun.leetcode;

/*
题目：不同路径
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？
例如，一个7 x 3 的网格。有多少可能的路径？

说明：m 和 n 的值均不超过 100。

示例 1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
示例 2:

输入: m = 7, n = 3
输出: 28
 */
public class LeetCode48_ {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.uniquePaths2(3, 6));
	}

	static class Solution {
		//解法2，找规律 arr[i][j] = arr[i][j-1] + arr[i-1][j]  1ms  72.40%
		public int uniquePaths2(int m, int n) {
			int[][] arr = new int[m][n];
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					if(i == 0 || j == 0) {
						arr[i][j] = 1;
					}else {
						arr[i][j] = arr[i][j-1] + arr[i-1][j];
					}
				}
			}
			return arr[m-1][n-1];
		}
		// 解法1，递归  超出时间限制
		public int uniquePaths(int m, int n) {
			// 递归出口
			if ((m == 1 && n == 2) || (m == 2 && n == 1) || (m == 1 && n == 1)) {
				return 1;
			}
			int sum1 = m - 1 >= 1 ? uniquePaths(m - 1, n) : 0;
			int sum2 = n - 1 >= 1 ? uniquePaths(m, n - 1) : 0;
			return sum1 + sum2;
		}
	}
}
