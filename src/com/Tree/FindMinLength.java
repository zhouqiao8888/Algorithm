package com.Tree;

//寻找二叉树路径的最小深度（根节点到叶子节点称为一条路径）
public class FindMinLength {
	public int run(TreeNode root) {
		if(root == null)	
			return 0;
		if(root.left == null && root.right == null)	//左右均空
			return 1;
		if(root.left == null && root.right != null)	//左空右不空
			return run(root.right) + 1;
		if(root.left != null && root.right == null)	//左不空右空
			return run(root.left) + 1;
		
		return run(root.left) > run(root.right) ? run(root.right) + 1 : run(root.left) + 1;
    }
	
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		//root1.left.left = new TreeNode(4);
		//root1.left.right = new TreeNode(5);
		root1.right.left = new TreeNode(6);
		root1.right.right = new TreeNode(7);
		FindMinLength fm = new FindMinLength();
		System.out.println(fm.run(root1));
	}
}
