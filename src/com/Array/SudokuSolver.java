package com.Array;
//求解数独
public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		if(board == null || board.length <= 0 || board[0].length <= 0)
			return;
		dfs(board, 0);
    }
	
	public boolean dfs(char[][] board, int index) { //dfs通过返回boolean类型的值来判断是否搜索成功
		if(index == 81) {
			return true;
		}
		int row = index / 9; //元素所在行
		int col = index % 9; //元素所在列
		if(board[row][col] != '.') {	//已有元素，回溯
			if(dfs(board, ++ index))
				return true;
			return false;
		}
		else {	//没有元素，需要求解，在1-9内进行暴力搜索
			for(char c = '1';c <= '9';c ++) {
				if(!isValid(board, c, row, col)) {
					continue;
				}
				else {
					board[row][col] = c;  //找到了可行解，回溯
					if(dfs(board, ++ index)) {  
						return true;
					}
					index --;	//没找到，恢复现场
					board[row][col] = '.';
				}
			}
		};
		return false;
	}
	
	public boolean isValid(char[][] board, char c, int row, int col) {
		//不能同行
		for(int i = 0;i < 9;i ++) {
			if(board[row][i] == c) {
				return false;
			}
		}
		//不能同列
		for(int i = 0;i < 9;i ++) {
			if(board[i][col] == c) {
				return false;
			}
		}
		//不能同一个九宫格
		int m = 3 * (row / 3) + col / 3; //第m个九宫格
		for(int i = 3 * (m / 3);i < 3 * (m / 3) + 3;i ++) {	  //第m个九宫格行的范围
			for(int j = 3 * (m % 3);j < 3 * (m % 3) + 3;j ++) {	  //第m个九宫格列的范围
				if(board[i][j] == c)
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},
		          {'6','.','.','1','9','5','.','.','.'},
		          {'.','9','8','.','.','.','.','.','.'},
		          {'8','.','.','.','6','.','.','.','3'},
		          {'4','.','.','8','.','3','.','.','1'},
		          {'7','.','.','.','2','.','.','.','6'},
		          {'.','6','.','.','.','.','2','8','.'},
		          {'.','.','.','4','1','9','.','.','5'},
		          {'.','.','.','.','8','.','.','7','9'}};
		new SudokuSolver().solveSudoku(board);
		for(int i = 0;i < 9;i ++) {
			for(int j = 0;j < 9;j ++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
