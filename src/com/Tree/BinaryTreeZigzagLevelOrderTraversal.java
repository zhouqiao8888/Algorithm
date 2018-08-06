package com.Tree;

import java.util.*;

//二叉树Z字型遍历
public class BinaryTreeZigzagLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
		if(root == null)
			return resList;
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack1 = new Stack<TreeNode>(); //存放奇数层节点
		Stack<TreeNode> stack2 = new Stack<TreeNode>(); //存放偶数层节点
		stack1.push(root);
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				TreeNode temp = stack1.pop();
				list.add(temp.val);
				if(temp.left != null) {
					stack2.push(temp.left);
				}
				if(temp.right != null) {
					stack2.push(temp.right);
				}
			}
			if(!list.isEmpty()) {
				resList.add(new ArrayList<Integer>(list));
				list.clear();
			}
			while(!stack2.isEmpty()) {
				TreeNode temp = stack2.pop();
				list.add(temp.val);
				if(temp.right != null) {
					stack1.push(temp.right);
				}
				if(temp.left != null) {
					stack1.push(temp.left);
				}
			}
			if(!list.isEmpty()) {
				resList.add(new ArrayList<Integer>(list));
				list.clear();
			}
		}
		return resList;
    }
	
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);
		root1.left.left.left = new TreeNode(8);
		
		root1.right.left = new TreeNode(6);
		root1.right.right = new TreeNode(7);
		root1.right.right.right = new TreeNode(9);
		BinaryTreeZigzagLevelOrderTraversal bt = new BinaryTreeZigzagLevelOrderTraversal();
		System.out.println(bt.zigzagLevelOrder(root1));
	}
}
