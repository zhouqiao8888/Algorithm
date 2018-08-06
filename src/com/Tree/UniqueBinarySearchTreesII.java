package com.Tree;

import java.util.ArrayList;

/*����һ��n���ҳ����е�BST������ڵ�ֵ��1~n
 *�������3��������5��
 * 1        3     3       2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class UniqueBinarySearchTreesII {
	public ArrayList<TreeNode> generateTrees(int n) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		if(n <= 0) {
            list.add(null);
			return list;
        }
		return countBST(1, n);
    }
	
	public ArrayList<TreeNode> countBST(int start, int end) {
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		if(start > end) {
			list.add(null);
			return list;
		}
		for(int i = start;i <= end;i ++) { //���ڵ㷶Χ
			ArrayList<TreeNode> leftList = countBST(start, i - 1); //����������iС,��˵����������ڵ㷶Χ
			ArrayList<TreeNode> rightList = countBST(i + 1, end); //����������i��,��˵����������ڵ㷶Χ
			for(int j = 0;j < leftList.size();j ++) {
				for(int k = 0;k < rightList.size();k ++) { //�����������
					TreeNode root = new TreeNode(i);
					root.left = leftList.get(j);
					root.right = rightList.get(k);
					list.add(root);
				}
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		UniqueBinarySearchTreesII ubt = new UniqueBinarySearchTreesII();
		System.out.println(ubt.generateTrees(3).size());
	}
}
