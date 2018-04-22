package com.wangjun.leetcode;

import java.util.Arrays;

/*
题目：将有序数组转换成平衡二叉搜索树
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
 */
public class LeetCode20 {
	//解法1 递归  用时：2ms  战胜：23.04%
	public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        
        if(len == 0) {
        		return null;
        }
        if(len == 1) {
        		return new TreeNode(nums[0]);
        }
        
        TreeNode result = new TreeNode(nums[len/2]);
        int[] leftNums = Arrays.copyOfRange(nums, 0, len/2);
        result.left = sortedArrayToBST(leftNums);
        
        if(len/2 < (len - 1)) {
        		int[] rightNums = Arrays.copyOfRange(nums, len/2 + 1, len);
        		result.right = sortedArrayToBST(rightNums);
        }
        
        return result;
    }
	//解法2 递归  用时：1ms  战胜：100%
	public TreeNode sortedArrayToBST2(int[] nums) {
		if(nums.length == 0)
			return null;
		
		TreeNode node = sortedHelper(nums, 0, nums.length - 1);
        
        return node;
    }
	public TreeNode sortedHelper(int[] nums, int start, int end) {
		if(start > end) {
			return null;
		}
		TreeNode node;
		int mid = start + (end - start)/2;
		node = new TreeNode(nums[mid]);
		node.left = sortedHelper(nums, start, mid - 1);
		node.right = sortedHelper(nums, mid + 1, end);
		return node;
	}
}
