package com.wangjun.leetcode;

/*
题目：合并两个有序链表
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */
public class LeetCode14 {

	public static void main(String[] args) {
		

	}
	
	//解法1  用时：13ms  战胜：68.11%
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = null;
        int n = 0;
        ListNode index = null;
        while(null != l1 || null != l2) {
        	ListNode node;
        	if(null == l1) {
        		node = l2;
        		l2 = l2.next;
        	}else if(null == l2) {
        		node = l1;
        		l1 = l1.next;
        	}else if(l1.val < l2.val) {
        		node = l1;
        		l1 = l1.next;
        	}else {
        		node = l2;
        		l2 = l2.next;
        	}
        	if(n == 0) {
        		newHead = node;
        		index = node;
        	}else {
        		index.next = node;
        		index = node;
        	}
        	n++;
        	
        }
        
        return newHead;
    }
	
	//解法2，使用递归    用时：11ms  战胜：86.63%
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if(null == l1) {
			return l2;
		}
		if(null == l2) {
			return l1;
		}
		ListNode node;
		if(l1.val > l2.val) {
			node = l2;
			node.next = mergeTwoLists2(l1, l2.next);
		}else {
			node = l1;
			node.next = mergeTwoLists2(l1.next, l2);
		}
		
		return node;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

}
