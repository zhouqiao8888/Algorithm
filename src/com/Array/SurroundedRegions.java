package com.Array;

import java.util.Scanner;

/*
 * һ��2D�������x,o,����һ����ά���󣬰����б�X��Χ��O�����X�������ĳ��O�ڱߣ��ǣ��ϣ������������O������O�����ܱ��X��
 ���磺       
X X X X
X O O X
X X O X
X O X X
�任���ǣ� X X X X  
		X X X X
		X X X X
		X O X X
 */
public class SurroundedRegions {
	/*
	 *˼·�����ҳ�������߽��ϵ�O������O(�����߽��ϵ�O,��DFS),��ǳ�*,Ȼ���ٰ�ʣ�µ�O���X,����ٰѱ�ǵ�*��ԭ��O
	 */
	public void solve(char[][] board) {
		if(board == null || board.length <= 0 || board[0].length <= 0)	return;
		int rows = board.length;
		int cols = board[0].length;
		for(int j = 0;j < cols;j ++) {	//�ж����������߽�
			dfs(board, 0, j, rows, cols);
			dfs(board, rows - 1, j, rows, cols);
		}
		
		for(int i = 0;i < rows;i ++) {	//�ж����������߽�
			dfs(board, i, 0, rows, cols);
			dfs(board, i, cols - 1, rows, cols);
		}
		
		for(int i = 0;i < rows;i ++) {	//��ʣ�������O���X
			for(int j = 0;j < cols;j ++) {
				if(board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
		
		for(int i = 0;i < rows;i ++) {	//��*�ָ���O
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
			if(row - 1 > 0) {	//��Ҫ����0�ˣ���Ϊ�߽��������Ѿ��ѹ���
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
		int n = s.nextInt();	//��
		int m = s.nextInt();	//��
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
