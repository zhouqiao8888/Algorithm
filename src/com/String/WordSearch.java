package com.String;
/*
 * ����һ����ά�ַ������һ���ַ������жϸ��ַ����Ƿ��Ǹö�ά�����е�һ��·��������
 * ["ABCE"],
   ["SFCS"],
   ["ADEE"]
word ="ABCCED", -> returns true,
word ="SEE", -> returns true,
word ="ABCB", -> returns false
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
	     if(board == null || board.length <= 0 || board[0].length <= 0 
	       || word == null || word.length() <= 0)
	    	 return false;
		 boolean[][] visited = new boolean[board.length][board[0].length];
	     for(int i = 0;i < board.length;i ++) {
	    	 for(int j = 0;j < board[0].length;j ++) {
	    		 if(isExist(board, word, i, j, 0, visited)) {
	    			 return true;
	    		 }
	    	 }	    		 
	     }
	     return false;
	}
	
	public boolean isExist(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
		if(index == word.length())
			return true;
		boolean flag = false;
		if(i >= 0 && i < board.length && j >= 0 && j < board[0].length 
		   && !visited[i][j] && board[i][j] == word.charAt(index)) {
			index ++;
			visited[i][j] = true;
			flag = isExist(board, word, i - 1, j, index, visited) ||
				   isExist(board, word, i + 1, j, index, visited) ||
				   isExist(board, word, i, j - 1, index, visited) ||
				   isExist(board, word, i, j + 1, index, visited);
			if(!flag) { //����·��ʧ���ˣ����ص���һ�㣬��Ҫ��������
				index --;
				visited[i][j] = false;
			}
		}	
		return flag;
	}
	
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}; 
		String word = "ABCCED";
		String word2 = "SEE";
		String word3 = "ABCB";
		System.out.println(new WordSearch().exist(board, word2));
	}
}
