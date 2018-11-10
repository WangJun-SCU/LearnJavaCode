package com.wangjun.leetcode;

/*
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false
 */
public class LeetCode64 {

	public static void main(String[] args) {
		System.out.println((int)'a');
		System.out.println((int)'z');
		System.out.println((int)'A');
		System.out.println((int)'Z');
		System.out.println((int)'0');
		System.out.println((int)'9');
		
		System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
	}

	static class Solution {
		// 解法1  7ms  84.99%
	    public boolean isPalindrome(String s) {
	        int left = 0;
	        int right = s.length() - 1;
	        while(left < right) {
	        	while(left < s.length() && isNumOrLetter(s.charAt(left)) == '!') {
	        		left++;
	        	}
	        	while(right >= 0 && isNumOrLetter(s.charAt(right)) == '!') {
	        		right--;
	        	}
	        	if((left < right) && isNumOrLetter(s.charAt(left)) != isNumOrLetter(s.charAt(right))) {
	        		System.out.println(s.charAt(left));
	        		return false;
	        	}
	        	left++;
	        	right--;
	        }
	        return true;
	    }
	    
	    public char isNumOrLetter(char c) {
	    	if((c >= 48 && c <= 57) || (c >= 65 && c <= 90)) {
	    		return c;
	    	}
	    	if(c >= 97 && c <= 122) {
	    		return (char)(c - 32);
	    	}
	    	return '!';
	    }
	}
}
