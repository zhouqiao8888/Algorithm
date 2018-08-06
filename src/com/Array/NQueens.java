package com.Array;

import java.util.ArrayList;

/*
 * 皇后问题：设计一个n*n的矩阵，保证所有的皇后(皇后用Q表示，其他用.表示)不能同行，不能同列，
 * 不能在一条对角线上(正对角线和反对角线)，例如n=4
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
		for(int i = 0;i < n;i ++) { //开始都初始化为.
			for(int j = 0;j < n;j ++) {
				c[i][j] = '.';
			}
		}
		return dfs(res, c, 0, n);
	}
	
	public ArrayList<String[]> dfs(ArrayList<String[]> res, char[][] c, int row, int n) { //char[][]是一个辅助数组，记录Q和.
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
				c[row][j] = '.';	//回退
			}
		}
		return res;
	}
	
	public boolean isValid(char[][] c, int row, int col, int n) {
		//排除行
		for(int i = 0;i < col;i ++) {
			if(c[row][i] == 'Q') {
				return false;
			}
		}
		//排除列
		for(int i = 0;i < row;i ++) {
			if(c[i][col] == 'Q') {
				return false;
			}
		}
		//排除对角线，往左斜上方找
		for(int i = row - 1, j = col - 1;i >= 0 && j >= 0;i --, j --) {
			if(c[i][j] == 'Q') {
				return false;
			}
		}
		//排除反对角线 ，往右斜上方找
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
