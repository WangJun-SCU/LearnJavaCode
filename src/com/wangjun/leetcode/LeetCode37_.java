package com.wangjun.leetcode;

import java.util.LinkedList;

/*
每个节点的右向指针
给定一个二叉树

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。

说明:

你只能使用额外常数空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
你可以假设它是一个完美二叉树（即所有叶子节点都在同一层，每个父节点都有两个子节点）。
示例:

给定完美二叉树，

     1
   /  \
  2    3
 / \  / \
4  5  6  7
调用你的函数后，该完美二叉树变为：

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL
 */
public class LeetCode37_ {

	public static void main(String[] args) {
		Solution s = new Solution();
		TreeLinkNode root0 = new TreeLinkNode(0);
		TreeLinkNode root1 = new TreeLinkNode(1);
		TreeLinkNode root2 = new TreeLinkNode(2);
		TreeLinkNode root3 = new TreeLinkNode(3);
		TreeLinkNode root4 = new TreeLinkNode(4);
		TreeLinkNode root5 = new TreeLinkNode(5);
		TreeLinkNode root6 = new TreeLinkNode(6);
		root0.left = root1;
		root0.right = root2;
		root1.left = root3;
		root1.right = root4;
		root2.left = root5;
		root2.right = root6;

		s.connect(root0);

		LinkedList<TreeLinkNode> list = new LinkedList<>();
		list.offer(root0);
		while (!list.isEmpty()) {
			int len = list.size();
			for (int i = 0; i < len; i++) {
				TreeLinkNode node = list.poll();
				System.out.println("val:" + node.val);
				System.out.println("next:" + (node.next == null ? null : node.next.val));
				node.next = list.peek();
				if (node.left != null) {
					list.offer(node.left);
				}
				if (node.right != null) {
					list.offer(node.right);
				}
			}
			System.out.println("###");
		}
	}

	static class Solution {
		// 解法2  只能适用于完全二叉树  2ms  55.26%
		public void connect2(TreeLinkNode root) {
			TreeLinkNode level_start = root;
			while (level_start != null) {
				TreeLinkNode cur = level_start;
				while (cur != null) {
					if (cur.left != null) {
						cur.left.next = cur.right;
					}
					if (cur.right != null && cur.next != null) {
						cur.right.next = cur.next.left;
					}
					cur = cur.next;
				}
				level_start = level_start.left;
			}
		}

		// 解法1 根据按层遍历 3ms 46.49%
		public void connect(TreeLinkNode root) {
			if (root == null) {
				return;
			}
			LinkedList<TreeLinkNode> list = new LinkedList<>();
			list.offer(root);
			while (!list.isEmpty()) {
				int len = list.size();
				for (int i = 0; i < len; i++) {
					TreeLinkNode node = list.poll();
					node.next = i == (len - 1) ? null : list.peek();
					if (node.left != null) {
						list.offer(node.left);
					}
					if (node.right != null) {
						list.offer(node.right);
					}
				}
			}
		}
	}

	static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

}
