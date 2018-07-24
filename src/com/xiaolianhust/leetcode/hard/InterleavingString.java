package com.xiaolianhust.leetcode.hard;

public class InterleavingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isInterleaveByDp("aabcc", "dbbca", "aadbbcbcac"));
	}
	
	/**
	 * 第一种核心思路：
	 * 老套路，先完成递归思路。然后转换成真dp，这样对我来说，相对于更加好理解一些。
	 * 题目的意思就是说，s1和s2的字符可以任意交错，但是相对顺序必须保持。
	 * 
	 * 也就是说它
	 * if s1[i] == s3[k],那么就是递归到下一层
	 * if s2[j] == s3[k],那么递归到下一层。
	 * else return false
	 * 
	 * 考虑基准情形，
	 * if(i == s1n && j == s2n && k == s3n)
	 * 		return true
	 * 
	 * 
	 * oK,递归思路相对于来说，还是很好理解的。
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 */
	public static boolean isInterleave(String s1, String s2, String s3) {
		return helper(s1, 0, s2, 0, s3, 0);
    }

	private static boolean helper(String s1, int i, String s2, int j, String s3, int k) {
		//基准情形
		if(i == s1.length() && j == s2.length() && k == s3.length())
			return true;
		
		//一般情形
		boolean result = false;
		if(i < s1.length() && s1.charAt(i) == s3.charAt(k)) 
			result = helper(s1, i + 1, s2, j, s3, k + 1);
		if(j < s2.length() && s2.charAt(j) == s3.charAt(k))
			result = result || helper(s1, i, s2, j + 1, s3, k + 1);
		
		return result;
	}
	
	/**
	 * 书写真DP的例程。
	 * 
	 * bug1：边界设置有问题。
	 * 
	 * 总结下dp的思路：
	 * 1. 假设基准情形已知。
	 * 这次我搞得，又是反方向的dp
	 * 
	 * 2. 根据当前情形来考虑
	 * if(i == k) f(i,j,k) = f(i+1,j,k+1)
	 * if(j == k) f(i,j,k) = f(i,j,k) || f(i,j+1,k+1)
	 * 
	 * 比较有意思的就是，我做了一个三维的dp的思路，尼玛这真是尴尬。
	 * 前排的思路都是bfs，我思考下。
	 * 
	 * test1:36ms, beat 8.92% ε=ε=ε=┏(゜ロ゜;)┛
	 * 好吧这道题dp应该不是一种好的选择，明天早上思考下BFS思路。
	 * 
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 */
	public static boolean isInterleaveByDp(String s1, String s2, String s3) {
		int n1 = s1.length();
		int n2 = s2.length();
		int n3 = s3.length();
		if(n1 + n2 != n3) return false;
		boolean[][][] dp = new boolean[n1 + 1][n2 + 1][n3 + 1];
		int i, j, k;
		char ch1, ch2, ch3;
		//基准情形1
		dp[n1][n2][n3] = true;
		
		//基准情形2和3
		for(k = n3 - 1;k >= 0;--k) {
			ch3 = s3.charAt(k);
			for(i = n1 - 1;i >= 0;--i) {
				ch1 = s1.charAt(i);
				if(ch1 == ch3)
					dp[i][n2][k] = dp[i + 1][n2][k + 1];
			}
			
			for(j = n2 - 1;j >= 0;--j) {
				ch2 = s2.charAt(j);
				if(ch2 == ch3)
					dp[n1][j][k] = dp[n1][j + 1][k + 1];
			}
		}
		
		//一般情形
		for(i = n1 - 1;i >= 0;--i) {
			ch1 = s1.charAt(i);
			for(j = n2 - 1;j >= 0;--j) {
				ch2 = s2.charAt(j);
				for(k = n3 - 1;k >= 0;--k) {
					ch3 = s3.charAt(k);
					boolean curr = false;
					if(ch1 == ch3)
						curr = dp[i + 1][j][k + 1];
					if(ch2 == ch3)
						curr = curr || dp[i][j + 1][k + 1];
					dp[i][j][k] = curr;
				}
			}
		}
		return dp[0][0][0];
	}
	
}
