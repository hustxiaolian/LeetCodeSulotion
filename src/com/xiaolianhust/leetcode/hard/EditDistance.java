package com.xiaolianhust.leetcode.hard;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minDistanceReal("horse", "ros"));
	}
	
	
	/**
	 * ��̬�滮�������⡣
	 * �����ҵ�optimal structure��
	 * ѧϰ�±��˵�˼����ʽ��
	 * 1. ����֪��������Ĵ𰸡�
	 * 2. ���������������ǵ�ǰ�����
	 * 3. �������������µ����壬������ȷ�ı߽������
	 * 
	 * ����������˼·��ֽ�ϣ�����https://leetcode.com/problems/edit-distance/discuss/25846/20ms-Detailed-Explained-C++-Solutions-(O(n)-Space)
	 * 
	 * ���ȳ����õݹ�д�¡�
	 * 
	 * ��Ȼ��λ���û������������dp�������Ǻ��ѣ��Ժ�һ��Ҫ��������˼·����Ȼ����д�µݹ飬��˼·�����������
	 * ��д������dp
	 * 
	 * @param word1
	 * @param word2
	 * @return
	 */
	public static int minDistanceRecursion(String word1, String word2) {
        return helper(word1, word2, word1.length(), word2.length());
    }


	private static int helper(String word1, String word2, int i, int j) {
		//��׼����,Ҳ�Ǿ��ǵ�����һ���ַ���Ϊ��ֵ��ʱ����ôop��������������Ҫɾ�����߲���Է�length�Ĵ�����
		if(i == 0)
			return j;
		else if(j == 0)
			return i;
		
		if(word1.charAt(i - 1) == word2.charAt(j - 1))//�����ǰλ������ȫ��ͬ����ô��ȫ����Ҫ����
			return helper(word1, word2, i - 1, j - 1);
		else {
			//���ϵ������α�ʾreplace��delete����insert�����
			return Math.min(helper(word1, word2, i - 1, j - 1) + 1, 
					Math.min(helper(word1, word2, i, j - 1) + 1, 
							helper(word1, word2, i - 1, j) + 1));
		}
	}
	
	public static int minDistanceReal(String word1, String word2) {
		int n1 = word1.length();
		int n2 = word2.length();
		int[][] dp = new int[n1 + 1][n2 + 1];
		//��׼���Σ�Ҳ���Ǳ߽����
		for(int j = 0;j <= n2;++j) 
			dp[0][j] = j;
		for(int i = 0;i <= n1;++i) 
			dp[i][0] = i;
		
		//һ������
		for(int i = 1;i <= n1;++i) {
			char ch1 = word1.charAt(i - 1);
			for(int j = 1;j <= n2;++j) {
				char ch2 = word2.charAt(j - 1);
				if(ch1 == ch2) 
					dp[i][j] = dp[i - 1][j - 1];
				else {
					int replace = dp[i - 1][j - 1] + 1;
					int insert = dp[i - 1][j] + 1;
					int delete = dp[i][j - 1] + 1;
					dp[i][j] = Math.min(replace, Math.min(insert, delete));
				}
			}
		}
		
		return dp[n1][n2];
	}
	
}
