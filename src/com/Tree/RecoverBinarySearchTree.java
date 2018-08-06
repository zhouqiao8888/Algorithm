package com.Tree;
/*二叉搜索树的两个元素被错误地交换，恢复该二叉树
 *例如被交换后的二叉搜索树如下：可以看到3和1被交换了，
 *交换后的中序遍历为：3214567（本来应该是1234567）
 *发现3>2,2>1,其中3和1有问题
 *  4
   / \
  2   6
 / \ / \
3  1 5  7
 *   
 */
public class RecoverBinarySearchTree {
	TreeNode preRoot = new TreeNode(Integer.MIN_VALUE); //要初始化，否则无法比较
	TreeNode firstMistake = null;
	TreeNode secondMistake = null;
	public void recoverTree(TreeNode root) {
		middleOrder(root);
		int temp = firstMistake.val;
		firstMistake.val = secondMistake.val;
		secondMistake.val = temp;
    }	
	
	public void middleOrder(TreeNode root) {
		if(root == null)
			return;
		middleOrder(root.left);
		//System.out.println("preRoot:" + preRoot.val + " root:" + root.val);
		if(firstMistake == null && preRoot.val >= root.val) { //第一个错误
			firstMistake = preRoot;
		}
		if(firstMistake != null && preRoot.val >= root.val) { //第二个错误
			secondMistake = root;
		}
		preRoot = root;  //保证preRoot一直在root的前面
		middleOrder(root.right);
	}
	
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(4);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(6);
		
		root1.left.left = new TreeNode(3);
		root1.left.right = new TreeNode(1);
		//root1.left.left.left = new TreeNode(8);
		
		root1.right.left = new TreeNode(5);
		root1.right.right = new TreeNode(7);
		//root1.right.right.right = new TreeNode(8);
		RecoverBinarySearchTree st = new RecoverBinarySearchTree();
		st.recoverTree(root1);
		System.out.println(st.firstMistake.val + " " + st.secondMistake.val);
	}
}
