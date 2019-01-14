package com.wangjun.leetcode;
/**
 * @author wangjun
 * @date 2019-01-14
 * @version 1.0
 * 
 * 最长公共前缀
 * 
 * 编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
 */
public class LeetCode66 {

	public static void main(String[] args) {
		Solution s = new Solution();
		
		String[] strs = {"flower","flow","flight"};
		System.out.println(s.longestCommonPrefix(strs));
	}
	
	static class Solution {
		
		//解法1 12ms 45.49%
	    public String longestCommonPrefix(String[] strs) {
	    	
	    	if(strs.length == 0) {
	    		return "";
	    	}
	    	
	        StringBuffer sb = new StringBuffer("");
	        String base = strs[0];
	        for(int n = 0; n < base.length(); n++) {
	        	for(int i = 1; i < strs.length; i++) {
	        		if(n >= strs[i].length()) {
	        			return sb.toString();
	        		}
		        	char c1 = base.charAt(n);
		        	char c2 = strs[i].charAt(n);
		        	if(c1 != c2) {
		        		return sb.toString();
		        	}
		        }
	        	sb.append(base.charAt(n));
	        }
	        
	        return sb.toString();
	    }
	}

}
