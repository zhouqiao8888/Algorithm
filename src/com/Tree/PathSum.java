package com.Tree;

/*
 *����һ�Ŷ�������һ���������ж϶��������Ƿ���ڽ��ֵ�ĺ�Ϊ����������·����
 */
public class PathSum {
	 public boolean hasPathSum(TreeNode root, int sum) {
		 if(root == null) {
			 return false;
		 }
		 sum -= root.val;
		 if(sum == 0 && root.left == null && root.right == null)
			 return true;
		 return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
	 }
	 
	 public static void main(String[] args) {
			TreeNode root1 = new TreeNode(1);
			root1.left = new TreeNode(2);
			root1.right = new TreeNode(3);
			root1.left.left = new TreeNode(4);
			root1.left.right = new TreeNode(5);
			root1.right.left = new TreeNode(6);
			root1.right.right = new TreeNode(4);
			 		
			System.out.println(new PathSum().hasPathSum(root1, 8));
		}
		    
}
