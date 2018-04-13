package com.wangjun.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
给定两个二叉树，写一个函数来检查它们是否相同。
如果两棵树在结构上相同并且节点具有相同的值，则认为它们是相同的。
 */
public class LeetCode11 {

	List<Integer> list1 = new ArrayList<Integer>();
	List<Integer> list2 = new ArrayList<Integer>();

	public static void main(String[] args) {
		LeetCode11 lc = new LeetCode11();

		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;

		TreeNode t12 = new TreeNode(1);
		TreeNode t22 = new TreeNode(2);
		TreeNode t32 = new TreeNode(3);
		t12.left = t22;
		t12.right = t32;

		System.out.println(lc.isSameTree2(t1, t12));
	}

	//解法1  用时：7ms  战胜：18.69%
	public boolean isSameTree(TreeNode p, TreeNode q) {
		scanDLR(p, list1);
		scanDLR(q, list2);
		if (list1.size() != list2.size()) {
			System.out.println(list1.size() + "-" + list2.size());
			return false;
		}
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i) != null) {
				if (!list1.get(i).equals(list2.get(i))) {
					System.out.println(list1.get(i) + ":" + list2.get(i));
					return false;
				}
			}else if(list1.get(i) != list2.get(i)){
				return false;
			}
		}
		return true;

	}

	public void scanDLR(TreeNode treeNode, List<Integer> list) {
		if (null == treeNode) {
			list.add(null);
			System.out.println("null");
			return;
		}
		list.add(treeNode.val);
		System.out.println(treeNode.val);
		scanDLR(treeNode.left, list);
		scanDLR(treeNode.right, list);
	}
	
	//解法2 用时：5ms  战胜：64.95%
	public boolean isSameTree2(TreeNode p, TreeNode q) {
		if(null == p && null == q)
			return true;
		if(null == p || null == q)
			return false;
		if(p.val == q.val)
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		return false;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
