package com.Tree;
/*�ж�һ�����Ƿ��ǶԳƵ�
 *  1
   / \
  2   2
 / \ / \
3  4 4  3
�ؼ��ǱȽϣ�1�ڵ��2�ڵ�ֵ�Ƿ���ͬ��֮���ٱȽ�1�ڵ����ڵ��2�ڵ���ҽڵ㣬1�ڵ���ҽڵ��2�ڵ����ڵ��Ƿ���ͬ
 */
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if(root == null)  //����Ĭ���ǶԳƵ�
			return true;
		return isSymmetric2(root.left, root.right);
	}
	
	public boolean isSymmetric2(TreeNode root1, TreeNode root2) {
		if(root1 == null && root2 == null) //�ݹ鵽Ҷ�ӽڵ�
			return true;
		if((root1 == null && root2 != null) || (root1 != null && root2 == null) 
			||root1.val != root2.val)     //һ��Ϊ�գ���һ����Ϊ�գ�ֱ��false
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
