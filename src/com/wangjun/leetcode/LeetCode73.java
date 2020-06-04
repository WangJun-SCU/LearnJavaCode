package com.wangjun.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 写一个程序，输出从 1 到 n 数字的字符串表示。

1. 如果 n 是3的倍数，输出“Fizz”；

2. 如果 n 是5的倍数，输出“Buzz”；

3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 */
public class LeetCode73 {

	public static void main(String[] args) {
		
	}
	
	public static List<String> fizzBuzz(int n) {
		List<String> res = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			if(i % 15 == 0) {
				res.add("FizzBuzz");
				continue;
			}
			if(i % 5 == 0) {
				res.add("Buzz");
				continue;
			}
			if(i % 3 == 0) {
				res.add("Fizz");
				continue;
			}
			res.add(String.valueOf(i));
		}
		return res;
    }

}
