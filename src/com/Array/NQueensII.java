package com.Array;
public class NQueensII {
	int count = 0;
	public int totalNQueens(int n) {
		if(n <= 0)
			return 0;
		char[][] c = new char[n][n];
		for(int i = 0;i < n;i ++) { //开始都初始化为.
			for(int j = 0;j < n;j ++) {
				c[i][j] = '.';
			}
		}
		return dfs(c, 0, n);        
	}
	
	public int dfs(char[][] c, int row, int n) { //char[][]是一个辅助数组，记录Q和.
		if(row == n) {
			count ++;
			return count;
		}
		for(int j = 0;j < n;j ++) {
			if(isValid(c, row, j, n)) {
				c[row][j] = 'Q';
				dfs(c, row + 1, n);
				c[row][j] = '.';	//回退
			}
		}
		return count;
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
		System.out.println(new NQueensII().totalNQueens(4));
	}
}
