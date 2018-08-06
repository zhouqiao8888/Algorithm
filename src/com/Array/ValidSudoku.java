package com.Array;
import java.util.*;
/*
 * 判断一个字符数组是否为有效的数独(每一行，每一列，每一个九宫格没有重复的数字)
 * 没有填的数字用.替代
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
				//第i行
				if(board[i][j] != '.' && !rowSet.add(board[i][j])) {  //加入不了，说明该行有重复
					return false;
				}
				//第i列
				if(board[j][i] != '.' && !colSet.add(board[j][i])) {  //加入不了，说明该列有重复
					return false;
				}
				//判断归属的九宫格里有没有重复数字
				int row = 3 * (i / 3) + j / 3; //归属第row个九宫格
				int col = 3 * (i % 3) + j % 3; //归属第row个九宫格的第col个元素
				if(board[row][col] != '.' && !blockSet.add(board[row][col])) {  //加入不了，说明该九宫格里有重复元素
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
