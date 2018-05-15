package com.wangjun.leetcode;

import java.util.LinkedList;
import java.util.List;

/*
给定一个字符串，找出不含有重复字符的最长子串的长度。

示例：

给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。

给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。

给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 */
public class LeetCode33_ {

	public static void main(String[] args) {
		String s = "c";
		Solution s1 = new Solution();
		System.out.println(s1.lengthOfLongestSubstring(s));
	}
	
	//REVIEW 无重复字符串的子串
	static class Solution {
		//解法1  63ms  37.88%
		//使用一个list存储每个字符，如果已经存储过，则删掉这个字符之前的所有字符
	    public int lengthOfLongestSubstring(String s) {
	    	
	    	if(null == s || s.length() ==0) {
	    		return 0;
	    	}
	    	
	    	int maxLen = 0;
	    	LinkedList<Character> list = new LinkedList<>();
	    	
	    	int len = s.length();
	    	for(int i = 0; i < len; i++) {
	    		char c = s.charAt(i);
	    		if(list.contains(c)) {
	    			maxLen = Math.max(maxLen, list.size());
	    			int index = list.indexOf(c);
	    			for(int j = 0; j <= index; j++) {
	    				list.pop();
	    			}
	    		}
	    		list.add(c);
	    	}
	    	
	        return Math.max(maxLen, list.size());
	    }
	}

}
