package com.wangjun.leetcode;
/*
题目：旋转图像
给定一个 n × n 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。

说明：

你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 */
public class LeetCode57_ {

	public static void main(String[] args) {
		
	}
	
	class Solution {
		/*
		 *   解法1 discuss 先以(1,1)到(n,n)为轴对称交换，然后以竖中轴进行左右交换  19ms  0%
		 *   1  2  3      1  4  7      7  4  1
		 *   4  5  6  ->  2  5  8  ->  8  5  2
		 *   7  8  9      3  6  9      9  6  3
		 *   效率最低！
		 *   REVIEW 尝试优化算法
		 */
	    public void rotate(int[][] matrix) {
	        if(null == matrix || matrix.length == 0) return;
	        int len = matrix.length;
	        for(int i = 1; i < len; i++) {
	        	for(int j = 0; j < i; j++) {
	        		int tem = matrix[i][j];
	        		matrix[i][j] = matrix[j][i];
	        		matrix[j][i] = tem;
	        	}
	        }
	        
	        for(int i = 0; i < len/2; i++) {
	        	for(int j = 0; j < len; j++) {
	        		int tem = matrix[j][i];
	        		System.out.println(tem);
	        		matrix[j][i] = matrix[j][len - i - 1];
	        		matrix[j][len - i - 1] = tem;
	        	}
	        }
	    }
	}
}
