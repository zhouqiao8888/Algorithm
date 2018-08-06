package com.Array;

import java.util.*;

/*
 * ����һ��2D������ĳ��Ԫ��Ϊ0������Ԫ�������к���ȫ����Ϊ0
 * �������¿ռ临�Ӷ�ΪO(m*n),�Ľ�����¿ռ临�Ӷ�ΪO(m+n),����Ҫ�󣺿ռ临�Ӷ�ΪO(n),
 */
public class SetMatrixZeroes {
	//�ռ临�Ӷ�O(m+n):��������list�ֱ�洢Ԫ��0��Ӧ���б���б꣬ʱ�临�Ӷ�O(mn)
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
	
	//�ռ临�Ӷ�O(1)�����õ�һ�е�һ�д洢Ԫ��0��Ӧ���б���б꣬ʱ�临�Ӷ�O(mn)
	public void setZeroes2(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;
		int rows = matrix.length;
		int cols = matrix[0].length;
		boolean rowFlag = false;
		boolean colFlag = false;
		//�жϵ�һ���Ƿ���0
		for(int j = 0;j < cols;j ++) {
			if(matrix[0][j] == 0) {
				rowFlag = true;
				break;
			}
		}
		//�жϵ�һ���Ƿ���0
		for(int i = 0;i < rows;i ++) {
			if(matrix[i][0] == 0) {
				colFlag = true;
				break;
			}
		}
		//���õ�һ�е�һ�д洢������0Ԫ�ض�Ӧ���б���б�
		for(int i = 1;i < rows;i ++) {
			for(int j = 1;j < cols;j ++) {
				if(matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		//��0
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
		//�ٴ��жϵ�һ��
		if(rowFlag) {
			for(int j = 0;j < cols;j ++) {
				matrix[0][j] = 0;
			}
		}
		//�ٴ��жϵ�һ��
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
