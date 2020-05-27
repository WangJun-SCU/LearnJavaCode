package com.wangjun.leetcode;

/*
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class LeetCode71 {
	public static void main(String[] args) {

	}

	public static boolean isSymmetric(TreeNode root) {
		if(root == null) {
			return true;
		}
		if(root.left != null && root.right != null) {
			return helper(root.left, root.right);
		}else if (root.left == null && root.right == null) {
			return true;
		}
		return false;
	}
	
	public static boolean helper(TreeNode left, TreeNode right) {
		if(left.val != right.val) return false;
		boolean leftEqual = true;
		boolean rightEqual = true;
		if(left.left != null && right.right != null) {
			leftEqual = helper(left.left, right.right);
		}else if(left.left == null && right.right == null) {
			leftEqual = true;
		}else {
			return false;
		}
		
		if(left.right != null && right.left != null) {
			rightEqual = helper(left.right, right.left);
		}else if(left.right == null && right.left == null) {
			rightEqual = true;
		}else {
			return false;
		}
		
		return leftEqual && rightEqual;
	}
	
	/*
	 * 精简瘦身过的
	 */
	public static boolean isSymmetric2(TreeNode root) {
	      if(root == null) return true;
	      return helper2(root.left, root.right);
	 }
	
	private static boolean helper2(TreeNode t1,TreeNode t2) {
		 if(t1 == null && t2 == null) return true;
		 if(t1 == null || t2 == null) return false;
		 if(t1.val != t2.val) return false;
		 return helper2(t1.left, t2.right) && helper2(t1.right, t2.left);
	 }
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
}
