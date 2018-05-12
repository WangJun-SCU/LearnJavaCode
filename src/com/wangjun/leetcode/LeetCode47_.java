package com.wangjun.leetcode;

/*
题目：搜索二维矩阵
编写一个高效的算法来搜索 m x n 矩阵中的一个目标值 target。该矩阵具有以下特性：

每行的元素从左到右升序排列。
每列的元素从上到下升序排列。
例如，

给定以下矩阵 matrix ：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
示例 1:

输入: matrix, target = 5
输出: true
示例 2:

输入: matrix, target = 20
输出: false
 */
public class LeetCode47_ {
	public static void main(String[] args) {

	}

	class Solution {
		// 解法3，右上到左下缩小范围  38ms  20%
		public boolean searchMatrix3(int[][] matrix, int target) {
			if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
				return false;
			}
			int row = 0;
			int col = matrix[0].length - 1;
			while(row <= matrix.length - 1 && col >= 0) {
				if(matrix[row][col] == target) {
					return true;
				}
				if(target < matrix[row][col]) {
					col--;
				}else if(target > matrix[row][col]) {
					row++;
				}
			}
			return false;
		}
		// 解法2，依次減小len2 31ms  24.29%
		public boolean searchMatrix2(int[][] matrix, int target) {
			if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
				return false;
			}
			int len1 = matrix.length;
			int len2 = matrix[0].length;
			for (int i = 0; i < len1; i++) {
				for (int j = 0; j < len2; j++) {
					if (matrix[i][j] == target) {
						return true;
					} else if (matrix[i][j] > target) {
						len2 = j;
						break;
					}
				}
			}
			return false;
		}

		// 解法1，依次遍历 39ms 17.14%
		public boolean searchMatrix(int[][] matrix, int target) {
			if (null == matrix || matrix.length == 0) {
				return false;
			}
			int len1 = matrix.length;
			int len2 = matrix[0].length;
			for (int i = 0; i < len1; i++) {
				for (int j = 0; j < len2; j++) {
					if (matrix[i][j] == target) {
						return true;
					} else if (matrix[i][j] > target) {
						break;
					}
				}
			}
			return false;
		}
	}

}
