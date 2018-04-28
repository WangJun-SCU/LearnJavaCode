package com.wangjun.leetcode;

import java.util.Stack;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
 */
public class LeetCode30 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isValid("]"));
	}

	// 解法2 7ms 92.99%
	static class Solution2 {
		public boolean isValid(String s) {
			Stack<Character> stack = new Stack<>();
			for (char c : s.toCharArray()) {
				if (c == '(') {
					stack.push(')');
				} else if (c == '[') {
					stack.push(']');
				} else if (c == '{') {
					stack.push('}');
				} else if (stack.isEmpty() || c != stack.pop()) {
					return false;
				}
			}
			return stack.isEmpty();
		}
	}

	// 解法1 7ms 92.99%
	static class Solution {
		public boolean isValid(String s) {
			if (null == s)
				return false;
			if ("".equals(s))
				return true;
			Stack<Character> stack = new Stack<>();
			int len = s.length();
			for (int i = 0; i < len; i++) {
				char c = s.charAt(i);
				if (c == '(' || c == '[' || c == '{') {
					stack.push(c);
				} else {
					if (stack.isEmpty()) {
						return false;
					}
					char cTop = stack.peek();
					if (c == ')' && cTop == '(') {
						stack.pop();
						continue;
					}
					if (c == ']' && cTop == '[') {
						stack.pop();
						continue;
					}
					if (c == '}' && cTop == '{') {
						stack.pop();
						continue;
					}
					return false;
				}
			}
			if (stack.isEmpty()) {
				return true;
			}
			return false;
		}
	}

}
