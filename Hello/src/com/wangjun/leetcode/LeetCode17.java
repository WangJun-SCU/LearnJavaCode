package com.wangjun.leetcode;

import java.util.LinkedList;

/*
 * 题目：树的最大深度
 * 
 */
public class LeetCode17 {
	//解法1 递归  用时：0ms
	public int maxDepth(TreeNode root) {
        if(null == root){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right? left + 1: right + 1;
    }
	//解法2 非递归 使用队列 每次存储一层 count++  用时：
	public int maxDepth2(TreeNode root) {
		if(null == root) {
			return 0;
		}
		LinkedList<TreeNode> list = new LinkedList<>();
		list.offer(root);
		int count = 0;
		while(!list.isEmpty()) {
			int size = list.size();
			while(size > 0) {
				TreeNode cur = list.poll();
				if(null != cur.left) {
					list.addLast(cur.left);
				}
				if(null != cur.right) {
					list.addLast(cur.right);
				}
				size--;
			}
			count++;
		}
		return count;
	}
}
