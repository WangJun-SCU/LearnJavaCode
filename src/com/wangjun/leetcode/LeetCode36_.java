package com.wangjun.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class LeetCode36_ {

	public static void main(String[] args) {
		
	}
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	class Solution {
		
		List<Integer> list = new ArrayList<>();
		
		 //解法2，遍历，使用栈  1ms  69.35%
	    public List<Integer> inorderTraversal2(TreeNode root) {
	    	Stack<TreeNode> stack = new Stack<>();
	    	TreeNode node = root;
	    	while(node != null || !stack.isEmpty()) {
	    		while(node != null) {
	    			stack.push(node);
	    			node = node.left;
	    		}
	    		if(!stack.isEmpty()) {
	    			node = stack.pop();
	    			list.add(node.val);
	    			node = node.right;
	    		}
	    	}
	    	return list;
	    }
		
		//解法1， 迭代  0ms
	    public List<Integer> inorderTraversal(TreeNode root) {
	    	if(null == root) {
	    		return list;
	    	}
	    	if(root.left != null) {
	    		inorderTraversal(root.left);
	    	}
	    	list.add(root.val);
	    	if(root.right != null) {
	    		inorderTraversal(root.right);
	    	}
	    	
	    	return list;
	    }
	}

}
