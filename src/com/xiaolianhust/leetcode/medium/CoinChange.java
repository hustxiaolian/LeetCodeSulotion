package com.xiaolianhust.leetcode.medium;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		System.out.println(coinChange(new int[] {288,160,10,249,77,314,429}, 9208));
	}
	
	/**
	 * 思路：
	 * 假设coin，从小到大的排序。这是一道经典的dp例题。
	 * dp核心思路：
	 * 1. 假设我知道f(n - 1)及其之间的所有的所有钱的正确结果。
	 * 2. 根据当前情况来思考，当前的面值如果需要保证最小的面值，那么就是
	 * i - coin[1] , i - coin[2]...然后取他们之间的最小值。
	 * 
	 * 3. 边界情况。只有具有才具有
	 * test1: 35ms, beats 24.39%ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 
	 * 第二种思路：
	 * 递归遍历思路。
	 * 从大面值的coin开始，反复试探能不能找零，并且找到合适的值。
	 * 我日了，大佬添加的这一个判断句可太强了。直接从TLE变成了beats 90%学习了
	 * 
	 * 谁说递归慢的，只要递归基准判断写好，避免大量的重复的判断，尤其是coins中有1的情况下。
	 * 谢谢，学习了。
	 * 
	 * @param coins
	 * @param amount
	 * @return
	 */
	public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(n == 0 || amount == 0) return 0;
        Arrays.sort(coins);
        result = Integer.MAX_VALUE;
        helper(coins, n - 1, amount, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
	
	private static int result = 0;
	
	private static void helper(int[] coins, int currCoin, int remainAmount, int count) {
		//基准情形
		if(remainAmount == 0) {
			result = Math.min(result, count);
			return;
		}
		else if(currCoin < 0 || remainAmount < coins[0] || count >= result)
			return;
		//从大面积开始，反复尝试是否能找零
		for(int i = remainAmount / coins[currCoin]; i >= 0; --i) {
			int nextRemain = remainAmount - i * coins[currCoin];
			if(currCoin - 1 >= 0 && nextRemain / coins[currCoin - 1] >= result - count)
				break;
			helper(coins, currCoin - 1, nextRemain, count + i);
		}
	}

	public static int coinChangeDP(int[] coins, int amount) {
		if(amount == 0) return 0;
		int n = coins.length;
		Arrays.sort(coins);
		int minCoin = coins[0];
		int[] dp = new int[amount + 1];
		
		for(int i = 0;i < n;++i) {
			if(coins[i] > amount)
				break;
			dp[coins[i]] = 1;
		}
		
		for(int i = minCoin;i <= amount;++i) {
			if(dp[i] != 0) continue;
			int currMin = amount;
			boolean can = false;
			for(int j = 0;j < n;++j) {
				int lastDPindex = i - coins[j];
				if(lastDPindex < minCoin) continue;
				int lastDP = dp[i - coins[j]];
				if(lastDP != 0) {
					can = true;
					currMin = Math.min(currMin, dp[i - coins[j]]);
				}
			}
			if(can)
				dp[i] = currMin + 1;
		}
		return dp[amount] == 0? -1 : dp[amount];
	}
	
	
	
}
