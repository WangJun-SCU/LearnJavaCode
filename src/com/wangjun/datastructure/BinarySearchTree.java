package com.wangjun.datastructure;

public class BinarySearchTree {
		int val;
		BinarySearchTree left;
		BinarySearchTree right;
		public BinarySearchTree(int val) {
			this.val = val;
		}
		
		//二叉搜索树的查找
		public BinarySearchTree get(BinarySearchTree root, int val) {
			if(null == root) return null;
			if(val > root.val) return get(root.right, val);
			if(val < root.val) return get(root.left, val);
			return root;
		}
		
		//二叉树的插入,返回根节点
		public BinarySearchTree put(BinarySearchTree root, int val) {
			if(null == root) return new BinarySearchTree(val);
			if(val > root.val) root.right = put(root.right, val);
			if(val < root.val) root.left = put(root.left, val);
			if(val == root.val) root.val = val;
			return root;
		}
}
