package com.Tree;
/*�ж��������Ƿ���ͬ���ṹ��ͬ���ҽڵ�ֵ��ͬ
 *  1      1
   / \    / \
  2   3  2   3
 */
public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null) //���ÿ���Ĭ������ͬ��
			return true;
		if((p == null && q != null) || (p != null && q == null) || p.val != q.val) {  //һ��Ϊ�գ���һ����Ϊ�գ�ֱ��false
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
	
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		//root2.right = new TreeNode(32);

//		root1.left.left = new TreeNode(3);
//		root1.left.right = new TreeNode(4);
//		root1.left.left.left = new TreeNode(8);
//		
//		root1.right.left = new TreeNode(4);
//		root1.right.right = new TreeNode(3);
//		root1.right.right.right = new TreeNode(8);
		SameTree st = new SameTree();
		System.out.println(st.isSameTree(root1, root2));
	}
}
