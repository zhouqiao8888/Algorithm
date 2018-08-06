package com.Array;

import java.util.Scanner;

/*
 * 一个2D区域包含x,o,输入一个二维矩阵，把所有被X包围的O都变成X，但如果某个O在边（角）上，则所有与这个O相连的O都不能变成X。
 例如：       
X X X X
X O O X
X X O X
X O X X
变换后是： X X X X  
		X X X X
		X X X X
		X O X X
 */
public class SurroundedRegions {
	/*
	 *思路：先找出所有与边界上的O相连的O(包括边界上的O,用DFS),标记成*,然后再把剩下的O变成X,最后再把标记的*还原成O
	 */
	public void solve(char[][] board) {
		if(board == null || board.length <= 0 || board[0].length <= 0)	return;
		int rows = board.length;
		int cols = board[0].length;
		for(int j = 0;j < cols;j ++) {	//判断上下两条边界
			dfs(board, 0, j, rows, cols);
			dfs(board, rows - 1, j, rows, cols);
		}
		
		for(int i = 0;i < rows;i ++) {	//判断左右两条边界
			dfs(board, i, 0, rows, cols);
			dfs(board, i, cols - 1, rows, cols);
		}
		
		for(int i = 0;i < rows;i ++) {	//将剩余的所有O变成X
			for(int j = 0;j < cols;j ++) {
				if(board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
		
		for(int i = 0;i < rows;i ++) {	//将*恢复成O
			for(int j = 0;j < cols;j ++) {
				if(board[i][j] == '*') {
					board[i][j] = 'O';
				}
			}
		}
		
	}
	
	public void dfs(char[][] board, int row, int col, int rows, int cols) {
		if(board[row][col] == 'O') {
			board[row][col] = '*';
			if(row - 1 > 0) {	//不要等于0了，因为边界主程序已经搜过了
				dfs(board, row - 1, col, rows, cols);
			}
			if(row + 1 < rows - 1) {
				dfs(board, row + 1, col, rows, cols);
			}
			if(col - 1 > 0) {
				dfs(board, row, col - 1, rows, cols);
			}
			if(col + 1 < cols - 1) {
				dfs(board, row, col + 1, rows, cols);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();	//行
		int m = s.nextInt();	//列
		if(n <= 0 || m <= 0)
			return;
		char[][] board = new char[n][m];
		for(int i = 0;i < n;i ++) {
			for(int j = 0;j < m;j ++) {
				board[i][j] = (s.next().toCharArray())[0];
			}
		}
		
		SurroundedRegions sr = new SurroundedRegions();
		sr.solve(board);
		for(int i = 0;i < n;i ++) {
			for(int j = 0;j < m;j ++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
