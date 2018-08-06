package com.Tree;
/*����������������Ԫ�ر�����ؽ������ָ��ö�����
 *���类������Ķ������������£����Կ���3��1�������ˣ�
 *��������������Ϊ��3214567������Ӧ����1234567��
 *����3>2,2>1,����3��1������
 *  4
   / \
  2   6
 / \ / \
3  1 5  7
 *   
 */
public class RecoverBinarySearchTree {
	TreeNode preRoot = new TreeNode(Integer.MIN_VALUE); //Ҫ��ʼ���������޷��Ƚ�
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
		if(firstMistake == null && preRoot.val >= root.val) { //��һ������
			firstMistake = preRoot;
		}
		if(firstMistake != null && preRoot.val >= root.val) { //�ڶ�������
			secondMistake = root;
		}
		preRoot = root;  //��֤preRootһֱ��root��ǰ��
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
