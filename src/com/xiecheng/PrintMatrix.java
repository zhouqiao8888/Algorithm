package com.xiecheng;
/* ������ھ���
 * 1 2 3 4
 * 5 6 7 8
 * 9 10 11 12
 * Ҫ�󽫾���˳ʱ����ת90�ȴ�ӡ
 * 9 5 1
 * 10 6 2
 * 11 7 3
 * 12 8 4
 * ͨ���۲죬���Է����ǰ��н��д�ӡ��
 */
public class PrintMatrix {
	public void printMatrix(int[][] matrix) {
		for(int j = 0;j < matrix[0].length;j ++) {
			for(int i = matrix.length - 1;i >= 0;i --) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		new PrintMatrix().printMatrix(matrix);
	}
}
