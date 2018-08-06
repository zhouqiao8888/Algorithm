package com.Tree;

import java.util.*;

//¶þ²æÊ÷²ãÐò±éÀú
public class BinaryTreeLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
		if(root == null)
			return resList;
		ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int count = 0;
		while(!queue.isEmpty()) {
			if(count == 0) {
				count = queue.size();
			}
			TreeNode temp = queue.poll();
			if(temp != null) {
				list.add(temp.val);
				count --;
			}
			if(count == 0) {
				resList.add(new ArrayList<Integer>(list));
				list.clear();
			}
			if(temp.left != null) {
				queue.offer(temp.left);
			}
			if(temp.right != null) {
				queue.offer(temp.right);
			}
		}
		return resList;
	}
}
