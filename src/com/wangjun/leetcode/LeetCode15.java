package com.wangjun.leetcode;

/*
反转一个单链表。
进阶:
链表可以迭代或递归地反转。你能否两个都实现一遍？
 */
public class LeetCode15 {

	public static void main(String[] args) {
		LeetCode15 lc = new LeetCode15();
		ListNode node1 = lc.new ListNode(1);
		ListNode node2 = lc.new ListNode(2);
		ListNode node3 = lc.new ListNode(3);
		node1.next = node2;
		node2.next = node3;
		ListNode result = lc.reverseList(node1);
		result.printListNode();
	}
	
	// 解法2 递归
	public ListNode reverseList2(ListNode head) {
	    /* recursive solution */
	    return reverseListInt(head, null);
	}

	private ListNode reverseListInt(ListNode head, ListNode newHead) {
	    if (head == null)
	        return newHead;
	    ListNode next = head.next;
	    head.next = newHead;
	    return reverseListInt(next, head);
	}
	
	//解法1  用时：0ms  战胜：100%
	public ListNode reverseList(ListNode head) {
		
		ListNode result = null;
		while(null != head) {
			ListNode node = head.next;
			head.next = result;
			result = head;
			head = node;
		}
		
		return result;
    }

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
		
		public void printListNode() {
			ListNode node = this;
			while(null != node) {
				System.out.print(node.val + "-->");
				node = node.next;
			}
		}
	}
}
