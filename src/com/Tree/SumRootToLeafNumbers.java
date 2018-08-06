package com.Tree;
/*������ÿ���ڵ��ֵֻ����0-9������һ���������������¹������
 * 12 + 13 = 25(����ÿ����һ��ڵ㣬�ͽ�ǰ��ĺͳ���10�ټ��ϱ���Ľڵ�ֵ)
 *  1
 * / \
  2   3
 */
public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {		
		return getSum(root, 0);
    }
	
	public int getSum(TreeNode root, int sum) {	
		if(root == null)
        	return 0;
        sum = sum * 10 + root.val;
        if(root.left == null && root.right == null) {
        	return sum;
        }
        return getSum(root.left, sum) + getSum(root.right, sum);
	}
	
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		//root1.left.left = new TreeNode(4);
		//root1.left.right = new TreeNode(5);
//		root1.right.left = new TreeNode(6);
//		root1.right.right = new TreeNode(7);
		SumRootToLeafNumbers st = new SumRootToLeafNumbers();
		System.out.println(st.sumNumbers(root1));
	}
}
