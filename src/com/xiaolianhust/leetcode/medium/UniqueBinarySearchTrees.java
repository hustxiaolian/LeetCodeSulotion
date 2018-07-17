package com.xiaolianhust.leetcode.medium;

public class UniqueBinarySearchTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numTrees2(3));
	}
	
	/**
	 * 第一种思路：
	 * 非dp的套路，递归来做。
	 * 依次从左到右(1-n)选取一个数字作为根节点，然后递归到两边，求取两个子树的又多少中可能性。
	 * 基准情形：让left > right是，即该子树为空，这样子树算只有一种情形即为null；让left = right时，该子树只有一个根节点，也是单一情形。
	 * 
	 * 从下面的计算势中，我们可以发现存在大量的重复计算。
	 * 我一开始寻找dp的思路出现了偏差，这才是optimal structure。
	 * 
	 * test1: 0ms, beats 100%ε=ε=ε=┏(゜ロ゜;)┛
	 * 一条经验，如果一开始想dp没找到切入点的话，可以按照直觉，写递归，然后可能在这个过程中，就会发现dp的奥妙。
	 * 
	 * @param n
	 * @return
	 */
	public static int numTrees(int n) {
        return helper(1, n);
    }

	private static int helper(int left, int right) {
		if(left >= right)
			return 1;

		int result = 0;
		for(int i = left;i <= right;++i) {
			result += ( helper(left, i - 1) * helper(i + 1, right) );
		} 
		return result;
	}
	
	/**
	 * 备忘法，避免重复计算。
	 * 时间复杂度降低到N^2.
	 * @param n
	 * @return
	 */
	public static int numTrees2(int n) {
		if(n <= 1) return 1;
		int[][] dp = new int[n][n];
		return helper2(1, n, dp);
	}

	private static int helper2(int left, int right, int[][] dp) {
		if(left - 1 < 0 || left - 1 >= dp.length || right - 1 < 0 || right - 1 >= dp.length)
			return 1;
		if(dp[left - 1][right - 1] == 0) {
			if(left >= right) {
				dp[left - 1][right -1] = 1;
				return 1;
			}
			int result = 0;
			for(int i = left;i <= right;++i) {
				result += ( helper2(left, i - 1, dp) * helper2(i + 1, right, dp) );
			} 
			dp[left - 1][right - 1] = result;
			return result;
		}
		else
			return dp[left - 1][right - 1];
	}
	
	
}
