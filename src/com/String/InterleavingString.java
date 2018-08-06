package com.String;
/*判读字符串s3是否由字符串s1和字符串s2交织而成
 *例如s1 ="aabcc",s2 ="dbbca", 
 *When s3 ="aadbbcbcac", return true.
 When s3 ="aadbbbaccc", return false. 
 */
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
	    if(s1 == null || s2 == null || s3 == null || (s1.length() + s2.length() != s3.length()))
	    	return false;
	    boolean flag =  isMatch(s1, 0, s2, 0, s3, 0);
	    return flag;
	}
	
	//回溯法求解
	public boolean isMatch(String s1, int p1, String s2, int p2, String s3, int p3) {
		if(p3 == s3.length())
			return true;
		boolean can = false;
		if(p1 < s1.length() && s1.charAt(p1) == s3.charAt(p3)) {
			can = isMatch(s1, p1 + 1, s2, p2, s3, p3 + 1);
		}
		if(!can && p2 < s2.length() && s2.charAt(p2) == s3.charAt(p3)) {
			can = isMatch(s1, p1, s2, p2 + 1, s3, p3 + 1);
		}
		return can;
	}
	
	public static void main(String[] args) {
		String s1 ="aabcc";
		String s2 ="dbbca";
		String s3 ="aadbbbaccc";
		System.out.println(new InterleavingString().isInterleave(s1, s2, s3));
	}
}
