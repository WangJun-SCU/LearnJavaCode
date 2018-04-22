package com.wangjun.leetcode;

/*
假设你正在爬楼梯。需要 n 步你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。
 */
public class LeetCode23 {

	public static void main(String[] args) {
		System.out.println(new LeetCode23().climbStairs(44));
	}
	
	//解法1 递归 超出时间限制了
	public int climbStairs(int n) {
		if(n == 1) {
			return 1;
		}
        if(n == 2) {
        		return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
	//解法2 不用递归  2ms  100%
	public int climbStairs1(int n) {
		if(n ==0 )
			return 0;
		if(n == 1)
			return 1;
		if(n == 2) {
			return 2;
		}
		int step1 = 1;
		int step2 = 2;
		int sum = 0;
		for(int i = 2; i < n; i++) {
			sum = step1 + step2;
			step1 = step2;
			step2 = sum;
		}
		return sum;
	}

}
