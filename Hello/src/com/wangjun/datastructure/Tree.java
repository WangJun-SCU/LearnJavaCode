package com.wangjun.datastructure;

public class Tree {

	public static void main(String[] args) {
		Tree tree = new Tree();
		TreeNode root = new TreeNode("root");
		TreeNode node1 = new TreeNode("ndoe1");
		TreeNode node2 = new TreeNode("ndoe2");
		TreeNode node3 = new TreeNode("ndoe3");
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		System.out.println("树的深度是：" + tree.deepth(root));
		System.out.println("先序遍历：");
		tree.showDLR(root);
	}
	
	//计算树的深度
	//递归方法
	public int deepth(TreeNode treeNode) {
		if(treeNode == null)
			return 0;
		int left = deepth(treeNode.left);
		int right = deepth(treeNode.right);
		return left > right? left + 1: right + 1;
	}
	//显示节点数据
	public void showData(TreeNode treeNode) {
		if(treeNode != null)
			System.out.println(treeNode.value);
	}
	//遍历1 先序遍历
	public void showDLR(TreeNode treeNode) {
		if(null != treeNode) {
			showData(treeNode);
			showDLR(treeNode.left);
			showDLR(treeNode.right);
		}
	}
}

class TreeNode {
	String value;
	TreeNode left;
	TreeNode right;
	public TreeNode(String value) {
		this.value = value;
	}
}
