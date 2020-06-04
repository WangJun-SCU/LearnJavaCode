package com.wangjun.leetcode;

/*
 * 颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。
 */
public class LeetCode75 {

	public static void main(String[] args) {
		System.out.println(reverseBits(-3));
		System.out.println(Integer.toBinaryString(-3));
	}

	public static int reverseBits(int n) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			res = (res << 1) + (((n >>> i) & 1) == 1? 1: 0);
		}
		return res;
	}

}
