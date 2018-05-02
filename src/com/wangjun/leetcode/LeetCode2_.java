package com.wangjun.leetcode;

import java.math.BigDecimal;

/*
给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。
将两数相加返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 * 
 */
public class LeetCode2_ {

	public static void main(String[] args) {
		// 243 564
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		l3.next = null;

		ListNode l12 = new ListNode(5);
		ListNode l22 = new ListNode(6);
		ListNode l32 = new ListNode(4);
		l12.next = l22;
		l22.next = l32;
		l32.next = null;

		ListNode result = new Solution().addTwoNumbers(l1, l12);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// 解法1 54ms 35.95%
	static class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			StringBuffer sb1 = new StringBuffer(l1.val + "");
			ListNode ln1 = l1;
			while (null != ln1.next) {
				ln1 = ln1.next;
				sb1.append(ln1.val);
			}
			change(sb1);

			StringBuffer sb2 = new StringBuffer(l2.val + "");
			ListNode ln2 = l2;
			while (null != ln2.next) {
				ln2 = ln2.next;
				sb2.append(ln2.val);
			}
			change(sb2);

			BigDecimal i1 = new BigDecimal(sb1.toString());
			BigDecimal i2 = new BigDecimal(sb2.toString());
			BigDecimal i3 = i1.add(i2);

			String str = i3 + "";
			ListNode head = null;
			for (int i = 0; i < str.length(); i++) {
				ListNode tem = new ListNode(Integer.parseInt("" + str.charAt(i)));
				tem.next = head;
				head = tem;
			}

			return head;
		}

		// 首位互换
		public void change(StringBuffer sb) {
			for (int i = 0; i < sb.length() / 2; i++) {
				char tem = sb.charAt(i);
				sb.replace(i, i + 1, sb.charAt(sb.length() - i - 1) + "");
				sb.replace(sb.length() - i - 1, sb.length() - i, tem + "");
			}
		}
	}

	//TODO 没看懂
	class Solution2 {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			ListNode prev = new ListNode(0);
			ListNode head = prev;
			int carry = 0;
			while (l1 != null || l2 != null || carry != 0) {
				ListNode cur = new ListNode(0);
				int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
				cur.val = sum % 10;
				carry = sum / 10;
				prev.next = cur;
				prev = cur;

				l1 = (l1 == null) ? l1 : l1.next;
				l2 = (l2 == null) ? l2 : l2.next;
			}
			return head.next;
		}
	}
}
