package com.Array;
public class NQueensII {
	int count = 0;
	public int totalNQueens(int n) {
		if(n <= 0)
			return 0;
		char[][] c = new char[n][n];
		for(int i = 0;i < n;i ++) { //��ʼ����ʼ��Ϊ.
			for(int j = 0;j < n;j ++) {
				c[i][j] = '.';
			}
		}
		return dfs(c, 0, n);        
	}
	
	public int dfs(char[][] c, int row, int n) { //char[][]��һ���������飬��¼Q��.
		if(row == n) {
			count ++;
			return count;
		}
		for(int j = 0;j < n;j ++) {
			if(isValid(c, row, j, n)) {
				c[row][j] = 'Q';
				dfs(c, row + 1, n);
				c[row][j] = '.';	//����
			}
		}
		return count;
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
		System.out.println(new NQueensII().totalNQueens(4));
	}
}
