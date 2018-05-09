package com.wangjun.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
题目：电话号码的组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class LeetCode42_ {

	public static void main(String[] args) {
		String digits = "23";
		Solution s = new Solution();
		System.out.println(s.letterCombinations(digits));
	}
	
	static class Solution {
		List<String> list = new ArrayList<>();
		
		String[] strList = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		
		//解法1  3ms  93.58%
	    public List<String> letterCombinations(String digits) {
	    	if(null == digits || "".equals(digits)) {
	    		return list;
	    	}
	    	String sb = "";
	    	letterHelp(sb, digits, 0);
	    	return list;
	    }
	    public void letterHelp(String sb, String digits, int index) {
	    	int len = digits.length();
	    	if(index == len) {
	    		list.add(sb);
	    	}else {
	    		int indexStr = Integer.valueOf(digits.charAt(index) + "") - 2;
	    		String strTem = strList[indexStr];
	    		for(int i = 0; i < strTem.length(); i++) {
	    			letterHelp(sb + strTem.charAt(i), digits, index + 1);
	    		}
	    	}
	    }
	}

}
