package com.wangjun.leetcode;
/*
题目：回文链表
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class LeetCode62 {

	public static void main(String[] args) {
		
	}
	
	class Solution {
		
		// 解法1 3ms  55.88%
	    public boolean isPalindrome(ListNode head) {
	    	if(null == head) return true;
	        // 先反转链表放置到另一个链表上
	    	ListNode last = null;
	    	ListNode fanHead = new ListNode(head.val);
	    	ListNode next = head.next;
	    	while(next != null) {
	    		fanHead.next = last;
	    		last = fanHead;
	    		fanHead = new ListNode(next.val);
	    		next = next.next;
	    	}
	    	fanHead.next = last;
	    	
	    	// 将反转后的链表和原链表进行比较
	    	while(head != null) {
	    		if(head.val != fanHead.val) {
	    			return false;
	    		}
	    		head = head.next;
	    		fanHead = fanHead.next;
	    	}
	    	return true;
	    }
	}

}
