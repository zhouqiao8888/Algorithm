package com.Tree;
/*二叉树层序遍历，倒序输出，例如：输入
 *  3
   / \
  9  20
    /  \
   15   7
输出
[
  [15,7]
  [9,20],
  [3],
]

 */
import java.util.*;
public class BinaryTreeLevelOrderTraversalII {
	ArrayList<ArrayList<Integer>> resList = new ArrayList<ArrayList<Integer>>();
	ArrayList<ArrayList<Integer>> resList2 = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> list = new ArrayList<Integer>();
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		if(root == null) 
			return resList;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int count = queue.size();	//记录队列中每一层元素的个数
		queue.offer(root);		
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
		
		for(int i = resList.size() - 1;i >= 0;i --) {
			resList2.add(resList.get(i));
		}
		return resList2;
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
		BinaryTreeLevelOrderTraversalII bt = new BinaryTreeLevelOrderTraversalII();
		System.out.println(bt.levelOrderBottom(root1));
	}
}
