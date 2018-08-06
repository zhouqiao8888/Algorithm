package com.Array;
//�������
public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		if(board == null || board.length <= 0 || board[0].length <= 0)
			return;
		dfs(board, 0);
    }
	
	public boolean dfs(char[][] board, int index) { //dfsͨ������boolean���͵�ֵ���ж��Ƿ������ɹ�
		if(index == 81) {
			return true;
		}
		int row = index / 9; //Ԫ��������
		int col = index % 9; //Ԫ��������
		if(board[row][col] != '.') {	//����Ԫ�أ�����
			if(dfs(board, ++ index))
				return true;
			return false;
		}
		else {	//û��Ԫ�أ���Ҫ��⣬��1-9�ڽ��б�������
			for(char c = '1';c <= '9';c ++) {
				if(!isValid(board, c, row, col)) {
					continue;
				}
				else {
					board[row][col] = c;  //�ҵ��˿��н⣬����
					if(dfs(board, ++ index)) {  
						return true;
					}
					index --;	//û�ҵ����ָ��ֳ�
					board[row][col] = '.';
				}
			}
		};
		return false;
	}
	
	public boolean isValid(char[][] board, char c, int row, int col) {
		//����ͬ��
		for(int i = 0;i < 9;i ++) {
			if(board[row][i] == c) {
				return false;
			}
		}
		//����ͬ��
		for(int i = 0;i < 9;i ++) {
			if(board[i][col] == c) {
				return false;
			}
		}
		//����ͬһ���Ź���
		int m = 3 * (row / 3) + col / 3; //��m���Ź���
		for(int i = 3 * (m / 3);i < 3 * (m / 3) + 3;i ++) {	  //��m���Ź����еķ�Χ
			for(int j = 3 * (m % 3);j < 3 * (m % 3) + 3;j ++) {	  //��m���Ź����еķ�Χ
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
