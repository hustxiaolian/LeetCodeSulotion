package com.xiaolianhust.leetcode.medium;

public class IntegerBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(integerBreak2(8));
	}
	
	/**
	 * 思路：
	 * 老套路，dp核心思路：（在草稿纸上，我先写出来，回头总结）
	 * 1. 假设已知之前所有的情况，即已知f(i-1)及其之前所有的情况。
	 * 2. 根据题意考虑当前情况。
	 * 		i = x1+...+xj
	 * 		f(i) = Math(f(x1)*...*f(xj))
	 * 在本题中，我们可以分析得到，x1+x2=y，其f(y)我们已知，所以，按照题目意思我们只需要分解成两个，
	 * 至于x1,x2要不要继续分解，获取更大的乘积值，这个已经在之前计算过了。
	 * 同时,注意到2,3这两个数字不分解更大，他们两比较特殊，其它的都是分解比较大。
	 * 
	 * test1:1ms, beats 53.12%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 改进。
	 * @param n
	 * @return
	 */
	public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2;i <= n;++i) {
        	int left = 1, right = i - 1;
        	int currMax = 0;
        	while(left <= right) {
        		int max1 = Math.max(left * right, left * dp[right]);
        		int max2 = Math.max(dp[left] * right, dp[left] * dp[right]);
        		currMax = Math.max(Math.max(max1, max2), currMax);
        		left++;right--;
        	}
        	dp[i] = currMax;
        }
        return dp[n];
    }
	
	public static int integerBreak2(int n) {
		if(n <= 3)
			return n - 1;
		int[] dp = new int[n + 1];
		dp[1] = 1; dp[2] = 2;dp[3] = 3;
		for(int i = 4;i <= n;++i) {
			int left = 1, right = i - 1;
			int currMax = 0;
			while(left <= right) {
				currMax = Math.max(currMax, dp[left++]*dp[right--]);
			}
			dp[i] = currMax;
		}
		return dp[n];
	}
}
