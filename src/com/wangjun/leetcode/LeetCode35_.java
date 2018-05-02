package com.wangjun.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
编写一个程序，找到两个单链表相交的起始节点。

例如，下面的两个链表：

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
在节点 c1 开始相交。

 

注意：

如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class LeetCode35_ {

	public static void main(String[] args) {

	}

	class Solution {
		
		// 解法2  lenA + lenB = lenB + lenA
		// 2ms  85.28%
		public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
			//边界检查
			if(null == headA || null == headB)
				return null;
			ListNode a = headA;
			ListNode b = headB;
			//如果ab长度一样，一次循环迭代就可以找出
			//如果ab长度不一样，另两个引用指向另一方，根据lenA + lenB = lenB + lenA
			//那么第二次循环的时候，两个链表剩余的长度就是一样的了。
			while(a != b) {
				a = a == null? headB : a.next;
				b = b == null? headA : b.next;
			}
			return a;
		}

		// 解法1 循环查找吧  201ms  0%  最笨的方法
		public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
			List<ListNode> list = new ArrayList<>();
			while(headA != null) {
				list.add(headA);
				headA = headA.next;
			}
			while(headB != null) {
				if(list.contains(headB)) {
					return headB;
				}
				headB = headB.next;
			}
			return null;
		}
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
