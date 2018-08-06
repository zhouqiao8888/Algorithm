package com.Array;

import java.util.ArrayList;

/*
 * �ʺ����⣺���һ��n*n�ľ��󣬱�֤���еĻʺ�(�ʺ���Q��ʾ��������.��ʾ)����ͬ�У�����ͬ�У�
 * ������һ���Խ�����(���Խ��ߺͷ��Խ���)������n=4
 *".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q.",
  
  "..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."
 */
public class NQueens {
	public ArrayList<String[]> solveNQueens(int n) {
		ArrayList<String[]> res = new ArrayList<String[]>();
		if(n <= 0)
			return res;
		char[][] c = new char[n][n];
		for(int i = 0;i < n;i ++) { //��ʼ����ʼ��Ϊ.
			for(int j = 0;j < n;j ++) {
				c[i][j] = '.';
			}
		}
		return dfs(res, c, 0, n);
	}
	
	public ArrayList<String[]> dfs(ArrayList<String[]> res, char[][] c, int row, int n) { //char[][]��һ���������飬��¼Q��.
		if(row == n) {
			String[] arr = new String[n];
			for(int i = 0;i < n;i ++) {
				StringBuilder sb = new StringBuilder();
				for(int j = 0;j < n;j ++) {
					sb.append(c[i][j]);
				}
				arr[i] = sb.toString();
			}
			res.add(arr);
			return res;
		}
		for(int j = 0;j < n;j ++) {
			if(isValid(c, row, j, n)) {
				c[row][j] = 'Q';
				dfs(res, c, row + 1, n);
				c[row][j] = '.';	//����
			}
		}
		return res;
	}
	
	public boolean isValid(char[][] c, int row, int col, int n) {
		//�ų���
		for(int i = 0;i < col;i ++) {
			if(c[row][i] == 'Q') {
				return false;
			}
		}
		//�ų���
		for(int i = 0;i < row;i ++) {
			if(c[i][col] == 'Q') {
				return false;
			}
		}
		//�ų��Խ��ߣ�����б�Ϸ���
		for(int i = row - 1, j = col - 1;i >= 0 && j >= 0;i --, j --) {
			if(c[i][j] == 'Q') {
				return false;
			}
		}
		//�ų����Խ��� ������б�Ϸ���
		for(int i = row - 1, j = col + 1;i >= 0 && j < n;i --, j ++) {
			if(c[i][j] == 'Q') {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		ArrayList<String[]> res = new NQueens().solveNQueens(4);
		for(String[] arr : res) {
			for(int i = 0;i < arr.length;i ++) {
				System.out.println(arr[i]);
			}
			System.out.println();
		}
	}
}
