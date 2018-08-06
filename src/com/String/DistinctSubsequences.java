package com.String;
/*���������ַ���S��T�����S�е������У����˳��ɱ䣩��T�ĸ����������ж��壺
*ACE��ABCDE�������У���AEC����
*��̬�滮�⣺S��������T�Ǳ���
*/
public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		if(T.length() == 0) //��Sȫ��ɾ��
			return 1;
		if(S.length() == 0)
			return 0;
		int[][] res = new int[S.length() + 1][T.length() + 1];
		//��ʼ��res
		for(int i = 1;i <= T.length();i ++) {
			res[0][i] = 0;
		}
		
		for(int i = 0;i <= S.length();i ++) {
			res[i][0] = 1;
		}
		
		for(int i = 1;i <= S.length();i ++) {
			for(int j = 1;j <= T.length();j ++) {
				if(S.charAt(i - 1) == T.charAt(j - 1)) {
					res[i][j] = res[i - 1][j] + res[i - 1][j - 1];
				}
				else {
					res[i][j] = res[i - 1][j]; //��i - 1�����͵�j - 1������ƥ�䣬��ֻ�ܿ����j�����Ƿ�ƥ�� 
				}
			}
		}
		return res[S.length()][T.length()];
	}
	
	public static void main(String[] args) {
		System.out.println(new DistinctSubsequences().numDistinct("a", "a"));
	}
}
