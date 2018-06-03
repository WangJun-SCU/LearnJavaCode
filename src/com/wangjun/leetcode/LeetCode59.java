package com.wangjun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
题目：有效的字母异位词

给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class LeetCode59 {
	
	class Solution {
		// 解法4  先排序再比较  6ms  69.51%
		public boolean isAnagram4(String s, String t) {
			if(s.length() != t.length()) return false;
			char[] arr1 = s.toCharArray();
			char[] arr2 = t.toCharArray();
			Arrays.sort(arr1);
			Arrays.sort(arr2);
			for(int i = 0; i < arr1.length; i++) {
				if(arr1[i] != arr2[i])
					return false;
			}
			return true;
		}
		// 解法3 使用hashMap  41ms 15.58%
		public boolean isAnagram3(String s, String t) {
			int len1 = s.length();
	        int len2 = t.length();
	        if(len1 != len2) return false;
	        HashMap<Character, Integer> hash = new HashMap<>();
	        for(int i = 0; i < len1; i++) {
	        	char c = s.charAt(i);
	        	if(hash.containsKey(c)) {
	        		hash.put(c, hash.get(c) + 1);
	        	}else {
	        		hash.put(c, 1);
	        	}
	        }
	        for(int i = 0; i < len2; i++) {
	        	char c = t.charAt(i);
	        	if(hash.containsKey(c)) {
	        		hash.put(c, hash.get(c) - 1);
	        	}else {
	        		return false;
	        	}
	        }
	        for(Character c: hash.keySet()) {
	        	if(hash.get(c) != 0) {
	        		return false;
	        	}
	        }
	        return true;
		}
		// 解法2 优化成LinkedList  323ms  4.02%
		public boolean isAnagram2(String s, String t) {
	        int len1 = s.length();
	        int len2 = t.length();
	        if(len1 != len2) return false;
	        List<String> list = new LinkedList<>();
	        for(int i = 0; i < s.length(); i++){
	            list.add("" + s.charAt(i));
	        }
	        for(int i = 0; i < t.length(); i++){
	            list.remove("" + t.charAt(i));
	        }
	        return list.size() == 0? true : false;
	    }
		// 解法1 最笨  774ms  2.35%
	    public boolean isAnagram(String s, String t) {
	        int len1 = s.length();
	        int len2 = t.length();
	        if(len1 != len2) return false;
	        List<String> list = new ArrayList<>();
	        for(int i = 0; i < s.length(); i++){
	            list.add("" + s.charAt(i));
	        }
	        for(int i = 0; i < t.length(); i++){
	            list.remove("" + t.charAt(i));
	        }
	        return list.size() == 0? true : false;
	    }
	}
 
}
