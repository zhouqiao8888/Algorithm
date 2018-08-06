package com.Tree;
/*给定一个n，存在多少种BST，满足节点值是1~n
 *例如给定3，共存在5种
 * 1        3     3       2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		if(n <= 0)
			return 0;
		return countBST(1, n);
    }
	
	public int countBST(int start, int end) {
		if(start > end) {
			return 1;
		}
		int count = 0;
		for(int i = start;i <= end;i ++) { //根节点范围
			int leftCount = countBST(start, i - 1); //左子树都比i小,因此得左子树根节点范围
			int rightCount = countBST(i + 1, end); //右子树都比i大,因此得右子树根节点范围
			count = count + leftCount * rightCount; //左右子树配对
		}
		return count;
	}
	
	public static void main(String[] args) {
		UniqueBinarySearchTrees ubt = new UniqueBinarySearchTrees();
		System.out.println(ubt.numTrees(4));
	}
}
