package com.wangjun.leetcode;

/*
计算所有小于非负数整数 n 的质数数量。
 */
public class LeetCode27 {

	public static void main(String[] args) {
		Solution2 s = new Solution2();
		System.out.println(s.countPrimes(1000));
	}

	// 解法2  35ms  54.1%
	static class Solution2 {
		public int countPrimes(int n) {
			boolean[] arr = new boolean[n];
			int result = 0;
			//将所有非质数位置设置为true
			for (int i = 2; i < n; i++) {
				if (!arr[i]) {
					result++;
					//只有是质数的时候再进行赋值true
					for (int j = 2; (i * j) < n; j++) {
						arr[i * j] = true;
					}
				}
			}
			return result;
		}
	}

	// 解法1 超时
	static class Solution {
		public int countPrimes(int n) {
			if (n < 3) {
				return 0;
			}
			int result = 0;
			for (int i = 2; i < n; i++) {
				boolean tag = false;
				for (int j = 2; j <= Math.sqrt(i); j++) {
					if (i % j == 0) {
						tag = true;
						break;
					}
				}
				if (!tag) {
					result++;
				}
			}
			return result;
		}
	}
}
