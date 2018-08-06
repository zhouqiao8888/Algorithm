package com.Tree;
//给出二叉树的前序遍历和中序遍历数组，还原二叉树
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	//递归法解:关键点是前序遍历数组的长度与对应的中序遍历数组长度是一样的
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length == 0 || inorder.length == 0)
			return null;
		return getRootNode(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
	}
	
	public TreeNode getRootNode(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
		if(ps > pe || is > ie) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[ps]);
		int i = is;
		for(;i <= ie;i ++) {
			if(inorder[i] == preorder[ps]) {
				break;
			}
		}
		root.left = getRootNode(preorder, inorder, ps + 1, ps - is + i, is, i - 1);
		root.right = getRootNode(preorder, inorder, pe - ie + i + 1, pe, i + 1, ie);
		return root;
	}
}
