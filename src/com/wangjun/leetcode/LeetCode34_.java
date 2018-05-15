package com.wangjun.leetcode;

/*
题目：最长的回文子串
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba"也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
 */
public class LeetCode34_ {

	public static void main(String[] args) {
		Solution s = new Solution();
		String s1 = "bbbb";
		System.out.println(s.longestPalindrome(s1));
	}

	// REVIEW 最长的回文子串  需要看下DISCUSS 优秀解法
	static class Solution {
		// 解法1，遍历一次，每个字符作为中间依次向两边辐射
		// 59ms 58.18%  
		public String longestPalindrome(String s) {
			if (null == s || s.length() == 0) {
				return null;
			}

			int maxLen = 1;
			int start = 0;
			int end = 0;
			for (int i = 0; i < s.length(); i++) {
				int left = i, right = i;
				// 第一种情况 aba
				while (left >= 0 && right < s.length()) {
					if (s.charAt(left) == s.charAt(right)) {
						left--;
						right++;
					} else {
						break;
					}
				}
				left++;
				right--;
				if (right - left + 1 > maxLen) {
					maxLen = right - left + 1;
					start = left;
					end = right;
				}
				// 第二种情况 bb
				left = i;
				right = i + 1;
				while (left >= 0 && right < s.length()) {
					if (s.charAt(left) == s.charAt(right)) {
						left--;
						right++;
					} else {
						break;
					}
				}
				left++;
				right--;
				if (right - left + 1 > maxLen) {
					maxLen = right - left + 1;
					start = left;
					end = right;
				}

			}

			return s.substring(start, end + 1);
		}
	}

}
