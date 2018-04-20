package com.wangjun.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
题目：二叉树的层次遍历
给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
 */
public class LeetCode19 {
	//解法1  用时：2ms  战胜：88.25%
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		
		if(null == root) {
			return result;
		}
		
		LinkedList<TreeNode> list = new LinkedList<>();
		list.offer(root);
		while(!list.isEmpty()) {
			int size = list.size();
			List<Integer> listTem = new ArrayList<>();
			while(size > 0) {
				TreeNode node = list.pop();
				listTem.add(node.val);
				if(node.left != null) {
					list.offer(node.left);
				}
				if(node.right != null) {
					list.offer(node.right);
				}
				size--;
			}
			result.add(listTem);
		}
		return result;
    }
}
