package com.xiaolianhust.leetcode.hard;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minDistanceReal("horse", "ros"));
	}
	
	
	/**
	 * 动态规划经典例题。
	 * 首先找到optimal structure。
	 * 学习下别人的思考方式。
	 * 1. 假设知道子问题的答案。
	 * 2. 根据题意分情况考虑当前的情况
	 * 3. 搞清楚别人情况下的意义，设置正确的边界情况。
	 * 
	 * 具体的题意和思路见纸上，或者https://leetcode.com/problems/edit-distance/discuss/25846/20ms-Detailed-Explained-C++-Solutions-(O(n)-Space)
	 * 
	 * 首先尝试用递归写下。
	 * 
	 * 虽然这次还是没做出来，但是dp本来就是很难，以后一定要按照上述思路来，然后先写下递归，把思路彻底理清楚后
	 * 再写真正的dp
	 * 
	 * @param word1
	 * @param word2
	 * @return
	 */
	public static int minDistanceRecursion(String word1, String word2) {
        return helper(word1, word2, word1.length(), word2.length());
    }


	private static int helper(String word1, String word2, int i, int j) {
		//基准情形,也是就是当其中一个字符串为空值的时候，那么op操作数，至少是要删除或者插入对方length的次数。
		if(i == 0)
			return j;
		else if(j == 0)
			return i;
		
		if(word1.charAt(i - 1) == word2.charAt(j - 1))//如果当前位置上完全相同，那么完全不需要动。
			return helper(word1, word2, i - 1, j - 1);
		else {
			//从上到下依次表示replace，delete，和insert的情况
			return Math.min(helper(word1, word2, i - 1, j - 1) + 1, 
					Math.min(helper(word1, word2, i, j - 1) + 1, 
							helper(word1, word2, i - 1, j) + 1));
		}
	}
	
	public static int minDistanceReal(String word1, String word2) {
		int n1 = word1.length();
		int n2 = word2.length();
		int[][] dp = new int[n1 + 1][n2 + 1];
		//基准情形，也就是边界情况
		for(int j = 0;j <= n2;++j) 
			dp[0][j] = j;
		for(int i = 0;i <= n1;++i) 
			dp[i][0] = i;
		
		//一般情形
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
