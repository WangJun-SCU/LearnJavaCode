package com.wangjun.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个二叉树，检查它是否是它自己的镜像（即，围绕它的中心对称）。
例如，这个二叉树 [1,2,2,3,4,4,3] 是对称的。
 */
public class LeetCode13 {

	public static void main(String[] args) {

	}

	//解法1，利用DLR和DRL遍历是否相同  用时：18ms  战胜：26.36%
	public boolean isSymmetric(TreeNode root) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		scanDLR(list1, root);
		scanDRL(list2, root);
		for(int i = 0; i < list1.size(); i++) {
			if(list1.get(i) == null && list2.get(i) == null) {
				continue; 
			}
			if(list1.get(i) == null || list2.get(i) == null) {
				return false;
			}
			if(!list1.get(i).equals(list2.get(i))) {
				return false;
			}
		}
		return true;
	}

	public void scanDLR(List<Integer> list, TreeNode treeNode) {
		if(null == treeNode) {
			list.add(null);
			return;
		}
		list.add(treeNode.val);
		scanDLR(list, treeNode.left);
		scanDLR(list, treeNode.right);
	}
	
	public void scanDRL(List<Integer> list, TreeNode treeNode) {
		if(null == treeNode) {
			list.add(null);
			return;
		}
		list.add(treeNode.val);
		scanDRL(list, treeNode.right);
		scanDRL(list, treeNode.left);
	}
	
	//解法2，使用递归  用时：13ms  战胜：67.73%
	public boolean isSymmetric2(TreeNode root) {
	    return root==null || isSymmetricHelp(root.left, root.right);
	}

	private boolean isSymmetricHelp(TreeNode left, TreeNode right){
	    if(left==null || right==null)
	        return left==right;
	    if(left.val!=right.val)
	        return false;
	    return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
	}
	
	//树结构
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}