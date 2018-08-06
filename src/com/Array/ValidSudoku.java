package com.Array;
import java.util.*;
/*
 * �ж�һ���ַ������Ƿ�Ϊ��Ч������(ÿһ�У�ÿһ�У�ÿһ���Ź���û���ظ�������)
 * û�����������.���
 */
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		if(board == null || board.length <= 0 || board[0].length <= 0)
			return false;
		for(int i = 0;i < board.length;i ++) {
			Set<Character> rowSet = new HashSet<Character>();
			Set<Character> colSet = new HashSet<Character>();
			Set<Character> blockSet = new HashSet<Character>();
			for(int j = 0;j < board[i].length;j ++) {
				//��i��
				if(board[i][j] != '.' && !rowSet.add(board[i][j])) {  //���벻�ˣ�˵���������ظ�
					return false;
				}
				//��i��
				if(board[j][i] != '.' && !colSet.add(board[j][i])) {  //���벻�ˣ�˵���������ظ�
					return false;
				}
				//�жϹ����ľŹ�������û���ظ�����
				int row = 3 * (i / 3) + j / 3; //������row���Ź���
				int col = 3 * (i % 3) + j % 3; //������row���Ź���ĵ�col��Ԫ��
				if(board[row][col] != '.' && !blockSet.add(board[row][col])) {  //���벻�ˣ�˵���þŹ��������ظ�Ԫ��
					return false;
				}
				//System.out.print(board[row][col] + " ");
			}
			//System.out.println();
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
		System.out.println(new ValidSudoku().isValidSudoku(board));
	}
}
