package com.Tree;

public class BalancedBinaryTree {
	boolean flag = true;
	public boolean isBalanced(TreeNode root) {
        getDepth(root);
        return flag;
    }
	
	public int getDepth(TreeNode root) {
		if(root == null)
			return 0;
		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);
		if(Math.abs(leftDepth - rightDepth) > 1) {
			flag = false;
		}
		return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
	}
}
