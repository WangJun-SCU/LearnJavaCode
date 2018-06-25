package com.wangjun.leetcode;
/*
题目：删除链表中的节点

请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。

现有一个链表 -- head = [4,5,1,9]，它可以表示为:

    4 -> 5 -> 1 -> 9
示例 1:

输入: head = [4,5,1,9], node = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
示例 2:

输入: head = [4,5,1,9], node = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
说明:

链表至少包含两个节点。
链表中所有节点的值都是唯一的。
给定的节点为非末尾节点并且一定是链表中的一个有效节点。
不要从你的函数中返回任何结果。
 */
public class LeetCode60 {
	
	static ListNode headTop;

	public static void main(String[] args) {
		
		
		ListNode root = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		
		headTop = root;
		
		root.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		LeetCode60 lc = new LeetCode60();
		lc.printList(headTop);
		Solution s = new Solution();
		s.deleteNode(node2);
		lc.printList(headTop);
	}
	
	// 打印链表
	public void printList(ListNode root) {
		while(root != null) {
			System.out.print(root.val + "->");
			root = root.next;
		}
		System.out.println();
	}
	
	static class Solution {
		
		// 1ms  100%
	    public void deleteNode(ListNode node) {
	    	// 原来是这个意思...
	    	node.val = node.next.val;
	    	node.next = node.next.next;
	    }
	}

}
