package com.xiaolianhust.leetcode.medium;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		System.out.println(coinChange(new int[] {288,160,10,249,77,314,429}, 9208));
	}
	
	/**
	 * ˼·��
	 * ����coin����С�������������һ�������dp���⡣
	 * dp����˼·��
	 * 1. ������֪��f(n - 1)����֮������е�����Ǯ����ȷ�����
	 * 2. ���ݵ�ǰ�����˼������ǰ����ֵ�����Ҫ��֤��С����ֵ����ô����
	 * i - coin[1] , i - coin[2]...Ȼ��ȡ����֮�����Сֵ��
	 * 
	 * 3. �߽������ֻ�о��вž���
	 * test1: 35ms, beats 24.39%��=��=��=��(�b��b;)��
	 * 
	 * 
	 * �ڶ���˼·��
	 * �ݹ����˼·��
	 * �Ӵ���ֵ��coin��ʼ��������̽�ܲ������㣬�����ҵ����ʵ�ֵ��
	 * �����ˣ�������ӵ���һ���жϾ��̫ǿ�ˡ�ֱ�Ӵ�TLE�����beats 90%ѧϰ��
	 * 
	 * ˭˵�ݹ����ģ�ֻҪ�ݹ��׼�ж�д�ã�����������ظ����жϣ�������coins����1������¡�
	 * лл��ѧϰ�ˡ�
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
		//��׼����
		if(remainAmount == 0) {
			result = Math.min(result, count);
			return;
		}
		else if(currCoin < 0 || remainAmount < coins[0] || count >= result)
			return;
		//�Ӵ������ʼ�����������Ƿ�������
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
