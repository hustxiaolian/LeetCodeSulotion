package com.xiaolianhust.leetcode.medium;

import java.util.Arrays;

public class PerfectSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PerfectSquares ps = new PerfectSquares();
		System.out.println(ps.numSquares(15));
	}
	
	/**
	 * 思路：
	 * 最基本的思路：递归思路。
	 * 1. 首先求出<= N的所有perfect squares
	 * 2. 然后使用递归，成功后和现有的结果比较。计算出最少的次数。
	 * 
	 * test1: 60ms, beats 25.45% ε=ε=ε=┏(゜ロ゜;)┛
	 * 
	 * 果然可以使用dp来做，更加快。
	 * @param n
	 * @return
	 */
	private int result = Integer.MAX_VALUE;
	public int numSquares(int n) {
        int[] psNums = new int[(int)Math.sqrt(n)];
        for(int i = 0;i < psNums.length ;++i)
        	psNums[i] = (i + 1) * (i + 1);
        helper(psNums, n, 0, psNums.length - 1);
        return result;
    }
	
	/**
	 * 
	 * @param psNums
	 * @param remain
	 * @param count
	 * @param startIndex
	 */
	private void helper(int[] psNums, int remain, int count, int startIndex) {
		if(remain == 0) {
			result = Math.min(result, count);
			return;
		}
		
		for(int i = startIndex;i >= 0;--i) {
			if(remain >= psNums[i]) {
				for(int j = remain / psNums[i];j > 0; --j) {
					int newRemian = remain - psNums[i] * j;
					if(count + j > result) 
						break;
					helper(psNums, newRemian, count + j, i - 1);
				}
			}
		}
	}
	
	/**
	 * 思路：
	 * dp思路：惯用思路：
	 * 1. 假设我已知f(i - 1)之间所有的正确结果，
	 * 2. 根据当前情况，即 f(i) = f(i - perfectNum[j]) + 1;
	 * 3. 边界情况f(0) = 0, f(1) = f(1 - 1) + 1 = 1
	 * 
	 * @param n
	 * @return
	 */
	public int numSquares2(int n) {
        int[] psNums = new int[(int)Math.sqrt(n)];
        int[] dp = new int[n + 1];
        for(int i = 0;i < psNums.length ;++i)
        	psNums[i] = (i + 1) * (i + 1);
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1;i <= n;++i) {
        	int tmp = (int)Math.sqrt(i);
        	for(int j = 0;j < tmp; ++j) {
        		dp[i] = Math.min(dp[i], dp[i - psNums[j]] + 1);
        	}
        }
        return dp[n];
    }
}
