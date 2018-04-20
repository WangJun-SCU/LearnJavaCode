package com.wangjun.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 */
public class LeetCode18 {
	
	private List<Integer> list = new ArrayList<>();
	
	//解法1 用时3ms  战胜：42.69%
	public boolean isValidBST(TreeNode root) {
		if(null == root) {
			return true;
		}
        scanTree(root);
        int len = list.size();
        for(int i = 0; i < len - 1; i++) {
        		if(list.get(i) >= list.get(i+1)) {
        			return false;
        		}
        }
        return true;
    }
	
	public void scanTree(TreeNode root) {
		if(root.left != null) {
			scanTree(root.left);
		}
		list.add(root.val);
		if(root.right != null) {
			scanTree(root.right);
		}
	}
	
}
