package com.Tree;
//��һ���������е�����ת����һ������������
public class ConvertSortedArrayToBinarySearchTree {
	 public TreeNode sortedArrayToBST(int[] num) {
		 if(num.length <= 0)
			 return null;
		 if(num.length == 1)
			 return new TreeNode(num[0]);
		 return sortedArrayToBST2(num, 0, num.length - 1);
	 }
	 
	 public TreeNode sortedArrayToBST2(int[] num, int start, int end) {	 
		 if(start > end) {
			 return null;
		 }
		 if(start == end) {
			 return new TreeNode(num[start]);
		 }
		 int middle = (start + end + 1) / 2; //�����ż�������Ļ�����Ҫ��ȡ����һ���м�����Ϊ���ڵ�
		 TreeNode root = new TreeNode(num[middle]);
		 root.left = sortedArrayToBST2(num, start, middle - 1);
		 root.right = sortedArrayToBST2(num, middle + 1, end);
		 return root;
	 }
}
