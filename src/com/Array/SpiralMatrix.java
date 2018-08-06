package com.Array;
/*
 * 对一个二维矩阵螺旋式打印输出，例如
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
返回[1,2,3,6,9,8,7,4,5]. 
 */
import java.util.ArrayList;

public class SpiralMatrix {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		 ArrayList<Integer> res = new  ArrayList<Integer>();
		 if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
			 return res;
		 int i = 0;
		 int j = 0;
		 int i2 = matrix.length - 1;
		 int j2 = matrix[0].length - 1;
		 return getRes(matrix, res, i, j, i2, j2);
    }
	
	public ArrayList<Integer> getRes(int[][] matrix, ArrayList<Integer> res, int i, int j, int i2, int j2) {
		if(i > i2 || j > j2)
			return res;
		boolean flag = false;
		boolean flag2 = false;
		boolean flag3 = false;
		for(int k = j;k <= j2;k ++) { //第一条边
			res.add(matrix[i][k]);
			flag = true;
		}
		
		if(flag) {
			for(int k = i + 1;k <= i2;k ++) { //第二条边
				res.add(matrix[k][j2]);
				flag2 = true;
			}
		}
		
		if(flag2) {
			for(int k = j2 - 1;k >= j;k --) { //第三条边
				res.add(matrix[i2][k]);
				flag3 = true;
			}
		}
		
		if(flag3) {
			for(int k = i2 - 1;k >= i + 1;k --) { //第四条边
				res.add(matrix[k][j]);
				flag3 = true;
			}
		}
		getRes(matrix, res, i + 1, j + 1, i2 - 1, j2 - 1);
		return res;
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4}, {4,5,6,7}, {7,8,9,10}};
		System.out.println(new SpiralMatrix().spiralOrder(matrix));
	}
 	
}
