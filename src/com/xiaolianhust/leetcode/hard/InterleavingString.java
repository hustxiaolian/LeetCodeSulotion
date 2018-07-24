package com.xiaolianhust.leetcode.hard;

public class InterleavingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isInterleaveByDp("aabcc", "dbbca", "aadbbcbcac"));
	}
	
	/**
	 * ��һ�ֺ���˼·��
	 * ����·������ɵݹ�˼·��Ȼ��ת������dp������������˵������ڸ��Ӻ����һЩ��
	 * ��Ŀ����˼����˵��s1��s2���ַ��������⽻���������˳����뱣�֡�
	 * 
	 * Ҳ����˵��
	 * if s1[i] == s3[k],��ô���ǵݹ鵽��һ��
	 * if s2[j] == s3[k],��ô�ݹ鵽��һ�㡣
	 * else return false
	 * 
	 * ���ǻ�׼���Σ�
	 * if(i == s1n && j == s2n && k == s3n)
	 * 		return true
	 * 
	 * 
	 * oK,�ݹ�˼·�������˵�����Ǻܺ����ġ�
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 */
	public static boolean isInterleave(String s1, String s2, String s3) {
		return helper(s1, 0, s2, 0, s3, 0);
    }

	private static boolean helper(String s1, int i, String s2, int j, String s3, int k) {
		//��׼����
		if(i == s1.length() && j == s2.length() && k == s3.length())
			return true;
		
		//һ������
		boolean result = false;
		if(i < s1.length() && s1.charAt(i) == s3.charAt(k)) 
			result = helper(s1, i + 1, s2, j, s3, k + 1);
		if(j < s2.length() && s2.charAt(j) == s3.charAt(k))
			result = result || helper(s1, i, s2, j + 1, s3, k + 1);
		
		return result;
	}
	
	/**
	 * ��д��DP�����̡�
	 * 
	 * bug1���߽����������⡣
	 * 
	 * �ܽ���dp��˼·��
	 * 1. �����׼������֪��
	 * ����Ҹ�ã����Ƿ������dp
	 * 
	 * 2. ���ݵ�ǰ����������
	 * if(i == k) f(i,j,k) = f(i+1,j,k+1)
	 * if(j == k) f(i,j,k) = f(i,j,k) || f(i,j+1,k+1)
	 * 
	 * �Ƚ�����˼�ľ��ǣ�������һ����ά��dp��˼·���������������Ρ�
	 * ǰ�ŵ�˼·����bfs����˼���¡�
	 * 
	 * test1:36ms, beat 8.92% ��=��=��=��(�b��b;)��
	 * �ð������dpӦ�ò���һ�ֺõ�ѡ����������˼����BFS˼·��
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
		//��׼����1
		dp[n1][n2][n3] = true;
		
		//��׼����2��3
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
		
		//һ������
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
