package com.Tree;
/*判断一颗树是否是对称的
 *  1
   / \
  2   2
 / \ / \
3  4 4  3
关键是比较：1节点和2节点值是否相同，之后再比较1节点的左节点和2节点的右节点，1节点的右节点和2节点的左节点是否相同
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if(root == null)  //空树默认是对称的
			return true;
		return isSymmetric2(root.left, root.right);
	}
	
	public boolean isSymmetric2(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null) //递归到叶子节点
			return true;
		if((root1 == null && root2 != null) || (root1 != null && root2 == null) 
			||root1.val != root2.val)     //一个为空，另一个不为空，直接false
			return false;
		return isSymmetric2(root1.left, root2.right) && isSymmetric2(root1.right, root2.left);
	}
	
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
//		root1.right = new TreeNode(2);
//		
//		root1.left.left = new TreeNode(3);
//		root1.left.right = new TreeNode(4);
//		root1.left.left.left = new TreeNode(8);
//		
//		root1.right.left = new TreeNode(4);
//		root1.right.right = new TreeNode(3);
//		root1.right.right.right = new TreeNode(8);
		SymmetricTree st = new SymmetricTree();
		System.out.println(st.isSymmetric(root1));
	}
}
