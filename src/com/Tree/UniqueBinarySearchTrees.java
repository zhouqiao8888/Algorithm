package com.Tree;
/*����һ��n�����ڶ�����BST������ڵ�ֵ��1~n
 *�������3��������5��
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
		for(int i = start;i <= end;i ++) { //���ڵ㷶Χ
			int leftCount = countBST(start, i - 1); //����������iС,��˵����������ڵ㷶Χ
			int rightCount = countBST(i + 1, end); //����������i��,��˵����������ڵ㷶Χ
			count = count + leftCount * rightCount; //�����������
		}
		return count;
	}
	
	public static void main(String[] args) {
		UniqueBinarySearchTrees ubt = new UniqueBinarySearchTrees();
		System.out.println(ubt.numTrees(4));
	}
}
