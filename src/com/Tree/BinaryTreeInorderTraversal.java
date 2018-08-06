package com.Tree;

import java.util.ArrayList;

//¶þ²æÊ÷ÖÐÐò±éÀú
public class BinaryTreeInorderTraversal {
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		if(root == null)
			return list;
		inorderTraversal(root.left);
		list.add(root.val);
		inorderTraversal(root.right);
		return list;
	}
	 
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
//		root1.left.left = new TreeNode(3);
//		root1.left.right = new TreeNode(4);
//		root1.left.left.left = new TreeNode(8);		
//		root1.right.left = new TreeNode(4);
//		root1.right.right = new TreeNode(3);
//		root1.right.right.right = new TreeNode(8);
		
		BinaryTreeInorderTraversal st = new BinaryTreeInorderTraversal();
		st.inorderTraversal(root1);
		System.out.println(list);
	}
}
