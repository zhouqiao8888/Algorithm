package com.Array;

import java.util.*;

/*
 * 给定一个2D矩阵，若某个元素为0，将该元素所在行和列全部置为0
 * 最差情况下空间复杂度为O(m*n),改进情况下空间复杂度为O(m+n),本题要求：空间复杂度为O(n),
 */
public class SetMatrixZeroes {
	//空间复杂度O(m+n):采用两个list分别存储元素0对应的行标和列标，时间复杂度O(mn)
	public void setZeroes(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;
		Set<Integer> rowSets = new HashSet<Integer>();
		Set<Integer> colSets = new HashSet<Integer>();
		int rows = matrix.length;
		int cols = matrix[0].length;
		for(int i = 0;i < rows;i ++) {
			for(int j = 0;j < cols;j ++) {
				if(matrix[i][j] == 0) {
					rowSets.add(i);
					colSets.add(j);
				}
			}
		}
		for(int row : rowSets) {
			for(int j = 0;j < cols;j ++) {
				matrix[row][j] = 0;
			}
		}
		for(int col : colSets) {
			for(int i = 0;i < rows;i ++) {
				matrix[i][col] = 0;
			}
		}
	}	
	
	//空间复杂度O(1)：利用第一行第一列存储元素0对应的行标和列标，时间复杂度O(mn)
	public void setZeroes2(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;
		int rows = matrix.length;
		int cols = matrix[0].length;
		boolean rowFlag = false;
		boolean colFlag = false;
		//判断第一行是否有0
		for(int j = 0;j < cols;j ++) {
			if(matrix[0][j] == 0) {
				rowFlag = true;
				break;
			}
		}
		//判断第一列是否有0
		for(int i = 0;i < rows;i ++) {
			if(matrix[i][0] == 0) {
				colFlag = true;
				break;
			}
		}
		//利用第一行第一列存储其它的0元素对应的行标和列标
		for(int i = 1;i < rows;i ++) {
			for(int j = 1;j < cols;j ++) {
				if(matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		//置0
		for(int i = 1;i < rows;i ++) {
			if(matrix[i][0] == 0) {
				for(int j = 0;j < cols;j ++) {
					matrix[i][j] = 0;
				}
			}
		}
		for(int j = 1;j < cols;j ++) {
			if(matrix[0][j] == 0) {
				for(int i = 0;i < rows;i ++) {
					matrix[i][j] = 0;
				}
			}
		}
		//再次判断第一行
		if(rowFlag) {
			for(int j = 0;j < cols;j ++) {
				matrix[0][j] = 0;
			}
		}
		//再次判断第一列
		if(colFlag) {
			for(int i = 0;i < rows;i ++) {
				matrix[i][0] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,0,5},{7,9,0}};
		new SetMatrixZeroes().setZeroes2(matrix);
		int rows = matrix.length;
		int cols = matrix[0].length;
		for(int i = 0;i < rows;i ++) {
			for(int j = 0;j < cols;j ++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
