package com.wangjun.leetcode;

/*
两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

给出两个整数 x 和 y，计算它们之间的汉明距离。

注意：
0 ≤ x, y < 231.

示例:

输入: x = 1, y = 4

输出: 2

解释:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

上面的箭头指出了对应二进制位不同的位置。
 */
public class LeetCode31 {

	public static void main(String[] args) {
		System.out.println(1 ^ 1);
		
	}
	class Solution {
		//解法2  使用亦或  9ms  69.48%
		public int hammingDistance2(int x, int y) {
	        int result = 0;
	        int tem = x ^ y;
	        while(tem != 0) {
	        		if((tem & 1 ) == 1) {
	        			result++;
	        		}
	        		tem = tem >>> 1;
	        }
	        return result;
	    }
		//解法1 17ms  25.56%
	    public int hammingDistance(int x, int y) {
	        int result = 0;
	        while(x != 0 || y != 0){
	            if((x & 1) != (y & 1)){
	                result++;
	            }
	            x = x >>> 1;
	            y = y >>> 1;
	        }
	        return result;
	    }
	}
}
