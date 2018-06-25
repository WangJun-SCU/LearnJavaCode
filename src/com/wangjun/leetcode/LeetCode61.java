package com.wangjun.leetcode;
/*
题目：删除链表倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？
 */
public class LeetCode61 {

	public static void main(String[] args) {

	}
	
	class Solution {
		// 解法2  discuss  借助头结点  10ms  96.53%
		public ListNode removeNthFromEnd2(ListNode head, int n) {
			ListNode start = new ListNode(0);
			ListNode slow = start, fast = start; 
			slow.next = head;
			for(int i = 0; i <= n; i++) {
				fast = fast.next;
			}
			while(fast != null) {
				slow = slow.next;
				fast = fast.next;
			}
			slow.next = slow.next.next;
			return start.next;
		}
		// 解法1，比较笨  27ms  17.53%
	    public ListNode removeNthFromEnd(ListNode head, int n) {
	    	// 先获取一共几个节点
	    	int sum = 0;
	    	ListNode node = head;
	    	while(node != null) {
	    		node = node.next;
	    		sum++;
	    	}
	    	// 删除第 sum - n个节点
	    	int delIndex = 0;
	    	node = head;
            ListNode preNode = null;
	    	while(delIndex != (sum - n)) {
                preNode = node;
	    		node = node.next;
	    		delIndex++;
	    	}
	    	// 删除node
	    	if(node.next != null) {
	    		node.val = node.next.val;
		    	node.next = node.next.next;
	    	}else if(delIndex == 0){
                return null;
	    	}else{
                preNode.next = null;
            }
	    	return head;
	    }
	}
}
