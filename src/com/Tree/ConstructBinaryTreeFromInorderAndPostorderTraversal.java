package com.Tree;
//给出二叉树的中序遍历和后序遍历数组，还原二叉树
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	//递归法解:关键点是后续遍历数组的长度与对应的中序遍历数组长度是一样的
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder.length == 0 || postorder.length == 0)
			return null;
		return getRootNode(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1);
	}
	
	public TreeNode getRootNode(int[] postorder, int[] inorder, int ps, int pe, int is, int ie) {
		if(ps > pe || is > ie) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[pe]);
		int i = is;
		for(;i <= ie;i ++) {
			if(inorder[i] == postorder[pe]) {
				break;
			}
		}
		root.left = getRootNode(postorder, inorder, ps, ps - is + i - 1, is, i - 1);
		root.right = getRootNode(postorder, inorder, pe - ie + i, pe - 1, i + 1, ie);
		return root;
	}
}
