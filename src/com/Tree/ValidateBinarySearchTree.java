package com.Tree;
//判断一棵树是否是二叉搜索树(bst)
//思路：定义一个根节点的前导节点，中序遍历时一直比较它和根节点的值就能判断出来
public class ValidateBinarySearchTree {
	TreeNode preRoot = new TreeNode(Integer.MIN_VALUE); //要初始化，否则无法比较
	boolean flag = true;
	public boolean isValidBST(TreeNode root) {
		middleOrder(root);
		return flag;
    }
	
	public void middleOrder(TreeNode root) {
		if(root == null)
			return;
		middleOrder(root.left);
		//System.out.println("preRoot:" + preRoot.val + " root:" + root.val);
		if(preRoot.val >= root.val) { //不满足bst
			flag = false;
			return;
		}
		preRoot = root;  //保证preRoot一直在root的前面
		middleOrder(root.right);
	}
	
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(4);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(6);
		
		root1.left.left = new TreeNode(1);
		root1.left.right = new TreeNode(3);
		//root1.left.left.left = new TreeNode(8);
		
		root1.right.left = new TreeNode(5);
		root1.right.right = new TreeNode(7);
		//root1.right.right.right = new TreeNode(8);
		ValidateBinarySearchTree vt = new ValidateBinarySearchTree();
		System.out.println(vt.isValidBST(root1));
	}
	
}
