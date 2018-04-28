package com.wangjun.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
字谜分组
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。
 */
public class LeetCode32_ {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] arr = {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> list = s.groupAnagrams2(arr);
		for(int i = 0; i < list.size(); i++) {
			List<String> listItem = list.get(i);
			for(String str: listItem) {
				System.out.print(str + "->");
			}
			System.out.println();
		}
		
	}
	
	static class Solution {
		//解法2 如何比较字母异位词呢？  25ms  89.82%
		public List<List<String>> groupAnagrams2(String[] strs) {
			HashMap<String,List<String>> map = new HashMap<>();
			for(String s: strs) {
				char[] arr = s.toCharArray();
				Arrays.sort(arr);
				String temStr = String.valueOf(arr);
				if(!map.containsKey(temStr)) {
					map.put(temStr,new ArrayList<String>());
				}
				map.get(temStr).add(s);
			}
			List<List<String>> result = new ArrayList<>(map.values());
			return result;
		}
		//解法1 排序比较  233ms  5.31%
	    public List<List<String>> groupAnagrams(String[] strs) {
	        List<List<String>> result = new ArrayList<>();
	        List<String> sortList = new ArrayList<>();
	        for(int i = 0; i < strs.length; i++) {
	        		if(sortList.contains(sortString(strs[i]))) {
	        			int index = sortList.indexOf(sortString(strs[i]));
	        			List<String> tem = result.get(index);
	        			tem.add(strs[i]);
	        			result.set(index, tem);
	        		}else {
	        			sortList.add(sortString(strs[i]));
	        			List<String> tem = new ArrayList<>();
	        			tem.add(strs[i]);
	        			result.add(tem);
	        		}
	        }
	        return result;
	    }
	    
	    public String sortString(String str) {
	    		StringBuilder sb = new StringBuilder(str);
	    		//冒泡排序
	    		int len = sb.length();
	    		for(int i = 0; i < len; i++) {
	    			for(int j = 0; j < len - 1 - i; j++) {
	    				if(sb.charAt(j) > sb.charAt(j + 1)) {
	    					char c = sb.charAt(j);
	    					sb.setCharAt(j, sb.charAt(j+1));
	    					sb.setCharAt(j+1, c);
	    				}
	    			}
	    		}
	    		System.out.println("sort:" + sb.toString());
	    		return sb.toString();
	    }
	}

}
