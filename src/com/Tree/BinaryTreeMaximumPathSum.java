package com.Tree;
/*给定一个二叉树，求路径值的最大和：路径可以从二叉树任意一个节点开始，任意一个节点结束
 *  1
 * / \
  2   3
  最大路径和是4
 */
public class BinaryTreeMaximumPathSum {
	int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
        getMax(root);
        return max;
    }
	
	public int getMax(TreeNode root) {
		if(root == null)
			return 0;
		int sum = root.val;
		int left = getMax(root.left);
		int right = getMax(root.right);
		if(left > 0) {
			sum += left;
		}
		if(right > 0) {
			sum += right;
		}
		if(sum > max) {	//max是要统计所有最长路径的最大和，所以左右都要加
			//System.out.println(sum);
			max = sum;
		}
		return Math.max(left, right) > 0 ? root.val + Math.max(left, right) : root.val;	//每一层路径的最大和
	}
	
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		//root1.left.right = new TreeNode(5);
//		root1.right.left = new TreeNode(6);
//		root1.right.right = new TreeNode(7);
		BinaryTreeMaximumPathSum bm = new BinaryTreeMaximumPathSum();
		System.out.println(bm.getMax(root1));
	}
}
