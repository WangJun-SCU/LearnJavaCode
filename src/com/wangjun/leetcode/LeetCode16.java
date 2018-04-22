package com.wangjun.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 题目：环形链表
 * 给定一个链表，判断链表中是否有环。
进阶：
你能否不使用额外空间解决此题？
 */
public class LeetCode16 {

	public static void main(String[] args) {

	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// 解法1  用时36ms，战胜：0%
	public boolean hasCycle(ListNode head) {
		List<ListNode> list = new ArrayList<>();
		while(null != head) {
			if(list.contains(head)) {
				return true;
			}else {
				list.add(head);
				head = head.next;
			}
		}
		
		return false;
	}
	
	//解法2  额外的空间为O(1)  用时：1ms  战胜：95.01%
	//如果有环，跑的快的总会和走的慢的汇合。
	public boolean hasCycle2(ListNode head) {
		if(null == head) {
			return false;
		}
		
		ListNode walker = head;
		ListNode runner = head;
		
		while(null != runner.next && null != runner.next.next) {
			walker = walker.next;
			runner  = runner.next.next;
			if(walker == runner) {
				return true;
			}
		}
		
		return false;
	}
	
	//解法3  额外的空间为O(1)  用时：1ms  战胜：95.01%
	// 依次遍历，使所有的节点指向head，如果遍历过程中发现节点指向了head说明遍历过了，也就是有环
	public boolean hasCycle3(ListNode head) {
		if(null == head) {
			return false;
		}
		
		ListNode current = head;
		ListNode pre = head;
		while(null != head && null != head.next) {
			if(current.next == head) {
				return true;
			}
			current = current.next;
			pre.next = head;
			pre = current;
		}
		
		return false;
	}

}
