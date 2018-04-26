package com.wangjun.leetcode;
/*
题目：实现strStr()
实现 strStr() 函数。
给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
示例 1:
输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:
输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:
当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class LeetCode12 {

	public static void main(String[] args) {
		LeetCode12 lc = new LeetCode12();
		System.out.println(lc.strStr("hello", "ll"));
		
		System.out.println("hello".indexOf("ll"));

	}
	
	//解法1，用时：7ms  战胜：69.77%
	public int strStr(String haystack, String needle) {
		if("".equals(needle))
			return 0;
		
        char[] arr1 = haystack.toCharArray();
        char[] arr2 = needle.toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        
        for(int i = 0; i < (len1 - len2 + 1); i++) {
        		boolean tag = true;
        		for(int j = 0; j < len2; j++) {
        			if(arr1[i + j] != arr2[j]) {
        				tag = false;
        				break;
        			}
        		}
        		if(tag) {
        			return i;
        		}
        }
        return -1;
    }

}
