package com.Tree;

import java.util.ArrayList;

/*给定一个n，找出所有的BST，满足节点值是1~n
 *例如给定3，共存在5种
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
		for(int i = start;i <= end;i ++) { //根节点范围
			ArrayList<TreeNode> leftList = countBST(start, i - 1); //左子树都比i小,因此得左子树根节点范围
			ArrayList<TreeNode> rightList = countBST(i + 1, end); //右子树都比i大,因此得右子树根节点范围
			for(int j = 0;j < leftList.size();j ++) {
				for(int k = 0;k < rightList.size();k ++) { //左右子树配对
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
